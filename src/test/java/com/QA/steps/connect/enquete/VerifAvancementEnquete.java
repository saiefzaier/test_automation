package com.QA.steps.connect.enquete;

import com.QA.locators.EnqueteLocators;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifAvancementEnquete {
    public static String avancement;
    private final WebDriver driver = GenerateurDriver.driver;

    @Then("verifier que l avancement de l enquete est egale a {int}%")
    public void verifierQueLAvancementDeLEnqueteEstEgaleA(int arg0) {

        String str1= arg0 +"%";
        Boolean modules2 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.attributeToBe(By.xpath(EnqueteLocators.Avancement_Premiere_Enquete), "innerText",str1));
        Assert.assertEquals(driver.findElement(By.xpath(EnqueteLocators.Avancement_Premiere_Enquete)).getAttribute("innerText"),str1);
        avancement=str1;

    }

}
