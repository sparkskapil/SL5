import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	Socket socket = null;
	String host=null;
	int port;
	Client(String host, int port){
		this.host = host;
		this.port = port;
		
		try {
			socket = new Socket(this.host,this.port);
			
			System.out.println("Client Connected to "+this.host+":"+this.port);
			System.out.println("Input -1 to close the connection");
			process(socket);
			socket.close();
			System.out.println("Connection to the Server Closed by client");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void process(Socket socket) {
		int num=0;
		
			try {
				//Setting Up Input and Output Streams
				DataOutputStream os = new DataOutputStream(socket.getOutputStream());
				DataInputStream is = new DataInputStream(socket.getInputStream());
				Scanner scanner = new Scanner(System.in);
				
				
				while(true) {
					//Getting user Input
					System.out.print("\nEnter a Number:");
					num = scanner.nextInt();
					//Writing Input to Server
					os.writeUTF(num+"");
					
					if(num<0)break;
					
					//Reading Server Response
					String line = is.readUTF();
					System.out.println("Server >>  "+line);
				}
				os.close();
				is.close();
				scanner.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	public static void main(String args[]) {
		if(args.length>=2) {
			Client client = new Client(args[0],Integer.parseInt(args[1]));
		}
		else {
			Client client = new Client("localhost",5000);
		}
	}
}
