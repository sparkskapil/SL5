import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
	public static void main(String args[]) {
		try {
			Registry R1 = LocateRegistry.getRegistry("localhost",5000);
			Service service = (Service)R1.lookup("Concat");
			Scanner sc = new Scanner(System.in);
			String Result;
			System.out.print("\n Enter String 1: ");
			String s1 = sc.nextLine();
			System.out.print("\n Enter String 2: ");
			String s2 = sc.nextLine();
			
			System.out.print("Invoking Remote Method");
			Result = service.Concat(s1, s2);
			System.out.println("Result: " + Result);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
