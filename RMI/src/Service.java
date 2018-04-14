import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Service extends Remote{
	public String Concat(String S1, String S2) throws RemoteException;
}
