package com.iris.pbms.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="ProjectEmpAllocation")
public class ProjectEmpAllocation {

    @Id
    @GeneratedValue
    @Column(name="allocationid")
    private int allocationId;



	@OneToOne
    @JoinColumn(name="configid")
    RoleConfig roleconfig;


	@OneToOne
    @JoinColumn(name="employeeid")
    Employeees empObj;

     public ProjectEmpAllocation() {
           super();
    }

 public int getallocationId() {
		return allocationId;

}


	public void setallocationId(int allocationId) {
		this.allocationId = allocationId;

	}

	public RoleConfig getRoleConfig() {
		return roleconfig;
		}

  public void setRoleConfig(RoleConfig roleconfig) {
	this.roleconfig=roleconfig;
	}

	public Employeees empObj() {
		return empObj;
	}


  public void setempObj(Employeees empObj) {
	this.empObj = empObj;
	}
/*
  public Projects getProObj() {
      return ProObj();

	}


  public void setProObj(Projects proObj) {

		this.proObj = proObj;

	}
	*/
       @Override
  	public String toString() {
  		return "ProjectEmpAllocation [allocationId=" + allocationId + ", roleconfig=" + roleconfig + ", empObj="
  				+ empObj + "]";
  	}

}