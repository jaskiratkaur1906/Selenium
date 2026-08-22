package day43;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertion {

    //@Test
    void test_hardAssertions(){
        System.out.println("testing....");
        System.out.println("testing....");

        //Hard assertions
        Assert.assertEquals(1,2); //if pass following statements will execute
                                                    //id fails following statements will not execute

        System.out.println("testing....");
        System.out.println("testing....");
    }

    @Test
    void test_softAssertions(){
        System.out.println("testing....");
        System.out.println("testing....");

        //Hard assertions
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(1,2);

        System.out.println("testing....");
        System.out.println("testing....");

        sa.assertAll(); //mandatory
    }

}

/*
In Assert class methods are static therefore we can access like this
In SoftAssert class mothods are static therefore we have to create object to access softassert methods
 */

/*
Hard Assertions
----------
- we can access from "Assert" class
- methods are static
- if hard assertion failed then rest of the statements will not be executed

Soft Assertions
----------
- we can access though "SoftAssert" object
- if soft assertion got failed then rest of the statements still execute
 */
