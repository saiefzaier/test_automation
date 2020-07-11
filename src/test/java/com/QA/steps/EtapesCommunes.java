package com.QA.steps;

import com.QA.base.streams;
import com.QA.locators.CommonLocators;
import com.QA.locators.GestionDuPersonnel;
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
    public void lutilisateurSelectionneDansLaListeDeroulante(String optionlistederoulante, String listederoulante) throws Throwable {
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
            if (!list1.isEmpty()) {
                try {
                    for (WebElement element1 : list1) {
                        actions.moveToElement(element1).perform();
                        if (element1.getAttribute("innerText").equals(optionlistederoulante)) {
                            element1.click();
                            x = false;
                            break;
                        }
                    }
                } catch (StaleElementReferenceException ignored) {
                }
                if (x) {
                    logger.info("L'option " + optionlistederoulante + " n'éxiste pas dans la liste déroulante " + listederoulante);
                    throw new Exception("L'option " + optionlistederoulante + " n'éxiste pas dans la liste déroulante " + listederoulante);
                }
            } else {
                logger.info("La liste déroulante " + listederoulante + " est vide");
                throw new Exception("La liste déroulante " + listederoulante + " est vide");
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
    public void lUtilisateurSelectionneDansLaListe(String Optiondelaliste, String liste) throws IllegalAccessException, InterruptedException {
        logger.info("L'utilisateur selectionne : " + Optiondelaliste + " dans la liste : " + liste);
        String locator = "vide";
        List<WebElement> L;
        List<WebElement> L1;
        boolean state = true;
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

        while (state) {
            for (WebElement x : L) {
                actions.moveToElement(x).perform();
                if (x.getText().contains(Optiondelaliste)) {
                    JavascriptExecutor executor = (JavascriptExecutor) driver;
                    executor.executeScript("arguments[0].click();", x);
                    //TODO get this back to a normal click after resolving chrome 83 bug on clicking on elements with size 200 x 0
                    //x.click();
                    state = false;
                    break;
                }
            }
            action.pause(driver, 2000);
            if (Character.toString(locator.charAt(0)).contains("/")) {
                L1 = driver.findElements(By.xpath(locator));
            } else if (locator.contains("[") || Character.toString(locator.charAt(0)).contains(".")) {
                L1 = driver.findElements(By.cssSelector(locator));
            } else {
                L1 = driver.findElements(By.id(locator));
            }
            if (L1.size() > L.size()) {
                L = L1;
            } else {
                state = false;
            }
        }
    }

    @Then("vérifier que le message {string} s affiche")
    public void vérifierQueLeMessageSAffiche(String textenotification) throws InterruptedException {
        logger.info("Vérification de l'affichage du message : " + textenotification);
        WebElement modules = (new WebDriverWait(driver, 300))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CommonLocators.Notification_Simple)));
        Boolean veriftxtnotif = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.refreshed(ExpectedConditions.attributeToBeNotEmpty(modules, "innerText")));
        action.pause(driver, 1000);
        Assert.assertTrue(modules.getAttribute("innerText").contains(textenotification));
        action.pause(driver, 100);
        modules.click();

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
            for (int i = 0; i < nompopulation.length(); i++) {
                driver.findElement(By.xpath(locator)).sendKeys(Character.toString(nompopulation.charAt(i)));
                action.pause(driver, 50);
            }
        } else if (locator.contains("[") || Character.toString(locator.charAt(0)).contains(".")) {
            for (int i = 0; i < nompopulation.length(); i++) {
                driver.findElement(By.cssSelector(locator)).sendKeys(Character.toString(nompopulation.charAt(i)));
                action.pause(driver, 50);
            }
        } else {
            for (int i = 0; i < nompopulation.length(); i++) {
                driver.findElement(By.id(locator)).sendKeys(Character.toString(nompopulation.charAt(i)));
                action.pause(driver, 50);
            }
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
    public void lUtilisateurVérifieQueALaValeur(String emplacement, String valeur) throws Exception {

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
        try {
            Boolean modules = (new WebDriverWait(driver, 20))
                    .until(ExpectedConditions.attributeContains(driver.findElement(By.xpath(locator)), "innerText", valeur));
        }
        catch (TimeoutException ignored){ throw new Exception ("La durée de la demande d'absence n'est pas correcte");}
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

        boolean elementExiste = false;

        for (WebElement x : L) {
            actions.moveToElement(x).perform();
            if (x.getAttribute("title").equals(Optiondelaliste)) {
                elementExiste = true;
                logger.info("Element trouvé ");
                break;
            }
        }

        Assert.assertTrue(elementExiste);


    }


    @And("l utilisateur  {string} l'option {string}")
    public void lUtilisateurActiveDésactiveLOption(String choix, String option) throws IllegalAccessException {
        logger.info("L'utilisateur " + choix + " l'option " + option);
        String locator = "vide";
        listededonnees.add(option);
        listededonnees.add(choix);
        // The element to be activated / deactivated must have the "checked" property when inspected
        for (List<Field> f : ListeGlobaleLocators) {
            for (Field x : f) {
                if (x.getName().equals(option)) {
                    locator = (String) x.get(x);
                    break;
                }
            }
            if (!locator.equals("vide")) {
                break;
            }
        }
        // The click on the element is only feasible with the use of javascript
        Boolean optionChecked;
        if (option.contains("JS_")) {
            WebElement elementChoix = driver.findElement(By.xpath(locator));
            optionChecked = elementChoix.isSelected();
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            if ((choix.equals("active") && !optionChecked) || (choix.equals("désactive") && optionChecked)) {
                executor.executeScript("arguments[0].click();", elementChoix);
            }
        }
    }

    @And("vérifier que l element {string} n est pas affiché")
    public void vérifierQueLElementNEstPasAffiché(String element) throws IllegalAccessException {
        logger.info("vérifier que l'élement " + element + " est affiché");
        String locator = "vide";
        for (List<Field> f : ListeGlobaleLocators) {
            for (Field x : f) {
                if (x.getName().equals(element)) {
                    locator = (String) x.get(x);
                    break;
                }
            }
            if (!locator.equals("vide")) {
                break;
            }
        }
        Boolean elementAffiché;
        try {
            WebElement element1 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            elementAffiché = true;
        } catch (NoSuchElementException | TimeoutException e) {
            elementAffiché = false;
        }
        Assert.assertFalse(elementAffiché);


    }

    @And("vérifier que l' element {string} est affiché")
    public void vérifierQueLElementEstAffiché(String element) throws IllegalAccessException {
        logger.info("vérifier que l'élement " + element + " n'est pas affiché");
        String locator = "vide";
        for (List<Field> f : ListeGlobaleLocators) {
            for (Field x : f) {
                if (x.getName().equals(element)) {
                    locator = (String) x.get(x);
                    break;
                }
            }
            if (!locator.equals("vide")) {
                break;
            }
        }
        Boolean elementAffiché;
        try {
            WebElement element1 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            elementAffiché = true;
        } catch (NoSuchElementException | TimeoutException e) {
            elementAffiché = false;
        }

        Assert.assertTrue(elementAffiché);

    }

    @And("verifier que la recherche est KO")
    public void verifierQueLaRechercheEstKO() {
        logger.info("verifier que la recherche du collaborateur inactif est KO");
        WebElement Recherche_KO = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDuPersonnel.Recherche_KO)));
        Assert.assertTrue(Recherche_KO.isDisplayed());
    }

    @Then("l utilisateur ferme la fenetre du navigateur")
    public void lUtilisateurFermeLaFenetreDuNavigateur() {
        logger.info("Fermeture de la fenêtre actuelle du navigateur");
        GenerateurDriver.restartSession = true;
    }

    @And("l utilisateur reçoit une notification {string}")
    public void lUtilisateurReçoitUneNotification(String textenotif) {
        driver.findElement(By.xpath(CommonLocators.Bouton_Notifications_Portal)).click();
        WebElement modules = (new WebDriverWait(driver, 40)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(CommonLocators.Première_Notification_Portal)));
        Assert.assertTrue(driver.findElement(By.xpath(CommonLocators.Première_Notification_Portal)).getAttribute("innerText").contains(textenotif));
    }
}



