package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class IdrisPage {

    public IdrisPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath="(//*[text()='Sign In'])[1]")
    public WebElement signIn;
    @FindBy(xpath="(//input[@id='username'])[1]")
    public WebElement username;
    @FindBy(xpath="//button[@name='login']")
    public WebElement signIn2;

    @FindBy(xpath="//a[text()='My Account']")
    public WebElement myAccount;
    @FindBy(xpath="//a[text()='Store Manager']")
    public WebElement storeManager;

    @FindBy(xpath="(//a[@class='wcfm_menu_item '])[3]")
    public WebElement products;

    @FindBy(xpath="//span[text()='Add New']")
    public WebElement productsAddNew;

    @FindBy(xpath="(//div[@class='page_collapsible_content_holder'])[4]")
    public WebElement shipping;

    @FindBy(xpath="//*[@id='weight']")
    public WebElement shippingWeight;

    @FindBy(xpath="//input[@id='length']")
    public WebElement dimensionsLength;

    @FindBy(xpath="//input[@id='width']")
    public WebElement dimensionsWidth;

    @FindBy(xpath="//input[@id='height']")
    public WebElement dimensionsHeight;

    @FindBy(xpath="//select[@id='_wcfmmp_processing_time']")
    public WebElement ddProcessingTime;

    //--------------// US014 E AİT LOCATE LER //-----------------//

    @FindBy(xpath="(//a[@class='wcfm_menu_item '])[5]")
    public WebElement coupons;

    @FindBy(xpath="//span[text()='Add New']")
    public WebElement couponsAddNew;

    @FindBy(xpath="//input[@id='minimum_amount']")
    public WebElement minimumSpend;

    @FindBy(xpath="//input[@id='maximum_amount']")
    public WebElement maximumSpend;

    @FindBy(xpath="//input[@id='individual_use']")
    public WebElement cboxIndividualUseOnly;

    @FindBy(xpath="//input[@id='exclude_sale_items']")
    public WebElement cboxExcludeSaleITems;

    @FindBy(xpath="//select[@id='exclude_product_categories']")
    public WebElement ddExcludeCategories;

    @FindBy(xpath="//div[@id='wcfm_products_manage_form_shipping_expander']")
    public List<WebElement> shippingTamami;




    //--------------------------------------//
    @FindBy(xpath="//*[@id='pro_title']")
    public WebElement productTitle;

    @FindBy(xpath="(//input[@class='wcfm-checkbox checklist_type_product_cat '])[1]")
    public WebElement checkboxAccessories;

    @FindBy(xpath="//img[@id='featured_img_display']")
    public WebElement resimSec;

    @FindBy(xpath="//*[text()='Media Library']")
    public WebElement mediaLibrary;

    @FindBy(xpath="(//div[@class='thumbnail'])[1]")
    public WebElement resim;

    @FindBy(xpath="//*[@class='button media-button button-primary button-large media-button-select']")
    public WebElement select;

    @FindBy(xpath="//*[@id='gallery_img_gimage_0_display']")
    public WebElement kucukResim;
    @FindBy(xpath="(//*[@class='thumbnail'])[10]")
    public WebElement resim2;

    @FindBy(xpath="(//*[@class='button media-button button-primary button-large media-button-select'])[2]")
    public WebElement addToGallery;
    @FindBy(xpath="(//input[@class='wcfm_submit_button'])[1]")
    public WebElement submit;

    @FindBy(xpath="//*[text()='Sign Out']")
    public WebElement signOut;


}
