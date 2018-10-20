package Maini;

import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Terminal {

    public static String[] cmd = new String[15];
    public static String[] help = new String[15];
    public static String[] arr = new String[15];

    public Terminal() {
        set_help();
    }

    public void mkdir(String NewFolderName)// b t create new folder
    {
        File dir = new File(NewFolderName);
        boolean success = dir.mkdir();
        if (success) {
            System.out.println("directorie were created successfully");
        } else {
            System.out.println("failed create the directorie");
        }
    }

    public void rmdir(String DeletedFolderName) //batms7 el folders ely gowaha fady mafho4 ay 7aga ya3ni
    {
        File dir = new File(DeletedFolderName);
        boolean success = dir.delete();
        if (success) {
            System.out.println("directory were deleted successfully");
        } else {
            System.out.println("failed delete the directory");
        }
    }

    public void cat(String FirstFileName, String SecondFilename)//concatinate two files's content and show the result
    {
        Scanner scan, scan2;
        String text = new String("");
        try {
            scan = new Scanner(new java.io.File(FirstFileName));
            while (scan.hasNext()) {
                text += scan.next();
            }

        } catch (Exception e) {

            System.out.println("we can't open the first file " + e.getMessage());
        }
        text += " ";
        try {
            scan2 = new Scanner(new java.io.File(SecondFilename));
            while (scan2.hasNext()) {
                text += scan2.next();
            }
        } catch (Exception e) {

            System.out.println("we can't open the second file " + e.getMessage());
        }
        System.out.println(text);
    }

    public void more() {
        System.out.print("[cd] ");
        System.out.println("change the directory");
        System.out.print("[clear] ");
        System.out.println("delete the command");
        System.out.print("[cp] ");
        System.out.println("copy and paste");
        System.out.print("[mkdir] ");
        System.out.println("Make a new folder");
        System.out.print("[rmdir] ");
        System.out.println("delete a folder which has no content inside it");
        System.out.print("[cat] ");
        System.out.println("concatinate tow folder's content and show the result");
        System.out.print("[rm] ");
        System.out.println("delete a file");
        System.out.print("[pwd] ");
        System.out.println("show the user's current directory");
    }

    public void rm(String DeletedFileName) // delete a file
    {
        File file = new File(DeletedFileName);
        if (file.delete()) {
            System.out.println("File deleted successfully");
        } else {
            System.out.println("Failed to delete the file");
        }
    }

    public void pwd() //show the user's current directory
    {
        String pwd = System.getProperty("user.dir");
        System.out.println(pwd);
    }

    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void cd(String Input) {

    }

    public void mv(String src, String dst) {
        // Files.move(new Path(src), new Path(dst),StandardCopyOption.COPY_ATTRIBUTES );
    }

    public void args() {
        for (int k = 0; k < 15; k++) {
            System.out.println(cmd[k] + " : " + arr[k]);
        }
    }

    public void help() {
        for (int k = 0; k < 15; k++) {
            System.out.println(cmd[k] + " : " + help[k]);
        }
    }

    public void Date() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
      
    }
    
    public boolean exit()
    {
        return false;
    }
    
    private static void set_help() {
        cmd[0] = "clear";
        cmd[1] = "cd";
        cmd[2] = "ls";
        cmd[3] = "cp";
        cmd[4] = "mv";
        cmd[5] = "rm";
        cmd[6] = "mkdir";
        cmd[7] = "rmdir";
        cmd[8] = "cat";
        cmd[9] = "more";
        cmd[10] = "pwd";
        cmd[11] = "date";
        cmd[12] = "args";
        cmd[13] = "exit";
        cmd[14] = "help";

        help[0] = "clear the terminal screen";
        help[1] = "Change the shell working directory.\nChange the current directory to DIR. The default DIR is the value of theHOME shell variable.";
        help[2] = "list directory contents.";
        help[3] = "copy files and directories.";
        help[4] = "move files.";
        help[5] = "remove files or directories.";
        help[6] = "make directories.";
        help[7] = "remove empty directories.";
        help[8] = "concatenate files and print on the standard output.";
        help[9] = "file perusal filter for crt viewing.";
        help[10] = "Print the name of the current working directory.";
        help[11] = "Current date/time.";
        help[12] = "List all command arguments.";
        help[13] = "Stop all.";
        help[14] = "display information about builtin commands.";

        arr[0] = "it takes no arguments.";
        arr[1] = "one string the path of the new directory.";
        arr[2] = "(the arguments are optional) one or more string the directory that would be listed.";
        arr[3] = "two strings the path of the files.";
        arr[4] = "two strings the path of the files.";
        arr[5] = "one string the path of the file.";
        arr[6] = "one string the path of the directory.";
        arr[7] = "one string the path of the directory.";
        arr[8] = "one string or more the path of the file.";
        arr[9] = "one string the path of the file.";
        arr[10] = "it takes no arguments.";
        arr[11] = "it take no arguments.";
        arr[12] = "one string the name of the commands.";
        arr[13] = "it takes no arguments.";
        arr[14] = "it takes no arguments.";
    }

}
