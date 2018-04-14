import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements Service{

	protected Server() throws RemoteException {
		super();
		System.out.println("Server Started....");
	}

	@Override
	public String Concat(String S1, String S2) {
		return S1 + S2;
	}
	public static void main(String args[]) throws RemoteException {
		
			Server RS = new Server();
			LocateRegistry.createRegistry(5000).rebind("Concat", RS);
		
	}
}
