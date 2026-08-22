package day43;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertionDemo {
    @Test
    void test(){
        //Assert.assertEquals("xyz","xyz"); //pass
        //Assert.assertEquals(123,345); //fails
        //Assert.assertEquals("abc",345); //fails

        //Assert.assertNotEquals(123,123); //fail
        //Assert.assertNotEquals(123, 345); //pass

        //Assert.assertTrue(true); //pass
        //Assert.assertTrue(false);//fail
        //Assert.assertTrue(1==2); //fail
        //Assert.assertTrue(1==1); //pass

        Assert.assertFalse(1==2); //PASS
        Assert.assertFalse(1==1); //fail

    }
}

/*
   These are hard assertions
 */