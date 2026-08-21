package day40;
import org.testng.annotations.Test;

/*
1) open app
2) login
3) logout

for each step we will create a method
main method is not required here (@ Test or any other annotation is required)

1- Testng run tests methods in alphabetical order by default
2- We can control order using priority(controls the order of execution)
3- Once you provide priority to the test methods, then order of methods is not considered
4- Priorities can be random numbers (no need to have consecutive numbers)
5- If you do not provide any priority then default value is Zero (0).
6- If the priorities are the same then again execute methods in alphabetical order
7- Negative values are allowed in priority (smaller one will be executed first)
8- TestNG execute test methods only if they are having @Test annotations

 */

public class TestNGDemo {

    @Test(priority = 10)
    public void openapp() {
        System.out.println("opening application.........");
    }
    @Test(priority = 50)
    void login(){
        System.out.println("Log in to app ........");
    }
    @Test(priority = 100)
    void logout(){
        System.out.println("Log out to app ........");
    }

}
/*
- TestNG: Test New Generation
- java based unit testing tool

- Adv:
    1) Test cases and test suites
    2) Grouping of test cases
    3)Prioritize
    4)Parameterization
    5)Parallel Testing
    6)Reports

-@Test Annotation (replacment of main method)
 */