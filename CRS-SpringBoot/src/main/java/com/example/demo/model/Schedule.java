package com.example.demo.model;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "schedule")
public class Schedule {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name = "schedule_Id")
	private BigInteger scheduleId;

	@OneToOne(fetch = FetchType.EAGER)
	private Place srcPlace;

	@OneToOne(fetch = FetchType.EAGER)
	private Place dstnPlace;

	@Column(name = "departure_date")
	private String deptDateTime;

	@Column(name = "arrival_date")
	private String arrDateTime;
	
	public Schedule()
	{
		
	}

	public Schedule(Long id, BigInteger scheduleId, Place srcPlace, Place dstnPlace, String deptDateTime, String arrDateTime) {
		this.id = id;
		this.scheduleId = scheduleId;
		this.srcPlace = srcPlace;
		this.dstnPlace = dstnPlace;
		this.deptDateTime = deptDateTime;
		this.arrDateTime = arrDateTime;
	}

	public BigInteger getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(BigInteger scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Place getSrcPlace() {
		return srcPlace;
	}

	public void setSrcPlace(Place srcPlace) {
		this.srcPlace = srcPlace;
	}

	public Place getDstnPlace() {
		return dstnPlace;
	}

	public void setDstnPlace(Place dstnPlace) {
		this.dstnPlace = dstnPlace;
	}

	public String getDeptDateTime() {
		return deptDateTime;
	}

	public void setDeptDateTime(String deptDateTime) {
		this.deptDateTime = deptDateTime;
	}

	public String getArrDateTime() {
		return arrDateTime;
	}

	public void setArrDateTime(String arrDateTime) {
		this.arrDateTime = arrDateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", srcPlace=" + srcPlace + ", dstnPlace=" + dstnPlace
				+ ", deptDateTime=" + deptDateTime + ", arrDateTime=" + arrDateTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrDateTime == null) ? 0 : arrDateTime.hashCode());
		result = prime * result + ((deptDateTime == null) ? 0 : deptDateTime.hashCode());
		result = prime * result + ((dstnPlace == null) ? 0 : dstnPlace.hashCode());
		result = prime * result + ((scheduleId == null) ? 0 : scheduleId.hashCode());
		result = prime * result + ((srcPlace == null) ? 0 : srcPlace.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		if (arrDateTime == null) {
			if (other.arrDateTime != null)
				return false;
		} else if (!arrDateTime.equals(other.arrDateTime))
			return false;
		if (deptDateTime == null) {
			if (other.deptDateTime != null)
				return false;
		} else if (!deptDateTime.equals(other.deptDateTime))
			return false;
		if (dstnPlace == null) {
			if (other.dstnPlace != null)
				return false;
		} else if (!dstnPlace.equals(other.dstnPlace))
			return false;
		if (scheduleId == null) {
			if (other.scheduleId != null)
				return false;
		} else if (!scheduleId.equals(other.scheduleId))
			return false;
		if (srcPlace == null) {
			if (other.srcPlace != null)
				return false;
		} else if (!srcPlace.equals(other.srcPlace))
			return false;
		return true;
	}
	
}
