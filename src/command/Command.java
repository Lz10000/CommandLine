package command;

import java.util.Scanner;

public class Command {
    
    
    
    public static void main(String[] args){
        Node tree = new Node("root");
        String command;
        Scanner scanner = new Scanner(System.in);
        CommandHandler ch = new CommandHandler(tree);
        while( (command = scanner.nextLine()) != null) {
            ch.handle(command);
        }
    }
}
