import java.util.*;
import java.io.*;

public class JukeBox4{
	//ArrayList<String> songList = new ArrayList<String>(); simple version just has two tokens
	ArrayList<Song3> songList = new ArrayList<Song3>();

	public static void main(String[] args){
		JukeBox4 jb = new JukeBox4();
		jb.start();
	}

	class ArtistCompare implements Comparator<Song3>{
		public int compare(Song3 one, Song3 two){
			return one.getArtist().compareTo(two.getArtist());
		}
	}

	private void start(){
		getSongs();
		System.out.println(songList);
		Collections.sort(songList);
		System.out.println(songList);

		//comparator part using ArrayList
		//ArtistCompare artistCompare = new ArtistCompare();
		//Collections.sort(songList, artistCompare);

		HashSet<Song3> hs = new HashSet<Song3>();
		hs.addAll(songList);  //HashSet has addAll method
		System.out.println(hs);
	}

	private void getSongs(){
		try{
			File file = new File("songlist3.txt");

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
		Song3 nextSong = new Song3(token[0], token[1], token[2], token[3]);
		songList.add(nextSong);
	}

}