package com.solvd.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.gui.components.Footer;
import com.solvd.gui.components.NavBar;

public class ItemPage extends AbstractPage{

    @FindBy(id = "footc")
    private Footer footer;

    @FindBy(id = "navbarExample")
    private NavBar navBar;

    @FindBy(xpath = "//*[@id='tbodyid']/h2")
    private ExtendedWebElement name;

    @FindBy(xpath = "//*[@id='tbodyid']/h3")
    private ExtendedWebElement price;
    
    @FindBy(xpath = "//*[@id='more-information']/p/")
    private ExtendedWebElement description;

    @FindBy(xpath = "//*[@id='tbodyid']/div[2]/div/a")
    private ExtendedWebElement addToCartButton;

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

    public void addToCart(){
        addToCartButton.click();
        driver.switchTo().alert().accept();
    }

    public Footer getFooter() {
        return footer;
    }

    public NavBar getNavBar(){
        return navBar;
    }

}
