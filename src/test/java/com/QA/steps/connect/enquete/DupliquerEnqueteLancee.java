package com.QA.steps.connect.enquete;

import com.QA.locators.EnqueteLocators;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.QA.steps.connect.enquete.VerifAvancementEnquete.avancement;

public class DupliquerEnqueteLancee {

    private static final WebDriver driver = GenerateurDriver.driver;
    @And("l avancement de lenquete nest pas reinisialise")
    public void lAvancementDeLenqueteNestPasReinisialise() {

        WebElement modules1 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(EnqueteLocators.Avancement_Deuxieme_Enquete)));
        String str1=driver.findElement(By.xpath(EnqueteLocators.Avancement_Deuxieme_Enquete)).getAttribute("innerText");
         Assert.assertEquals(str1,avancement);
    }
}
