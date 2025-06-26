package com.automation.utils;

import io.restassured.response.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import static com.automation.dataProviders.ConfigFileReader.getPropertyEnvironment;
import static com.automation.utils.DBCaller.DB_PASSWORD;
import static com.automation.utils.DatabaseConstants.*;
import static io.restassured.RestAssured.given;

public class APICaller {
    static Response response;

    public static int RESPONSE_STATUS_CODE_200 = 200;
    public static int RESPONSE_STATUS_CODE_201 = 201;
    public static int RESPONSE_STATUS_CODE_400 = 400;
    public static int RESPONSE_STATUS_CODE_401 = 401;
    public static int RESPONSE_STATUS_CODE_500 = 500;
    public static int RESPONSE_STATUS_CODE_502 = 502;
    private static final String CONTENT_TYPE_JSON = "application/json";
    private static final String AUTH_HEADER = "Authorization";
    private static final String SIGNATURE_HEADER = "signature";
    private static final String APPS_HEADER = "apps";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String BEARER = "Bearer ";

    public static String makeAPICall(String apiUrl) throws Exception {
        // Create an HttpClient
        HttpClient httpClient = HttpClientBuilder.create().build();

        // Define the API request
        HttpGet request = new HttpGet(apiUrl);

        // Execute the request and get the response
        HttpResponse response = httpClient.execute(request);

        // Extract and return the response body as a String
        String responseBody = org.apache.commons.io.IOUtils.toString(response.getEntity().getContent(), "UTF-8");

        // Print or log the API response content
        System.out.println("API Request Body: " + request);
        System.out.println("API Response Code: " + response.getStatusLine().getStatusCode());
        System.out.println("API Response Body: " + responseBody);

        return responseBody;

    }

    // GET Method without Headers
    public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url); // http get request
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpget); // hit the url

        return closeableHttpResponse;
    }

    // GET Method with Headers
    public CloseableHttpResponse get(String url, HashMap<String, String> headerMap)
            throws ClientProtocolException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url); // http get request

        for (Map.Entry<String, String> entry : headerMap.entrySet()) {

            httpget.addHeader(entry.getKey(), entry.getValue());
        }

        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpget); // hit the url

        return closeableHttpResponse;
    }

    // Post Method
    public CloseableHttpResponse post(String url, String entityString, HashMap<String, String> headerMap) throws ClientProtocolException, IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url); // post request
        httpPost.setEntity(new StringEntity(entityString)); // payload

        // headers
        for (Map.Entry<String, String> entry : headerMap.entrySet()) {

            httpPost.addHeader(entry.getKey(), entry.getValue());
        }

        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpPost); // hit the url

        return closeableHttpResponse;

    }
    // Put Method without Body
    public CloseableHttpResponse put(String url, HashMap<String, String> headerMap) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut httpput = new HttpPut(url); // post request

        // headers
        for (Map.Entry<String, String> entry : headerMap.entrySet()) {

            httpput.addHeader(entry.getKey(), entry.getValue());
        }

        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpput); // hit the url

        return closeableHttpResponse;

    }
    public CloseableHttpResponse put(String url, String entityString, HashMap<String, String> headerMap) throws ClientProtocolException, IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut httpPut = new HttpPut(url); // post request
        httpPut.setEntity(new StringEntity(entityString)); // payload

        // headers
        for (Map.Entry<String, String> entry : headerMap.entrySet()) {

            httpPut.addHeader(entry.getKey(), entry.getValue());
        }

        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpPut); // hit the url

        return closeableHttpResponse;

    }
    /**
     * This method is used to get the base URL from the environment configuration.
     *
     * @return The base URL as a string.
     */

    public static String getBaseUrl() {
       String baseUrl;
        if(getPropertyEnvironment().equalsIgnoreCase("uat")||getPropertyEnvironment().equalsIgnoreCase("dev")) {
            baseUrl="https://api-klik-uat.edts.id/";
        } else {
            baseUrl="https://api-klik.klikindomaret.com";
        }
        return baseUrl;
    }

    /**
     * Retrieves the OTP from the API.
     *
     * @param phoneNumber The phone number for which to retrieve the OTP.
     * @return The OTP as a string.
     */
    public static String getOTP(String phoneNumber) {
        // Pause the execution for 2 seconds to ensure the previous operation is complete
        // Send a GET request to the API to retrieve the OTP
        response =
                given()
                        .log()
                        .all()
                        .pathParam("phoneNumber", phoneNumber)
                        .pathParam("type", "sms")
                        .get(getBaseUrl() + "customer/api/helper/otp/" + "{phoneNumber}/{type}")
                        .then()
                        .log() // Log the response details
                        .all()
                        .statusCode(200) // Verify the response status code is 200 (OK)
                        .extract()
                        .response(); // Extract the response object

        // Extract the OTP from the response JSON
        return response.jsonPath()
                .getString("data.otpNumber");
    }

    /**
     * Performs a database API call with a given query.
     *
     * @param query  The SQL query to execute.
     * @param schema The schema to use for the database connection.
     * @return The response from the database API.
     */
    private static Response helperDatabaseAPI(String query, String schema) {
        // Set up the request with logging and JSON content type
        return given()
                .log()
                .all()
                .header(CONTENT_TYPE_HEADER, CONTENT_TYPE_JSON)
                // Set up the request body with database connection details and query
                .body("{\n" +
                        "    \"jdbc\": \"" + DB_HOST + ":" + DB_PORT + "/" + schema + "\",\n" +
                        "    \"username\": \"" + DB_USER + "\",\n" +
                        "    \"password\": \"" + DB_PASSWORD + "\",\n" +
                        "    \"classname\": \"" + DB_DRIVER_NAME + "\",\n" +
                        "    \"query\": \"" + query + "\"\n" +
                        "}")
                // Send the request to the database API
                .post(DB_API_URL + "getresult")
                // Verify the response status code and extract the response
                .then()
                .log() // Log the response details
                .all()
                .statusCode(200) // Verify the response status code is 200 (OK)
                .extract()
                .response(); // Extract the response object
    }
}
