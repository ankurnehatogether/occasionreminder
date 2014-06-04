/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stepupit.reminder.dao.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ank
 */
@Entity
@Table(name = "occasions", catalog = "occasionreminder", schema = "")
@XmlRootElement
public class OccasionsRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "occasionid")
	private Integer occasionid;
	@Basic(optional = false)
	@Column(name = "name")
	private String name;
	@OneToMany(mappedBy = "occasionId")
	private Collection<ContactoccasionRecord> contactoccasionCollection;
	@JoinColumn(name = "userid", referencedColumnName = "userId")
	@ManyToOne
	private UserRecord userid;

	public OccasionsRecord() {
	}

	public OccasionsRecord(Integer occasionid) {
		this.occasionid = occasionid;
	}

	public OccasionsRecord(String name) {
		this.name = name;
	}

	public OccasionsRecord(String occasionName, UserRecord user) {
		this.name = occasionName;
		this.userid = user;
	}



	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof OccasionsRecord)) {
			return false;
		}
		OccasionsRecord other = (OccasionsRecord) object;
		if ((this.occasionid == null && other.occasionid != null)
				|| (this.occasionid != null && !this.occasionid
				.equals(other.occasionid))) {
			return false;
		}
		return true;
	}

	@XmlTransient
	public Collection<ContactoccasionRecord> getContactoccasionCollection() {
		return this.contactoccasionCollection;
	}

	public String getName() {
		return this.name;
	}

	public Integer getOccasionid() {
		return this.occasionid;
	}

	/**
	 * @return the userid
	 */
	public UserRecord getUserid() {
		return this.userid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.occasionid != null ? this.occasionid.hashCode() : 0);
		return hash;
	}

	public void setContactoccasionCollection(
			Collection<ContactoccasionRecord> contactoccasionCollection) {
		this.contactoccasionCollection = contactoccasionCollection;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOccasionid(Integer occasionid) {
		this.occasionid = occasionid;
	}

	/**
	 * @param userid
	 *            the userid to set
	 */
	public void setUserid(UserRecord userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Occasions[ occasionid=" + this.occasionid + " ]";
	}

}
