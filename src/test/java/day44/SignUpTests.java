package day44;

import org.testng.annotations.Test;

public class SignUpTests {

    @Test(priority = 1, groups = {"regression"})
    void signupByEmail(){
        System.out.println("This is signup by email");
    }
    @Test(priority = 2, groups = {"regression"})
    void signupByFacebook(){
        System.out.println("This is signup by facebook");
    }
    @Test(priority = 3, groups = {"regression"})
    void signupByTwitter(){
        System.out.println("This is signup by twitter");
    }
    
}
/*
grouping
--------
- class1 - m1, m2, m3....
- class2 - m4, m5, m6....
- class3 - m7, m8, m9....

sanity
regression
functional
 */