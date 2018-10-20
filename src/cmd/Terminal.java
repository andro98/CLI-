package cmd;

import java.util.*;
import java.io.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Terminal {

    public void mkdir(String NewFolderName)// b t create new folder
    {
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

    public void more() // batbin kol command bai3ml eh ll user
    {
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

    public String cd(String current, String commandd) {
        String dot = "..";
        Stack<String> directoryStack = new Stack<String>();
        String[] split = current.split("/");
        for (String cmd : split) {
            directoryStack.push(cmd);
        }
        String[] split2 = commandd.split("/");
        for (String cmd : split2) {
            if (dot.equals(cmd)) {
                if (!directoryStack.empty()) {
                    directoryStack.pop();
                }
            } else {
                directoryStack.push(cmd);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!directoryStack.isEmpty()) {
            String cmd = directoryStack.pop();
            sb.insert(0, cmd);
            sb.insert(0, "/");
        }
        return sb.toString();

    }

    public static void clearcons() {

        for (int i = 0; i < 100; i++) {

            System.out.println();
        }
    }

    public static void cp(String f1, String f2) throws IOException {

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
}
