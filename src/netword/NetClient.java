package netword;

import java.io.*;
import java.net.Socket;

/**
 * Created by Administrator on 2017/5/6 0006.
 */
public class NetClient implements Serializable{
    private Socket socket;
    private InputStream is;
    private ObjectInputStream ois;
    private OutputStream os;
    private ObjectOutputStream oos;

    public void connect() throws Exception {
        socket = new Socket("localhost", 9999);
        is = socket.getInputStream();
        os = socket.getOutputStream();
    }

    public void send(Object object) throws IOException {
        if (oos == null)
            oos = new ObjectOutputStream(os);
        oos.writeObject(object);
    }

    public Object receive() throws IOException, ClassNotFoundException {
        if (ois == null)
            ois = new ObjectInputStream(is);
        return ois.readObject();
    }

    public void close() throws IOException {
        is.close();
        os.close();
        socket.close();
    }
}
