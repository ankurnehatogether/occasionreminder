/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stepupit.reminder.dao.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ank
 */
@Entity
@Table(name = "contactoccasion", catalog = "occasionreminder", schema = "")
@XmlRootElement
public class ContactoccasionRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "contactoccId")
	private Integer contactoccId;
	@JoinColumn(name = "occasionId", referencedColumnName = "occasionid")
	@ManyToOne
	private OccasionsRecord occasionId;
	@JoinColumn(name = "contactid", referencedColumnName = "contactid")
	@ManyToOne
	private ContactsRecord contactid;

	public ContactoccasionRecord() {
	}

	public ContactoccasionRecord(Integer contactoccId) {
		this.contactoccId = contactoccId;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof ContactoccasionRecord)) {
			return false;
		}
		ContactoccasionRecord other = (ContactoccasionRecord) object;
		if ((this.contactoccId == null && other.contactoccId != null) || (this.contactoccId != null && !this.contactoccId.equals(other.contactoccId))) {
			return false;
		}
		return true;
	}

	public ContactsRecord getContactid() {
		return this.contactid;
	}

	public Integer getContactoccId() {
		return this.contactoccId;
	}

	public OccasionsRecord getOccasionId() {
		return this.occasionId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.contactoccId != null ? this.contactoccId.hashCode() : 0);
		return hash;
	}

	public void setContactid(ContactsRecord contactid) {
		this.contactid = contactid;
	}

	public void setContactoccId(Integer contactoccId) {
		this.contactoccId = contactoccId;
	}

	public void setOccasionId(OccasionsRecord occasionId) {
		this.occasionId = occasionId;
	}

	@Override
	public String toString() {
		return "Contactoccasion[ contactoccId=" + this.contactoccId + " ]";
	}

}
