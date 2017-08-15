package NetCalculator.nio;

/**
 * NIO 服务器端
 */
public class Server {
    // 默认端口
    private static int DEFAULT_PORT = 12345;
    // server 处理
    private static ServerHandler serverHandler;

    // start() 方法
    public static void start() {
        start(DEFAULT_PORT);
    }

    public static synchronized void start(int port) {
        if (serverHandler != null) {
            serverHandler.stop();
        }
        serverHandler = new ServerHandler(port);
        new Thread(serverHandler, "Server").start();
    }

    public static void main(String[] args) {
        start();
    }
}
