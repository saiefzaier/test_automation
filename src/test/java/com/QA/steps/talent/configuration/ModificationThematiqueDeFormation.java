package com.QA.steps.talent.configuration;

import com.QA.locators.ConfigurationTalentLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ModificationThematiqueDeFormation {


    private static final WebDriver driver = GenerateurDriver.driver;
    private ActionsCommunes action = new ActionsCommunes();

    @When("l'utilisateur modifie{string}la derniere thematique ajoutee")
    public void lUtilisateurModifieLaDerniereThematiqueAjoutee(String thematique) throws InterruptedException {


        //rechercher le nombre de ligne
        List<WebElement> list=driver.findElements(By.xpath(ConfigurationTalentLocators.Liste_Thematique_Formation));
        int indiceDernierElement =list.size()-1;

        //Remplir le champ
        String  beforeXpath="/html/body/app-root/app-layout/div/section/div/acc-hr-talent-component/acc-hr-talent-configuration/div[2]/div[2]/section/acc-single-element-generic-cr-container/div[2]/div/section/div[2]/form/div/div[";
        String  afterXpath="]/div/div/input[2]";
        String  actualXpath=beforeXpath+indiceDernierElement+afterXpath;

        driver.findElement(By.xpath(actualXpath)).clear();
        action.pause(driver,1000);
        driver.findElement(By.xpath(actualXpath)).sendKeys(thematique);

    }


}
