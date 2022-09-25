package pl.testeroprogramowania;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest { // Klasa pl.testeroprogramowania.BaseTest jest rodzicem klasy pl.testeroprogramowania.OneTest i TwoTest

    @BeforeTest
    public void beforeTest(){
        System.out.println("Im running @BeforeTest");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Im running @BeforeMethod");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("Im running @AfterTest");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Im running @AfterMethod");
    }

}
