import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class SmtpClient {

	public static void main(String[] args) {
		Socket smtpSocket=null;
		DataOutputStream os=null;
		DataInputStream is=null;
		try{
			smtpSocket =new Socket("localhost", 9999);
			os=new DataOutputStream(smtpSocket.getOutputStream());
			is=new DataInputStream(smtpSocket.getInputStream());
		}catch(Exception e){
			e.printStackTrace();
		}
		if(smtpSocket!=null&&os!=null&&is!=null) {
			try {
				os.write("HELO\n".getBytes());
				os.write("HELO\n".getBytes());
				os.write("Mail From\n".getBytes());
				os.write("RCTP To\n".getBytes());
				os.write("Data\n".getBytes());
				os.write("From\n".getBytes());
				os.write("Hi There\n".getBytes());
				os.write("QUIT\n".getBytes());
				System.out.println("SERVER RESPONSE\n\n");
				String responseLine;
				while((responseLine=is.readLine())!=null){
					System.out.println(responseLine);
					if (responseLine==null || responseLine.length()<1)
						break;
				}
				os.flush();
				os.close();
				is.close();
				smtpSocket.close();
				System.out.println("---- FINISHED -----");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
