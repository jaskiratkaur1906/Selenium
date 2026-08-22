package day43;

import org.testng.annotations.*;

public class AnnotationsDemo {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite - runs once, before everything");
    }

    @BeforeClass
    public void login() {
        System.out.println("Login - runs once, before all @Test methods in this class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("  Before Method - runs before EACH @Test");
    }

    @Test
    public void search() {
        System.out.println("    Search - Test 1");
    }

    @Test
    public void advSearch() {
        System.out.println("    Adv Search - Test 2");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("  After Method - runs after EACH @Test");
    }

    @AfterClass
    public void logout() {
        System.out.println("Logout - runs once, after all @Test methods in this class");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite - runs once, after everything");
    }
}
/*
@Test

@BeforeMethod
@AfterMethod

@BeforeClass
@AfterClass

@BeforeSuite
@AfterSuite

TC1:
1) Login --->@BeforeClass
2) Search ---> @Test
3) Logout --->@AfterClass
4) Login  --->@BeforeClass
5) Adv Search --->@Test
6) Logout --->AfterClass

 */