package com.mike;


import org.hamcrest.Matchers;
import org.junit.Test;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class FilesTests {

    @Test
    public void someTest()
    {
        RandomString r = new RandomString();
        String result = r.getAlphaNumericString(5);

      // assertThat(result.length(), is(not(3)));
        LinkedList<String> s = new LinkedList<String>();
        String a2="af";
        String a1="";
        s.add(a2);
        s.add(a1);

         Collections.sort(s);
        System.out.println(s);
    }
}
