package com.mike;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;


public class InsertionSort {
    private static long comparings=0;
    private IndexesHolder indexes;
    private int begin=0;
    private int end=0;
    static FileOperations s;
    private LinkedList<Integer> points=null;

    {
        try {
            s = new FileOperations("src/main/resources/strings.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public InsertionSort(IndexesHolder arr) {
        this.indexes = arr;
    }

    public InsertionSort(IndexesHolder arr,int begin,int end) {
        this.indexes = arr;
        this.begin = begin;
        this.end = end;
    }

    public InsertionSort(IndexesHolder arr, LinkedList<Integer> points) {
        this.indexes=arr;
        this.points=points;
    }

    private int compareAndCount(String a,String b)
    {
        comparings++;
        return a.compareTo(b);
    }

    public IndexesHolder start() {
        int temp, j;

        for (int i = 0; i < indexes.getArr().size() - 1; i++) {
            String valI = s.gevaValueofElement(indexes.getArr().get(i));
            String val_Iplus1 = s.gevaValueofElement(indexes.getArr().get(i + 1));
            if (compareAndCount(valI,val_Iplus1) > 0) {

                ArrayValues tmpVal = indexes.getArr().get(i + 1);

                j = i;
                while (j > 0 && (compareAndCount(s.gevaValueofElement(indexes.getArr().get(j-1)),val_Iplus1) > 0)) {
                    j--;
                }
                indexes.getArr().remove(i + 1);
                indexes.getArr().add(j, tmpVal);
            }

        }
        System.out.println("Comparision="+ comparings);
        return this.indexes;
    }


    public IndexesHolder start2() {
        int temp, j;

        for (int i = 0; i < points.size() - 1; i++) {
            String valI = s.gevaValueofElement(indexes.getArr().get(points.get(i)));
            String val_Iplus1 = s.gevaValueofElement(indexes.getArr().get(points.get(i+1)));
            if (compareAndCount(valI,val_Iplus1) > 0) {

                ArrayValues tmpVal = indexes.getArr().get(points.get(i+1));

                j = i;
                while (j > 0 && (compareAndCount(s.gevaValueofElement(indexes.getArr().get(points.get(j-1))),val_Iplus1) > 0)) {
                    j--;
                }
                indexes.getArr().remove(points.get(i+1));
                indexes.getArr().add(points.get(j), tmpVal);
            }

        }
        System.out.println("Comparision="+ comparings);
        return this.indexes;

    }


//    public void outSorted()
//    {
//        System.out.println("========================");
//        RandomAccessFile raf = null;
//        try {
//            raf = new RandomAccessFile("src/main/resources/strings.csv".toString(), "rw");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        LinkedList<ArrayValues> tmpArr = indexes.getArr();
//        for (int i = 0; i < tmpArr.size(); i++) {
//            try {
//                raf.seek(tmpArr.get(i).getStartOffset());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                System.out.println(raf.readLine());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
}
//    int temp, j;
//    for(int i = 0; i < arr.length - 1; i++){
//        if (arr[i] > arr[i + 1]) {
//        temp = arr[i + 1];
//        arr[i + 1] = arr[i];
//        j = i;
//        while (j > 0 && temp < arr[j - 1]) {
//        arr[j] = arr[j - 1];
//        j--;
//        }
//        arr[j] = temp;
//        }
//        }