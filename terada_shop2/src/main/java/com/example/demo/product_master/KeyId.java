package com.example.demo.product_master;

import java.io.Serializable;

public class KeyId implements Serializable {
	private String PRODUCTCD;

	public String getProductCd() {
        return PRODUCTCD;
    }
    public void setProductCd(String productCd) {
        this.PRODUCTCD = productCd;
    }

//	private String makercd;
//
//	public String getMakerCd() {
//        return makercd;
//    }
//    public void setMakerCd(String makerCd) {
//        this.productcd = makerCd;
//    }
}
