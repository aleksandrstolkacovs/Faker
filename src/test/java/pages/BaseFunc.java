package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseFunc {
    private  WebDriver driver;

    public BaseFunc(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/nail.karimov/IdeaProjects/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void goToUrl(String url){
        if (!url.contains("http://") || !url.contains("https://")){
            url = "https://" + url;
        }
            driver.get(url);
    }

    public WebElement getElement(By locator){
        Assertions.assertFalse(driver.findElements(locator).isEmpty(), "There is no such element");
        return driver.findElement(locator);
    }

    public void waiForElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void closeBrouser(){
        driver.quit();
    }

}
