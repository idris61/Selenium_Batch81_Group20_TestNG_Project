package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BeyzaPage {
    public BeyzaPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath="(//*[text()='Sign In'])[1]")
    public WebElement signIn;

    @FindBy(xpath="(//input[@id='username'])[1]")
    public WebElement username;

    @FindBy(xpath="//*[text()='Sign Out']")
    public WebElement signOut;

    @FindBy(xpath = "(//*[text()='My Account'])[4]")
    public WebElement myAccount;

    @FindBy(xpath = "//*[@class='myaccount-content']")
    public WebElement myAccountList;

    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement myAccountSignOutLink;

    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storManager;

    @FindBy(xpath = "(//span[@class='text'])[4]")
    public WebElement products;

    @FindBy(xpath = "(//span[@class='text'])[18]")
    public WebElement addNew;

    @FindBy(xpath = "(//*[text()='Toptan Ürün Gösterme Ayarları'])[1]")
    public WebElement toptanUrunlerGostermeAyarlari;

    @FindBy(xpath = "//select[@id='piecetype']")
    public WebElement pieceDdm;

    @FindBy(xpath = "//*[@id='unitpercart']")
    public WebElement unitPerPiece;

    @FindBy(xpath = "//input[@id='minorderqtytr']")
    public WebElement minOrderQuantity;

    @FindBy(xpath = "(//span[@class='text'])[14]")
    public WebElement reports;




}
