package com.solvd.lautaro;

import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONCompareMode;
import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.APIMethodPoller;
import com.solvd.api.GetWeatherMethod;
import com.solvd.api.PostWeatherMethod;

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
    public void testCreateWeather() throws Exception{
        LOGGER.info("test");
        setCases("4555,54545");
        PostWeatherMethod api = new PostWeatherMethod();
        
        AtomicInteger counter = new AtomicInteger(0);

        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }

    @Test()
    public void testSomething() throws Exception {
        GetWeatherMethod api = new GetWeatherMethod();
        api.callAPIExpectSuccess();
    }
}
