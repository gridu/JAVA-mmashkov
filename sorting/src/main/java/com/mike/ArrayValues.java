package com.mike;

public class ArrayValues {

    private long startOffset;
    private int length;

    public ArrayValues(long startOffset, int length) {
        this.startOffset = startOffset;
        this.length = length;
    }

    public long getStartOffset() {
        return startOffset;
    }

    public void setStartOffset(long startOffset) {
        this.startOffset = startOffset;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
