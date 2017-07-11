import java.util.*;
import java.io.*;

public class JukeBox{
	//ArrayList<String> songList = new ArrayList<String>(); simple version just has two tokens
	ArrayList<Song> songlist = new ArrayList<Song>();

	public static void main(String[] args){
		JukeBox jb = new JukeBox();
		jb.start();
	}

	private void start(){
		getSongs();
		System.out.println(songList);
		Collections.sort(songList);
		System.out.println(songList);
	}

	private void getSongs(){
		try{
			File file = new File("songlist.txt");

			//there is a problem
			BufferedReader reader = new BufferedReader(new FileReader(file)); 
			String song;
			while((song = reader.readLine())!=null){
				addSong(song);
			}
		}catch(Exception ex){
			//problem
			ex.printStackTrace();
		}
	}

	private void addSong(String song){
		//problem in simple version, remember how to use string.split();
		//String[] token = song.split("/");
		//songList.add(token[0]);
	}

}