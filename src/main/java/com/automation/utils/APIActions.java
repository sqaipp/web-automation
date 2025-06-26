package com.automation.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class APIActions {
    static APICaller restClient;
    static CloseableHttpResponse closeableHttpResponse, closeableHttpResponse1, closeableHttpResponse2;

    public static String hitAPIGetAvailablePLU(int qtyPLU) throws IOException {
        /*
         * API Post : Get Available PLU
         */
        System.out.println("API Post : Get Available PLU");
        String plu = null;
        restClient = new APICaller();

        /*
         * API Post 1
         */
        HashMap<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Content-Type", "application/json");

        String apiURL = "http://103.103.30.83:8866/getresult";

        Map<Object, Object> data = new HashMap<>();
        data.put("jdbc", "jdbc:postgresql://192.168.92.152:5433/klik_stock");
        data.put("username", "qa_team");
        data.put("password", "edts321");
        data.put("classname", "org.postgresql.Driver");
        data.put("query", "select ps.plu from app.product_store ps where ps.store_code = 'TBLJ' and ps.qty_akhir > 0 and ps.stock > 0");

        // Obj to Json in String
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String JsonToString1 = mapper.writeValueAsString(data);
        System.out.println(JsonToString1);

        closeableHttpResponse1 = restClient.post(apiURL, JsonToString1, headerMap);

        //validate response from API:
        String responseBody1 = IOUtils.toString(closeableHttpResponse1.getEntity().getContent(), "UTF-8");

        JSONObject responseJson1 = new JSONObject(responseBody1);
        JSONArray jsonarr1 = responseJson1.getJSONArray("myArrayList");

        //status code:
        int statusCode1 = closeableHttpResponse1.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode1, APICaller.RESPONSE_STATUS_CODE_200);

        // Print or log the API response content
        System.out.println("API Response Code 1 - PLU Stock Ready : " + closeableHttpResponse1.getStatusLine().getStatusCode());

        List<String> memList1 = null;
        if (!jsonarr1.isNull(0)) {
            //Not Null
            memList1 = new ArrayList<String>();

            int i = 0;
            while (i < 1000) {
                JSONObject element = jsonarr1.getJSONObject(i).getJSONObject("map");
                plu = element.getString("plu");
                memList1.add(plu);
                i++;
            }
        }
        System.out.println("Array API 1 - PLU Stock Ready : " + memList1);

        /*
         * API Post 2
         */
        HashMap<String, String> headerMap2 = new HashMap<String, String>();
        headerMap2.put("Content-Type", "application/json");

        Map<Object, Object> data2 = new HashMap<>();
        data2.put("jdbc", "jdbc:postgresql://192.168.92.152:5433/klik_catalog");
        data2.put("username", "qa_team");
        data2.put("password", "edts321");
        data2.put("classname", "org.postgresql.Driver");
        data2.put("query", "select x.plu from app.product x where x.published = true");

        // Obj to Json in String
        ObjectMapper mapper2 = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String JsonToString2 = mapper2.writeValueAsString(data2);
        System.out.println(JsonToString2);

        closeableHttpResponse2 = restClient.post(apiURL, JsonToString2, headerMap2);

        //validate response from API:
        String responseBody2 = IOUtils.toString(closeableHttpResponse2.getEntity().getContent(), "UTF-8");

        JSONObject responseJson2 = new JSONObject(responseBody2);
        JSONArray jsonarr2 = responseJson2.getJSONArray("myArrayList");

        //status code:
        int statusCode2 = closeableHttpResponse2.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode2, APICaller.RESPONSE_STATUS_CODE_200);

        // Print or log the API response content
        System.out.println("API Response Code 2 - PLU Published True : " + closeableHttpResponse2.getStatusLine().getStatusCode());

        List<String> memList2 = null;
        if (!jsonarr2.isNull(0)) {
            //Not Null
            memList2 = new ArrayList<String>();

            int i = 0;
            while (i < 5000) {
                JSONObject element = jsonarr2.getJSONObject(i).getJSONObject("map");
                plu = element.getString("plu");
                memList2.add(plu);
                i++;
            }
        }
        System.out.println("Array API 2 - PLU Published True : " + memList2);

        List<String> memList3 = new RandomHelper().intersection(memList1, memList2);

        List<String> memListFinal = memList3.subList(0, qtyPLU);
        System.out.println("Get Final PLU Available : " + memListFinal);
        return memListFinal.toString();
    }

    public static String hitAPIGetPaymentMinPLU(int priceMin) throws IOException {
        /*
         * API Post : Get Available PLU
         */
        System.out.println("API Post : Get Available PLU");
        String plu = null;
        restClient = new APICaller();

        /*
         * API Post 1
         */
        HashMap<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Content-Type", "application/json");

        String apiURL = "http://103.103.30.83:8866/getresult";

        Map<Object, Object> data = new HashMap<>();
        data.put("jdbc", "jdbc:postgresql://192.168.92.152:5433/klik_stock");
        data.put("username", "qa_team");
        data.put("password", "edts321");
        data.put("classname", "org.postgresql.Driver");
        data.put("query", "select ps.plu from app.product_store ps where ps.store_code = 'TBLJ' and ps.qty_akhir > 0 and ps.stock > 0");

        // Obj to Json in String
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String JsonToString1 = mapper.writeValueAsString(data);
        System.out.println(JsonToString1);

        closeableHttpResponse1 = restClient.post(apiURL, JsonToString1, headerMap);

        //validate response from API:
        String responseBody1 = IOUtils.toString(closeableHttpResponse1.getEntity().getContent(), "UTF-8");

        JSONObject responseJson1 = new JSONObject(responseBody1);
        JSONArray jsonarr1 = responseJson1.getJSONArray("myArrayList");

        //status code:
        int statusCode1 = closeableHttpResponse1.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode1, APICaller.RESPONSE_STATUS_CODE_200);

        // Print or log the API response content
        System.out.println("API Response Code 1 - PLU Stock Ready : " + closeableHttpResponse1.getStatusLine().getStatusCode());

        List<String> memList1 = null;
        if (!jsonarr1.isNull(0)) {
            //Not Null
            memList1 = new ArrayList<String>();

            int i = 0;
            while (i < 1000) {
                JSONObject element = jsonarr1.getJSONObject(i).getJSONObject("map");
                plu = element.getString("plu");
                memList1.add(plu);
                i++;
            }
        }
        System.out.println("Array API 1 - PLU Stock Ready : " + memList1);

        /*
         * API Post 2
         */
        HashMap<String, String> headerMap2 = new HashMap<String, String>();
        headerMap2.put("Content-Type", "application/json");

        Map<Object, Object> data2 = new HashMap<>();
        data2.put("jdbc", "jdbc:postgresql://192.168.92.152:5433/klik_catalog");
        data2.put("username", "qa_team");
        data2.put("password", "edts321");
        data2.put("classname", "org.postgresql.Driver");
        data2.put("query", "select x.plu from app.product x where x.published = true");

        // Obj to Json in String
        ObjectMapper mapper2 = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String JsonToString2 = mapper2.writeValueAsString(data2);
        System.out.println(JsonToString2);

        closeableHttpResponse2 = restClient.post(apiURL, JsonToString2, headerMap2);

        //validate response from API:
        String responseBody2 = IOUtils.toString(closeableHttpResponse2.getEntity().getContent(), "UTF-8");

        JSONObject responseJson2 = new JSONObject(responseBody2);
        JSONArray jsonarr2 = responseJson2.getJSONArray("myArrayList");

        //status code:
        int statusCode2 = closeableHttpResponse2.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode2, APICaller.RESPONSE_STATUS_CODE_200);

        // Print or log the API response content
        System.out.println("API Response Code 2 - PLU Published True : " + closeableHttpResponse2.getStatusLine().getStatusCode());

        List<String> memList2 = null;
        if (!jsonarr2.isNull(0)) {
            //Not Null
            memList2 = new ArrayList<String>();

            int i = 0;
            while (i < 5000) {
                JSONObject element = jsonarr2.getJSONObject(i).getJSONObject("map");
                plu = element.getString("plu");
                memList2.add(plu);
                i++;
            }
        }
        System.out.println("Array API 2 - PLU Published True : " + memList2);

        List<String> memList3 = new RandomHelper().intersection(memList1, memList2);

        List<String> memListFinal = memList3.subList(0, 1);
        System.out.println("Get Final Additional PLU Available : " + memListFinal);
        return memListFinal.toString();
    }

    public static void hitAPIChangeStatus(String transactionCode, String salesOrderNo, String VAAccountNo) throws
            IOException {
        /*
         * API Post : Change Status to PAID
         */
        System.out.println("API Post : Change Status to PAID");

        restClient = new APICaller();

        HashMap<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Content-Type", "application/json");

        String apiURL = "https://api-klik-uat.edts.id/wv/api/open/v1/update-status";

        Map<Object, Object> data = new HashMap<>();
        data.put("URL", "https://api-klik-uat.edts.id/wv/api/open/v1/update-status");
        data.put("SalesOrderNo", salesOrderNo);
        data.put("TransactionCode", transactionCode);
        data.put("PaymentStatus", 2);
        data.put("ResponseMessageMapID", "00000000-0000-0000-0000-000000000000");
        data.put("ResponseErrorCode", null);
        data.put("ResponseMessage", "");
        data.put("ResponseDescription", "");
        data.put("ResponseMapping", "");
        data.put("CC_CARD_NO_PARTIAL", null);
        data.put("CC_AUTH_ID", null);
        data.put("PaymentReff", "TEST005");
        data.put("PaymentAccountID", VAAccountNo);
        data.put("BillingReff", "");

        // Obj to Json in String
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String JsonToString = mapper.writeValueAsString(data);
        System.out.println(JsonToString);

        closeableHttpResponse = restClient.post(apiURL, JsonToString, headerMap);
        //validate response from API:
        String responseBodyCartInfo = IOUtils.toString(closeableHttpResponse.getEntity().getContent(), "UTF-8");

        //status code:
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, APICaller.RESPONSE_STATUS_CODE_200);

        // Print or log the API response content
        System.out.println("API Callback PC Response : " + closeableHttpResponse.getStatusLine().getStatusCode());

        JSONObject responseJsonCartInfo = new JSONObject(responseBodyCartInfo);
        System.out.println("API Response Code Callback PC : " + responseJsonCartInfo);
    }

    public static void hitAPIPaymentToPaid(String phoneNo, String VAAccountNo) throws IOException {
        /*
         * API Post : Post API Payment to PAID
         */
        System.out.println("API Post : Post API Payment to PAID");

        restClient = new APICaller();

        HashMap<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Content-Type", "application/json");

        String apiURL = "http://103.103.30.83:8866/getresult";

        Map<Object, Object> data = new HashMap<>();
        data.put("jdbc", "jdbc:postgresql://192.168.92.152:5433/klik_order");
        data.put("username", "qa_team");
        data.put("password", "edts321");
        data.put("classname", "org.postgresql.Driver");
        data.put("query", "select omh.invoice_no, oph.external_transaction_code, oph.internal_transaction_code, oph.payment_status, oph.total_order_amount, " +
                "oph.customer_admin_fee_amount from app.order_master_header omh, app.order_payment_header oph where omh.customer_mobile_phone = '" + phoneNo + "' " +
                "and oph.payment_status = 'UNPAID' and oph.order_master_header_id = omh.id");

        // Obj to Json in String
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String JsonToString = mapper.writeValueAsString(data);
        System.out.println(JsonToString);

        closeableHttpResponse = restClient.post(apiURL, JsonToString, headerMap);

        //validate response from API:
        String responseBodyPs = IOUtils.toString(closeableHttpResponse.getEntity().getContent(), "UTF-8");

        JSONObject responseJson = new JSONObject(responseBodyPs);
        JSONArray jsonarr = responseJson.getJSONArray("myArrayList");

        if (!jsonarr.isNull(0)) {
            //Not Null
            //with loop
//        for (int i = 0; i < jsonarr.length(); i++) {
//            JSONObject element = jsonarr.getJSONObject(i).getJSONObject("map");
//            System.out.println(element.getString("internal_transaction_code"));
//        }
            //with index
            JSONObject element = jsonarr.getJSONObject(0).getJSONObject("map");
            String invoiceNo = element.getString("invoice_no");
            String shoppingCartId = element.getString("internal_transaction_code");
            String transactionCode = element.getString("external_transaction_code");
            BigDecimal totalAmount = element.getBigDecimal("total_order_amount");
            BigDecimal paymentAdminFee = element.getBigDecimal("customer_admin_fee_amount");

            System.out.println("invoiceNo : " + invoiceNo);
            System.out.println("shoppingCartId : " + shoppingCartId);
            System.out.println("transactionCode : " + transactionCode);
            System.out.println("totalAmount : " + totalAmount);
            System.out.println("paymentAdminFee : " + paymentAdminFee);

            //status code:
            int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
            Assert.assertEquals(statusCode, APICaller.RESPONSE_STATUS_CODE_200);

            // Print or log the API response content
            System.out.println("API Response Code Payment Header: " + closeableHttpResponse.getStatusLine().getStatusCode());

//            BigDecimal totalAmountValue = totalAmount.subtract(paymentAdminFee);
//            String codeToDigest = PRIVATE_KEY + PUBLIC_KEY + shoppingCartId + totalAmountValue.intValue() + paymentAdminFee.intValue();
//            System.out.println("Code to hash : " + StringUtils.upperCase(codeToDigest));
//            String md5Hex = DigestUtils.md5Hex(StringUtils.upperCase(codeToDigest));
//            System.out.println("MD5 : " + StringUtils.upperCase(md5Hex));
//            String sha1Hex = DigestUtils.sha1Hex(StringUtils.upperCase(md5Hex));
//            System.out.println("SHA1 : " + StringUtils.upperCase(sha1Hex));

            //hitCartInfo(StringUtils.upperCase(sha1Hex), transactionCode);

            String[] bits = invoiceNo.split("-");
            String salesOrderNo = bits[bits.length - 1];
            System.out.println("salesOrder : " + salesOrderNo);

            hitAPIChangeStatus(transactionCode, salesOrderNo, VAAccountNo);

        } else {
            //Null
            System.out.println("No Data : " + jsonarr);
        }
    }

    public static String LoginBO() throws
            IOException {

        restClient = new APICaller();

        HashMap<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Content-Type", "application/json");

        String apiURL = "https://api-klik-uat.edts.id/user/api/back-office/auth/login";

        Map<Object, Object> data = new HashMap<>();
        data.put("username", "useruat1@yopmail.com");
        data.put("password", "Klik1234");

        // Obj to Json in String
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String JsonToString = mapper.writeValueAsString(data);

        closeableHttpResponse = restClient.post(apiURL, JsonToString, headerMap);

        //validate response from API:
        String responseLoginBO = IOUtils.toString(closeableHttpResponse.getEntity().getContent(), "UTF-8");

        JSONObject responseJson = new JSONObject(responseLoginBO);

        //status code:
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, APICaller.RESPONSE_STATUS_CODE_200);

        JSONObject element = responseJson.getJSONObject("data");
        String Bearer = element.getString("accessToken");
        System.out.println("Bearer :"+Bearer);
        return Bearer;
    }

    public static void UpdateComplainOnprogress(String Bearer, String ComplainId) throws
            IOException {
        System.out.println("API Post : Update Complain to Onprogress");

        restClient = new APICaller();

        HashMap<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Content-Type", "application/json");
        headerMap.put("Authorization", "Bearer "+Bearer);

        String apiURL = "https://api-klik-uat.edts.id/complain/api/back-office/complain/"+ComplainId+"/onprogress";
        System.out.println("API Update Complain Onprogress URL : " + apiURL);

        closeableHttpResponse = restClient.put(apiURL, headerMap);
        System.out.println("API Update Complain Onprogress Header : " + headerMap);

        // Print or log the API response content
        System.out.println("API Update Complain Onprogress Status Code: " + closeableHttpResponse.getStatusLine().getStatusCode());

        //validate response from API:
        String responseUpdateComplainOnprogress = IOUtils.toString(closeableHttpResponse.getEntity().getContent(), "UTF-8");

        JSONObject responseJson = new JSONObject(responseUpdateComplainOnprogress);
        System.out.println("API Response Body : " + responseJson);

        //status code:
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, APICaller.RESPONSE_STATUS_CODE_200);
    }

    public static void UpdateComplainResolve(String Bearer, String ComplainId) throws
            IOException {
        System.out.println("API Post : Update Complain to Resolve");

        restClient = new APICaller();

        HashMap<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Content-Type", "application/json");
        headerMap.put("Authorization", "Bearer "+Bearer);

        String apiURL = "https://api-klik-uat.edts.id/complain/api/back-office/complain/"+ComplainId+"/resolve";
        System.out.println("API Update Complain Onprogress URL : " + apiURL);

        // Creating the Map
        Map<Object, Object> data = new HashMap<>();

        // Creating resolveCategory map
        Map<Object, Object> resolveCategory = new HashMap<>();
        resolveCategory.put("id", 97);
        resolveCategory.put("name", "Pengecekkan lebih lanjut oleh tim terkait");
        resolveCategory.put("active", true);

        // Creating complainCategory map
        Map<Object, Object> complainCategory = new HashMap<>();
        complainCategory.put("id", 493);
        complainCategory.put("name", "Toko sedang ramai sehingga belum proses pesanan");
        complainCategory.put("subCategory", 0);
        complainCategory.put("subCategories", null);

        // Adding the maps to the main data map
        data.put("resolveCategory", resolveCategory);
        data.put("complainCategory", complainCategory);
        data.put("complainNotes",  "Ini notes kendala dari QA");
        data.put("resolveNotes", "Ini notes solusi dari QA");

        // Obj to Json in String
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String JsonToString = mapper.writeValueAsString(data);
        System.out.println(JsonToString);

        closeableHttpResponse = restClient.put(apiURL, JsonToString, headerMap);
        System.out.println("API Update Complain Onprogress Header : " + headerMap);

        //validate response from API:
        String responseUpdateComplainResolve = IOUtils.toString(closeableHttpResponse.getEntity().getContent(), "UTF-8");

        JSONObject responseJson = new JSONObject(responseUpdateComplainResolve);
        System.out.println(responseJson);

        //status code:
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, APICaller.RESPONSE_STATUS_CODE_200);
    }
    public static void LogoutBO() throws IOException {
        System.out.println("API Post : Remove BO Session");
        restClient = new APICaller();

        HashMap<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Content-Type", "application/json");

        String apiURL = "http://103.103.30.83:8866/getresult";

        Map<Object, Object> data = new HashMap<>();
        data.put("jdbc", "jdbc:postgresql://192.168.92.152:5433/klik_auth");
        data.put("username", "klikapps");
        data.put("password", "Klik4pps4dm4aplk@s!0nlyEdts*321!");
        data.put("classname", "org.postgresql.Driver");
        data.put("query", "delete from app.session where username = 'useruat1@yopmail.com'");

        // Obj to Json in String
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String JsonToString1 = mapper.writeValueAsString(data);
        System.out.println(JsonToString1);

        closeableHttpResponse1 = restClient.post(apiURL, JsonToString1, headerMap);

        //validate response from API:
        String responseBody1 = IOUtils.toString(closeableHttpResponse1.getEntity().getContent(), "UTF-8");
        System.out.println(responseBody1);

        //status code:
        int statusCode1 = closeableHttpResponse1.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode1, APICaller.RESPONSE_STATUS_CODE_200);

        // Print or log the API response content
        System.out.println("API Response Code 1 - PLU Stock Ready : " + closeableHttpResponse1.getStatusLine().getStatusCode());
    }

    public static void main(String[] args) throws IOException {
        //hitAPIPaymentToPaid("0812345432101", "205550812345432101");
        //hitAPIGetAvailablePLU(3);
//        System.out.println(LoginBO());



//        LoginBO();
//        UpdateComplainOnprogress(LoginBO(),gjhg);
    }
}
