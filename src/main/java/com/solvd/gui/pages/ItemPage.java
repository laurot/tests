package com.solvd.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class ItemPage extends AbstractPage{

    @FindBy(xpath = "/html/body/div[5]/div/div[1]")
    private ExtendedWebElement name;

    @FindBy(xpath = "/html/body/div[5]/div/div[2]/h3")
    private ExtendedWebElement price;
    
    @FindBy(xpath = "/html/body/div[5]/div/div[2]/div[1]/div/div/p")
    private ExtendedWebElement description;

    public ItemPage(WebDriver driver) {
        super(driver);
    }
    
    public String readName(){
        assertElementPresent(name);
        return name.getText();
    }
    public String readPrice(){
        assertElementPresent(price);
        return price.getText();
    }
    public String readDescription(){
        assertElementPresent(description);
        return description.getText();
    }
}
