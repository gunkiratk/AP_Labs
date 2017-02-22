/*@author
1.Gunkirat Kaur(2015032)
2.Shaan Chopra(2015090)
*/
import java.util.*;

public class PasswordException extends Exception{
    private String str1;
    public PasswordException(String str1){
        this.str1 = str1;
    }
    public String toString(){
       return " Password Incorrect";
    }
}