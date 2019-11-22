
package com.iris.pbms.model;



import javax.persistence.Column;



import javax.persistence.Entity;



import javax.persistence.Id;



import javax.persistence.Table;







@Entity

@Table(name="EmployeeRole") 

public class EmployeeRole{



	



	@Id

	@Column(name="roleid")

    private int roleId;



	@Column(name="rolename")

    private String roleName;

	

	public int getRoleId() {



		return roleId;



	}



	public void setRoleId(int roleId) {



		this.roleId = roleId;



	}



	public String getRoleName() {



		return roleName;



	}



	public void setRoleName(String roleName) {



		this.roleName = roleName;



	}



	



	



	@Override

    public String toString() {



		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";



	}



	



	







}