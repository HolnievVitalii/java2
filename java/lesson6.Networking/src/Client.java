import java.io.*;
import java.net.Socket;
import java.net.Socket;

/**
 * @author holni
 * @version dated September 02, 2019
 */
public class Client {
    private final static int SERVER_PORT = 8888;

    public static void main(String[] args)
    {
        try
        {
            Socket socket = new Socket("127.0.0.1", SERVER_PORT);
            Socket socket1 = serverConnection(socket);
            System.out.println("We have connection with server");

            DataInputStream incomeChannel = getIncomeChannel(socket1);
            DataOutputStream outcomeChannel = getOutcomeChannel(socket1);

            BufferedReader terminalReader = getTerminalReader();
            String incomeMsg = null;
            while (true)
            {
                String outcomeMsg = terminalReader.readLine();
                System.out.println("We are sending to server : " + outcomeMsg);
                outcomeChannel.writeUTF(outcomeMsg);
                outcomeChannel.flush();

                incomeMsg = incomeChannel.readUTF();
                System.out.println("Server: " + incomeMsg);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static BufferedReader getTerminalReader()
    {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    private static DataOutputStream getOutcomeChannel(Socket socket) throws IOException
    {
        OutputStream outputStream = socket.getOutputStream(); // outcome information
        return new DataOutputStream(outputStream);
    }

    private static DataInputStream getIncomeChannel(Socket socket) throws IOException
    {
        InputStream inputStream = socket.getInputStream(); // income information
        return new DataInputStream(inputStream);
    }

    private static Socket serverConnection(Socket socket) throws IOException {
        return socket;
    }
}
