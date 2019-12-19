package encryption;

/**
 * Created by momoko on 2019/12/19
 *
 * @author momoko
 */

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;

/**
 * 使用私钥对原始消息的哈希进行签名
 * 再使用公钥对签名进行解密，与原始消息的哈希进行对比
 *
 * 数字签名就是用发送方的私钥对原始数据进行签名，只有用发送方公钥才能通过签名验证。
 *
 * 数字签名用于：
 *
 * 防止伪造；
 * 防止抵赖；
 * 检测篡改。
 * 常用的数字签名算法包括：MD5withRSA／SHA1withRSA／SHA256withRSA／SHA1withDSA／SHA256withDSA／SHA512withDSA／ECDSA等。
 */
public class SignAlgorithm {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        //生成RSA公钥/私钥
        KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
        kpGen.initialize(1024);
        KeyPair kp = kpGen.generateKeyPair();
        PrivateKey sk = kp.getPrivate();
        PublicKey pk = kp.getPublic();

        //待签名的消息
        byte[] message = "Hello, I am momoko!".getBytes(StandardCharsets.UTF_8);

        //用私钥签名
        Signature s = Signature.getInstance("SHA1withRSA");
        s.initSign(sk);
        s.update(message);
        byte[] signed = s.sign();
        System.out.println(String.format("signature: %x", new BigInteger(1, signed)));

        //用公钥验证:
        Signature v = Signature.getInstance("SHA1withRSA");
        v.initVerify(pk);
        v.update(message);
        boolean valid = v.verify(signed);
        System.out.println("valid? " + valid);

    }
}
