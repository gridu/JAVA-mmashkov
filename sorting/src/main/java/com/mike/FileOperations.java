package com.mike;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.mike.Utils.getAlphaNumericString;
import static org.junit.Assert.assertTrue;

public class FileOperations {

    private static long reads=0;
    RandomAccessFile raf ;
    private Path file;

    public FileOperations(String filePath) throws FileNotFoundException {

        file=Paths.get(filePath);
        raf = new RandomAccessFile(file.toString(), "rw");
    }


    public Path generateFileOfStrings(int stringCount, int length) throws IOException {
        BufferedWriter bw = Files.newBufferedWriter(file);
        for (int j = 0; j < stringCount; j++) {
            bw.write(getAlphaNumericString(length));
             bw.newLine();
        }
        bw.close();

        return file;
    }

    public IndexesHolder getIndexesHoderFromFile(Path file) throws IOException {
        IndexesHolder indexHolder = new IndexesHolder(file);
        raf.seek(0);
        String tmpsSTR=null;
        long offsetBegin = raf.getFilePointer();
        while((tmpsSTR = raf.readLine()) != null) {
            ArrayValues arrayValues = new ArrayValues(offsetBegin,tmpsSTR.length());
            indexHolder.getArr().add(arrayValues);
            offsetBegin=raf.getFilePointer();

        }
        System.out.println("Array filled");
        return indexHolder;
    }

    public void printReadings()
    {
        System.out.println("Reads="+reads);
    }

    public  String gevaValueofElement(ArrayValues element)
    {
        try {

            raf.seek(element.getStartOffset());
            reads++;
            return raf.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}