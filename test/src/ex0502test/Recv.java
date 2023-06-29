package ex0502test;

import java.io.*;
import java.net.Socket;

public class Recv extends Thread	//	받는 쓰레드
{
	private Socket socket;

	public Recv(){}
	
	public Recv(Socket socket)
	{
		this.socket = socket;
	}
	
	public void setSocket(Socket socket) {this.socket = socket;}
	
	@Override
	public void run()
	{
		
		try 
		{
			InputStream is = socket.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			
			while(true) 
			{
				String msg = in.readLine();
				
			
				
				if (msg.equals("exit"))
				{
					in.close();
					System.exit(0);
					break;
					
				}
				
				else {
					System.out.println(msg);
				}
			}
		}
		catch(Exception e) {}
	}
}