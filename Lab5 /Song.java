import java.util.*;
import java.io.*;

class Song extends Media{

	private String moviename;

	Song(String mn,String t,String a,String y,String gen,String s,String r,String d){
		super(t,a,y,gen,s,r,d);
		moviename = mn;
	}

	public String getMoviename(){
		return moviename;
	}

	public String toString(){
		return "Song Name : " + getTitle()+"\n"+"Movie Name : " + getMoviename()+"\n"+"Artist : " + getArtist()+"\n"+"Year of Release : " + getYear()+"\n"+"Genre : " + getGenre()+"\n"+"Size : " + getSize()+"\n"+"Rating : " + getRating()+"\n"+"Duration(min) : " + getDuration();
		

	}
}