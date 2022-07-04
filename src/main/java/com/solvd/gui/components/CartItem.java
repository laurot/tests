package com.solvd.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.gui.pages.CartPage;

public class CartItem extends AbstractUIObject{
    
    @FindBy(xpath = ".//td[2]")
    private ExtendedWebElement itemName;

    @FindBy(xpath = ".//td[3]")
    private ExtendedWebElement itemPrice;

    @FindBy(xpath = ".//td[4]/a")
    private ExtendedWebElement deleteFromCartBtn;

    public CartItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    
    public String readName(){
        assertElementPresent(itemName);
        return itemName.getText();
    }

    public String readPrice(){
        assertElementPresent(itemPrice);
        return itemPrice.getText();
    }

    public CartPage deleteItemFromCart(){
        deleteFromCartBtn.click();
        return new CartPage(driver);
    }
}
