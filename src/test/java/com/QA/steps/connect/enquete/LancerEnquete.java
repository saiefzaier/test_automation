package com.QA.steps.connect.enquete;


import com.QA.locators.EnqueteLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class LancerEnquete {

    private static final WebDriver driver = GenerateurDriver.driver;


    @And("l utilisateur clique sur Bouton_Enquete_Portail et verifie le chargement de la liste des enquetes")
    public void lUtilisateurCliqueSurBouton_Enquete_PortailEtVerifieLeChargementDeLaListeDesEnquetes() {


        boolean x = true;
        while (x) {

            driver.findElement(By.xpath(EnqueteLocators.Bouton_Enquete_Portail)).click();

            try {
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(2, SECONDS)
                        .pollingEvery(1, SECONDS)
                        .ignoring(NoSuchElementException.class);
                WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
                    public WebElement apply(WebDriver webDriver) {
                        return driver.findElement(By.xpath(EnqueteLocators.Premiere_Enquete_Afficher));
                    }
                });
                if (driver.findElement(By.xpath(EnqueteLocators.Premiere_Enquete_Afficher)).isDisplayed()){x = false;}
            }
            catch (Exception e){ }
        }



    }


    @Then("verifier que l'enquete est affichée")
    public void verifierQueLEnqueteEstAffichée() {

        String str1=ActionsCommunes.DataProvider("Libelle_Enquete_Creation");

        List<WebElement> list=driver.findElements(By.xpath(EnqueteLocators.Liste_Enquete_Portail));
        Boolean exist=false;

          for(WebElement element:list){
              String str2=element.getAttribute("innerText");
               if (str2.equals(str1)){
                   exist=true;
                   break;
               }
          }

        Assert.assertTrue(exist);

    }



}
