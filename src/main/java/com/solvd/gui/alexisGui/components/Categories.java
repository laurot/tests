package com.solvd.gui.alexisGui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.gui.alexisGui.pages.HomePage;
import com.solvd.gui.alexisGui.pages.PhonesPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Categories extends AbstractUIObject {
    @FindBy(linkText = "Phones")
    private ExtendedWebElement phonesLink;
    @FindBy(linkText = "Laptop")
    private ExtendedWebElement laptopLink;
    @FindBy(linkText = "Monitors")
    private ExtendedWebElement monitorsLink;

    public Categories(WebDriver driver) {
        super(driver);
    }

    public Categories(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public PhonesPage openPhonesPage() {
        phonesLink.click();
        return new PhonesPage(driver);
    }

}
