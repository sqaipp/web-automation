package com.automation.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GenerateSignature {

    private static String PRIVATE_KEY = "K3rEt@96";
    private static String PUBLIC_KEY = "klikidm";

    public static void main(String[] args) {
        String shoppingCartId = "feacb32d-f04e-49f7-b345-2e1a319e1686";
        BigDecimal totalAmount = BigDecimal.valueOf(182300.0);
        BigDecimal paymentAdminFee = BigDecimal.valueOf(5469.0);
        String transactionCode = "KI230106081453427715";
        String customerId = "fc45f59b-34a6-4a2b-bced-f45653a1c4b2";
        BigDecimal totalRefundAmount = BigDecimal.valueOf(197500);
        String timestamp = "2022-12-26T09:38:00";
//        https://payment-beta-uat.klikindomaret.net/paymentcenterbeta/api/Saldo/GenerateToken?customerid=3c8c006f-de07-4932-b3cd-e0a320a86c33&timestamp=2022-12-15T09:30:43&clientid=klikEDTS

//        https://payment-beta-uat.klikindomaret.net/paymentcenterbeta/api/Saldo/GenerateToken?customerid=3c8c006f-de07-4932-b3cd-e0a320a86c33&timestamp=2022-12-15T09:30:43&clientid=klikEDTS

//        CartInfo_Request(PRIVATE_KEY, PUBLIC_KEY, shoppingCartId);
//        CartInfo_Response(PRIVATE_KEY, PUBLIC_KEY, shoppingCartId, totalAmount);
        Validate_Request(PRIVATE_KEY, PUBLIC_KEY, shoppingCartId, totalAmount, paymentAdminFee);
//        Reversal_Request(PRIVATE_KEY, PUBLIC_KEY, shoppingCartId);
//        Cancel_Payment(PRIVATE_KEY, PUBLIC_KEY, transactionCode);
//        RequestRefund_Request(PRIVATE_KEY, PUBLIC_KEY, customerId, transactionCode, shoppingCartId, totalRefundAmount);
//        RequestSaldo_Request(PRIVATE_KEY, "klikidm", customerId, timestamp);

//        createSignature("K3RET@96KLIKIDMC4F87739-E7D9-4659-995D-90FDE734A068850005000");
    }

    private static String RequestSaldo_Request(String privateKey, String clientId, String customerId, String timestamp) {
        String codeToDigest = customerId + timestamp + privateKey + clientId;
        return createSignature(codeToDigest);
    }

    private static String CartInfo_Request(String privateKey, String publicKey, String shoppingCartId) {
        String codeToDigest = privateKey + publicKey + shoppingCartId;
        return createSignature(codeToDigest);
    }

    private static String CartInfo_Response(String privateKey, String publicKey, String shoppingCartId, BigDecimal totalAmount) {
        String codeToDigest = privateKey + publicKey + shoppingCartId + totalAmount;
        return createSignature(codeToDigest);
    }

    public static String Validate_Request(String privateKey, String publicKey, String shoppingCartId, BigDecimal totalAmount, BigDecimal paymentAdminFee) {
        BigDecimal totalAmountValue = totalAmount.subtract(paymentAdminFee);
        String codeToDigest = privateKey + publicKey + shoppingCartId + totalAmountValue.intValue() + paymentAdminFee.intValue();
        return createSignature(codeToDigest);
    }

    private static String Reversal_Request(String privateKey, String publicKey, String shoppingCartId) {
        String codeToDigest = privateKey + publicKey + shoppingCartId;
        return createSignature(codeToDigest);
    }

    private static String RequestRefund_Request(String privateKey, String publicKey, String customerId, String transactionCode, String shoppingCartId, BigDecimal totalRefundAmount) {
        String codeToDigest = privateKey + customerId + transactionCode + totalRefundAmount.setScale(0, RoundingMode.HALF_UP);
        return createSignatureLower(codeToDigest);
    }

    private static String Cancel_Payment(String privateKey, String publicKey, String transactionCode) {
        String codeToDigest = publicKey + privateKey + transactionCode;
        return createSignature(codeToDigest);
    }

    private static String createSignature(String codeToDigest) {
        System.out.println("Code to hash : " + StringUtils.upperCase(codeToDigest));
        String md5Hex = DigestUtils.md5Hex(StringUtils.upperCase(codeToDigest));
        System.out.println("MD5 : " + StringUtils.upperCase(md5Hex));
        String sha1Hex = DigestUtils.sha1Hex(StringUtils.upperCase(md5Hex));
        System.out.println("SHA1 : " + StringUtils.upperCase(sha1Hex));
        return StringUtils.upperCase(sha1Hex);
    }

//    Code To Hash = K3rEt@96d3b458e0-eb68-45c9-8de9-729cc83299aaKI22121308330142705085000
//    MD5 = 6752c1941ec5642ddcf4660d420f6800
//    SHA1 = 04c63a08c034fcff3ff9aec395771cc8530bf0d3

    private static String createSignatureLower(String codeToDigest) {
        System.out.println("Code to hash : " + codeToDigest);
        String md5Hex = DigestUtils.md5Hex(codeToDigest);
        System.out.println("MD5 : " + md5Hex);
        String sha1Hex = DigestUtils.sha1Hex(md5Hex);
        System.out.println("SHA1 : " + sha1Hex);


//        System.out.println("Code to hash : " + StringUtils.lowerCase(codeToDigest));
//        String md5Hex = DigestUtils.md5Hex(StringUtils.lowerCase(codeToDigest));
//        System.out.println("MD5 : " + StringUtils.lowerCase(md5Hex));
//        String sha1Hex = DigestUtils.sha1Hex(StringUtils.lowerCase(md5Hex));
//        System.out.println("SHA1 : " + StringUtils.lowerCase(sha1Hex));
        return sha1Hex;
    }

}
