package com.mike;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class RandomString {
    private  static final String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                                          + "0123456789"
                                                                 + "abcdefghijklmnopqrstuvxyz";
    private static final  int charLen=AlphaNumericString.length();

    // function to generate a random string of length n
    public static String getAlphaNumericString(int n)
    {

            // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
//        IntStream.range(0, n).forEach(d ->
//                sb.append(AlphaNumericString.charAt(((int)
//                        Math.random()*ldd))));


        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int)(charLen * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    public void WriteDataToFile (String file) throws IOException {


        BufferedWriter bw = Files.newBufferedWriter(Paths.get("src/main/resources/strings.csv"));
        bw.write("fdsfdasfdsafds");
        bw.close();


        // Get the size n
        int n = 20;
        for (int j=0;j<20;j++) {
            RandomString.getAlphaNumericString(n);
            System.out.println(RandomString.getAlphaNumericString(n));
        }

    }


}