package com.byzCorp.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LOOKUP", schema = "BYZ", uniqueConstraints = @UniqueConstraint(columnNames = { "NAME","STATUS" }))
@DynamicInsert
@DynamicUpdate
@SequenceGenerator(name = "LOOKUP_SEQ", sequenceName = "BYZ.LOOKUP_SEQ", allocationSize = 1)
public class LookUp implements Serializable {

	@Id
	@Column(name = "LOOKUP_ID", unique = true, nullable = false, precision = 12, scale = 0)
	//@GeneratedValue(strategy = GenerationType.IDENTITY) for mysql
	@GeneratedValue(generator = "LOOKUP_SEQ", strategy = GenerationType.SEQUENCE)
	private long lookUpId;
	@Column(name = "NAME", length = 255, nullable = false)
	private String name;
	@Column(name = "PARENT_ID", length = 12, nullable = true)
	private Long parentId = 0L;
	@Column(name = "DESCRIPTION", length = 255, nullable = true)
	private String description;
	@Column(name = "STATUS", length = 1, nullable = false)
	private Integer status = 1;

	public LookUp(){

	}

	public long getLookUpId() {
		return lookUpId;
	}

	public void setLookUpId(long lookUpId) {
		this.lookUpId = lookUpId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
