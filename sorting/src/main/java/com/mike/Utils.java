package com.mike;

import java.util.LinkedList;

import static java.lang.Math.pow;

public class Utils {
  private static final String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "0123456789"
            + "abcdefghijklmnopqrstuvxyz";


   // private static final String AlphaNumericString = "12";

    private static final int charLen = AlphaNumericString.length();

    public static LinkedList countGap(int size) {
        int i=1, gap=1;
        LinkedList<Integer> tmpListofGaps = new LinkedList();
        do {

            tmpListofGaps.add(gap);
            gap= (int) (pow(4,i)+3*pow(2,i-1)+1);
            i++;
        }while (gap*3<size);
        return tmpListofGaps;
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
}
