package com.solvd.gui.alexisGui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.gui.alexisGui.pages.CartPage;
import com.solvd.gui.alexisGui.pages.HomePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {
    @FindBy(linkText = "Home")
    private ExtendedWebElement homeLink;

    @FindBy(linkText = "Contact")
    private ExtendedWebElement contactLink;

    @FindBy(id="cartur")
    private ExtendedWebElement cartLink;


    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HomePage openHomePage() {
        homeLink.click();
        return new HomePage(driver);
    }

    public CartPage openCartPage() {
        cartLink.click();
        return new CartPage(driver);
    }
}
