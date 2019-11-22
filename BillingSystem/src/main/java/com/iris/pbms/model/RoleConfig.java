package com.iris.pbms.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="RoleConfig")
public class RoleConfig {
    @Id
    @GeneratedValue
    @Column(name="configid")

     private int configId;
    @Column(name="perHourBill")

    private int perHourBill;
    @Column(name="location")

    private String location;
    @ManyToOne
    @JoinColumn(name="projectid")

    Projects proObj;



	@ManyToOne

    @JoinColumn(name="roleid")

    EmployeeRole roleObj;

    public RoleConfig() {

     super();
}



       public int getconfigId() {

       return configId;
}

 public void setconfigId(int configId) {
     configId = configId;
}

 public int getperHourBill() {
     return perHourBill;
	}

  public void setperHourBill(int perHourBill) {
      perHourBill =perHourBill;
}
  public String getLocation() {
       return location;
}

public void setLocation(String location) {
   location=location;



	}
	public Projects getProObj() {

	return proObj;



	}

	public void setProObj(Projects proObj) {
	this.proObj = proObj;



	}

public EmployeeRole getRoleObj() 
{return roleObj;



	}




public void setRoleObj(EmployeeRole roleObj) {

this.roleObj = roleObj;



	}


@Override

    public String toString() {

return "RoleConfig [configId=" + configId + ", perHourBill=" + perHourBill	+ "location=" + location + ", proObj=" + proObj + ", roleObj=" + roleObj + "]";



	}

}