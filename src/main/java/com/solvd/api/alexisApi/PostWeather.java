package com.solvd.api.alexisApi;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${base_url}/data/2.5/weather", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "alexisApi/_post/rq.json")
@ResponseTemplatePath(path = "alexisApi/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostWeather extends AbstractApiMethodV2 {

    public PostWeather() {
        super("alexisApi/_post/rq.json", "alexisApi/_post/rs.json", "api/weather/weather.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        addUrlParameter("lat", "-26.7617");
        addUrlParameter("lon", "-65.1789");
        addUrlParameter("appid", "5b344c6b2d82cee778953054fd277080");
    }
}
