package com.mike;

import java.util.LinkedList;

public class IndexesHolder {


    private LinkedList<ArrayValues> arr=new LinkedList<>();

    public LinkedList<ArrayValues> getArr() {
        return arr;
    }

    public void setArr(LinkedList<ArrayValues> arr) {
        this.arr = arr;
    }

    public void flip(int a, int b)
    {
        ArrayValues tmpElement = arr.get(a);
        arr.set(a,arr.get(b));
        arr.set(b,tmpElement);
    }
}
