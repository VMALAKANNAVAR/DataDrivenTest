package com.tester.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class Logintest {

    @When("user is on login page")
    public void test1()
    {
        System.out.println("Hi");
    }

    @And("User enter user name")
    public void test2()
    {
        System.out.println("Hello");
    }

}
