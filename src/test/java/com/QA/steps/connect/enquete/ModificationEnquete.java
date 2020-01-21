package com.QA.steps.connect.enquete;

import com.QA.locators.EnqueteLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ModificationEnquete {

    private static final WebDriver driver = GenerateurDriver.driver;

    @Then("vérifier que l'enquete a été modifié correctement")
    public void vérifierQueLEnqueteAÉtéModifiéCorrectement() {


        String str1=ActionsCommunes.DataProvider("Libelle_Enquete_Modification");

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
