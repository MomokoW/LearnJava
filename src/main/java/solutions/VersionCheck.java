package solutions;

import java.util.regex.Pattern;

/**
 * Created by momoko on 2019/12/26
 *
 * @author momoko
 */
public class VersionCheck {


    public int compareVersion(String oldVer, String newVer) {
        String[] oldV = oldVer.split("\\.");
        String[] newV = newVer.split("\\.");
        int len = Math.min(oldV.length, newV.length);
        int result = 0;
        int i;
        for (i = 0; i < len; i++) {
            if (isNumber(oldV[i]) && isNumber(newV[i])) {
                int v1 = Integer.parseInt(oldV[i]);
                int v2 = Integer.parseInt(newV[i]);
                if (v1 == v2)
                    continue;
                result = v1 - v2;
                if (result != 0)
                    return result;
            } else {
                return 0;
            }
        }
        if (oldV.length == newV.length) {
            result = 0;
        } else
            result = 0 - Integer.parseInt(newV[i + 1]);
        return result;
    }

    public boolean isNumber(String s) {
        if (s == null || s.trim().length() == 0) return false;
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(s).matches();
    }
}
