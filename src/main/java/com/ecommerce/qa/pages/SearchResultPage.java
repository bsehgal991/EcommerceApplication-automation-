package com.ecommerce.qa.pages;

import com.ecommerce.qa.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;
import java.util.List;

public class SearchResultPage extends BaseTest {

    @FindBy(xpath = "//span[contains(@class, 'a-size-medium')]")
    List<WebElement> searchedProductsNames;

    public SearchResultPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }

    public ProductDetailsPage verifyClickonSearchResults()
    {
        for(int i=1;i<=searchedProductsNames.size();i++)
        {
            if(i==3)
            {
                searchedProductsNames.get(i).click();
                break;
            }
        }
        return new ProductDetailsPage();

    }
}
