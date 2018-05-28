package com.byzCorp.model;

import com.byzCorp.login.model.Users;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "HRLEAVE_DETAIL", schema = "BYZ", uniqueConstraints = @UniqueConstraint(columnNames = { "HRLEAVE_DETAIL_ID" }))
@DynamicInsert
@DynamicUpdate
@SequenceGenerator(name = "HRLEAVE_DETAIL_SEQ", sequenceName = "BYZ.HRLEAVE_DETAIL_SEQ", allocationSize = 1)
public class HrLeaveDetail implements Serializable {

	@Id
	@Column(name = "HRLEAVE_DETAIL_ID", unique = true, nullable = false, precision = 12, scale = 0)
	@GeneratedValue(generator = "HRLEAVE_DETAIL_SEQ", strategy = GenerationType.SEQUENCE)
	private long hrLeaveDetailId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID", nullable = false)
	public Users users;
	@Column(name = "YEAR", length = 12, nullable = false)
	private Integer year;
	@Column(name = "DAY", length = 12, nullable = false)
	private Integer day;

	public HrLeaveDetail(){

	}
	public HrLeaveDetail(long hrLeaveDetailId) {
		this.hrLeaveDetailId = hrLeaveDetailId;
	}

	public long getHrLeaveDetailId() {
		return hrLeaveDetailId;
	}

	public void setHrLeaveDetailId(long hrLeaveDetailId) {
		this.hrLeaveDetailId = hrLeaveDetailId;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}
}
