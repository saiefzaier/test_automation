package com.QA.steps.connect.enquete;

import com.QA.locators.EnqueteLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifResultatEnquete {


    private final WebDriver driver = GenerateurDriver.driver;
    private ActionsCommunes action = new ActionsCommunes();


    @Then("verifier que le resultat est correct")
    public void verifierQueLeResultatEstCorrect() throws InterruptedException {

        Boolean modules2 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.attributeToBe(By.xpath(EnqueteLocators.Nombre_De_Reponse_Enquete), "innerText","2"));
        Assert.assertEquals("2",driver.findElement(By.xpath(EnqueteLocators.Nombre_De_Reponse_Enquete)).getAttribute("innerText"));

        driver.findElement(By.xpath(EnqueteLocators.Nombre_De_Reponse_Enquete)).click();
        action.pause(driver,200);

        driver.findElement(By.xpath(EnqueteLocators.Nom_Premier_Participant_Enquete)).click();
        action.pause(driver,200);


        boolean test= Boolean.parseBoolean(driver.findElement(By.xpath(EnqueteLocators.Participant_Reponse1_Enquete)).getAttribute("checked"));

        Assert.assertTrue(test);

        action.pause(driver,200);
        driver.findElement(By.xpath(EnqueteLocators.Nom_Deuxieme_Participant_Enquete)).click();


        test= Boolean.parseBoolean(driver.findElement(By.xpath(EnqueteLocators.Participant_Reponse2_Enquete)).getAttribute("checked"));

        Assert.assertTrue(test);


       Assert.assertEquals("Blanche Beauchamp",driver.findElement(By.xpath(EnqueteLocators.Nom_Premier_Participant_Enquete)).getAttribute("innerText"));
       Assert.assertEquals("Gaston Boutot",driver.findElement(By.xpath(EnqueteLocators.Nom_Deuxieme_Participant_Enquete)).getAttribute("innerText"));


    }


}
