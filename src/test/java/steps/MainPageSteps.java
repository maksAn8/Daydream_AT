package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import utils.DriverSingleton;

import java.util.List;
import java.util.Random;

public class MainPageSteps {
    private MainPage mainPage = new MainPage();
    private WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriver(), 5);
    private List<WebElement> rows;

    @Then("^I see main page$")
    public void iSeeMainPage() {
        wait.until(ExpectedConditions.visibilityOf(mainPage.getDbSelect()));
    }

    @Then("^I see table with data from '(.*)'$")
    public void iSeeTableWithData(String db) {
        wait.until(ExpectedConditions.visibilityOf(mainPage.getDbSelect())).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(mainPage.getDbSelectOptions()));
        mainPage.getDbSelectOptions().stream().filter(webElement -> webElement.getAttribute("textContent").equals(db)).forEach(WebElement::click);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(mainPage.getTableRow())));
    }

    @And("^I change '(.*)' to '(.*)'$")
    public void iChangeColumnValue(String columnName, String value) {
        WebElement elementToChange = null;
        switch (columnName) {
            case "Fname":
                elementToChange = mainPage.getFirstNameField();
                break;
            case "Lname":
                elementToChange = mainPage.getLastNameField();
                break;
            case "Age":
                elementToChange = mainPage.getAgeField();
                break;
            case "City":
                elementToChange = mainPage.getCityField();
                break;
            case "Phone number":
                elementToChange = mainPage.getPhoneField();
                break;
            case "Email":
                elementToChange = mainPage.getEmailField();
                break;
            case "Company name":
                elementToChange = mainPage.getCompanyField();
                break;
        }
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(elementToChange)));
        Actions action = new Actions(DriverSingleton.getDriver());
        action.doubleClick(elementToChange).click().sendKeys(value).build().perform();
        //elementToChange.sendKeys(value);
        action.moveToElement(mainPage.getLogo()).click().build().perform();
    }

    @Then("^I refresh page and check '(.*)' = '(.*)'$")
    public void iRefreshPageAndCheckColumn_nameValue(String columnName, String value) {
        DriverSingleton.getDriver().navigate().refresh();
        WebElement elementToCheck = null;
        switch (columnName) {
            case "Fname":
                elementToCheck = mainPage.getFirstNameField();
                break;
            case "Lname":
                elementToCheck = mainPage.getLastNameField();
                break;
            case "Age":
                elementToCheck = mainPage.getAgeField();
                break;
            case "City":
                elementToCheck = mainPage.getCityField();
                break;
            case "Phone number":
                elementToCheck = mainPage.getPhoneField();
                break;
            case "Email":
                elementToCheck = mainPage.getEmailField();
                break;
            case "Company name":
                elementToCheck = mainPage.getCompanyField();
                break;
        }
        Assert.assertEquals("Update failed", value, elementToCheck.getAttribute("title"));
    }

    @When("^I select '(.*)' theme in dropdown$")
    public void iSelectThemeThemeInDropdown(String theme) {
        String expectedColor;
        wait.until(ExpectedConditions.visibilityOf(mainPage.getThemeSelect())).click();
        if (theme.equals("Dark")) {
            wait.until(ExpectedConditions.visibilityOf(mainPage.getDarkTheme())).click();
            expectedColor = "rgba(0, 0, 0, 0)";
        } else {
            wait.until(ExpectedConditions.visibilityOf(mainPage.getLightTheme())).click();
            expectedColor = "rgba(229, 229, 229, 1)";
        }
        wait.until(ExpectedConditions.attributeToBe(DriverSingleton.getDriver().findElement(By.className("container")), "background-color", expectedColor));
        Assert.assertEquals("Theme is not " + theme,
                expectedColor,
                DriverSingleton.getDriver().findElement(By.tagName("section")).getCssValue("background-color"));
    }

    @Then("^Theme became '(.*)'$")
    public void themeBecame(String theme) {
        String expectedColor;
        if (theme.equals("Dark")) {
            expectedColor = "rgba(0, 0, 0, 0.85)";
        } else {
            expectedColor = "rgba(229, 229, 229, 1)";
        }
        Assert.assertEquals("Theme is not " + theme,
                expectedColor,
                DriverSingleton.getDriver().findElement(By.tagName("section")).getCssValue("background-color"));
    }

    @And("^I log out$")
    public void iLogOut() {
        mainPage.getLogOutBtn().click();
    }

    @And("^I create Person$")
    public void iCreatePerson() {
        mainPage.getFirstNameInput().sendKeys("AutoName");
        mainPage.getLastNameInput().sendKeys("AutoLastName");
        mainPage.getAgeInput().sendKeys(Integer.toString(new Random().nextInt(151)));
        mainPage.getCityInput().sendKeys("AutoCity");
        mainPage.getPhoneInput().sendKeys("+" + (new Random().nextInt(1_000_000_001) + 1_147_483_647));
        mainPage.getEmailInput().sendKeys("auto.Email" + (new Random().nextInt(1000)) + "@mail.com");
        mainPage.getCompanyInput().sendKeys("autoCompany");
        mainPage.getCreateBtn().click();
    }

    @Then("^I check Person was added to data base '(.*)'$")
    public void iCheckPersonWasAddedToDataBase(String db) {
        try {
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.attributeToBe(mainPage.getFirstNameField(), "textContent", "AutoName")));
        } catch (TimeoutException e) {
            DriverSingleton.getDriver().navigate().refresh();
        }
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.attributeToBe(mainPage.getLastNameField(), "textContent", "AutoLastName")));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.attributeToBe(mainPage.getCityField(), "textContent", "AutoCity")));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.attributeToBe(mainPage.getCompanyField(), "textContent", "autoCompany")));
    }

    @And("^I delete Person$")
    public void iDeletePerson() {
        rows = DriverSingleton.getDriver().findElements(By.cssSelector(".table.table-content .table__row"));
        System.out.println(rows.size());
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(mainPage.getDeleteRowBtn()))).click();
        DriverSingleton.getDriver().navigate().refresh();
    }

    @Then("^I check Person was deleted in data base '(.*)'$")
    public void iCheckPersonWasDeletedInDataBase(String db) {
        Assert.assertEquals("Row was not deleted",
                rows.size() - 1,
                DriverSingleton.getDriver().findElements(By.cssSelector(".table.table-content .table__row")).size());
    }
}
