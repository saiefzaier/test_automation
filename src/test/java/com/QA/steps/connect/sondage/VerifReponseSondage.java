package com.QA.steps.connect.sondage;

import com.QA.locators.SondageLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class VerifReponseSondage {

    private final WebDriver driver = GenerateurDriver.driver;
    private ActionsCommunes action2 = new ActionsCommunes();
    private Actions action = new Actions(driver);

    @Then("verifier que les reponses du sondage sont corrects")
    public void verifierQueLesReponsesDuSondageSontCorrects() throws InterruptedException {


        WebElement element = driver.findElement(By.xpath(SondageLocators.Participant_Sondage_Reponse1));
        action.moveToElement(element).perform();

        action2.pause(driver,500);

        String str =driver.findElement(By.cssSelector("tooltip-container")).getAttribute("innerText");

        Assert.assertEquals("Blanche Beauchamp",str);


        element = driver.findElement(By.xpath(SondageLocators.Participant_Sondage_Reponse2));
        action.moveToElement(element).perform();

        action2.pause(driver,500);

        str =driver.findElement(By.cssSelector("tooltip-container")).getAttribute("innerText");

        Assert.assertEquals("Gaston Boutot",str);


       Assert.assertEquals("oui",driver.findElement(By.xpath(SondageLocators.Participant_Reponse_Afficher1)).getAttribute("title"));
       Assert.assertEquals("non",driver.findElement(By.xpath(SondageLocators.Participant_Reponse_Afficher2)).getAttribute("title"));



    }


}
