package com.mike;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

import static java.nio.ByteBuffer.allocate;
import static java.nio.file.StandardOpenOption.READ;

public class FileOperations {
    private static long reads=0;
    IndexesHolder holder = new IndexesHolder();
    RandomAccessFile raf ;

//    private static final String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
//            + "0123456789"
//            + "abcdefghijklmnopqrstuvxyz";

    private static final String AlphaNumericString = "12";
    private static final int charLen = AlphaNumericString.length();

    private Path file;

    public FileOperations(String filePath) throws FileNotFoundException {
        file=Paths.get(filePath);
        raf = new RandomAccessFile(file.toString(), "rw");
    }

    // function to generate a random string of length n
    public static String getAlphaNumericString(int n) {

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
//        IntStream.range(0, n).forEach(d ->
//                sb.append(AlphaNumericString.charAt(((int)
//                        Math.random()*ldd))));


        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int) (charLen * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    public void WriteDataToFile(String file) throws IOException {

        BufferedWriter bw = Files.newBufferedWriter(Paths.get("src/main/resources/strings.csv"));
        bw.write("fdsfdasfdsafds");
        bw.close();


        // Get the size n
        int n = 20;
        for (int j = 0; j < 20; j++) {
            FileOperations.getAlphaNumericString(n);
            System.out.println(FileOperations.getAlphaNumericString(n));
        }

    }


    public Path getArrayOfStrings(int stringCount, int length) throws IOException {
        LinkedList<String> result=new LinkedList<>();

        BufferedWriter bw = Files.newBufferedWriter(file);


        for (int j = 0; j < stringCount; j++) {
            bw.write(FileOperations.getAlphaNumericString(length));
             bw.newLine();

        }
        bw.close();
        return file;

    }

    public void getHolder(Path file) throws IOException {

        raf.seek(0);
        String tmpsSTR;
        System.out.print(raf.getFilePointer()+" ");
        long offsetBegin = raf.getFilePointer();
        while((tmpsSTR = raf.readLine()) != null) {
            System.out.println("  "+ tmpsSTR +" "+ tmpsSTR.length()+ " "+raf.getFilePointer());
            ArrayValues arrayValues = new ArrayValues(offsetBegin,tmpsSTR.length());
            holder.getArr().add(arrayValues);
            offsetBegin=raf.getFilePointer();
//            offsetBegin=tmpsSTR.length()+System.lineSeparator().length();
        }



    }

    public void outSorted() throws IOException {


        LinkedList<ArrayValues> tmpArr = holder.getArr();
        for(int i=0;i<tmpArr.size();i++)
        {
            raf.seek(tmpArr.get(i).getStartOffset());
            System.out.println(raf.readLine());
        }

    }

    public void runSort() {
        InsertionSort toSort = new InsertionSort(holder);
        ShSorter toShSortt=new ShSorter(holder);
        System.out.println("Readings="+toShSortt.getGaps());
        toShSortt.start(holder);
    //    this.holder=toSort.start();
        System.out.println("Readings="+reads);

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