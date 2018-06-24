package test;

import static org.junit.Assert.*;

import org.junit.Test;

import command.CommandHandler;
import command.Node;

public class TestCases {

    @Test
    public void test() {
        Node tree = new Node("root");
        CommandHandler ch = new CommandHandler(tree);
        
        assertEquals(ch.current(), "root");
        
        ch.handle("mkdir liz");
        assertEquals(ch.current(), "root");
        
        ch.handle("cd liz");
        assertEquals(ch.current(), "root\\liz");
        
        ch.handle("up");
        assertEquals(ch.current(), "root");
    }

}
