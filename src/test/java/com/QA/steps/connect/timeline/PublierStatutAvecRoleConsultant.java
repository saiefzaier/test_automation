package com.QA.steps.connect.timeline;


import com.QA.locators.TimelineLocators;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;


public class PublierStatutAvecRoleConsultant {

    private final WebDriver driver = GenerateurDriver.driver;


    @Then("Vérifier que le bloc de publication n'est pas affiché")
    public void vérifierQueLeBlocDePublicationNEstPasAffiché() {

        List<WebElement> l = driver.findElements(By.cssSelector(TimelineLocators.Bloc_Publication_TimeLine));
        Assert.assertEquals(0,l.size());

    }


}
