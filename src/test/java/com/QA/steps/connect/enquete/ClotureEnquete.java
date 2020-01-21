package com.QA.steps.connect.enquete;

import com.QA.locators.EnqueteLocators;
import com.QA.locators.SondageLocators;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ClotureEnquete {

    private final WebDriver driver = GenerateurDriver.driver;

    @Then("verifier que l enquete ne peut plus etre lancer ou stopper")
    public void verifierQueLEnqueteNePeutPlusEtreLancerOuStopper() {





        List<WebElement> liste =driver.findElements(By.xpath(EnqueteLocators.Liste_Options_Enquete));

        Boolean contient=false;

        String lancer="icons8-entering-geo-fence cursor";
        String stopper="icons8-circled-pause cursor";

        for( WebElement element:liste){
            if(  ( (element.getAttribute("className")).equals(lancer) )|( (element.getAttribute("className")).equals(stopper) ) ){
                contient=true;
                break;
            }

        }



    }


}
