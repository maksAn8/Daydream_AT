package steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AuthorizationPage;
import utils.DriverSingleton;

import static utils.Config.AUTH_PAGE_URL;

public class AuthorizationSteps {
    private AuthorizationPage authPage = new AuthorizationPage();
    private WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriver(), 10);

    @Given("^User sign in with login '(.*)' and password '(.*)'$")
    public void userSignIn(String login, String password) {
        authPage.getLoginInput().sendKeys(login);
        authPage.getPasswordInput().sendKeys(password);
        authPage.getLoginBtn().click();
    }

    @Given("^Authorization page is opened$")
    public void authorizationPageIsOpened() {
        DriverSingleton.getDriver().get(AUTH_PAGE_URL);
    }
}
