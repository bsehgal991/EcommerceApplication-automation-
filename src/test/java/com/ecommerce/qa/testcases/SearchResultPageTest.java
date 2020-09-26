package com.ecommerce.qa.testcases;

import com.ecommerce.qa.base.BaseTest;
import com.ecommerce.qa.pages.HomePage;
import com.ecommerce.qa.pages.LoginPage;
import com.ecommerce.qa.pages.ProductDetailsPage;
import com.ecommerce.qa.pages.SearchResultPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchResultPageTest extends BaseTest
{

    public static Logger log= LogManager.getLogger(SearchResultPageTest.class.getName());
    LoginPage loginPage;
    HomePage homePage;
    SearchResultPage searchResultPage;

    public SearchResultPageTest() throws IOException {
        super();
    }

    @BeforeClass
    public void setup() throws IOException {

        initialization();
        loginPage=new LoginPage();
        loginPage.clickOnSignInButton();
        homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        log.info("navigated to search result page");
        //searchResultPage=homePage.verifyProductSearch();
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }


    @Test(priority=1)
    public void clickOnSearchResultTest()
    {
        ProductDetailsPage productDetailsPage=searchResultPage.verifyClickonSearchResults();
    }
}
