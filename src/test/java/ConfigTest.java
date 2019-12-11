import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import test.Config;

/**
 * Created by momoko on 2019/12/11
 *
 * @author momoko
 */
public class ConfigTest {
    Config config;

    @BeforeEach
    void setUp(){this.config = new Config();}

    @AfterEach
    void tearDown() {
        this.config = null;
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testWindows() {
        Assertions.assertEquals("C:\\test.ini",config.getConfig("test.ini"));
    }

    @Test
    @EnabledOnOs({OS.LINUX,OS.MAC})
    void testLinuxAndMac() {
        Assertions.assertEquals("/usr/local/test.cfg",config.getConfig("test.cfg"));
    }
}
