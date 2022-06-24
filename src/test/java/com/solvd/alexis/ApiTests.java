package com.solvd.alexis;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.api.alexisApi.GetWeatherMap;
import com.solvd.api.alexisApi.GetWindSpeed;
import org.apache.logging.log4j.Logger;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class ApiTests {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "Alexis")
    public void testGetWeatherMap(){
        LOGGER.info("testing");
        GetWeatherMap api = new GetWeatherMap();
        api.callAPIExpectSuccess();
        api.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        api.validateResponseAgainstSchema("alexisApi/_get/city/rs.schema");
    }

    @Test()
    public void testGetWindSpeed(){
        GetWindSpeed api = new GetWindSpeed();
        api.callAPIExpectSuccess();
        api.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        api.validateResponseAgainstSchema("alexisApi/_get/windSpeed/rs.schema");
    }
}
