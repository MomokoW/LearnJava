package test;

/**
 * Created by momoko on 2019/12/11
 *
 * @author momoko
 */
public class Config {
    public String getConfig(String filename) {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            return "C:\\" + filename;
        }
        if (os.contains("mac") || os.contains("linux") || os.contains("unix")) {
            return "/usr/local/" + filename;
        }
        throw new UnsupportedOperationException();

    }
}
