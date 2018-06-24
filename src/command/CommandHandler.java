package command;

import java.util.Arrays;
import java.util.Stack;

public class CommandHandler {
    Node tree;
    Node currDir;
        
    public CommandHandler(Node tree){
        this.tree = tree;
        currDir = tree;
    }
    
    public void handle(String command){
        String[] args = command.split("\\s+");
        if(args.length == 2){
            String commandArg = args[0];
            if(commandArg.equals(CommandType.MKDIR)){
                mkDir(args[1]);
            }else if(commandArg.equals(CommandType.CD)){
                cd(args[1]);
            }
        }else if(args.length == 1){
            if(args[0].equals(CommandType.DIR)){
                printDirStructure();
            }else if(args[0].equals(CommandType.UP)){
                up();
            }
        }else{
            System.out.println("Invalid command");
        }
        
        
    }
    
    public void up(){
        if(currDir.parent == null){
            System.out.println("Cannot move up from root directory");
        }else{
            currDir = currDir.parent;
        }
    }
    
    public void cd(String arg){
        Node n = currDir.find(arg);
        if(n == null){
            System.out.println("Subdirectory does not exist");
        }else{
            currDir = n;
        }
    }
    
    public void mkDir(String arg){
        if(currDir.find(arg) != null){
            System.out.println("Subdirectory already exists");
        }else{
            currDir.addToNode(arg); 
        }
    }
    
    public void printDirStructure(){
        int dirLength = currDir.subDirs.size();
        System.out.println("Directory of "+current());
        if(dirLength == 0){
            System.out.println("No subdirectories");
        }else{
            String[] names = new String[currDir.subDirs.size()];
            int index = 0;
            for(Node n : currDir.subDirs){
                names[index++] = n.dirname;
            }
            Arrays.sort(names);
            int num = 0;
            for (String n: names) {
                if (num++ == 10)
                    System.out.println();
                System.out.print(n + " ");
            }
            System.out.println("");
        }
    }
    
    public String current(){
        Stack<String> values = new Stack<>();
        Node c = this.currDir;
        while (c != null) {
            values.add(c.dirname);
            c = c.parent;
        }
        String s = values.pop();
        while (!values.empty())
            s += ("\\" + values.pop());
        return s;
    }
    
    
   
}
