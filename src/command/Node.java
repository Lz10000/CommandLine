package command;

import java.util.ArrayList;
import java.util.Arrays;

public class Node {
    Node parent;
    String dirname;
    ArrayList<Node> subDirs = new ArrayList<Node>();
    
    public Node(String dirname){
            this.dirname = dirname;
            
    }
        
    //adds a dir as a subdir to current dir
    public Node addToNode(String s){
        Node n = new Node(s);
        subDirs.add(n);
        n.parent = this;
        return n;
     }
    
    public Node find(String dirname){
        for(Node n: subDirs){
            if(n.dirname.equals(dirname)){
                return n;
            }
        }
        return null;
    }
   
   
      
}
