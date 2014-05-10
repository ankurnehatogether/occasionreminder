package com.stepupit.reminder.dao.model;


/* To change this template, choose Tools | Templates
 * and open the template in the editor.
 * */


import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ank
 */
@Entity
@Table(name = "usergroups")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Usergroups.findAll", query = "SELECT u FROM Usergroups u"),
	@NamedQuery(name = "Usergroups.findByGrpId", query = "SELECT u FROM Usergroups u WHERE u.grpId = :grpId"),
	@NamedQuery(name = "Usergroups.findByGrpName", query = "SELECT u FROM Usergroups u WHERE u.grpName = :grpName"),
	@NamedQuery(name = "Usergroups.findByUserId", query = "SELECT u FROM Usergroups u WHERE u.userId = :userId") })
public class UserGroups implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "GrpId")
	private Integer grpId;
	@Column(name = "GrpName")
	private String grpName;
	@Column(name = "UserId")
	private Integer userId;

	public UserGroups() {
	}

	public UserGroups(Integer grpId) {
		this.grpId = grpId;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof UserGroups)) {
			return false;
		}
		UserGroups other = (UserGroups) object;
		if ((this.grpId == null && other.grpId != null)
				|| (this.grpId != null && !this.grpId.equals(other.grpId))) {
			return false;
		}
		return true;
	}

	public Integer getGrpId() {
		return this.grpId;
	}

	public String getGrpName() {
		return this.grpName;
	}

	public Integer getUserId() {
		return this.userId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.grpId != null ? this.grpId.hashCode() : 0);
		return hash;
	}

	public void setGrpId(Integer grpId) {
		this.grpId = grpId;
	}

	public void setGrpName(String grpName) {
		this.grpName = grpName;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "javaapplication2.Usergroups[ grpId=" + this.grpId + " ]";
	}

}
