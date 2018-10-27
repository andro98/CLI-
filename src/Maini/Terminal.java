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
    String d = "C:\\";

    File dir = new File(d);

    public void cp(String f1, String f2) throws IOException {
        int ind = f1.indexOf(":");
        if(ind == -1){
            f1 = (d + f1);
        }
        // Files.copy(Paths.get(f1),Paths.get(f2));
        File src = new File(f1);
        File des = new File(f2);
        if (src.exists()) {
            if (src.isFile()) {
                if (des.exists()) {
                    if (des.isFile()) {
                        Files.copy(Paths.get(f1), new FileOutputStream(f2));
                    } else if (des.isDirectory()) {
                        String name = "";
                        for (int i = f1.length() - 1; i >= 0; i--) {
                            if (f1.charAt(i) == '\\') {
                                name = f1.substring(i);
                                break;
                            }
                        }
                        f2 += name;
                        Files.copy(Paths.get(f1), new FileOutputStream(f2));
                    }

                } else {

                    String name = "";

                    for (int i = f2.length() - 1; i >= 0; i--) {

                        if (f2.charAt(i) == '\\') {
                            name = f2.substring(0, i - 1);
                            break;
                        }
                    }
                    File check = new File(name);

                    if (check.exists()) {

                        Files.copy(Paths.get(f1), new FileOutputStream(f2));
                    } else {
                        System.out.println("cp: cannot create regular file `" + f2 + "': No such file or directory");
                    }

                }
            } else {
                System.out.println("cp: omitting directory `" + f1 + "'");
            }
        } else {
            System.out.println("cp: cannot stat `" + f1 + "': No such file or directory");
        }
    }

    public void cd(String dest) {
        boolean exist = false;
        if (dest.equals("..")) {
            int j = d.indexOf("\\");
            int i = d.lastIndexOf("\\");
            if (i != j) {

                dest = d.substring(0, i);
                dir = new File(dest);
            }
            else{
                dest = d;
            }
        } else if (dest.indexOf(
                ":") != -1) {
            dir = new File(dest);
        } else {
            dir = new File(d + "\\" + dest);
            exist = true;
            System.out.println("hi");
        }

        if (dir.exists()) {
            if (exist) {
                d += "\\" + dest;
            } else {
                d = dest;
            }
        } else {
            System.out.println("bash: cd: " + dest + ":/ No such file or directory");
        }
    }

    public void ls() {

        File listOfFiles[] = dir.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }

    }

    public void mkdir(String NewFolderName)// b t create new folder
    {
        int ind=NewFolderName.indexOf(":");      
        if(ind==-1)
        {
            NewFolderName=d+NewFolderName;
        }
        File dir = new File(NewFolderName);
        boolean success = dir.mkdir();
        if (success) {
            System.out.println("directory were created successfully");
        } else {
            System.out.println("failed create the directory");
        }
    }

    public void rmdir(String DeletedFolderName) //batms7 el folders ely gowaha fady mafho4 ay 7aga ya3ni
    {
         int ind=DeletedFolderName.indexOf(":");      
        if(ind==-1)
        {
           DeletedFolderName=d+DeletedFolderName;
        }
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
            int ind=FirstFileName.indexOf(":");      
            if(ind==-1)
            {
                 FirstFileName=d+FirstFileName;
            }
            scan = new Scanner(new java.io.File(FirstFileName));
            while (scan.hasNext()) {
                text += scan.next();
            }

        } catch (Exception e) {

            System.out.println("we can't open the first file " + e.getMessage());
        }
        text += " ";
        try {
            int ind=SecondFilename.indexOf(":");      
            if(ind==-1)
            {
                 SecondFilename=d+SecondFilename;
            }
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
       Scanner scan=new Scanner(System.in);
        while(true)
        {
            String s;
            s=scan.nextLine();
            /*if(s.equals("break"))
            {
                break;
            }*/
            System.out.println(s);
        }
    }

    public void rm(String DeletedFileName) // delete a file
    {
       int ind=DeletedFileName.indexOf(":");      
        if(ind==-1)
        {
           DeletedFileName=d+DeletedFileName;
        }
        File file = new File(DeletedFileName);
        if (file.delete()) {
            System.out.println("File deleted successfully");
        } else {
            System.out.println("Failed to delete the file");
        }
    }

    public void pwd() //show the user's current directory
    {
        System.out.println(d);
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

    public boolean exit() {
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

    public void clear() {

        for (int i = 0; i < 100; i++) {

            System.out.println();
        }
    }

    public void mv(String f1, String f2) throws IOException {

        cp(f1, f2);

        File f = new File(f1);

        if (f.exists()) {

            if (f.isFile()) {

                f.delete();
            }
        }
    }
}
