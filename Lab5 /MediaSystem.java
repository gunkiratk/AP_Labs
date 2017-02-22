import java.util.*;
import java.io.*;
public class MediaSystem
{
	private static ArrayList<Movie> movie_list=new ArrayList<Movie>();
	private static ArrayList<Song> song_list=new ArrayList<Song>();
	private static int no_of_movie;
	private static int no_of_song;
	public void write_movie() throws IOException
	{
		FileOutputStream filestream_movie=new FileOutputStream("movie.dat");
		ObjectOutputStream os_movie=new ObjectOutputStream(filestream_movie);
		for(int i=0;i<movie_list.size();i++)
		{os_movie.writeObject(movie_list.get(i));
		}	
		filestream_movie.close();
	
}
public void write_song() throws IOException
	{
		FileOutputStream filestream_Song=new FileOutputStream("song.dat");
		ObjectOutputStream os_song=new ObjectOutputStream(filestream_Song);
		for(int i=0;i<song_list.size();i++)	
		{
		os_song.writeObject(song_list.get(i));
		}
		filestream_Song.close();

	
}
public void read_movie() throws IOException,ClassNotFoundException
{	Object obj_1;
		FileInputStream fis_mov = new FileInputStream("movie.dat");
		ObjectInputStream ois_mov = new ObjectInputStream(fis_mov);
		movie_list.clear();
		while(fis_mov.available()>0)
		{
		obj_1 = ois_mov.readObject();
		movie_list.add((Movie)obj_1);
		}
		// ois_mov.close();
		
}
public void read_song() throws IOException,ClassNotFoundException
{	Object obj_2;

		FileInputStream fis_son = new FileInputStream("song.dat");
		ObjectInputStream ois_son = new ObjectInputStream(fis_son);
		song_list.clear();
		while(fis_son.available()>0)
		{
		obj_2 = ois_son.readObject();
		song_list.add((Song)obj_2);
		}
		// ois_son.close();
	
}
public void SearchGenre(String g){
		// getSongs();
		int len_songs = song_list.size();
		int i;
		int count=0;
		for(i=0;i<len_songs;i++){
			if(song_list.get(i).getGenre().equals(g)){
				{
					System.out.println(song_list.get(i) + " ");
					count++;
				}
			System.out.println();
			}
		}
		if(count==0)
		{
			System.out.println("No match found");
		}
		
	}

	public void SearchDirector(String d){
		// getMovies();
		int len_movies = movie_list.size();
		int j;
		int count=0;
		for(j=0;j<len_movies;j++){
			if(movie_list.get(j).getDirector().equals(d)){
				{
					System.out.println(movie_list.get(j) + " ");
					count++;
				}
			System.out.println();	
			}
		}
		
		if(count==0)
		{
			System.out.println("No match found");
		}
	}

	public void SearchAllSongs(String mov){
		// getSongs();
		int len_songs = song_list.size();
		int i;
		int count=0;
		for(i=0;i<len_songs;i++){
			if(song_list.get(i).getMoviename().equals(mov)){
				{
					System.out.println(song_list.get(i) + " ");
					count++;
				}	
			System.out.println();
			}
			
		}
		if(count==0)
		{
			System.out.println("No match found");
		}
		
	}

	public void go(int k){
		// getSongs();
		Collections.sort(song_list);
		Collections.reverse(song_list);
		// getMovies();
		Collections.sort(movie_list);
		Collections.reverse(movie_list);
		int i;
		System.out.println("Top " + k + " Songs:");
		for(i=0;i<k;i++){
			//System.out.print(SongList.get(i) + " ");
			System.out.println(song_list.get(i).getTitle() + " : " + song_list.get(i).getRating());
		}
		System.out.println();
		int j;
		System.out.println("Top " + k + " Movies:");
		for(j=0;j<k;j++){
			System.out.println(movie_list.get(j).getTitle() + " : " + movie_list.get(j).getRating());
		}
		System.out.println();

	}
	public void update_rating()
	{
		System.out.println("What to update movie or song?");
		System.out.println("1.Movie");
		System.out.println("2.Song");
		Scanner in =new Scanner(System.in);
		int choice=in.nextInt();
		if(choice==1)
		{	int count=0;
			System.out.println("Enter Movie Name");
			Scanner t=new Scanner(System.in);
			String s=t.nextLine();
			for(int i=0;i<movie_list.size();i++)
			{	count++;
				if(movie_list.get(i).getTitle().equals(s))
				{	System.out.println("Enter rating");
					String r= t.nextLine();
					movie_list.get(i).setRating(r);
					// System.out.println(movie_list.get(i));
					break;
				}
			}
			

		}
		else if(choice ==2)
		{	int count=0;
			System.out.println("Enter Song Name");
			Scanner t=new Scanner(System.in);
			String s=t.nextLine();
			for(int i=0;i<song_list.size();i++)
			{	count++;
				if(song_list.get(i).getTitle().equals(s))
				{	System.out.println("Enter rating");
					String r= t.nextLine();
					song_list.get(i).setRating(r);
					break;
				}
			}
		}


	}

	public void write_file_music() throws IOException{
		BufferedWriter br_1 = null;
		try{
			br_1 = new BufferedWriter(new FileWriter("movie.txt"));
		br_1.write("Movie,Artist,Year of Release,Genre,Size,Rating,Duration,Director,Producer,Certification\n");
		for(int i=0;i<movie_list.size();i++)
		{
			br_1.write(movie_list.get(i).getTitle()+","+movie_list.get(i).getArtist()+","+movie_list.get(i).getYear()+","+movie_list.get(i).getGenre()+","+movie_list.get(i).getSize()+","+movie_list.get(i).getRating()+","+movie_list.get(i).getDuration()+","+movie_list.get(i).getDirector()+","+movie_list.get(i).getProducer()+","+movie_list.get(i).getCertification()+"\n");
		}
		}
		catch(IOException e)
			{
				e.printStackTrace();
			}
			finally{
				br_1.close();
			}
	}
	public void write_file_song() throws IOException{
		BufferedWriter br_1 = null;
		try{
			br_1 = new BufferedWriter(new FileWriter("song.txt"));
		br_1.write("Song,Movie Name,Artist,Year of Release,Genre,Size,Rating,Duration\n");
		for(int i=0;i<song_list.size();i++)
		{
			br_1.write(song_list.get(i).getTitle()+","+song_list.get(i).getMoviename()+","+song_list.get(i).getArtist()+","+song_list.get(i).getYear()+","+song_list.get(i).getGenre()+","+song_list.get(i).getSize()+","+song_list.get(i).getRating()+","+song_list.get(i).getDuration()+"\n");
		}
		}
		catch(IOException e)
			{
				e.printStackTrace();
			}
			finally{
				br_1.close();
			}
	}
	public static void main(String[] arg)
	{
		BufferedReader br_1 = null;
		BufferedReader br_2 = null;
		
		try{
			br_1 = new BufferedReader(new FileReader("movie.txt"));
			br_2 = new BufferedReader(new FileReader("song.txt"));
			String line_1=br_1.readLine();
			
		while((line_1=br_1.readLine())!=null)
		{	
			String[] details=line_1.split(",");
			Movie mov=new Movie(details[7],details[8],details[9],details[0],details[1],details[2],details[3],details[4],details[5],details[6]);	
			movie_list.add(mov);
		}	
		String line_2=br_2.readLine();
		while((line_2=br_2.readLine())!=null)
		{
			String[] details=line_2.split(",");
			Song son=new Song(details[1],details[0],details[2],details[3],details[4],details[5],details[6],details[7]);	
			song_list.add(son);
		}
		no_of_song=song_list.size();
		no_of_movie=movie_list.size();
		}catch (IOException e)
		{
			e.printStackTrace();
		}
		System.out.println(no_of_movie);
		System.out.println(no_of_song);

	System.out.println("1.Serialise and Deserialise");
	System.out.println("2.List of all song and Movie and their details");
	System.out.println("3.List of k movies by rating");
	System.out.println("4.Search and display songs based on genre.");
	System.out.println("5.Search and display movies based on director");
	System.out.println("6.Edit the rating of a song/movie");
	System.out.println("7.Display the count of number of songs/movies.");
	System.out.println("8.Search and display all the songs of a given movie.");
	System.out.println("9.Quit");
	Scanner input=new Scanner(System.in);
	int option=0;
	while(option!=9)
	{
		System.out.println("Enter your choice");
		option=input.nextInt();
		MediaSystem my=new MediaSystem();
		if(option==1){
			try{
				my.write_movie();
			my.write_song();
			}catch(IOException e)
			{
				e.printStackTrace();
			}
			try{
				my.read_movie();
				my.read_song();
			}catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
			System.out.println("MediaSystem Class Serialised and Deserialised");

	// for(int i=0;i<movie_list.size();i++)
		// System.out.print(movie_list);
	// for(int i=0;i<song_list.size();i++)
		// System.out.println();
		// System.out.print(song_list);
		}
	else if(option==2){

		// getSongs();
		System.out.println("LIST OF ALL SONGS : ");
		int len1 = song_list.size();
		int i;
		for(i=0;i<len1;i++){
			System.out.println(song_list.get(i));
			System.out.println();	
		}
		// getMovies();
		System.out.println("-------------------------------------------------------------------");
		System.out.println("LIST OF ALL MOVIES : ");
		int len2 = movie_list.size();
		int j;
		for(j=0;j<len2;j++){
			System.out.println(movie_list.get(j));
			System.out.println();	
		}


	}
	else if(option==3)
	{
		int k = input.nextInt();
		my.go(k);
	}
	else if(option==4)
	{
		Scanner str = new Scanner(System.in);
		String g = str.nextLine();
		my.SearchGenre(g);	
	}
	else if(option==5)
	{	Scanner str = new Scanner(System.in);
		String d = str.nextLine();
		my.SearchDirector(d);	
	}
	else if(option==6){
		my.update_rating();
		try{
				my.write_movie();
			my.write_song();
			}catch(IOException e)
			{
				e.printStackTrace();
			}
	}
	else if(option==7)
	{
		System.out.println("Number of movies:"+no_of_movie);
		System.out.println("Number of Songs:"+no_of_song);
		System.out.println();
	}
	else if(option==8)
	{	Scanner str = new Scanner(System.in);
		String mov = str.nextLine();
		my.SearchAllSongs(mov);
				
	}
	else if(option==9)
	{
		try{
			my.write_file_music();
			my.write_file_song();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		break;
	}
	else
	{
		System.out.println("Invalid Input");
	}
}
}
}

