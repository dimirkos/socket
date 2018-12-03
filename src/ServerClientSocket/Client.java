package ServerClientSocket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {

    public static void main(String[] args) {

        try{


            Socket socket = new Socket("127.0.0.1" , 2018) ;

            socket.setSoTimeout(6000);

            System.out.println("Say your name");

            PrintWriter writer = new PrintWriter(socket.getOutputStream() , true) ;

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)) ;

            writer.println(reader.readLine());

            writer.flush();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream())) ;



            String result = bufferedReader.readLine() ;

            System.out.println("result:" + result);

            reader.close();

            writer.close();

            bufferedReader.close();

            socket.close();

        }

        catch (Exception ex){

            ex.printStackTrace();

        }
    }
}