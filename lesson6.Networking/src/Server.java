import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * @author holni
 * @version dated September 02, 2019
 */

public class Server {
    private final static int PORT = 8888;

    public static void main(String[] args)
    {
        try
        {
            ServerSocket serverSocket = getServerSocket();
            System.out.println("We are waiting our clients.");
            Socket clientSocket = waitNewClient(serverSocket);
            System.out.println("We have a new client.");

            DataInputStream incomeChannel = getIncomeChannel(clientSocket);
            DataOutputStream outcomeChannel = getOutcomeChannel(clientSocket);


            BufferedReader terminalReader = getTerminalReader();
            String incomeMsg = null;
            while (true)
            {
                String outcomeMsg = terminalReader.readLine();
                System.out.println("We are sending to client: " + outcomeMsg);
                outcomeChannel.writeUTF(outcomeMsg);
                outcomeChannel.flush();

                incomeMsg = incomeChannel.readUTF();
                System.out.println("Client: " + incomeMsg);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    private static BufferedReader getTerminalReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    private static DataOutputStream getOutcomeChannel(Socket clientSocket) throws IOException
    {
        OutputStream outputStream = clientSocket.getOutputStream(); // outcome information
        return new DataOutputStream(outputStream);
    }

    private static DataInputStream getIncomeChannel(Socket clientSocket) throws IOException
    {
        InputStream inputStream = clientSocket.getInputStream(); // income information
        return new DataInputStream(inputStream);
    }

    private static Socket waitNewClient(ServerSocket serverSocket) throws IOException
    {
        return serverSocket.accept();
    }

    private static ServerSocket getServerSocket() throws IOException
    {
        return new ServerSocket(PORT);
    }

}
