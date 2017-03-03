
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocServer {
	ServerSocket ss;
	Socket s;
	public SocServer() throws Exception{
		ss = new ServerSocket(17499);
		System.out.println("listening on port: " + ss.getLocalPort());
		System.out.println("Server Start");
		
	}
	public void acceptClient() throws Exception{
		s = ss.accept();
		System.out.println("Client connected");
	}
	public String readMessage() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String str = br.readLine();
		return str;
		
	}
	public void closeServer() throws Exception{
		ss.close();
	}
	public static void main (String[] args) {
		try{
			SocServer s = new SocServer();
			s.acceptClient();
			System.out.println(s.readMessage());
			s.closeServer();
			}catch(Exception e){
				System.out.println("failed");
			}
		
	}

}
