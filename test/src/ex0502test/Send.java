package ex0502test;
import java.io.*;
import java.net.Socket;

public class Send extends Thread	//	내보내는 쓰레드
{
	private Socket socket;
	
	
	public Send(){}
	
	public Send(Socket socket)
	{
		this.socket = socket;
	}
	
	public void setSocket(Socket socket) {this.socket = socket;}
	
	@Override
	public void run()
	{

		try 
		{
			OutputStream os = socket.getOutputStream();
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(os)));
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while(true) 
			{
				String out_msg = br.readLine();
				String out_chk = out_msg;
				
				out.println(out_msg);
				out.flush();
					if(out_chk.equals("exit")) {
						System.exit(0);
					}
				}
			
		}
		catch(Exception e) {}
	}
}