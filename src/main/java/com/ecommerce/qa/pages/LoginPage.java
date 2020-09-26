package com.ecommerce.qa.pages;

import com.ecommerce.qa.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends BaseTest {

    //Object Repository

    @FindBy(xpath = "//span[contains(text(),'Hello, Sign in')]")
    @CacheLookup
    WebElement signInBtn;

    @FindBy(xpath = "//input[@id='ap_email']")
    @CacheLookup
    WebElement username;

    @FindBy(xpath = "//input[@id='continue']")
    @CacheLookup
    WebElement continueBtn;

    @FindBy(xpath = "//input[@type='password']")
    @CacheLookup
    WebElement password;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    @CacheLookup
    WebElement loginBtn;

    //Initializing the page objects
    public LoginPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }


    //Actions
    public void clickOnSignInButton() throws IOException {
        signInBtn.click();

        //return new LoginPage();
    }

    public HomePage login(String usrname,String pwd) throws IOException {

        username.sendKeys(usrname);
        continueBtn.click();
        password.sendKeys(pwd);
        loginBtn.click();

        return new HomePage();

    }
}
