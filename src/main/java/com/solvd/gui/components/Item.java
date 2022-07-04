package com.solvd.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.gui.pages.ItemPage;

public class Item extends AbstractUIObject {

    @FindBy(xpath = ".//div/div/h4/a")
    private ExtendedWebElement itemLink;

    @FindBy(xpath = ".//div/div/h5")
    private ExtendedWebElement price;

    @FindBy(xpath = ".//div/div/h5")
    private ExtendedWebElement description;

    public Item(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ItemPage openItemPage() {
        itemLink.click();
        return new ItemPage(driver);
    }

    public String readName() {
        return itemLink.getText();
    }

    public String readPrice() {
        return price.getText();
    }

    public String readDescription() {
        return description.getText();
    }
}
