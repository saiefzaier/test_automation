package com.QA.steps.talent.configuration;

import com.QA.locators.ConfigurationTalentLocators;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ModificationClassificationDeCompetence {

    private static final WebDriver driver = GenerateurDriver.driver;
    public static int dernierLibelleAfficherIndice;

    @And("l utilisateur modifie la classification cree")
    public void lUtilisateurModifieLaClassificationCree() {



        //rechercher l'indice du derniere element de la liste

        List<WebElement> list =driver.findElements(By.xpath(ConfigurationTalentLocators.Liste_Calification_Configuration_Talent));
        dernierLibelleAfficherIndice=list.size();

        //Cliquer sur le Bouton option_competence


        String beforeXpath="/html/body/app-root/app-layout/div/section/div/acc-hr-talent-component/acc-hr-talent-configuration/div[2]/div[2]/section/acc-evaluation-configuration-classication/div[2]/section/div[2]/div/div[1]/acc-evaluation-configuration-classification-table/table/tbody/tr[";
        String afterXpath="]/td[4]/div/a";
        String actualXpath=beforeXpath+dernierLibelleAfficherIndice+afterXpath;

        driver.findElement(By.xpath(actualXpath)).click();

    }


    @And("l utilisateur choisit l option editer")
    public void lUtilisateurChoisitLOptionEditer() {

        List<WebElement> list=driver.findElements(By.cssSelector("i[class='fa fa-pencil-square-o pull-right']"));
        WebElement  element=list.get(dernierLibelleAfficherIndice-1);
        element.click();

    }



}
