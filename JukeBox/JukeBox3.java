import java.util.*;
import java.io.*;

public class JukeBox3{
	//ArrayList<String> songList = new ArrayList<String>(); simple version just has two tokens
	ArrayList<Song2> songList = new ArrayList<Song2>();

	public static void main(String[] args){
		JukeBox3 jb = new JukeBox3();
		jb.start();
	}

	class ArtistCompare implements Comparator<Song2>{
		public int compare(Song2 one, Song2 two){
			return one.getArtist().compareTo(two.getArtist());
		}
	}

	private void start(){
		getSongs();
		System.out.println(songList);
		Collections.sort(songList);
		System.out.println(songList);

		//comparator part
		ArtistCompare artistCompare = new ArtistCompare();
		Collections.sort(songList, artistCompare);
		System.out.println(songList);
	}

	private void getSongs(){
		try{
			File file = new File("songlist2.txt");

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

		String[] token = song.split("/");
		Song2 nextSong = new Song2(token[0], token[1], token[2], token[3]);
		songList.add(nextSong);
	}

}