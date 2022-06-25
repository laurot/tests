package com.solvd.gui.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.gui.components.Footer;
import com.solvd.gui.components.Item;

public class HomePage extends AbstractPage{

    @FindBy(id = "footc")
    private Footer footer;

    @FindBy(xpath = "//*[@id='tbodyid']/div")
    private List<Item> items;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ItemPage selectItem(String itemName) {
        for (Item item : items) {
            if (item.readName().equalsIgnoreCase(itemName)) {
                return item.openItemPage();
            }
        }
        throw new RuntimeException("Unable to open model: " + itemName);
    }
    
    public Footer getFooter() {
        return footer;
    }
    
}
