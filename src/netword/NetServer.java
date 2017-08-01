package netword;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2017/5/6 0006.
 */
public class NetServer {
    public NetServer() {

    }

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            while(true) {
                Socket socket = serverSocket.accept();
                new ServerThread(socket).start();
//                InputStream is = socket.getInputStream();
//                ObjectInputStream ois = new ObjectInputStream(is);
//                OutputStream os = socket.getOutputStream();
//                ObjectOutputStream oos = new ObjectOutputStream(os);
//                while (true) {
//                    try {
//                        //从客户端读取Command对象
//                        UserCommand uc = (UserCommand) ois.readObject();
//                        //执行
//                        uc.execute(new UserService());
//                        //将Command写回客户端
//                        oos.writeObject(uc);
//                    } catch (ClassNotFoundException e) {
//                        e.printStackTrace();
//                    }
//
//                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new NetServer().start();
    }
}
