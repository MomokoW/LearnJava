package encryption;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

/**
 * Created by momoko on 2019/12/17
 *
 * @author momoko
 */
//编码算法
public class EncodeAlgorithm {
    public static void main(String[] args) throws UnsupportedEncodingException {
        /*
         URL编码有一套规则：
         如果字符是A~Z，a~z，0~9以及-、_、.、*，则保持不变；
         如果是其他字符，先转换为UTF-8编码，然后对每个字节以%XX表示。
         */

        String encode = URLEncoder.encode("中文!", String.valueOf(StandardCharsets.UTF_8));
        System.out.println(encode);
        String decode = URLDecoder.decode("%E4%B8%AD%E6%96%87%21");
        System.out.println(decode);


        /*
         URL编码是对字符进行编码，表示成%xx的形式，而Base64编码是对二进制数据进行编码，表示成文本格式。
         Base64编码可以把任意长度的二进制数据变为纯文本，且只包含A~Z、a~z、0~9、+、/、=这些字符。
         它的原理是把3字节的二进制数据按6bit一组，用4个int整数表示，然后查表，把int整数用索引对应到字符，得到编码后的字符串。
         因为6位整数的范围总是0~63，所以，能用64个字符表示：字符A~Z对应索引0~25，字符a~z对应索引26~51，字符0~9对应索引52~61，最后两个索引62、63分别用字符+和/表示。
         */

        byte[] input = new byte[]{(byte) 0xe4, (byte) 0xb8, (byte) 0xad };
        String b64encode = Base64.getEncoder().encodeToString(input);
        System.out.println(b64encode);
        byte[] output = Base64.getDecoder().decode("5Lit");
        System.out.println(Arrays.toString(output)); // [-28, -72, -83]


        /*
        如果输入的字节数组的长度不是3的整数倍，则对输入的末尾补一个或两个0x00
        编码后，如果末尾出现一个=则表示加了一个0x00,如果出现两个=则表示加了两个0x00
        解码的时候，去掉末尾补充的一个或两个0x00即可
         */

        byte[] input1 = new byte[]{(byte) 0xe4, (byte) 0xb8, (byte) 0xad, (byte) 0x21};
        String b64encoded = Base64.getEncoder().encodeToString(input1);
        String b64encoded2 = Base64.getEncoder().withoutPadding().encodeToString(input1);
        System.out.println(b64encoded);
        System.out.println(b64encoded2);
        byte[] output1 = Base64.getDecoder().decode(b64encoded2);
        System.out.println(Arrays.toString(output1));

    }
}
