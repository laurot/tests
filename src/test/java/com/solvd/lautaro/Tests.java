package com.solvd.lautaro;

import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONCompareMode;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;

import api.GetWeatherMethod;

public class Tests implements IAbstractTest {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    public void testGetWeather() throws Exception{
            LOGGER.info("test");
            GetWeatherMethod api = new GetWeatherMethod();
            api.callAPIExpectSuccess();
            api.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
            api.validateResponseAgainstSchema("api/weather/_get/rs.schema");
    }

    @Test()
    public void testSomething() throws Exception{
        GetWeatherMethod api = new GetWeatherMethod();
        api.callAPIExpectSuccess();
        api.validateResponse(mode, comparatorContext, validationFlags);
    }
}
