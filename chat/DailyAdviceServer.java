import java.net.*;
import java.io.*;

public class DailyAdviceServer{
	String[] adviseList = {"You really have to rethink your haircut!", "Take smaller bites", "Go for the tight jeans. NO! They do not make you look fat.","Only one word: inappropriate.", "Just for today, be honest. Tell your boss what your really think."};

	public void start(){
		try{
			ServerSocket serverSock = new ServerSocket(4242);

			while(true){
				Socket sock = serverSock.accept();

				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				String advice = getAdvice();
				writer.println(advice);
				writer.close();
				System.out.println(advice+" is send successfully.");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	private String getAdvice(){
		int random = (int)(Math.random()*adviseList.length);
		return adviseList[random];
	}

	public static void main(String[] args){
		DailyAdviceServer server = new DailyAdviceServer();
		server.start();
	}
}