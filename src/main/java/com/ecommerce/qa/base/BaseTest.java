package com.ecommerce.qa.base;

import com.ecommerce.qa.util.TestUtil;
import com.ecommerce.qa.util.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;

    public static Properties prop;

    public static EventFiringWebDriver e_driver;

    public static WebEventListener eventListener;


    public BaseTest() throws IOException {

        prop=new Properties();

        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/ecommerce/qa/config/config.properties");

        prop.load(fis);

    }

    public static void initialization() throws IOException {
        String browserName=prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().version("85.0.4183.87").setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("enable-automation");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--disable-gpu");

            if(browserName.contains("headless")) {
                //command to run test cases in chrome headless mode
                options.addArguments("headless");
            }
            driver = new ChromeDriver(options);
        }

        else if(browserName.equalsIgnoreCase("firefox"))
        {

        }

        e_driver=new EventFiringWebDriver(driver);
        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        eventListener=new WebEventListener();
        e_driver.register((WebDriverEventListener) eventListener);
        driver=e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));




    }
}
