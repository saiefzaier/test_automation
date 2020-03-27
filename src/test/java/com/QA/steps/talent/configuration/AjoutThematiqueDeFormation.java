package com.QA.steps.talent.configuration;

import com.QA.locators.ConfigurationTalentLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AjoutThematiqueDeFormation {

    private static final WebDriver driver = GenerateurDriver.driver;
    private ActionsCommunes action = new ActionsCommunes();


    @And("verifier que la thematique {string} est dans la liste")
    public void verifierQueLaThematiqueEstDansLaListe(String thematique) {

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

        Assert.assertTrue(trouve);

    }




    @And("l utilisateur ajoute la thematique{string}")
    public void lUtilisateurAjouteLaThematique(String thematique) throws InterruptedException {


        //rechercher le nombre de ligne
        List<WebElement> list=driver.findElements(By.xpath(ConfigurationTalentLocators.Liste_Thematique_Formation));
        int indiceDernierElement =list.size();

        //Remplir le champ
        String  beforeXpath="/html/body/app-root/app-layout/div/section/div/acc-hr-talent-component/acc-hr-talent-configuration/div[2]/div[2]/section/acc-single-element-generic-cr-container/div[2]/div/section/div[2]/form/div/div[";
        String  afterXpath="]/div/div/input[2]";
        String  actualXpath=beforeXpath+indiceDernierElement+afterXpath;


        driver.findElement(By.xpath(actualXpath)).sendKeys(thematique);
        action.pause(driver,1000);


        //cliquer sur valider
        beforeXpath="/html/body/app-root/app-layout/div/section/div/acc-hr-talent-component/acc-hr-talent-configuration/div[2]/div[2]/section/acc-single-element-generic-cr-container/div[2]/div/section/div[2]/form/div/div[";
        afterXpath="]/div/div/span/button";
        actualXpath=beforeXpath+indiceDernierElement+afterXpath;
        driver.findElement(By.xpath(actualXpath)).click();

    }



}
