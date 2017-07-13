import java.rmi.*;

public class MyRemoteClient{
	public static void main(String[] args){
		new MyRemoteClient().start();
	}

	public void main start(){
		try{
			MyRemote server = (MyRemote) Naming.lookup("rmi://127.0.0.1/Remote Hello");
			String s = server.sayHello();
			System.out.println(s);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
