package com.solvd.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class FooterMenu extends AbstractUIObject{
    
    public FooterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(id = "footmenu")
    private FooterMenu footerMenu;
    
}
