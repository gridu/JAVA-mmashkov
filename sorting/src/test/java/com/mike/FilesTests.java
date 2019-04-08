package com.mike;


import org.junit.Test;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class FilesTests {


    @Test
    public void getZerroLengthstrings() throws IOException {
        int lineCount=0;
        FileOperations r = new FileOperations("src/main/resources/strings.csv");
        InputStreamReader is;
        Path file = r.getArrayOfStrings(200, 0);
        BufferedReader bw = Files.newBufferedReader(file);
        String newLine;
        while((newLine=bw.readLine())!=null)
        {
            lineCount++;
            assertThat(newLine.length(),is(0));
            //System.out.println(newLine);
        }
        assertThat(lineCount,is(200));

    }

    @Test
    public void getZerroRecords() throws IOException {
        int lineCount=0;
        FileOperations r = new FileOperations("src/main/resources/strings.csv");
        InputStreamReader is;
        Path file = r.getArrayOfStrings(0, 10);
        BufferedReader bw = Files.newBufferedReader(file);
        String newLine;
        while((newLine=bw.readLine())!=null)
        {
            lineCount++;
            assertThat(newLine.length(),is(10));
            //System.out.println(newLine);
        }
        assertThat(lineCount,is(0));

    }

    @Test
    public void getListof200ElementsSize10() throws IOException {
        int lineCount=0;
        FileOperations r = new FileOperations("src/main/resources/strings.csv");
        InputStreamReader is;
        Path file = r.getArrayOfStrings(200, 10);

        BufferedReader bw = Files.newBufferedReader(file);
        String newLine;
        while((newLine=bw.readLine())!=null)
        {
            lineCount++;
            assertThat(newLine.length(),is(10));
            //System.out.println(newLine);
        }
        assertThat(lineCount,is(200));




    }
}
