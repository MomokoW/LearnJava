import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by momoko on 2019/12/11
 *
 * @author momoko
 */
public class StringUtilsTest {
    static List<Arguments> testCapitalize() {
        List<Arguments> arguments = new ArrayList<>();
        arguments.add(Arguments.arguments("abc", "Abc"));
        arguments.add(Arguments.arguments("APPLE", "Apple"));
        arguments.add(Arguments.arguments("BAnana", "Banana"));
        return arguments;
    }

//    @ParameterizedTest
//    @MethodSource
//    void testCapitalize(String input, String result) {
//        assertEquals(result, StringUtils.capitalize(input));
//    }

    //使用@CsvSource
//    @ParameterizedTest
//    @CsvSource({"abc, Abc", "APPLE, Apple", "gooD, Good"})
//    void testCaptalize(String input, String result) {
//        assertEquals(result, StringUtils.capitalize(input));
//    }

    //使用测试文件进行参数化测试
    @ParameterizedTest
    @CsvFileSource(resources = { "/test-capitalize.csv"})
    void testCaptalize(String input, String result) {
        assertEquals(result, StringUtils.capitalize(input));
    }

}
