package day44;

import org.testng.Assert;
import org.testng.annotations.Test;
/*
open app
login
search
advsearch
logout

 */

public class DependencyMethodDemo {
    @Test(priority = 1)
    public void openapp() {
        Assert.assertTrue(true);
    }
    @Test(priority = 2, dependsOnMethods = {"openapp"})
    void login(){
        Assert.assertTrue(true);
    }
    @Test(priority = 3, dependsOnMethods = {"login"})
    void search(){
        Assert.assertTrue(false);

    }
    @Test(priority = 4, dependsOnMethods = {"login","search"}) //can specify multiple method names
    void adv_search(){
        Assert.assertTrue(true);

    }
    @Test(priority = 5, dependsOnMethods = {"login"})
    void logout(){
        Assert.assertTrue(true);

    }
}
/*
dependsOnMethods = {"method1","method2",...}
-used to skip tests that are dependent on prev test fails
 */

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