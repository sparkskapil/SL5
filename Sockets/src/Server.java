import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	private ServerSocket server = null;
	private Socket socket = null;
	private int port;
	private int num_clients=0;
	Server(int port){
		this.port = port;
		try {
			server = new ServerSocket(this.port);
			
			System.out.println("Server Started at Port " + this.port);
			System.out.println("Server Waiting for Clients...");
			while(true) {
				socket = server.accept();
				Processing P = new Processing(socket,++num_clients);
				P.start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String args[]) {
		Server s = new Server(5000);
	}
	
	
	
	public int factorial(int num) {
		if(num<=0) {
			return 1;
		}
		return factorial(num-1)*num;
	}

	class Processing extends Thread{
		Socket socket;
		int ClientId;
		Processing(Socket socket,int ClientId){
			this.socket = socket;
			this.ClientId = ClientId;
		}
		public void process() {
			System.out.println("Client " + ClientId + " Connected");
			try {
				//Setting Up Input and OutputStreams
				DataOutputStream os = new DataOutputStream(socket.getOutputStream());
				DataInputStream is = new DataInputStream(socket.getInputStream());
				Scanner scanner = new Scanner(System.in);
				String line="";
				while(true)
				{
					line = is.readUTF();
					int num = Integer.parseInt(line);
					if(num<0)break;
					System.out.println("Client " + ClientId+ ">>  " + line);
					os.writeUTF("Factorial = " + factorial(num));
				}
				
				os.close();
				is.close();
				socket.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		public void run() {
			process();
			System.out.println("Connection with Client " + ClientId +" Terminated");
		}
		
	}
}


