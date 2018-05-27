package com.byzCorp.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LOOKUP_DETAIL", schema = "BYZ", uniqueConstraints = @UniqueConstraint(columnNames = { "LOOKUP_ID", "NAME" }))
@DynamicInsert
@DynamicUpdate
@SequenceGenerator(name = "LOOKUP_DETAIL_SEQ", sequenceName = "BYZ.LOOKUP_DETAIL_SEQ", allocationSize = 1)
public class LookUpDetail implements Serializable {

	@Id
	@Column(name = "LOOKUP_DETAIL_ID", unique = true, nullable = false, precision = 12, scale = 0)
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(generator = "LOOKUP_DETAIL_SEQ", strategy = GenerationType.SEQUENCE)
	private long lookUpDetailId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LOOKUP_ID", nullable = false)
	private LookUp lookUp;
	@Column(name = "NAME", length = 255, nullable = false)
	private String name;
	@Column(name = "VALUE", length = 12, nullable = false)
	private Integer value;
	@Column(name = "ORDER_NO", length = 12, nullable = true)
	private Integer orderNo;
	@Column(name = "PARENT_ID", length = 12, nullable = true)
	private Long parentId = 0L;
	@Column(name = "DESCRIPTION", length = 255, nullable = true)
	private String description;
	@Column(name = "STATUS", length = 1, nullable = false)
	private Integer status = 1;

	public LookUpDetail(){

	}

	public long getLookUpDetailId() {
		return lookUpDetailId;
	}

	public void setLookUpDetailId(long lookUpDetailId) {
		this.lookUpDetailId = lookUpDetailId;
	}

	public LookUp getLookUp() {
		return lookUp;
	}

	public void setLookUp(LookUp lookUp) {
		this.lookUp = lookUp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
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
