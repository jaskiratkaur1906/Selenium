package day44;

import org.testng.annotations.Test;

public class PaymentTests {

    @Test(priority = 1, groups = {"regression","sanity", "functional"})
    void paymentInRupees(){
        System.out.println("Payment in rupees");
    }
    @Test(priority = 2, groups = {"regression","sanity", "functional"})
    void paymentInDollors(){
        System.out.println("Payment in dollors");
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