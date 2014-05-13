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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ank
 */
@Entity
@Table(name = "user")
@XmlRootElement
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "userId")
	private Integer userId;
	@Column(name = "name")
	private String name;
	@Column(name = "phoneNo")
	private String phoneNo;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "activeuser")
	private Integer activeuser;




	public User() {
	}

	public User(Integer userId) {
		this.userId = userId;
	}

	public User(String name, String phoneNo, String email,
			String password) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
		this.password = password;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof User)) {
			return false;
		}
		User other = (User) object;
		if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
			return false;
		}
		return true;
	}

	public Integer getActiveuser() {
		return this.activeuser;
	}

	public String getEmail() {
		return this.email;
	}

	public String getName() {
		return this.name;
	}

	public String getPassword() {
		return this.password;
	}

	public String getPhoneNo() {
		return this.phoneNo;
	}

	public Integer getUserId() {
		return this.userId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.userId != null ? this.userId.hashCode() : 0);
		return hash;
	}

	public void setActiveuser(Integer activeuser) {
		this.activeuser = activeuser;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "User[ userId=" + this.userId + " ]";
	}

}
