package com.ecommerce.qa.pages;

import com.ecommerce.qa.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends BaseTest {

    @FindBy(xpath = "//span[contains(text(),'Hello, Bhawna')]")
    WebElement userNameLabel;


    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement searchbar;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement searchBtn;


    public HomePage() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }

    public String verifyHomePageTitle()
    {
        return driver.getTitle();
    }

    public boolean verifyUserNameLabel()
    {
        return userNameLabel.isDisplayed();
    }

    public SearchResultPage verifyProductSearch(String item) throws IOException {
         searchbar.sendKeys(item);
         searchBtn.click();
         return new SearchResultPage();
    }

}
