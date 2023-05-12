import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",10111);

            //asking user input with buffer
            BufferedReader userInputBuffer = new BufferedReader(new InputStreamReader(System.in));

            //taking the input from socket
            BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //to send the message i need a pen
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);

            String sendingMessage, receivingMessage;
            while(true) {
                receivingMessage = socketInput.readLine();
                System.out.println("Message from server: " + receivingMessage);
                sendingMessage = userInputBuffer.readLine();
                printWriter.println(sendingMessage);
                printWriter.flush();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
