/*@author
1.Gunkirat Kaur:2015032
2.Shaan Chopra:2015090
*/
import java.util.*;

class Vertex implements Comparable<Vertex>{
    public final String name;
    public ArrayList<Edge> adjacency_list;
    public int dist = 1000000;
    public Vertex prev = null;
    public char colour = 'w';
    public Vertex(String s1){
     name = s1; 
}
    public String toString(){
        return name;
    }
    public int compareTo(Vertex v1){
        if(dist <= v1.dist){
            return dist;
        }
        else{
            return v1.dist;
        }
    }
    

}