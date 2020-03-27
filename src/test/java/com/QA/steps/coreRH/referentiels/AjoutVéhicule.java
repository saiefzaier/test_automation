package com.QA.steps.coreRH.referentiels;

import com.QA.base.streams;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.EtapesCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.And;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Properties;
import static com.QA.base.TestGenerateurDriverInit.ListeGlobaleLocators;

public class AjoutVéhicule {

    private static final Logger logger = Logger.getLogger(EtapesCommunes.class);
    private final WebDriver driver = GenerateurDriver.driver;
    private static final Properties reader;
    private ActionsCommunes action = new ActionsCommunes();
   public static List<String> listededonnees =EtapesCommunes.listededonnees;
    public Actions actions = new Actions(driver);

    static {
        reader = streams.readers();
    }


    @And("l utilisateur saisit {string} dans l'input {string}")
    public void LutilisateurSaisitDansMarqueVéhicule(String input, String champ) throws IllegalAccessException {

          logger.info("L'utilisateur saisit : " + input + " dans le champ " + champ);
        String locator = "vide";
              listededonnees.add(champ);
           listededonnees.add(input);
        for (List<Field> f : ListeGlobaleLocators) {
            for (Field x : f) {
                if (x.getName().equals(champ)) {
                    locator = (String) x.get(x);
                    break;
                }
            }
            if (!locator.equals("vide")) {
                break;
            }
        }
        List<WebElement> Liste_Marques;
        if (Character.toString(locator.charAt(0)).contains("/")) {
            Liste_Marques = driver.findElements(By.xpath(locator));
        } else if (locator.contains("[") || Character.toString(locator.charAt(0)).contains(".")) {
            Liste_Marques = driver.findElements(By.cssSelector(locator));
        } else {
            Liste_Marques = driver.findElements(By.id(locator));
        }

        for (WebElement marque : Liste_Marques) {

            if (marque.getAttribute("value").equals("")) {
                marque.sendKeys(input);
                break;
            }

        }


    }

}
