package calculator.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2017/8/11 0011.
 */
public class ServerNormal {
    // 默认端口号
    private static int DEFAULT_PORT = 12345;
    // 单例的serverSocket
    private static ServerSocket server;

    public static void start() throws IOException {
        start(DEFAULT_PORT);
    }

    private synchronized static void start(int port) throws IOException {
        if (server != null) {
            return;
        }

        try {
            server = new ServerSocket(DEFAULT_PORT);
            System.out.println("服务器已启动，端口号：" + port);
            while (true) {
                Socket socket = server.accept();
                new Thread(new ServerHandler(socket)).start();
            }
        } finally {
            if (server != null) {
                System.out.println("服务器已关闭");
                server.close();
                server = null;
            }
        }
    }
}
