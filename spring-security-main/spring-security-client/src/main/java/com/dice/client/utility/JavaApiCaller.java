package com.dice.client.utility;

import com.dice.client.model.Response;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class JavaApiCaller {
    @Value("${rapid.service.api.key}")
    private String apiKey;
    @Value("${rapid.api.host}")
    private String apiHost;
    Logger logger = LoggerClass.getLogger(this.getClass().getName());
    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<Object> callAPI(String apiUrl) throws HttpServerErrorException {

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.set(Constants.X_RapidAPI_Key, apiKey);
        requestHeaders.set(Constants.X_RapidAPI_Host, apiHost);
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestHeaders);
        try {
            ResponseEntity<Object> response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.GET,
                    requestEntity,
                    Object.class
            );
            return response;
        } catch (Exception e) {
            logger.debug("Error while calling /callAPI api : {} ", e.getMessage());
            return new ResponseEntity<>(new Response(Constants.FAILED,"Exception occurs",e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
