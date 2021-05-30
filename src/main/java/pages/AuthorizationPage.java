package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverSingleton;

import static utils.Config.AUTH_PAGE_URL;

@Getter
public class AuthorizationPage {
    @FindBy(id = "loginIpt")
    private WebElement loginInput;

    @FindBy(id = "passwordIpt")
    private WebElement passwordInput;

    @FindBy(id = "login")
    private WebElement loginBtn;

    public AuthorizationPage() {
        PageFactory.initElements(DriverSingleton.getDriver(), this);
        DriverSingleton.getDriver().get(AUTH_PAGE_URL);
    }
}
