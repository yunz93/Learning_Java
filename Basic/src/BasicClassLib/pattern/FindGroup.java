package BasicClassLib.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/6/20 0020.
 */
public class FindGroup {
    public static void main(String[] args) {
        // 要验证的字符串
        String str = "yunz@foxmail.com";
        // 邮箱验证规则
        String regEx = "\\w{3,20}@\\w+\\.(com|org|cn|net|gov)";
        // 编译正则表达式
        Matcher m = Pattern.compile(regEx).matcher(str);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);

        System.out.println(m.group());
    }
}
