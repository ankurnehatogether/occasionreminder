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
@Table(name = "grpcontacts", catalog = "occasionreminder", schema = "")
@XmlRootElement
public class Grpcontacts implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "grpContactid")
	private Integer grpContactid;
	@JoinColumn(name = "contactid", referencedColumnName = "contactid")
	@ManyToOne
	private Contacts contactid;
	@JoinColumn(name = "grpid", referencedColumnName = "groupid")
	@ManyToOne
	private Groups grpid;

	public Grpcontacts() {
	}

	public Grpcontacts(Integer grpContactid) {
		this.grpContactid = grpContactid;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Grpcontacts)) {
			return false;
		}
		Grpcontacts other = (Grpcontacts) object;
		if ((this.grpContactid == null && other.grpContactid != null) || (this.grpContactid != null && !this.grpContactid.equals(other.grpContactid))) {
			return false;
		}
		return true;
	}

	public Contacts getContactid() {
		return this.contactid;
	}

	public Integer getGrpContactid() {
		return this.grpContactid;
	}

	public Groups getGrpid() {
		return this.grpid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.grpContactid != null ? this.grpContactid.hashCode() : 0);
		return hash;
	}

	public void setContactid(Contacts contactid) {
		this.contactid = contactid;
	}

	public void setGrpContactid(Integer grpContactid) {
		this.grpContactid = grpContactid;
	}

	public void setGrpid(Groups grpid) {
		this.grpid = grpid;
	}

	@Override
	public String toString() {
		return "Grpcontacts[ grpContactid=" + this.grpContactid + " ]";
	}

}
