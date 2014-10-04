package com.fhrweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * TennisMatchLevel entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TENNIS_MATCH_LEVEL")
public class User implements java.io.Serializable {

	// Fields

	private Long id;
	private String cnName;
	private String enName;
	private String trName;
	private Long sort;
	@Transient
	private String lang;
	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Long id) {
		this.id = id;
	}

	/** full constructor */
	public User(Long id, String cnName, String enName,
			String trName, Long sort) {
		this.id = id;
		this.cnName = cnName;
		this.enName = enName;
		this.trName = trName;
		this.sort = sort;
	}

	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "CN_NAME", length = 200)
	public String getCnName() {
		return this.cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	@Column(name = "EN_NAME", length = 200)
	public String getEnName() {
		return this.enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	@Column(name = "TR_NAME", length = 200)
	public String getTrName() {
		return this.trName;
	}

	public void setTrName(String trName) {
		this.trName = trName;
	}

	@Column(name = "SORT", precision = 22, scale = 0)
	public Long getSort() {
		return this.sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}
	
	@Transient
	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	@Transient
	public String getName() {
		if("tr".equals(this.lang)){
			return this.trName;
		}else{
			return this.cnName;
		}
	}
}