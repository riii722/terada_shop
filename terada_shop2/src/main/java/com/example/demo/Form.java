package com.example.demo;

import java.io.Serializable;

public class Form implements Serializable {
	public String productcd;
	public String syohinname;
	public String makercd;
	private Integer unitprice;


	public String getProductCd() {
		return productcd;
	}
	public void setProductCd(String productCd) {
		this.productcd = productCd;
	}

    public String getSyohinName() {
    	return syohinname;
    }
    public void setSyohinName(String syohinName) {
    	this.syohinname = syohinName;
    }

    public String getMakCd() {
		return makercd;
	}
	public void setMakerCd(String makerCd) {
		this.makercd = makerCd;
	}

	public Integer getUnitPrice() {
    	return unitprice;
    }
    public void setUnitPrice(Integer unitPrice) {
    	this.unitprice = unitPrice;
    }



}
