package netword;

import command.UserCommand;
import service.MemberService;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Administrator on 2017/5/6 0006.
 */
public class ServerThread extends Thread{
    private Socket socket;
    private InputStream is;
    private ObjectInputStream ois;
    private OutputStream os;
    private ObjectOutputStream oos;

    private MemberService memberService;

    public ServerThread(Socket socket) {
        this.socket = socket;
        memberService = new MemberService();
    }

    public void run() {
        try {
            is = socket.getInputStream();
            ois = new ObjectInputStream(is);
            os = socket.getOutputStream();
            oos = new ObjectOutputStream(os);
            while (true) {
                try {
                    //从客户端读取Command对象
                    UserCommand uc = (UserCommand) ois.readObject();
                    //执行
                    uc.execute(memberService);
                    //将Command写回客户端
                    oos.writeObject(uc);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
