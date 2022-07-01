package com.solvd.gui.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.gui.components.Footer;
import com.solvd.gui.components.Item;
import com.solvd.gui.components.NavBar;

public class HomePage extends AbstractPage{

    @FindBy(id = "footc")
    private Footer footer;

    @FindBy(id = "navbarExample")
    private NavBar navBar;

    @FindBy(xpath = "//*[@id='tbodyid']/div")
    private List<Item> items;

    @FindBy(id = "prev2")
    private ExtendedWebElement prevBtn;

    @FindBy(id = "next2")
    private ExtendedWebElement nextBtn;

    @FindBy(xpath = "//*[@id='contcont']/div/div[1]/div/a[2]")
    private ExtendedWebElement phonesMenuBtn;

    @FindBy(xpath = "//*[@id='contcont']/div/div[1]/div/a[3]")
    private ExtendedWebElement laptopsMenuBtn;

    @FindBy(xpath = "//*[@id='contcont']/div/div[1]/div/a[4]")
    private ExtendedWebElement MonitorsMenuBtn;

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

    public NavBar getNavBar(){
        return navBar;
    }

    public void nextOptions(){
        nextBtn.click();
    }

    public void prevOptions(){
        prevBtn.click();
    }

    public void showPhones(){
        phonesMenuBtn.click();
    }

    public void showLaptops(){
        laptopsMenuBtn.click();
    }
    
    public void showMonitors(){
        MonitorsMenuBtn.click();
    }
}
