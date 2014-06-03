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
@Table(name = "contacts", catalog = "occasionreminder", schema = "")
@XmlRootElement
public class ContactsRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "contactid")
	private Integer contactid;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "phoneno")
	private String phoneno;
	@OneToMany(mappedBy = "contactid")
	private Collection<GrpContactsRecord> grpcontactsCollection;
	@OneToMany(mappedBy = "contactid")
	private Collection<ContactoccasionRecord> contactoccasionCollection;
	@JoinColumn(name = "userid", referencedColumnName = "userId")
	@ManyToOne(optional = false)
	private UserRecord userid;

	public ContactsRecord() {
	}

	public ContactsRecord(Integer contactid) {
		this.contactid = contactid;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof ContactsRecord)) {
			return false;
		}
		ContactsRecord other = (ContactsRecord) object;
		if ((this.contactid == null && other.contactid != null) || (this.contactid != null && !this.contactid.equals(other.contactid))) {
			return false;
		}
		return true;
	}

	public Integer getContactid() {
		return this.contactid;
	}

	@XmlTransient
	public Collection<ContactoccasionRecord> getContactoccasionCollection() {
		return this.contactoccasionCollection;
	}

	public String getEmail() {
		return this.email;
	}

	@XmlTransient
	public Collection<GrpContactsRecord> getGrpcontactsCollection() {
		return this.grpcontactsCollection;
	}

	public String getName() {
		return this.name;
	}

	public String getPhoneno() {
		return this.phoneno;
	}

	public UserRecord getUserid() {
		return this.userid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.contactid != null ? this.contactid.hashCode() : 0);
		return hash;
	}

	public void setContactid(Integer contactid) {
		this.contactid = contactid;
	}

	public void setContactoccasionCollection(Collection<ContactoccasionRecord> contactoccasionCollection) {
		this.contactoccasionCollection = contactoccasionCollection;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setGrpcontactsCollection(Collection<GrpContactsRecord> grpcontactsCollection) {
		this.grpcontactsCollection = grpcontactsCollection;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public void setUserid(UserRecord userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Contacts[ contactid=" + this.contactid + " ]";
	}

}
