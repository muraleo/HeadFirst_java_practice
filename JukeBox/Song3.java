class Song3 implements Comparable<Song3>{
	String title;
	String artist;
	String rating;
	String bpm;

	Song3(String t, String a, String r, String b){
		title = t;
		artist = a;
		rating = r;
		bpm = b;
	}

	//override equals method
	public boolean equals(Object aSong){
		Song3 s = (Song3) aSong;
		return getTitle().equals(s.getTitle());
	}

	//override hashCode method
	public int hashCode(){
		return title.hashCode();
	}

	public int compareTo(Song3 s){
		return title.compareTo(s.getTitle());
	}

	public String getTitle(){
		return title;
	}

	public String getArtist(){
		return artist;
	}

	public String getRating(){
		return rating;
	}

	public String getBpm(){
		return bpm;
	}

	//override toString() method in Song class
	//when System.out.println(song), terminal will show title:artist for each song
	public String toString(){
		//return title+":"+artist;
		return title;
	}
}