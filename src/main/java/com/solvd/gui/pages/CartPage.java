package com.solvd.gui.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.gui.components.CartItem;

public class CartPage extends AbstractPage{

    @FindBy(xpath = "//*[@id='page-wrapper']/div/div[2]/button")
    private ExtendedWebElement placeOrderBtn;

    @FindBy(xpath = "//*[@id='tbodyid']/tr")
    private List<CartItem> cartItems;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartItem selectItem(String itemName) {
        for (CartItem item : cartItems) {
            if (item.readName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        throw new RuntimeException("Unable to find: " + itemName);
    }
    
}
