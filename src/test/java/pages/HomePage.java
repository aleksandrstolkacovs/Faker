package pages;

import org.openqa.selenium.By;

public class HomePage {
    private  BaseFunc baseFunc;

    private final By REGISTRATION_BTN = By.xpath(".//button[contains(@class, 'block secondary')]");

    public HomePage(BaseFunc baseFunc){
        this.baseFunc = baseFunc;
    }

    public void clickGetLoan(){
        baseFunc.getElement(REGISTRATION_BTN);
    }
}
