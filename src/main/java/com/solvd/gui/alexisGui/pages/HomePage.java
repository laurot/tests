/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.solvd.gui.alexisGui.pages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.gui.alexisGui.components.Categories;
import com.solvd.gui.alexisGui.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;


public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "//*[@id=\"cat\"]")
    private Categories categories;

    @FindBy(id = "navbarExample")
    private Header header;

    @FindBy(xpath = "//div[contains(@class, 'brandmenu-v2')]//a")
    private List<ExtendedWebElement> brandLinks;


    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public Categories getCategories() {
        return categories;
    }
    public Header getHeader(){
        return header;
    }

    public PhonesPage selectModel(String model) {
        LOGGER.info("selecting '" + model + "' model...");
        for (ExtendedWebElement modelLink : brandLinks) {
            String currentModel = modelLink.getText();
            LOGGER.info("currentBrand: " + currentModel);
            if (model.equalsIgnoreCase(currentModel)) {
                modelLink.click();
                return new PhonesPage(driver);
            }
        }
        throw new RuntimeException("Unable to open brand: " + model);
    }
}
