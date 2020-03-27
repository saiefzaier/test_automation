package com.QA.steps.talent.configuration;

import com.QA.locators.ConfigurationTalentLocators;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SuppressionThematiqueDeFormation {


    private static final WebDriver driver = GenerateurDriver.driver;


    @And("verifier que la thematique {string} n est plus dans la liste")
    public void verifierQueLaThematiqueNEstPlusDansLaListe(String thematique) {


        List<WebElement> list=driver.findElements(By.xpath(ConfigurationTalentLocators.Liste_Thematique_Formation));
        int rowCount =list.size()-1;

        String beforeXpath="/html/body/app-root/app-layout/div/section/div/acc-hr-talent-component/acc-hr-talent-configuration/div[2]/div[2]/section/acc-single-element-generic-cr-container/div[2]/div/section/div[2]/form/div/div[";
        String afterXpath="]/div/div/input[2]";

        boolean trouve=false;

        for(int i=1;i<=rowCount;i++){

            String actualXpath=beforeXpath+i+afterXpath;

            String str=driver.findElement(By.xpath(actualXpath)).getAttribute("value");

            if(str.equals(thematique)){
                trouve=true;
                break;
            }

        }

        Assert.assertFalse(trouve);




    }


    @When("l utilisateur supprime la derniere thematique ajoutee")
    public void lUtilisateurSupprimeLaDerniereThematiqueAjoutee() {


        //rechercher le nombre de ligne
        List<WebElement> list=driver.findElements(By.xpath(ConfigurationTalentLocators.Liste_Thematique_Formation));
        int indiceDernierElement =list.size()-1;

        //Remplir le champ
        String  beforeXpath="/html/body/app-root/app-layout/div/section/div/acc-hr-talent-component/acc-hr-talent-configuration/div[2]/div[2]/section/acc-single-element-generic-cr-container/div[2]/div/section/div[2]/form/div/div[";
        String  afterXpath="]/div/div/span/button";
        String  actualXpath=beforeXpath+indiceDernierElement+afterXpath;

        driver.findElement(By.xpath(actualXpath)).click();

    }


}
