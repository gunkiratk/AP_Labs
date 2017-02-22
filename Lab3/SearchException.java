/*@author
1.Gunkirat Kaur:2015032
2.Shaan Chopra:2015090
*/
import java.util.*;

public class SearchException extends Exception{
    private String str1;
    public SearchException(String str1){
        this.str1 = str1;
    }
    public String toString(){
       return "Usr " + str1+ " not found";
    }
}