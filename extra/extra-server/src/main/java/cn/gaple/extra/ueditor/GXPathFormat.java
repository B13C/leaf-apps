package cn.gaple.extra.ueditor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GXPathFormat {
    private static final String TIME = "time";
    private static final String FULL_YEAR = "yyyy";
    private static final String YEAR = "yy";
    private static final String MONTH = "mm";
    private static final String DAY = "dd";
    private static final String HOUR = "hh";
    private static final String MINUTE = "ii";
    private static final String SECOND = "ss";
    private static final String RAND = "rand";

    private static Date currentDate = null;
    private static final Pattern pattern = Pattern.compile("\\{([^\\}]+)\\}", Pattern.CASE_INSENSITIVE);

    public static String parse(String input) {
        Matcher matcher = pattern.matcher(input);
        GXPathFormat.currentDate = new Date();
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, GXPathFormat.getString(matcher.group(1)));
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 格式化路径, 把windows路径替换成标准路径
     *
     * @param input 待格式化的路径
     * @return 格式化后的路径
     */
    public static String format(String input) {
        return input.replaceAll("/+|\\\\+", "/");
    }

    public static String parse(String input, String filename) {
        Matcher matcher = pattern.matcher(input);
        String matchStr = null;
        GXPathFormat.currentDate = new Date();
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matchStr = matcher.group(1);
            if (matchStr.contains("filename")) {
                filename = filename.replace("$", "\\$").replaceAll("[\\/:*?\"<>|]", "");
                matcher.appendReplacement(sb, filename);
            } else {
                matcher.appendReplacement(sb, GXPathFormat.getString(matchStr));
            }
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    private static String getString(String pattern) {
        pattern = pattern.toLowerCase();
        // time 处理
        if (pattern.contains(GXPathFormat.TIME)) {
            return GXPathFormat.getTimestamp();
        } else if (pattern.contains(GXPathFormat.FULL_YEAR)) {
            return GXPathFormat.getFullYear();
        } else if (pattern.contains(GXPathFormat.YEAR)) {
            return GXPathFormat.getYear();
        } else if (pattern.contains(GXPathFormat.MONTH)) {
            return GXPathFormat.getMonth();
        } else if (pattern.contains(GXPathFormat.DAY)) {
            return GXPathFormat.getDay();
        } else if (pattern.contains(GXPathFormat.HOUR)) {
            return GXPathFormat.getHour();
        } else if (pattern.contains(GXPathFormat.MINUTE)) {
            return GXPathFormat.getMinute();
        } else if (pattern.contains(GXPathFormat.SECOND)) {
            return GXPathFormat.getSecond();
        } else if (pattern.contains(GXPathFormat.RAND)) {
            return GXPathFormat.getRandom(pattern);
        }
        return pattern;
    }

    private static String getTimestamp() {
        return System.currentTimeMillis() + "";
    }

    private static String getFullYear() {
        return new SimpleDateFormat("yyyy").format(GXPathFormat.currentDate);
    }

    private static String getYear() {
        return new SimpleDateFormat("yy").format(GXPathFormat.currentDate);
    }

    private static String getMonth() {
        return new SimpleDateFormat("MM").format(GXPathFormat.currentDate);
    }

    private static String getDay() {
        return new SimpleDateFormat("dd").format(GXPathFormat.currentDate);
    }

    private static String getHour() {
        return new SimpleDateFormat("HH").format(GXPathFormat.currentDate);
    }

    private static String getMinute() {
        return new SimpleDateFormat("mm").format(GXPathFormat.currentDate);
    }

    private static String getSecond() {
        return new SimpleDateFormat("ss").format(GXPathFormat.currentDate);
    }

    private static String getRandom(String pattern) {
        int length = 0;
        pattern = pattern.split(":")[1].trim();
        length = Integer.parseInt(pattern);
        return (Math.random() + "").replace(".", "").substring(0, length);
    }
}
