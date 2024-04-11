import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {

        try {
            System.out.println("Waiting for client...");
            ServerSocket ss = new ServerSocket(9806);
            while (true) {
                Socket soc = ss.accept();

                BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));

                String str = in.readLine();
                System.out.println("client: " + str);

                BufferedReader res = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter a response : ");
                String str1 = res.readLine();

                PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
                out.println(str1);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
