package com.mike;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static junit.framework.TestCase.assertTrue;

public class IndexesHolder {

    Path pathOfFile=null;
    private List<ArrayValues> arr=new ArrayList<>();

    public IndexesHolder(Path filePath) {
        this.pathOfFile=filePath;
    }

    @Override
    public String toString() {
        
        return "ArrayData{" +
                "arr=" + arr +
                '}';
    }

    public List<ArrayValues> getArr() {
        return arr;
    }

    public void setArr(ArrayList<ArrayValues> arr) {
        this.arr = arr;
    }

    public void flip(int a, int b)
    {
        ArrayValues tmpElement = arr.get(a);
        arr.set(a,arr.get(b));
        arr.set(b,tmpElement);
    }

    public void outSorted() {
try {
    RandomAccessFile raf = new RandomAccessFile(pathOfFile.toString(), "rw");

    List<ArrayValues> tmpArr = this.getArr();
    raf.seek(tmpArr.get(0).getStartOffset());
    String firstElem = raf.readLine();
    for (int i = 1; i < tmpArr.size(); i++) {

        raf.seek(tmpArr.get(i).getStartOffset());
        String second = raf.readLine();
        assertTrue("WRONG SORTING", firstElem.compareTo(second) <= 0);

          //     System.out.println(second);
        firstElem = second;
    }


    ////====
    raf.seek(0);
    String tmp=null;
    LinkedList<String> arrayForSort=new LinkedList<>();
    while((tmp=raf.readLine())!=null)

    {
        arrayForSort.add(tmp);
    }
    long before = System.currentTimeMillis();
    Collections.sort(arrayForSort);
    System.out.println("Sorted LinkedList"+(System.currentTimeMillis()-before));


    raf.seek(0);
    ArrayList<String> arrayForSort2=new ArrayList<>();
    while((tmp=raf.readLine())!=null)

    {
        arrayForSort2.add(tmp);
    }
     before = System.currentTimeMillis();
    Collections.sort(arrayForSort2);
    System.out.println("Sorted ArrayList"+(System.currentTimeMillis()-before));

    ////====
}catch (Exception e)
{
    e.printStackTrace();
}
        //     System.out.println("Arrsize="+tmpArr.size());
    }
}
