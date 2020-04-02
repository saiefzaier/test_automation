package com.QA.steps;

import com.QA.base.streams;
import com.QA.locators.CommonLocators;
import com.QA.utilités.XMLUtilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.QA.base.TestGenerateurDriverInit.ListeGlobaleLocators;

public class EtapesCommunes {

    private static final Logger logger = Logger.getLogger(EtapesCommunes.class);
    private final WebDriver driver = GenerateurDriver.driver;
    private static final Properties reader;
    private ActionsCommunes action = new ActionsCommunes();
    public static List<String> listededonnees = new ArrayList<>();
    public Actions actions = new Actions(driver);

    static {
        reader = streams.readers();
    }


    @Given("le navigateur est ouvert et la page d'acceuil est affichée")
    public void leNavigateurEstOuvertEtLaPageDAcceuilEstAffichée() {

        logger.info(" Ouverture de l'environnement : " + reader.getProperty("testsiteurl"));
        driver.get(reader.getProperty("testsiteurl"));
    }

    @And("l'utilisateur {string} est connecté")
    public void lUtilisateurEstConnecté(String utilisateur) throws Exception {

        logger.info("Connexion avec le user : " + utilisateur);
        WebElement modules1 = (new WebDriverWait(driver, 100))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(CommonLocators.Login_Bouton_connexion)));

        XMLUtilities utilities = new XMLUtilities();

        driver.findElement(By.id(CommonLocators.Login_Champ_Username)).sendKeys(utilisateur);
        action.pause(driver, 500);
        driver.findElement(By.id(CommonLocators.Login_Champ_password)).sendKeys((utilities.findUser(utilisateur).getPassword()));
        action.pause(driver, 500);
        driver.findElement(By.xpath(CommonLocators.Login_Bouton_connexion)).click();
        Assert.assertTrue(driver.findElements(By.cssSelector("a[class='list-group-item'][routerlink='/logout']")).size() != 0);

    }

    @When("l'utilisateur clique sur espace-RH")
    public void lUtilisateurCliqueSurEspaceRH() throws InterruptedException {

        logger.info("Changement de role vers espace-RH");
        driver.findElement(By.xpath(CommonLocators.Bouton_Role_RH)).click();
        action.pause(driver, 200);
        driver.findElement(By.xpath(CommonLocators.Bouton_Menu_Etendu)).click();

    }

    @And("l'utilisateur clique sur le module Connect")
    public void lUtilisateurCliqueSurLeModuleConnect() throws InterruptedException {

        driver.findElement(By.xpath(CommonLocators.Bouton_Module_Connect)).click();
        action.pause(driver, 200);
    }


    @And("wait {int}")
    public void wait(int arg0) throws InterruptedException {
        logger.info("Pause de " + arg0 / 1000 + " secondes");
        synchronized (driver) {
            driver.wait(arg0);
        }

    }


    @And("l'utilisateur clique sur Annonces")
    public void lUtilisateurCliqueSurAnnonces() {

        driver.findElement(By.xpath(CommonLocators.Bouton_Annonce)).click();
    }


    @And("l utilisateur se deconnecte")
    public void lUtilisateurSeDeconnecte() {

        driver.manage().deleteAllCookies();
        driver.get(reader.getProperty("testsiteurl"));
    }

    @And("l utilisateur clique sur {string}")
    public void lUtilisateurCliqueSur(String bouton) throws IllegalAccessException {
        logger.info("L'utilisateur clique sur : " + bouton);
        String locator = "vide";
        for (List<Field> f : ListeGlobaleLocators) {
            for (Field x : f) {
                if (x.getName().equals(bouton)) {
                    locator = (String) x.get(x);
                    break;
                }
            }
            if (!locator.equals("vide")) {
                break;
            }
        }
        if (bouton.contains("JS_")) {
            WebElement element = driver.findElement(By.xpath(locator));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        } else if (Character.toString(locator.charAt(0)).contains("/")) {
            WebElement element = driver.findElement(By.xpath(locator));
            actions.moveToElement(element).perform();
            WebElement modules = (new WebDriverWait(driver, 100)).until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } else if (locator.contains("[") || Character.toString(locator.charAt(0)).contains(".")) {
            WebElement element = driver.findElement(By.cssSelector(locator));
            actions.moveToElement(element).perform();
            WebElement modules = (new WebDriverWait(driver, 100)).until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } else {
            WebElement element = driver.findElement(By.id(locator));
            WebElement modules = (new WebDriverWait(driver, 100)).until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        }

    }


    @And("l utilisateur saisit {string} dans le champs {string}")
    public void lUtilisateurSaisitDansLeChamps(String texteSaisi, String Champ) throws IllegalAccessException {
        logger.info("L'utilisateur saisit : " + texteSaisi + " dans le champ " + Champ);
        String locator = "vide";
        listededonnees.add(Champ);
        listededonnees.add(texteSaisi);
        for (List<Field> f : ListeGlobaleLocators) {
            for (Field x : f) {
                if (x.getName().equals(Champ)) {
                    locator = (String) x.get(x);
                    break;
                }
            }
            if (!locator.equals("vide")) {
                break;
            }
        }
        if (Character.toString(locator.charAt(0)).contains("/")) {
            driver.findElement(By.xpath(locator)).sendKeys(texteSaisi);
        } else if (locator.contains("[") || Character.toString(locator.charAt(0)).contains(".")) {
            driver.findElement(By.cssSelector(locator)).sendKeys(texteSaisi);
        } else {
            driver.findElement(By.id(locator)).sendKeys(texteSaisi);
        }

    }


    @And("l utilisateur selectionne {string} dans la liste deroulante {string}")
    public void lutilisateurSelectionneDansLaListeDeroulante(String optionlistederoulante, String listederoulante) throws IllegalAccessException, InterruptedException {
        logger.info("L'utilisateur selectionne : " + optionlistederoulante + " dans la liste déroulante : " + listederoulante);
        listededonnees.add(listederoulante);
        listededonnees.add(optionlistederoulante);
        String locator = "vide";
        for (List<Field> f : ListeGlobaleLocators) {
            for (Field x : f) {
                if (x.getName().equals(listederoulante)) {
                    locator = (String) x.get(x);
                    break;
                }
            }
            if (!locator.equals("vide")) {
                break;
            }
        }
        if (locator.contains("JS_")) {
            WebElement element = driver.findElement(By.xpath(locator));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        } else if (Character.toString(locator.charAt(0)).contains("/")) {
            WebElement modules = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
            driver.findElement(By.xpath(locator)).click();
        } else if (locator.contains("[") || Character.toString(locator.charAt(0)).contains(".")) {
            WebElement modules = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
            driver.findElement(By.cssSelector(locator)).click();
        } else {
            WebElement modules = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.id(locator)));
            driver.findElement(By.id(locator)).click();
        }

       /* locator = "vide";
        action.pause(driver, 500);

        String inputlistederoulante = listederoulante + "_IL";
        for (List<Field> f : ListeGlobaleLocators) {
            for (Field x : f) {
                if (x.getName().equals(inputlistederoulante)) {
                    locator = (String) x.get(x);
                    break;
                }
            }
            if (!locator.equals("vide")) {
                break;
            }
        }
        String s = Character.toString(optionlistederoulante.charAt(0));
        if (Character.toString(locator.charAt(0)).contains("/")) {
            driver.findElement(By.xpath(locator)).sendKeys(s);
        } else if (locator.contains("[") || Character.toString(locator.charAt(0)).contains(".")) {
            driver.findElement(By.cssSelector(locator)).sendKeys(s);
        } else {
            driver.findElement(By.id(locator)).sendKeys(s);
        }*/
        locator = "vide";
        action.pause(driver, 1000);
        String cliquelistederoulante = listederoulante + "_CL";
        WebElement element = null;
        for (List<Field> f : ListeGlobaleLocators) {
            for (Field x : f) {
                if (x.getName().equals(cliquelistederoulante)) {
                    locator = (String) x.get(x);
                    break;
                }
            }
            if (!locator.equals("vide")) {
                break;
            }
        }

        boolean x = true;
        //Actions actions = new Actions(driver);
        while (x) {
            List<WebElement> list1 = driver.findElements(By.xpath(locator));
            if (list1.size() > 1) {
                try {
                    for (WebElement element1 : list1) {
                        actions.moveToElement(element1).perform();
                        if (element1.getAttribute("innerText").equals(optionlistederoulante)) {
                            element1.click();
                            x = false;
                            break;
                        }
                    }
                    x = false;
                } catch (StaleElementReferenceException ignored) {
                }
            } else {
                driver.findElement(By.xpath(locator)).click();
                x = false;
            }
        }

       /* if (Character.toString(locator.charAt(0)).contains("/")) {
            List<WebElement> list = driver.findElements(By.xpath(locator));
            element = driver.findElement(By.xpath(locator));
        } else if (locator.contains("[") || Character.toString(locator.charAt(0)).contains(".")) {
            List<WebElement> list = driver.findElements(By.cssSelector(locator));
            element = driver.findElement(By.cssSelector(locator));
        } else {

            element = driver.findElement(By.id(locator));
        }
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);*/

    }


    @And("l utilisateur selectionne {string} dans la liste {string}")
    public void lUtilisateurSelectionneDansLaListe(String Optiondelaliste, String liste) throws IllegalAccessException {
        logger.info("L'utilisateur selectionne : " + Optiondelaliste + " dans la liste : " + liste);
        String locator = "vide";
        List<WebElement> L;
        for (List<Field> f : ListeGlobaleLocators) {
            for (Field x : f) {
                if (x.getName().equals(liste)) {
                    locator = (String) x.get(x);
                    break;
                }
            }
            if (!locator.equals("vide")) {
                break;
            }
        }

        if (Character.toString(locator.charAt(0)).contains("/")) {
            L = driver.findElements(By.xpath(locator));
        } else if (locator.contains("[") || Character.toString(locator.charAt(0)).contains(".")) {
            L = driver.findElements(By.cssSelector(locator));
        } else {
            L = driver.findElements(By.id(locator));
        }

        for (WebElement x : L) {
            actions.moveToElement(x).perform();
            if (x.getText().equals(Optiondelaliste)) {
                x.click();
                break;
            }
        }
    }

    @Then("vérifier que le message {string} s affiche")
    public void vérifierQueLeMessageSAffiche(String textenotification) throws InterruptedException {
        logger.info("Vérification de l'affichage du message : " + textenotification);
        WebElement modules = (new WebDriverWait(driver, 300))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CommonLocators.Notification_Simple)));

        Boolean veriftxtnotif = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.attributeToBe(By.cssSelector(CommonLocators.Notification_Simple),"innerText",textenotification));

        Assert.assertTrue(veriftxtnotif);

    }

    @And("vérifier que le titre du modal est {string} et le texte du corps du modal est {string}")
    public void vérifierQueLeTitreDuModalEstEtLeTexteDuCorpsDuModalEst(String titremodal, String textecorpsmodal) {

        Assert.assertEquals(driver.findElement(By.cssSelector("h4[class='modal-title']")).getAttribute("innerText"), titremodal);
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class=text-center]")).getAttribute("innerText"), textecorpsmodal);

    }

    @And("l utilisateur modifie {string} dans le champs {string}")
    public void lUtilisateurModifieDansLeChamps(String nouveautexte, String champsamodifier) throws IllegalAccessException {

        String locator = "vide";
        listededonnees.add(champsamodifier);
        listededonnees.add(nouveautexte);
        for (List<Field> f : ListeGlobaleLocators) {
            for (Field x : f) {
                if (x.getName().equals(champsamodifier)) {
                    locator = (String) x.get(x);
                    break;
                }
            }
            if (!locator.equals("vide")) {
                break;
            }
        }

        if (Character.toString(locator.charAt(0)).contains("/")) {
            driver.findElement(By.xpath(locator)).clear();
            driver.findElement(By.xpath(locator)).sendKeys(nouveautexte);
        } else if (locator.contains("[") || Character.toString(locator.charAt(0)).contains(".")) {
            driver.findElement(By.cssSelector(locator)).clear();
            driver.findElement(By.cssSelector(locator)).sendKeys(nouveautexte);
        } else {
            driver.findElement(By.id(locator)).clear();
            driver.findElement(By.id(locator)).sendKeys(nouveautexte);
        }

    }

    @And("l utilisateur selectionne la population {string} dans la liste des populations {string}")
    public void lUtilisateurSelectionneLaPopulationDansLaListeDesPopulations(String nompopulation, String populationenquete) throws IllegalAccessException, InterruptedException {

        String locator = "vide";
        listededonnees.add(populationenquete);
        listededonnees.add(nompopulation);
        for (List<Field> f : ListeGlobaleLocators) {
            for (Field x : f) {
                if (x.getName().equals(populationenquete)) {
                    locator = (String) x.get(x);
                    break;
                }
            }
            if (!locator.equals("vide")) {
                break;
            }
        }
        if (Character.toString(locator.charAt(0)).contains("/")) {
            driver.findElement(By.xpath(locator)).sendKeys(nompopulation);
        } else if (locator.contains("[") || Character.toString(locator.charAt(0)).contains(".")) {
            driver.findElement(By.cssSelector(locator)).sendKeys(nompopulation);
        } else {
            driver.findElement(By.id(locator)).sendKeys(nompopulation);
        }


        action.pause(driver, 1000);

        driver.findElement(By.cssSelector("li[role='menuitem']")).click();

    }


    @And("l utilisateur upload {string} dans le champs {string}")
    public void lUtilisateurUploadDansLeChamps(String elementpourupload, String champsupload) throws IllegalAccessException {

        String locator = "vide";

        for (List<Field> f : ListeGlobaleLocators) {
            for (Field x : f) {
                if (x.getName().equals(champsupload)) {
                    locator = (String) x.get(x);
                    break;
                }
            }
            if (!locator.equals("vide")) {
                break;
            }
        }
        boolean b = locator.contains("[") || Character.toString(locator.charAt(0)).contains(".");
        boolean b1 = Character.toString(locator.charAt(0)).contains("/");
        switch (elementpourupload) {
            case "une vidéo":
                if (b1) {
                    driver.findElement(By.xpath(locator)).sendKeys(System.getProperty("user.dir") + "/src/test/resources/videospourtest/VideoTest.mp4");
                } else if (b) {
                    driver.findElement(By.cssSelector(locator)).sendKeys(System.getProperty("user.dir") + "/src/test/resources/videospourtest/VideoTest.mp4");
                } else {
                    driver.findElement(By.id(locator)).sendKeys(System.getProperty("user.dir") + "/src/test/resources/videospourtest/VideoTest.mp4");
                }
                break;

            case "un document":
                if (b1) {
                    driver.findElement(By.xpath(locator)).sendKeys(System.getProperty("user.dir") + "/src/test/resources/documentspourtest/DocumentTest.xlsx");
                } else if (b) {
                    driver.findElement(By.cssSelector(locator)).sendKeys(System.getProperty("user.dir") + "/src/test/resources/documentspourtest/DocumentTest.xlsx");
                } else {
                    driver.findElement(By.id(locator)).sendKeys(System.getProperty("user.dir") + "/src/test/resources/documentspourtest/DocumentTest.xlsx");
                }
                break;

            case "une image":
                if (b1) {
                    driver.findElement(By.xpath(locator)).sendKeys(System.getProperty("user.dir") + "/src/test/resources/imagespourtest/imagetest.jpg");
                } else if (b) {
                    driver.findElement(By.cssSelector(locator)).sendKeys(System.getProperty("user.dir") + "/src/test/resources/imagespourtest/imagetest.jpg");
                } else {
                    driver.findElement(By.id(locator)).sendKeys(System.getProperty("user.dir") + "/src/test/resources/imagespourtest/imagetest.jpg");
                }
                break;

            case "une image 2":
                if (b1) {
                    driver.findElement(By.xpath(locator)).sendKeys(System.getProperty("user.dir") + "/src/test/resources/imagespourtest/imagetest2.jpg");
                } else if (b) {
                    driver.findElement(By.cssSelector(locator)).sendKeys(System.getProperty("user.dir") + "/src/test/resources/imagespourtest/imagetest2.jpg");
                } else {
                    driver.findElement(By.id(locator)).sendKeys(System.getProperty("user.dir") + "/src/test/resources/imagespourtest/imagetest2.jpg");
                }
                break;

            default:
                logger.info("Aucun type de fichier selectionné pour l'upload ");
        }

    }


    @And("l utilisateur vérifie que {string} a la valeur {string}")
    public void lUtilisateurVérifieQueALaValeur(String emplacement, String valeur) throws IllegalAccessException {

        String locator = "vide";
        for (List<Field> f : ListeGlobaleLocators) {
            for (Field x : f) {
                if (x.getName().equals(emplacement)) {
                    locator = (String) x.get(x);
                    break;
                }
            }
            if (!locator.equals("vide")) {
                break;
            }
        }
        if (driver.findElement(By.xpath(locator)).isDisplayed() && valeur.equals("Non")) {
            driver.findElement(By.xpath(locator)).click();
            String emplacement2 = "Sauvegarde_" + emplacement;
            locator = "vide";
            for (List<Field> f : ListeGlobaleLocators) {
                for (Field x : f) {
                    if (x.getName().equals(emplacement2)) {
                        locator = (String) x.get(x);
                        break;
                    }
                }
                if (!locator.equals("vide")) {
                    break;
                }
            }
            driver.findElement(By.xpath(locator)).click();
        }

    }

    @And("l'utilisateur rafraichit la page")
    public void lUtilisateurRafraichitLaPage() {
        driver.navigate().refresh();
    }

    @Then("verifier la présence de {string} dans la liste {string}")
    public void verifierLaPrésenceDeDansLaListe(String Optiondelaliste, String liste) throws IllegalAccessException {

        logger.info("L'utilisateur vérifie la présence de  : " + Optiondelaliste + " dans la liste : " + liste);
        String locator = "vide";
        List<WebElement> L;
        for (List<Field> f : ListeGlobaleLocators) {
            for (Field x : f) {
                if (x.getName().equals(liste)) {
                    locator = (String) x.get(x);
                    break;
                }
            }
            if (!locator.equals("vide")) {
                break;
            }
        }

        if (Character.toString(locator.charAt(0)).contains("/")) {
            L = driver.findElements(By.xpath(locator));
        } else if (locator.contains("[") || Character.toString(locator.charAt(0)).contains(".")) {
            L = driver.findElements(By.cssSelector(locator));
        } else {
            L = driver.findElements(By.id(locator));
        }

        boolean  elementExiste=false;

        for (WebElement x : L) {
            actions.moveToElement(x).perform();
            if (x.getAttribute("title").equals(Optiondelaliste)) {
                elementExiste=true;
                logger.info("Element trouvé ");
                break;
            }
        }

        Assert.assertTrue(elementExiste);


    }



    }



