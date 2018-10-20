package Maini;

import java.io.*;
import java.util.*;

public class Parser {

    String[] args;
    String cmd;
    int size;
    Terminal t;

    public boolean parse(String input) {
        t = new Terminal();
        if (cutInput(input)) {
            switch (cmd) {
                case "cp":
                    break;
                case "mv":
                    break;
                case "rm":
                    if (size != 1) {
                        System.out.println("Wrong number of args");
                    } else {
                        t.rm(args[0]);
                    }
                    break;
                case "pwd":
                    if (size != 0) {
                        System.out.println("Wrong number of args");
                    } else {
                        t.pwd();
                    }
                    break;
                case "clear":
                    if (size != 0) {
                        System.out.println("Wrong number of args");
                    } else {
                        t.clear();
                    }
                    break;
                case "ls":
                    break;
                case "cd":
                    break;
                case "mkdir":
                    if (size != 1) {
                        System.out.println("Wrong number of args");
                    } else {
                        t.mkdir(args[0]);
                    }
                    break;
                case "rmdir":
                    if (size != 1) {
                        System.out.println("Wrong number of args");
                    } else {
                        t.rmdir(args[0]);
                    }
                    break;
                case "cat":
                    if (size != 2) {
                        System.out.println("Wrong number of args");
                    } else {
                        t.cat(args[0], args[1]);
                    }
                    break;
                case "more":
                    if (size != 0) {
                        System.out.println("Wrong number of args");
                    } else {
                        t.more();
                    }
                    break;
                case "date":
                    if (size != 0) {
                        System.out.println("Wrong number of args");
                    } else {
                        t.Date();
                    }
                    break;
                case "help":
                    if (size != 0) {
                        System.out.println("Wrong number of args");
                    } else {
                        t.help();
                    }
                    break;
                case "exit":
                    if (size != 0) {
                        System.out.println("Wrong number of args");
                    } else {
                        t.exit();
                        return false;
                    }
                    break;
                case "args":
                    if (size != 0) {
                        System.out.println("Wrong number of args");
                    } else {
                        t.args();
                    }
                    break;
                default:
                    System.out.println("There is no such command");
                    break;
            }
        } else {
            System.out.println("There is no such command");
        }
        return true;
    }

    private boolean cutInput(String Input) {
        int ind = setSize(Input);
        if (ind == -1) {
            return false;
        } else if (ind == -2) {
            cmd = Input;
            return true;
        }
        cmd = Input.substring(0, ind);
        size++;
        args = new String[size];
        int k = 0;
        for (int i = ind + 1; i < Input.length(); i++) {
            String tmp = "";
            while (i < Input.length() && Input.charAt(i) != ' ') {
                if (Input.charAt(i) == '"') {
                    i++;
                    while (Input.charAt(i) != '"') {
                        tmp += Input.charAt(i);
                        i++;
                    }
                    break;
                }
                tmp += Input.charAt(i);
                i++;
            }
            args[k] = tmp;
            k++;
        }
        return true;
    }

    private int setSize(String Input) {
        size = 0;
        int ind = Input.indexOf(" ");
        if (ind == -1) {
            if (Input.equals("pwd") || Input.equals("more") || Input.equals("clear") || Input.equals("args") || Input.equals("exit") || Input.equals("help")) {
                return -2;
            }
        }
        for (int j = ind + 1; j < Input.length(); j++) {
            if (Input.charAt(j) == '"') {
                j++;
                if (j >= Input.length()) {
                    return -1;
                }
                while (Input.charAt(j) != '"') {
                    j++;
                    if (j >= Input.length()) {
                        return -1;
                    }
                }
            }
            if (Input.charAt(j) == ' ') {
                size++;
            }
        }
        return ind;
    }
}
