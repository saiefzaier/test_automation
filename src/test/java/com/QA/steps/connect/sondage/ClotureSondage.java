package com.QA.steps.connect.sondage;

import com.QA.locators.SondageLocators;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ClotureSondage {

    private final WebDriver driver = GenerateurDriver.driver;


    @Then("verifier que le sondage ne peut plus etre lancer ou stopper")
    public void verifierQueLeSondageNePeutPlusEtreLancerOuStopper() {


      driver.findElement(By.xpath(SondageLocators.Bouton_Options_Sondage)).click();

        WebElement modules1 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(SondageLocators.Bouton_Supprimer_Sondage)));

        List<WebElement> liste =driver.findElements(By.xpath(SondageLocators.Liste_Options_Sondage));


      Boolean contient=false;

        for( WebElement element:liste){
            if(  ( (element.getAttribute("innerText")).equals("Lancer") )|( (element.getAttribute("innerText")).equals("Stopper") ) ){
               contient=true;
               break;
            }

        }

        Assert.assertFalse(contient);

    }


}
