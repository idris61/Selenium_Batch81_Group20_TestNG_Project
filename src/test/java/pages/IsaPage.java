package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class IsaPage {

    public IsaPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath="//span[text()='Sign In']")
    public WebElement signIn;
    @FindBy(xpath="(//input[@id='username'])[1]")
    public WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;
}
