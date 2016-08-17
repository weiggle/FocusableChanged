package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wei.li on 2016/8/17.
 */
public class CommenUtil {

    public static final String EMAIL_MATCHER = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
    public static final String PHONE_MATCHER = "^(((13[0-9])|(14[0-9])|(15([0-9]))|(17([0-9]))|(18[0-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";

    public static boolean verify(String str,String pattern) {
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(str);

        return matcher.matches();
    }
}
