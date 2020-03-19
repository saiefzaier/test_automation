package com.QA.steps.connect.sondage;

import com.QA.locators.CommonLocators;
import com.QA.locators.SondageLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class LancerSondage {

    private static final WebDriver driver = GenerateurDriver.driver;
    private static final Logger logger = Logger.getLogger(LancerSondage.class);
    private ActionsCommunes action = new ActionsCommunes();

    @Then("verifier que le sondage est affiché")
    public void verifierQueLeSondageEstAffiché() {


        String str1 = ActionsCommunes.DataProvider("Question1_Creation_Sondage");
        WebElement modules1 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(SondageLocators.Nom_Sondage_Afficher)));

        Boolean modules2 = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.attributeToBe(By.xpath(SondageLocators.Nom_Sondage_Afficher), "innerText", str1));


        Boolean modules3 = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.attributeToBe(By.xpath(SondageLocators.Sondage_Reponse1_Afficher), "innerText", ActionsCommunes.DataProvider("Reponse_1_sondage")));

        Boolean modules4 = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.attributeToBe(By.xpath(SondageLocators.Sondage_Reponse2_Afficher), "innerText", ActionsCommunes.DataProvider("Reponse_2_sondage")));

        String str2 = driver.findElement(By.xpath(SondageLocators.Nom_Sondage_Afficher)).getAttribute("innerText");

        Assert.assertEquals(str1, str2);

        String str3 = driver.findElement(By.xpath(SondageLocators.Sondage_Reponse1_Afficher)).getAttribute("innerText");
        String str4 = driver.findElement(By.xpath(SondageLocators.Sondage_Reponse2_Afficher)).getAttribute("innerText");
        Assert.assertEquals(str3, ActionsCommunes.DataProvider("Reponse_1_sondage"));
        Assert.assertEquals(str4, ActionsCommunes.DataProvider("Reponse_2_sondage"));


    }





    @And("l utilisateur clique sur Bouton_Sondage_Portail et verifie le chargement de la liste des sondages")
    public void lUtilisateurCliqueSurBouton_Sondage_PortailEtVerifieLeChargementDeLaListeDesSondages() throws InterruptedException {

        boolean x = true;
        while (x) {

            driver.findElement(By.xpath(SondageLocators.Bouton_Sondage_Portail)).click();
            action.pause(driver,1500);
            try {
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(2, SECONDS)
                        .pollingEvery(1, SECONDS)
                        .ignoring(NoSuchElementException.class);
                WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
                    public WebElement apply(WebDriver webDriver) {
                        return driver.findElement(By.xpath(SondageLocators.Sondage_Reponse2_Afficher));
                    }
                });
                if (driver.findElement(By.xpath(SondageLocators.Sondage_Reponse2_Afficher)).isDisplayed()){x = false;}
            }
            catch (Exception e){ }
        }



    }

}