package com.mike;

import java.io.IOException;
import java.nio.file.Path;

public class SortStarter {
    //new Paths("src/main/resources/strings.csv");
    static String root = "src/main/resources/";
    static String defFile="strings.csv";
    static String fileToSort=null;


    public static void main(String... args) throws IOException {
        if (args.length>0)
        if (args[0]==null)
        {
            fileToSort=root+defFile;
        }
        else
        {
            fileToSort=root+args[0];
        }

        fileToSort=root+defFile;
        System.out.println("begin");
        FileOperations s = new FileOperations(fileToSort);
        Path arr = s.getArrayOfStrings(100000, 5);
        s.fillHolder(arr);
        s.runSort();
        s.outSorted();

        //1)Generate test file / load
        //2)call sorter(FileStream)
        //3)
    }
}
