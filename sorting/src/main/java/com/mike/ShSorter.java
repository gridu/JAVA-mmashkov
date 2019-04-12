package com.mike;

import java.awt.geom.Area;
import java.util.LinkedList;

import static java.lang.Math.pow;

public class ShSorter {
    private IndexesHolder indexes;

    private LinkedList<Integer> gaps=new LinkedList<>();

    public ShSorter(IndexesHolder indexes) {
        this.indexes = indexes;
        this.gaps=countGap(indexes.getArr().size());
    }

     private LinkedList countGap(int size) {
        int i=1, gap=1;
        LinkedList<Integer> tmpListofGaps = new LinkedList();
        do {

            tmpListofGaps.add(gap);
            gap= (int) (pow(4,i)+3*pow(2,i-1)+1);
            i++;
        }while (gap*3<size);
        return tmpListofGaps;
    }

    public LinkedList<Integer> getGaps() {

        return gaps;
    }


    public void start(IndexesHolder holder) {
        long before = System.currentTimeMillis();
        do {

            for (int i = 0; i < gaps.getLast(); i++) {
                LinkedList<Integer> points = generateListForsort(indexes.getArr().size()-1, i);
                System.out.println(points);
                //   new InsertionSort(indexes, gaps.getLast())
                InsertionSort toSort = new InsertionSort(holder,points);
                holder=toSort.start2();
            }
            gaps.removeLast();

        }while(gaps.size()>1);
        long after = System.currentTimeMillis()-before;
        System.out.println("Time="+after);
    }

    private LinkedList<Integer> generateListForsort(int size, int i) {
        LinkedList<Integer> elements = new LinkedList<Integer>();
        int pointer = i;
        while (size>=pointer)
        {
            elements.add(pointer);
            pointer+=gaps.getLast();
        }

        return elements;

    }
}
