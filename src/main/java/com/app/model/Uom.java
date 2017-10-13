package com.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="uom_tab")
public class Uom implements Comparable<Uom>{
	
	@Id
	@Column(name="u_id")
	@GeneratedValue(generator="uomgen")
	@GenericGenerator(name="uomgen",strategy="increment")
	private long uomId;
	
	@Column(name="u_type")
	private String uomType;
	
	@Column(name="u_model")
	private String uomModel;
	
	@Column(name="u_cdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="u_lmdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModified;
	
	@Column(name="u_desc")
	private String description;
	

	public Uom() {
		super();
	}


	public Uom(long uomId) {
		super();
		this.uomId = uomId;
	}

	public Uom(String uomType, String uomModel, 
			String description,Date createDate) {
		super();
		this.uomType = uomType;
		this.uomModel = uomModel;
		this.description = description;
		this.createDate = createDate;
	}


	public long getUomId() {
		return uomId;
	}


	public void setUomId(long uomId) {
		this.uomId = uomId;
	}


	public String getUomType() {
		return uomType;
	}


	public void setUomType(String uomType) {
		this.uomType = uomType;
	}


	public String getUomModel() {
		return uomModel;
	}


	public void setUomModel(String uomModel) {
		this.uomModel = uomModel;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Date getLastModified() {
		return lastModified;
	}


	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Uom [uomId=" + uomId + ", uomType=" + uomType + ", uomModel="
				+ uomModel + ", createDate=" + createDate + ", lastModified="
				+ lastModified + ", description=" + description + "]";
	}


	@Override
	public int compareTo(Uom o) {
		return (int)(this.getUomId()-o.getUomId());
	}
	

}
