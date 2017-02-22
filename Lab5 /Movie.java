import java.util.*;
import java.io.*;

class Movie extends Media{
	private String director;
	private String producer;
	private String certification;

	Movie(String dir, String pro, String cer,String title,String a,String y,String gen,String s,String r, String d){
		super(title,a,y,gen,s,r,d);
		director = dir;
		producer = pro;
		certification = cer;
	}


	public String getDirector(){
		return director;
	}

	public String getProducer(){
		return producer;
	}

	public String getCertification(){
		return certification;
	}

	public String toString(){
		return "Movie Name : " + getTitle()+"\n"+"Artist : " + getArtist()+"\n"+"Year of Release : " + getYear()+"\n"+"Genre : " + getGenre()+"\n"+"Size : " + getSize()+"\n"+"Rating : " + getRating()+"\n"+"Duration(hrs) : " + getDuration()+"\n"+"Director : " + getDirector()+"\n"+"Producer : " + getProducer()+"\n"+"Certification : " + getCertification();
	
	}
}