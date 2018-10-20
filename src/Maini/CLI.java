package Maini;

import java.io.*;
import java.util.*;

/**
 * @author Andrew Emad
 * @author Maria George
 * @author Andrew Maher
 */
public class CLI {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        Parser p = new Parser();
        String input;
        boolean cont = true;
        
        while(cont)
        {
           input = myScan.nextLine();
           cont = p.parse(input);
        }
    }
    
}
