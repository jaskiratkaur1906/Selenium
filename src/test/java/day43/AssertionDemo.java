package day43;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionDemo {
    @Test
    void Test_title(){
        String exp_title = "Opencart";
        String act_title = "Opencart";
        Assert.assertEquals(exp_title,act_title);

    }
}
/*
Assertions are used for validations
There are 2 types of Assertions
    -Hard Assertions
    -Soft Assertions
 */