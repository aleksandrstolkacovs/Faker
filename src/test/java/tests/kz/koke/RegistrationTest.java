package tests.kz.koke;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.BaseFunc;

public class RegistrationTest {

    WebDriver driver;
    private BaseFunc baseFunc = new BaseFunc();
    private final String URL = "staging.koke.kz";

    private final By LOGIN_BTN = By.xpath("//a[contains(@class,  'not_logged')]");
    private final By REGISTRATION_BTN = By.xpath("//a[contains(@class,  'ma')]");
    private final By TITLE = By.xpath(".//h2[conatains(@class, 'pt35')]");

    private final By SET_LOAN_AMOUNT = By.xpath("//input[contains(@name, 'calc_amount')]");
    private final By SET_LOAN_TERM = By.xpath("//select[contains(@class,'value-select')]");
    private final By TAKE_LOAN = By.xpath(".//div[contains(@class,'button secondary')]");

    private final By PK_FIRST_PART = By.id("person-id-number-part-one");
    private final By PK_SECOND_PART = By.id("person-id-number-part-two");
    private final By PHONE = By.id("phone");
    private final By EMAIL = By.id("email");
    private final By PASSWORD1 = By.id("password");
    private final By PASSWORD2 = By.id("password-verify");
    private final By INCOME = By.xpath("//select[contains(@name, 'salary[income]')]");
    private final By OUTCOME = By.xpath("//select[contains(@name, 'salary[expenses]')]");
    private final By CHECKBOX = By.xpath("//*[@id=\"checkbox_container\"]/label[1]/span");
    private final By REGISTRATION_FIRST_PAGE_BTN = By.xpath("//button[contains(@class, 'w100p')]");

    private Integer loamAmount = 80000;
    private Integer termAmount = 25;
    private Integer startAge = 20;
    private Integer endAge = 80;
    private Integer pkFirstPart = 123456;
    private Integer pkSecondPart = 12345;
    private Integer phone = 22329737;
    private String email = "dsfsjdkf@gmail.com";
    private String titleToCheck = "ESMU BINO.LV KLIENTS";


    @Test
    public void createNemClient() throws InterruptedException {

        baseFunc.goToUrl(URL);

        driver.wait(3000);

//        driver.findElement(SET_LOAN_AMOUNT).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"), Keys.DELETE);
//        driver.findElement(SET_LOAN_AMOUNT).sendKeys(String.valueOf(loamAmount));
//        driver.findElement(SET_LOAN_TERM).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"), Keys.DELETE);
//        driver.findElement(SET_LOAN_TERM).sendKeys(String.valueOf(termAmount));
        driver.findElement(TAKE_LOAN).click();

//        driver.findElement(PK_FIRST_PART).sendKeys(String.valueOf(pkFirstPart));
//        driver.findElement(PK_SECOND_PART).sendKeys(String.valueOf(pkSecondPart));
//        driver.findElement(PHONE).sendKeys(String.valueOf(phone));
//        driver.findElement(EMAIL).sendKeys(String.valueOf(email));
//        driver.findElement(PASSWORD1).sendKeys(String.valueOf(phone));
//        driver.findElement(PASSWORD2).sendKeys(String.valueOf(phone));
//
//        new Select(driver.findElement(INCOME)).selectByValue("1000");
//        new Select(driver.findElement(OUTCOME)).selectByValue("150");
//
//        driver.findElement(CHECKBOX).click();
//        driver.findElement(REGISTRATION_FIRST_PAGE_BTN).click();
    }

}
