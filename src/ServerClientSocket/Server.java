package ServerClientSocket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    public static void main(String[] args) {

        try{
            ServerSocket serverSocket = new ServerSocket(2018) ;

            while(true){

                Socket socket = serverSocket.accept() ;

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream())) ;

                String result = bufferedReader.readLine() ;

                System.out.println("result: " + result);

                PrintWriter printWriter = new PrintWriter(socket.getOutputStream()) ;

                printWriter.print("hello, "+ result + ". I am Server!");

                printWriter.flush();

                printWriter.close();

                bufferedReader.close();

                socket.close();
            }
        }

        catch (Exception ex){

            ex.printStackTrace();
        }
    }
}