package com.ecommerce.qa.testcases;

import com.ecommerce.qa.base.BaseTest;
import com.ecommerce.qa.pages.HomePage;
import com.ecommerce.qa.pages.LoginPage;
import com.ecommerce.qa.pages.SearchResultPage;
import com.ecommerce.qa.util.TestUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends BaseTest
{

    public static Logger log= LogManager.getLogger(HomePageTest.class.getName());
    LoginPage loginPage;
    HomePage homePage;

    String sheetName="items";

    public HomePageTest() throws IOException {
        super();
    }

    @BeforeClass
    public void setup() throws IOException {
        initialization();
        loginPage=new LoginPage();
        loginPage.clickOnSignInButton();
        homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

    @Test(priority=1)
    public void verifyHomePageTitleTest()
    {
        log.info("checking home page title");
        String homepagetitle=homePage.verifyHomePageTitle();
        Assert.assertEquals(homepagetitle,"Amazon","HomePage Title not matched");
    }

    @Test(priority = 2)
    public void verifyUserNameLabelTest()
    {
        Assert.assertTrue(homePage.verifyUserNameLabel());
    }


    @DataProvider
    public Object[][] getEcommerceApplicationData()
    {
        Object data[][]=TestUtil.getTestData(sheetName);
        return data;
    }

    @Test(priority = 3,dataProvider = "getEcommerceApplicationData")
    public void verifyProductSearchTest(String item) throws IOException {
       SearchResultPage searchResultPage= homePage.verifyProductSearch(item);
    }

}
