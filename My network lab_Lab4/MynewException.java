import java.util.*;

public class MynewException extends Exception{
    private String str1;
    public MynewException(String str1){
        this.str1 = str1;
    }
    public String toString(){
       return "Username " + str1+ " does not exist. Please register.";
    }
}