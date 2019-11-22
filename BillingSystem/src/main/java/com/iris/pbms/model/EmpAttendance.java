
package com.iris.pbms.model;



import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;



import javax.persistence.Table;



@Entity
@Table(name="EmpAttendance")

public class EmpAttendance {

	

	@Id
    @GeneratedValue
   @Column(name="attendanceid")

	private Integer attendanceId;



	@Column(name="mnth")

	private String mnth;



	@Column(name="yrs")

	private Integer yrs;



	@Column(name="fullday")

	private Integer fullDay;



	@Column(name="halfday")

	private Integer halfDay;



	@OneToOne

	@JoinColumn(name="employeeid")

	Employeees empObj;

	

	@ManyToOne

	@JoinColumn(name="projectid")

	Projects proObj;



	



	



	public Integer getYrs() {



		return yrs;



	}







	public void setYrs(Integer yrs) {



		this.yrs = yrs;



	}







	public Integer getattendanceId() {



		return attendanceId;



	}







	public void setattendanceId(Integer attendanceId) {



		this.attendanceId = attendanceId;



	}







	public String getMnth() {



		return mnth;



	}







	public void setMonth(String month) {



		this.mnth = mnth;



	}







	public Integer getfullDay() {



		return fullDay;



	}







	public void setfullDay(Integer fullDay) {



		this.fullDay = fullDay;



	}







	public Integer gethalfDay() {



		return halfDay;



	}







	public void sethalfDay(Integer halfDay) {



		this.halfDay = halfDay;



	}







	public Employeees getEmpObj() {



		return empObj;



	}







	public void setEmpObj(Employeees empObj) {



		this.empObj = empObj;



	}







	public Projects getProObj() {

		return proObj;

	}







	public void setProObj(Projects proObj) {

		this.proObj = proObj;

	}







}