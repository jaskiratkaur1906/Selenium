package day44;

import org.testng.annotations.Test;

public class LoginTests {

    @Test(priority = 1, groups = {"sanity"})
    void loginByEmail(){
        System.out.println("This is login by email");
    }
    @Test(priority = 2, groups = {"sanity"})
    void loginByFacebook(){
        System.out.println("This is login by facebook");
    }
    @Test(priority = 3, groups = {"sanity"})
    void loginByTwitter(){
        System.out.println("This is login by twitter");
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
-----------------------------------------------------------

Requirements:

loginbyfacebook - sanity
loginbyemail - sanity
loginbytwitter - sanity

signupbyfacebook - regression
signupbyemail - regression
signupbytwitter - regression

paymentinrupees - sanity , regression (functional)
paymentindollars - sanity, regression (functional)

Run:

1- all sanity tests (we will use include)
2- al regression tests (we will use include)
3- all sanity but not regression (we will use exclude to remove regression)
4- all regression but not sanity (we will use exclude to remove sanity)
5- all methods which belongs to both sanity & regression(we will add common name group tag for it)
 */