package com.solvd.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.gui.pages.CartPage;
import com.solvd.gui.pages.HomePage;

public class NavBar extends AbstractUIObject{

    @FindBy(xpath = "//*[@id='navbarExample']/ul/li[1]/a")
    private ExtendedWebElement homeLink;

    @FindBy(xpath = "//*[@id='navbarExample']/ul/li[2]/a")
    private ExtendedWebElement contactLink;

    @FindBy(xpath = "//*[@id='navbarExample']/ul/li[3]/a")
    private ExtendedWebElement aboutLink;

    @FindBy(id = "cartur")
    private ExtendedWebElement cartLink;

    public NavBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HomePage openHomePage() {
        homeLink.click();
        return new HomePage(driver);
    }

    public CartPage openCartpage(){
        cartLink.click();
        return new CartPage(driver);
    }

}
