package com.company;



import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


public class Main {

    @Before
    public void setUp() throws Exception {
    }


    public static void main(String[] args) {

    }

    @Test  //TEST
    public void testBackgroundUpdateSpeed()
    {
        assertEquals(calculationAdd(4,7), 11);
    }


    public int calculationAdd(int a, int b)
    {
        return a + b;
    }
}
