import java.io.*;
import java.net.*;

public class DailyAdviceClient{
	private String advice;

	public void start(){
		try{
			Socket socket = new Socket("127.0.0.1", 4242);
			InputStreamReader is = new InputStreamReader(socket.getInputStream());
			BufferedReader reader = new BufferedReader(is);

			advice = reader.readLine();
			System.out.println("The advice is: "+ advice);
			reader.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public static void main(String[] args){
		DailyAdviceClient client = new DailyAdviceClient();
		client.start();
	}
}