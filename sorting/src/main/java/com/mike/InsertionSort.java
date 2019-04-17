package com.mike;

import java.io.FileNotFoundException;
import java.util.*;


public class InsertionSort implements Sorters {
    private static long comparings = 0;
    private IndexesHolder indexes;
    private int begin = 0;
    private int end = 0;
    static FileOperations s;
    private List<Integer> points = null;


    public InsertionSort(IndexesHolder arr) {
        this.indexes = arr;
    }

    public InsertionSort(IndexesHolder arr, int begin, int end) {
        this.indexes = arr;
        this.begin = begin;
        this.end = end;
    }

    public InsertionSort(IndexesHolder arr, List<Integer> points) {
        this.indexes = arr;
        this.points = points;
        try {
            s = new FileOperations(arr.pathOfFile.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private int compareAndCount(String a, String b) {
        comparings++;
        return a.compareTo(b);
    }


    public IndexesHolder start2() {
        List<String> stringsToSort = getMapofStrings(points);
        long before = System.currentTimeMillis();

        int temp, j;
        //System.out.println("start2 begin" + this.indexes.getArr().size());
        for (int i = 0; i < points.size() - 1; i++) {
            //String valI = s.gevaValueofElement(this.indexes.getArr().get(points.get(i)));
            String valI = stringsToSort.get(i);
            //String val_Iplus1 = s.gevaValueofElement(this.indexes.getArr().get(points.get(i + 1)));
            String val_Iplus1 = stringsToSort.get(i + 1);
            if (compareAndCount(valI, val_Iplus1) > 0) {

                ArrayValues tmpVal = this.indexes.getArr().get(points.get(i + 1));
                String tmpString=stringsToSort.get(i + 1);
                j = i;
             //   while (j > 0 && (compareAndCount(s.gevaValueofElement(this.indexes.getArr().get(points.get(j - 1))), val_Iplus1) > 0)) {
                while (j > 0 && (compareAndCount(stringsToSort.get(j - 1), val_Iplus1) > 0)) {
                    j--;
                }
                ArrayValues rem = this.indexes.getArr().remove((int) points.get(i + 1));
                String rem2 = stringsToSort.remove(i + 1);
                this.indexes.getArr().add(points.get(j), tmpVal);
                stringsToSort.add(j, tmpString);

                //               System.out.println("remoove="+ rem);
            }

        }
        System.out.println("Comparision=" + comparings);
        long after = System.currentTimeMillis();
        System.out.println("Sort takes ="+(after-before));
        return this.indexes;

    }


    public List<String> getMapofStrings(List<Integer> points) {
        List<String> listToSort=new ArrayList<>();

        for (int i=0;i<points.size();i++)
        {
            listToSort.add(s.gevaValueofElement(
                    this.indexes.getArr().get(points.get(i))));

        }
        s.printReadings();

        return listToSort;
    }

    @Override
    public void runSort() {

    }
}