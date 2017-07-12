class Song2 implements Comparable<Song2>{
	String title;
	String artist;
	String rating;
	String bpm;

	Song2(String t, String a, String r, String b){
		title = t;
		artist = a;
		rating = r;
		bpm = b;
	}

	public int compareTo(Song2 s){
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
	public String toString(){
		return title;
	}
}