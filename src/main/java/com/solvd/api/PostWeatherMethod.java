package com.solvd.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${base_url}/data/2.5/weather", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/weather/_post/rq.json")
@ResponseTemplatePath(path = "api/weather/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostWeatherMethod extends AbstractApiMethodV2 {

    public PostWeatherMethod() {
        super("api/weather/_post/rq.json", "api/weather/_post/rs.json", "api/weather/weather.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        addUrlParameter("lat", "33.44");
        addUrlParameter("lon", "-94.84");
        addUrlParameter("appid", "ebcbce76c2e1c2539d1c46431a4455f6");
    }
}