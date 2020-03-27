package com.QA.steps.talent.configuration;

import com.QA.locators.ConfigurationTalentLocators;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SuppressionClassificationDeCompetences {

    private static final WebDriver driver = GenerateurDriver.driver;




    @And("verifier que le libelle {string} n est plus dans la liste")
    public void verifierQueLeLibelleNEstPlusDansLaListe(String chaine) {

        List<WebElement> list =driver.findElements(By.xpath(ConfigurationTalentLocators.Liste_Calification_Configuration_Talent));
        int rowCount=list.size();

        String beforeXpath="/html/body/app-root/app-layout/div/section/div/acc-hr-talent-component/acc-hr-talent-configuration/div[2]/div[2]/section/acc-evaluation-configuration-classication/div[2]/section/div[2]/div/div[1]/acc-evaluation-configuration-classification-table/table/tbody/tr[";
        String afterXpath="]/td[1]";

        boolean trouve=false;

        for(int i=1;i<=rowCount;i++){

             String actualXpath=beforeXpath+i+afterXpath;
             WebElement element=driver.findElement(By.xpath(actualXpath));
             String test=element.getAttribute("innerText");
             if(chaine.equals(test)){
                 trouve=true;
                 break;
             }

        }

        Assert.assertFalse(trouve);

    }


    @And("l utilisateur choisit l option supprimer classification")
    public void lUtilisateurChoisitLOptionSupprimerClassification() {


        List<WebElement> list=driver.findElements(By.cssSelector("i[class='fa fa-remove pull-right '] "));
        WebElement  element=list.get(list.size()-1);
        element.click();

    }


}
