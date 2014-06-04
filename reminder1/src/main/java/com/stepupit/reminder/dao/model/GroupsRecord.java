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
@Table(name = "groups", catalog = "occasionreminder", schema = "")
@XmlRootElement
public class GroupsRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "groupid")
	private Integer groupid;
	@Basic(optional = false)
	@Column(name = "name")
	private String grpName;
	@Column(name = "advanceday")
	private Integer advanceday;
	@Column(name = "time")
	private Integer time;
	@OneToMany(mappedBy = "grpid")
	private Collection<GrpContactsRecord> grpcontactsCollection;
	@JoinColumn(name = "userid", referencedColumnName = "userId")
	@ManyToOne
	private UserRecord userid;

	public GroupsRecord() {
	}

	public GroupsRecord(Integer groupid) {
		this.groupid = groupid;
	}

	public GroupsRecord(String grpName) {
		this.grpName = grpName;
	}

	public GroupsRecord(String groupName, UserRecord user) {
		this.grpName = groupName;
		this.userid = user;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof GroupsRecord)) {
			return false;
		}
		GroupsRecord other = (GroupsRecord) object;
		if ((this.groupid == null && other.groupid != null)
				|| (this.groupid != null && !this.groupid.equals(other.groupid))) {
			return false;
		}
		return true;
	}

	public Integer getAdvanceday() {
		return this.advanceday;
	}

	public Integer getGroupid() {
		return this.groupid;
	}

	@XmlTransient
	public Collection<GrpContactsRecord> getGrpcontactsCollection() {
		return this.grpcontactsCollection;
	}

	public String getName() {
		return this.grpName;
	}

	public Integer getTime() {
		return this.time;
	}

	public UserRecord getUserid() {
		return this.userid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.groupid != null ? this.groupid.hashCode() : 0);
		return hash;
	}

	public void setAdvanceday(Integer advanceday) {
		this.advanceday = advanceday;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public void setGrpcontactsCollection(
			Collection<GrpContactsRecord> grpcontactsCollection) {
		this.grpcontactsCollection = grpcontactsCollection;
	}

	public void setName(String name) {
		this.grpName = name;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public void setUserid(UserRecord userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Groups[ groupid=" + this.groupid + " ]";
	}

}
