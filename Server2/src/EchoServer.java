import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class EchoServer {

	public static void main(String[] args) {
		try
		{		
			String line;
			DataInputStream is;
			PrintStream os;
			Socket clientSocket;
			ServerSocket echoserver =new ServerSocket(9999);
			while (!echoserver.isClosed()) {
				System.out.println("Waiting for Connection!!");
				clientSocket=echoserver.accept();
				System.out.println("Connected!!");
				is=new DataInputStream(clientSocket.getInputStream());
				os=new PrintStream(clientSocket.getOutputStream());
				while((line=is.readLine())!=null){
					if (line==null || line.length()<1)
						break;
					os.println(line);
				}
				is.close();
				os.flush();
				os.close();
				clientSocket.close();	
				System.out.println("Finished current echo request!!");
			}
			echoserver.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
