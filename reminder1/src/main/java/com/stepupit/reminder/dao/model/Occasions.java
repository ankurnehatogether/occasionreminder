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
public class Occasions implements Serializable {
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
	private Collection<Contactoccasion> contactoccasionCollection;

	public Occasions() {
	}

	public Occasions(Integer occasionid) {
		this.occasionid = occasionid;
	}

	public Occasions(Integer occasionid, String name) {
		this.occasionid = occasionid;
		this.name = name;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Occasions)) {
			return false;
		}
		Occasions other = (Occasions) object;
		if ((this.occasionid == null && other.occasionid != null) || (this.occasionid != null && !this.occasionid.equals(other.occasionid))) {
			return false;
		}
		return true;
	}

	@XmlTransient
	public Collection<Contactoccasion> getContactoccasionCollection() {
		return this.contactoccasionCollection;
	}

	public String getName() {
		return this.name;
	}

	public Integer getOccasionid() {
		return this.occasionid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.occasionid != null ? this.occasionid.hashCode() : 0);
		return hash;
	}

	public void setContactoccasionCollection(Collection<Contactoccasion> contactoccasionCollection) {
		this.contactoccasionCollection = contactoccasionCollection;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOccasionid(Integer occasionid) {
		this.occasionid = occasionid;
	}

	@Override
	public String toString() {
		return "Occasions[ occasionid=" + this.occasionid + " ]";
	}

}
