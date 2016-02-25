package com.company;





import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


public class Main {

  /*  @Test
    public void testDBinsertion()
    {
    ModelClass modelClass = new ModelClass();
        modelClass.writeToDB("DD", 12, 25, "sdsd");
        assertEquals("DD", modelClass.toString());
    }

    @Test
    public void testDBupdate()
    {
        ModelClass modelClass = new ModelClass();
        modelClass.writeToDB("DD", 12, 25, "sdsd");
        assertEquals("DD", modelClass.toString());

    }

    @Test
    public void testDBdelete()
    {
        ModelClass modelClass = new ModelClass();
        modelClass.writeToDB("DD", 12, 25, "sdsd");
        assertEquals("DD", modelClass.toString());
    }

    @Test
    public void testDBretrieve()
    {
        ModelClass modelClass = new ModelClass();
        modelClass.writeToDB("DD", 12, 25, "sdsd");
        assertEquals("DD", modelClass.toString());
    } */

    public static void main(String[] args) {
        ModelClass modelClass = new ModelClass();
        modelClass.deleteDB(1);
    }
}
