package cmd;

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
        
        while(true)
        {
           input = myScan.nextLine();
           p.parse(input);
        }
           /*command obj=new command();
       
      System.out.println( obj.cd("C:/Users/hp/desktop", "hio"));
      String pwd = System.getProperty("user.dir");
        System.out.println(pwd);cmd*/
    }
    
}
