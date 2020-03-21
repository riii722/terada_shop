package com.example.demo.accessingdatamysql;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity		//This tells Hibernate to make a table out of this class
@Table(name="maker_master")		//テーブルの名前を決められるからクラス名は自由にかける
public class MAKER_MASTER {
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "makercd")
//	private PRODUCT_DETAIL_MASTER productDetailMaster;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)		//IDに対して一位となるものを付与していく
	@Column(name="makercd")
	private String MAKERCD;

	@Column(name="makername")
	private String MAKERNAME;

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


	public String getMakerCd() {
	    return MAKERCD;
	}
	public void setMakerCd(String makerCd) {
		this.MAKERCD = makerCd;
	}

	public String getMakerName() {
		return MAKERNAME;
	}
	public void setMakerName(String makerName) {
		this.MAKERNAME = makerName;
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
	public void set(String kosinsya) {
		this.KOSINSYA = kosinsya;
	}

	public String getkosinPg() {
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
	public void set(Integer version ) {
		this.VERSION = version;
	}
}
