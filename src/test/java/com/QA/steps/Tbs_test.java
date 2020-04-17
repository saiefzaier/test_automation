package com.QA.steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tbs_test {



    WebDriver driver=new ChromeDriver();
    @Given("tbs homepage is open")
    public void openHomePage() {
        driver.get("www.google.com");
    }

}
