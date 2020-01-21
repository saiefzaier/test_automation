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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class VoterEnquete {

    private static final WebDriver driver = GenerateurDriver.driver;


    @Then("verifier que le vote de l enquete a etait compte")
    public void verifierQueLeVoteDeLEnqueteAEtaitCompte() {


        String str1 = "0";
        String str2=ActionsCommunes.DataProvider("Libelle_Enquete_Creation");

        WebElement modules1 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(EnqueteLocators.Premiere_Enquete_Afficher_Connect)));
        Boolean modules2 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.attributeToBe(By.xpath(EnqueteLocators.Premiere_Enquete_Afficher_Connect), "innerText", str2));

        String str3 = driver.findElement(By.xpath(EnqueteLocators.Premiere_Enquete_Afficher_Nombre_Reponse)).getAttribute("innerText");
        Assert.assertNotEquals(str1, str3);


    }


    @And("l utilisateur choisit l'enquete")
    public void lUtilisateurChoisitLEnquete() {


        List<WebElement> liste1=driver.findElements(By.xpath(EnqueteLocators.Liste_Enquete_Portail));
        List<WebElement> liste2=driver.findElements(By.cssSelector(EnqueteLocators.Liste_Enquetes_Afficher_Bouton_Radio));

        int size=liste1.size() ;
        String str= ActionsCommunes.DataProvider("Libelle_Enquete_Creation");

        for(int i=0;i<size;i++){
            if( (liste1.get(i).getAttribute("innerText")).equals(str) ){
                liste2.get(i).click();
                break;
            }

        }

    }


}
