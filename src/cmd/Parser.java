package cmd;
import java.io.*;
import java.util.*;

public class Parser {
    String[] args; 
    String cmd;
    int size;
    Terminal t;
    public boolean parse(String input)
    {
        t = new Terminal();
        if(cutInput(input))
        {
            switch(cmd)
        {
            case "cp":
                break;
            case "mv":
                break;
            case "rm":
                if(size != 1 )
                    System.out.println("Wrong number of args");
                else
                    t.mkdir(args[0]);
                break;    
            case "pwd":
                 if(size != 1 )
                    System.out.println("Wrong number of args");
                else
                    t.pwd();
                break;    
            case "clear":
                break;
            case "ls":
                break;
            case "cd":
                break;
            case "mkdir":
                if(size != 1 )
                    System.out.println("Wrong number of args");
                else
                    t.mkdir(args[0]);
                break;
            case "rmdir":
                   if(size != 1 )
                    System.out.println("Wrong number of args");
                else
                    t.rmdir(args[0]);
                break;
            case "cat":
                  if(size != 2 )
                    System.out.println("Wrong number of args");
                else
                    t.cat(args[0], args[1]);
                break;
            case "more":
                break;    
            case "date":
                break;
            case "help":
                break;
            case "exit":
                break;
            case "args":
                break;
            default:
                System.out.println("There is no such command");
                return false;
        }
        }
        else{
            System.out.println("There is no such command");
        }
        return false;
    }
    
    
    private boolean cutInput(String Input)
    {
        int ind = setSize(Input);
        if(ind == -1)
            return false;
        cmd = Input.substring(0, ind);
        size++;
        args = new String[size];
        int k =0;
        for(int i=ind + 1; i<Input.length(); i++)
        {
            String tmp = "";
            while(i < Input.length() && Input.charAt(i) != ' ')
            {
                if( Input.charAt(i) == '"')
                {
                    i++;
                     while(Input.charAt(i) != '"')
                        {
                            tmp +=Input.charAt(i);
                            i++;
                        }
                        break;
                }
                tmp +=Input.charAt(i);
                i++;
            }
            args[k] = tmp;
            k++;
        }
        return true;
    }
    
    private int setSize(String Input)
    {    
        int ind = Input.indexOf(" ");
        if(ind == -1)
        {
            if(Input.equals("pwd"))
            {
                ind = 3;
                return ind;
            }
        }
        size = 0;
        for(int j=ind + 1; j<Input.length(); j++){
            if( Input.charAt(j) == '"')
            {
                j++;
                 if(j>=Input.length())
                    {
                        return -1;
                    }
                while(Input.charAt(j) != '"')
                {
                    j++;
                    if(j>=Input.length())
                        {
                            return -1;
                        }
                }
            }
            if( Input.charAt(j) == ' ')
            {
                size++;
            }
        }
        return ind;
    }
}
