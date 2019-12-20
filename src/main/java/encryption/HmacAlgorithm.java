package encryption;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by momoko on 2019/12/19
 *
 * @author momoko
 */

/**
 * HmacMD5可以看作带有一个安全的key的MD5。使用HmacMD5而不是用MD5加salt，有如下好处：
 *
 * HmacMD5使用的key长度是64字节，更安全；
 * Hmac是标准算法，同样适用于SHA-1等其他哈希算法；
 * Hmac输出和原有的哈希算法长度一致。
 */

/**
 * 使用HmacMD5的步骤是：
 *
 * 通过名称HmacMD5获取KeyGenerator实例；
 * 通过KeyGenerator创建一个SecretKey实例；
 * 通过名称HmacMD5获取Mac实例；
 * 用SecretKey初始化Mac实例；
 * 对Mac实例反复调用update(byte[])输入数据；
 * 调用Mac实例的doFinal()获取最终的哈希值。
 */
public class HmacAlgorithm {
    public static void main(String[] args) {
        try {
            KeyGenerator kenGen = KeyGenerator.getInstance("HmacMD5");
            SecretKey key = kenGen.generateKey();
            byte[] encoded = key.getEncoded();
            System.out.println(Arrays.toString(encoded));
            //打印随机生成的key
            System.out.println(new BigInteger(1,  encoded).toString(16));
            Mac mac = Mac.getInstance("HmacMD5");
            mac.init(key);
            mac.update("HelloWorld".getBytes(StandardCharsets.UTF_8));
            byte[] bytes = mac.doFinal();
            System.out.println(new BigInteger(1, bytes).toString(16));



            //已知加密后的哈希和SecretKey，验证key是否为客户端生成的
            byte[] hkey = new byte[]{65, 50, -57, 22, -127, 51, -33, -70, 33, 100, 111, 94, 21, -41, -34, -8, 94, 17, -50, -81, 18, -7, -4, -72, -92, 38, 6, -69, -65, 42, 49, -59, 21, 108, 126, -86, 92, 51, -116, 10, -64, -57, 100, 101, -47, -126, 91, -114, 93, 97, 35, 51, 8, 47, 40, 28, 108, -2, -108, -48, -30, 97, -20, 46};
            SecretKey keySpec = new SecretKeySpec(hkey, "HmacMD5");
            Mac mac1 = Mac.getInstance("HmacMD5");
            mac1.init(keySpec);
            mac1.update("HelloWorld".getBytes(StandardCharsets.UTF_8));
            byte[] result = mac.doFinal();
            System.out.println(Arrays.toString(result));

        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }
}
