package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverSingleton;

import java.util.List;

@Getter
public class MainPage {
    @FindBy(className = "logo-img")
    private WebElement logo;

    @FindBy(id = "myBtn")
    private WebElement settingsBtn;

    @FindBy(id = "exit")
    private WebElement logOutBtn;

    @FindBy(id = "theme")
    private WebElement themeSelect;

    @FindBy(id = "themeDark")
    private WebElement darkTheme;

    @FindBy(id = "themeLight")
    private WebElement lightTheme;

    @FindBy(id = "lang")
    private WebElement languageSelect;

    @FindBy(css = ".two__navigation-language option")
    private List<WebElement> languageOptions;

    @FindBy(id = "findName")
    private WebElement fNameSearch;

    @FindBy(id = "findLname")
    private WebElement lNameSearch;

    @FindBy(id="dbSelect")
    private WebElement dbSelect;

    @FindBy(css = "#dbSelect option")
    private List<WebElement> dbSelectOptions;

    @FindBy(id="firstName")
    private WebElement firstNameInput;

    @FindBy(id="lastName")
    private WebElement lastNameInput;

    @FindBy(id="age")
    private WebElement ageInput;

    @FindBy(id="city")
    private WebElement cityInput;

    @FindBy(id="phone")
    private WebElement phoneInput;

    @FindBy(id="email")
    private WebElement emailInput;

    @FindBy(id="company")
    private WebElement companyInput;

    @FindBy(id="create")
    private WebElement createBtn;

    @FindBy(id="clearAll")
    private WebElement clearAllBtn;

    @FindBy(css = ".table.table-content .table__row")
    private WebElement tableRow;

    @FindBy(css=".table .table.table-content div[data-name='firstName']")
    private WebElement firstNameField;

    @FindBy(css=".table .table.table-content div[data-name='lastName']")
    private WebElement lastNameField;

    @FindBy(css=".table .table.table-content div[data-name='age']")
    private WebElement ageField;

    @FindBy(css=".table .table.table-content div[data-name='city']")
    private WebElement cityField;

    @FindBy(css=".table .table.table-content div[data-name='phone']")
    private WebElement phoneField;

    @FindBy(css=".table .table.table-content div[data-name='email']")
    private WebElement emailField;

    @FindBy(css=".table .table.table-content div[data-name='company']")
    private WebElement companyField;

    @FindBy(id="deleteRow")
    private WebElement deleteRowBtn;

    public MainPage() {
        PageFactory.initElements(DriverSingleton.getDriver(), this);
    }
}
