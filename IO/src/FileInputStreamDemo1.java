import java.io.*;

/**
 * Created by Administrator on 2017/6/24 0024.
 */
public class FileInputStreamDemo1 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        new FileInputStream( "IO/" + i + ".txt")));
                String message = null;
                StringBuilder info = new StringBuilder(); // 用于保存从文件中读取出来的内容
                while ((message = br.readLine()) != null) {
                    info.append(message);
                }
                System.out.println(info);
                String token = "zte"; // 待匹配的字符串
                int result = 0;
                int length = info.length();
                while (info.toString().contains(token)) {
                    // 记录每次出现的位置
                    result++;
                    System.out.println("第" + result + "次出现的位置是"
                            + (info.indexOf(token) + (length - info.length())));
                    // 截取字符串：减去匹配上字符串前面所有的字符。
                    info = new StringBuilder(info.substring(info.indexOf(token) + token.length()));
                }
                System.out.println("总共出现的次数是：" + result + "次");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
