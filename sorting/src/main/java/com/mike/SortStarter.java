package com.mike;

import java.nio.file.Path;
import java.nio.file.Paths;

public class SortStarter {
    //new Paths("src/main/resources/strings.csv");
    static String root = "src/main/resources/";
    static String defFile="strings.csv";
    static Path fileToSort;
    public static void main(String... args)
    {

        if (args[0]==null)
        {
            fileToSort=Paths.get(root+defFile);
        }
        else
        {
            fileToSort=Paths.get(root+args[0]);
        }


        System.out.println("begin");
      //  FileOperations s = new FileOperations();
        //1)Generate test file / load
        //2)call sorter(FileStream)
        //3)
    }
}
