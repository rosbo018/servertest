

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocClient {
	int port;
	String ip;
	Socket s;
	OutputStreamWriter osw;
	BufferedReader br;
	PrintWriter output;
	public SocClient() throws Exception {
		ip	= "localhost";
		port = 17499;
		s = new Socket(ip, port);
		System.out.println("listening on port: " + s.getLocalPort());
		osw = new OutputStreamWriter(s.getOutputStream());
		output = new PrintWriter(osw);
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}
	public void sendMessage(String message) throws Exception{
		output.write(message);
		osw.flush();
	}
	public String receiveMessage() throws Exception {
		String message = br.readLine();
		return message;
		
	}
	public void closeClient() throws Exception{
		s.close();
	}
	public static void main (String [] args) 
	{
		try{
			SocClient c = new SocClient();
			c.sendMessage("hello");
			c.closeClient();
		}catch(Exception e){
			System.out.println("failed");
		}
	}
}
