package com.ecommerce.qa.testcases;

import com.ecommerce.qa.base.BaseTest;
import com.ecommerce.qa.pages.HomePage;
import com.ecommerce.qa.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import java.io.IOException;

public class LoginPageTest extends BaseTest {

    public static Logger log= LogManager.getLogger(LoginPageTest.class.getName());

    LoginPage loginPage;
    public LoginPageTest() throws IOException {
        super();

    }

    @BeforeClass
    public void setUp() throws IOException {
        log.info("initializing browser");
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
        log.info("clicking on sign in button");
        loginPage.clickOnSignInButton();

    }


    @Test(priority = 2)
    public void loginTest() throws IOException {
        HomePage homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }


}
