package com.QA.steps;

import com.QA.base.streams;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;

public class Tbs_test {

    private static final Properties reader;
    static {
        reader = streams.readers();
    }

 private final   WebDriver driver=GenerateurDriver.driver;
    @Given("tbs homepage is open")
    public void openHomePage() {
        driver.get(reader.getProperty("testsiteurl"));

    }

}
