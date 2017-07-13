import java.rmi.*;
import java.rmi.server.*;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote{
	public String sayHello(){
		System.out.println("Hello RMI");
		return "Server says, 'Hey'";
	}

	public MyRemoteImpl() throws RemoteException{};

	public static void main(String[] args){
		try{
			MyRemote server = new MyRemoteImpl();

			//binding server with name "Remote Hello", client can find this server by "Remote Hello"
			Naming.rebind("Remote Hello", server);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
