package com.byzCorp.model;

import com.byzCorp.login.model.Users;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "HRLEAVE", schema = "BYZ", uniqueConstraints = @UniqueConstraint(columnNames = { "HRLEAVE_ID" }))
@DynamicInsert
@DynamicUpdate
@SequenceGenerator(name = "HRLEAVE_SEQ", sequenceName = "BYZ.HRLEAVE_SEQ", allocationSize = 1)
public class HrLeave implements Serializable {

	@Id
	@Column(name = "HRLEAVE_ID", unique = true, nullable = false, precision = 12, scale = 0)
	@GeneratedValue(generator = "HRLEAVE_SEQ", strategy = GenerationType.SEQUENCE)
	private long hrLeaveId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID", nullable = false)
	public Users users;
	@Column(name = "RECORD_TYPE_ID", length = 12, nullable = false)
	private Long recordTypeId;
	@Column(name = "TYPE_ID", length = 12, nullable = false)
	private Long typeId;
	@Column(name = "START_DATE", nullable = true)
	private Date startDate;
	@Column(name = "END_DATE", nullable = true)
	private Date endDate;
	@Column(name = "START_WORK_DATE", nullable = true)
	private Date startWorkDate;
	@Column(name = "TIME", length = 6, nullable = true)
	private Integer time;
	@Column(name = "LEAVE_YEAR", length = 6, nullable = true)
	private Integer leaveYear;
	@Column(name = "STATUS", length = 1, nullable = false)
	private Integer status = 1;

	public HrLeave(){

	}
	public HrLeave(long hrLeaveId) {
		this.hrLeaveId = hrLeaveId;
	}

	public long getHrLeaveId() {
		return hrLeaveId;
	}

	public void setHrLeaveId(long hrLeaveId) {
		this.hrLeaveId = hrLeaveId;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Long getRecordTypeId() {
		return recordTypeId;
	}

	public void setRecordTypeId(Long recordTypeId) {
		this.recordTypeId = recordTypeId;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartWorkDate() {
		return startWorkDate;
	}

	public void setStartWorkDate(Date startWorkDate) {
		this.startWorkDate = startWorkDate;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Integer getLeaveYear() {
		return leaveYear;
	}

	public void setLeaveYear(Integer leaveYear) {
		this.leaveYear = leaveYear;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
