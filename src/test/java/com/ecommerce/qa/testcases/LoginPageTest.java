package com.ecommerce.qa.testcases;

import com.ecommerce.qa.base.BaseTest;
import com.ecommerce.qa.pages.HomePage;
import com.ecommerce.qa.pages.LoginPage;
import org.testng.annotations.*;

import java.io.IOException;

public class LoginPageTest extends BaseTest {

    LoginPage loginPage;
    public LoginPageTest() throws IOException {
        super();

    }

    @BeforeClass
    public void setUp() throws IOException {
        initialization();
        loginPage=new LoginPage();
    }


    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

    @Test(priority=1)
    public void signInButtonClickTest() throws IOException {
        loginPage.clickOnSignInButton();

    }


    @Test(priority = 2)
    public void loginTest() throws IOException {
        HomePage homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }




}
