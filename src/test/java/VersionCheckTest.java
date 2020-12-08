import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.momoko.solutions.VersionCheck;

/**
 * Created by momoko on 2019/12/26
 *
 * @author momoko
 */
public class VersionCheckTest {

    @Test
    void testVersionCompares() {
        VersionCheck versionCheck = new VersionCheck();

        int i = versionCheck.compareVersion("1.0.1", "1.1.1");
        Assertions.assertEquals(-1, i);

        i = versionCheck.compareVersion("1.1", "1.1.0");
        Assertions.assertEquals(0, i);

        i = versionCheck.compareVersion("1.3.1alpha", "1.3.0");
        Assertions.assertEquals(0, i);

        i = versionCheck.compareVersion("1.2.14", "1.2.1");
        Assertions.assertEquals(13, i);

        i = versionCheck.compareVersion("2.2.14", "1.2.1");
        Assertions.assertEquals(1, i);

        i = versionCheck.compareVersion("2.2.14", "2.2.14");
        Assertions.assertEquals(1, i);


    }

    @Test
    void testNumberCheck() {
        VersionCheck versionCheck = new VersionCheck();
        boolean b = versionCheck.isNumber("");
        Assertions.assertFalse(b);
        b = versionCheck.isNumber("111a");
        Assertions.assertFalse(b);
        b = versionCheck.isNumber("1");
        Assertions.assertTrue(b);
        b = versionCheck.isNumber("1.0");
        Assertions.assertFalse(b);
        b = versionCheck.isNumber("1alpha");
        Assertions.assertFalse(b);


    }
}
