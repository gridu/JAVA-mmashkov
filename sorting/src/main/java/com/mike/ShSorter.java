package com.mike;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.mike.Utils.countGap;

public class ShSorter implements Sorters {
    private IndexesHolder indexes;

    private LinkedList<Integer> gaps=new LinkedList<>();

    public ShSorter(IndexesHolder indexes) {
        this.indexes = indexes;
        this.gaps=countGap(indexes.getArr().size());
    }


    public void runSort() {
        long before = System.currentTimeMillis();
        do {

            for (int i = 0; i < gaps.getLast(); i++) {
                List<Integer> points = generateListForSubSort(indexes.getArr().size()-1, i);
                System.out.println(points);
                //   new InsertionSort(indexes, gaps.getLast())
                InsertionSort toSort = new InsertionSort(indexes,points);
                toSort.start2();
                //holder=toSort.start2();
            }
            gaps.removeLast();

        }while(gaps.size()>0);
        indexes.outSorted();
        long after = System.currentTimeMillis()-before;
        System.out.println("Time="+after);
    }

    private List<Integer> generateListForSubSort(int size, int i) {
        List<Integer> elements = new ArrayList<>();
        int pointer = i;
        while (size>=pointer)
        {
            elements.add(pointer);
            pointer+=gaps.getLast();
        }

        return elements;

    }
}
