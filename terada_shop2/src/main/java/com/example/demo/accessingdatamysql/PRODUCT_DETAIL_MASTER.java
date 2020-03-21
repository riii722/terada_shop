package com.example.demo.accessingdatamysql;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_detail_master")
public class PRODUCT_DETAIL_MASTER {
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "productCd")
//	private List<PRODUCT_MASTER> productlMaster = new ArrayList<>();

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "makerCd")
//	private MAKER_MASTER makerMaster;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="productcd")
	private String PRODUCTCD;

	@Column(name="unitprice")
	private Integer UNITPRICE;

	@Column(name="makercd")
	private String MAKERCD;

	@Column(name="torokusya")
	private String TOROKUSYA;

	@Column(name="torokupg")
	private String TOROKUPG;

	@Column(name="torokudate")
	private Date TOROKUDATE;

	@Column(name="kosinsya")
	private String KOSINSYA;

	@Column(name="kosinpg")
	private String KOSINPG;

	@Column(name="kosindate")
	private Date KOSINDATE;

	@Column(name="version")
	private Integer VERSION;

    public String getProductCd() {
        return PRODUCTCD;
    }
    public void setProductCd(String productCd) {
        this.PRODUCTCD = productCd;
    }

    public Integer getUnitPrice() {
    	return UNITPRICE;
    }
    public void setUnitPrice(Integer unitPrice) {
    	this.UNITPRICE = unitPrice;
    }

    public String getMakerCd() {
        return MAKERCD;
    }
    public void setMakerCd(String makerCd) {
        this.MAKERCD = makerCd;
    }

    public String getTorokusya() {
    	return TOROKUSYA;
    }
    public void setTorokusya(String torokusya) {
    	this.TOROKUSYA = torokusya;
    }

    public String getTorokuPg() {
    	return TOROKUPG;
    }
    public void setTorokuPg(String torokuPg) {
    	this.TOROKUPG = torokuPg;
    }

    public Date getTorokuDate() {
    	return TOROKUDATE;
    }
    public void setTorokuDate(Date torokuDate) {
    	this.TOROKUDATE = torokuDate;
    }

    public String getKosinsya() {
    	return KOSINSYA;
    }
    public void setKosinsya(String kosinsya) {
    	this.KOSINSYA = kosinsya;
    }

    public String getKosinPg() {
    	return KOSINPG;
    }
    public void setKosinPg(String kosinPg) {
    	this.KOSINPG = kosinPg;
    }

    public Date getKosinDate() {
    	return KOSINDATE;
    }
    public void setKosinDate(Date kosinDate) {
    	this.KOSINDATE = kosinDate;
    }

    public Integer getVersion() {
    	return VERSION;
    }
    public void setVersion(Integer version) {
    	this.VERSION = version;
    }
}
