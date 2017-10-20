package com.sdczzm.wcmDemo;

import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.internal.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


/**
 * 为什么同时加了注解和构造方法没有报错？
 * application.properties 代码提示功能需要安装插件还是是IntellJ编辑器自带？
 * @author QiHuifang
 *
 */
@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	@NonNull
	@Column(unique=true)
	private String username;
	@NotNull
	@JsonIgnore
	private String password;
	@NotNull
	private String fullName;
	@CreatedDate
	@Column(updatable=false)
	@JsonIgnore
	private LocalDateTime createdDate;
	@LastModifiedDate
	@JsonIgnore
	private LocalDateTime lastModifiedDate;
	
	
	public boolean isNew() {
	    return id == null;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public LocalDateTime getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}


	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}


	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	
		
	
}
