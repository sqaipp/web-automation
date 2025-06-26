package com.automation.helper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class DataGetter {
	private String name;
	private String phoneNumber;
	private String emailAddress;
	private String pluProduct;
	private String pluProductXpress;
	private int subTotal;
	private int totalPrice;
	private int shippingFee;
	private int totalDiscount;
	private String salesOrderNo;
	private String vaNumber;
	private String orderId;
	private int pointLoyalty;
	private int pointCash;
	private String totalPointLoyalty;
	private String totalPointCash;
	private String passForgot;
	private String otp;


	public DataGetter() {
		// Add your initialization code here if needed.
	}
}
