<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<div align="center">
    <h1 style="text-align: center;font-family: verdana;color:green">Mark Attendance ! </h1>
<f:form action="submitData" modelAttribute="peaObj" method="get">
<div>
<label>Project :</label>

 <f:select path="proObj.projectId" id="project">
          <f:option value="0">----Select Project--------</f:option>
           <core:forEach items="${pList}" var="dOb">
              	<f:option value="${dOb.projectId}">${dOb.projectName}</f:option>
              	</core:forEach>
                  </f:select><br>
	</div>
<div>



		<label>Employees Under project :</label>
        <f:select path="empObj.employeeId" id="employee" >
        <f:option value="0">----Select Employee--------</f:option>
        </f:select><br>

		<div id="msg"></div>
        </div>



		<div>
        <label>Month :</label>

          <f:select path="mnth" cssClass="form-control" required="true">



			<f:option value="january">January</f:option>

             <f:option value="february">February</f:option>
             <f:option value="march">March</f:option>
             <f:option value="april">April</f:option>
             <f:option value="may">May</f:option>
             <f:option value="june">June</f:option>
             <f:option value="july">July</f:option>
             <f:option value="august">August</f:option>
             <f:option value="september">September</f:option>
           	<f:option value="october">October</f:option>
             <f:option value="november">November</f:option>
           	<f:option value="december">December</f:option>
</f:select>
<br>
       </div>
       <div>
          <label>Year :</label>
             <f:select path="yrs" id="yrs"  required="true">
              <f:option value="">Select year</f:option>
	</f:select>
                 <script type="text/javascript">

                   	for(y=2015;y<2021;y++){
                     var optn = document.createElement("OPTION");
                         optn.text=y;
                         	optn.value=y;
                       	if(y==2019){
                          optn.selected=true;
	}
	document.getElementById('yrs').options.add(optn);

	}

</script>

</div>

<br>

</div>
	<br>
	<div>
	    
<label>Half day:</label>
	<f:input path="halfDay" size="30" cssClass="form-control" placeholder="Enter Number of Half Days" required="true"/><br>
	</div>

	<div>	
         <label>Full Day:</label>
     <f:input path="fullDay" size="30" cssClass="form-control" placeholder="Enter Number of Full Days" required="true"/><br>
</div>

<div class="form-group">

      <button type="submit" class="btn btn-primary">Submit</button>
           </div>



	</f:form>



	</div>

	<script type="text/javascript">

		$('select#project').on('change', function() {

			console.log('I m here');

			$("div#msg").html("");

			var projectId=this.value;

			console.log('Project Id : '+projectId);

			$.get("getEmployeeesList?projectId="+projectId, function(data, status){

			    

			    console.log(data.length);

			    if(data.length!=0){

			    console.log('I m in if');

			    data.forEach(function(el, index) {

			    	console.log('Hello I m in for Each..');

			        console.log(el.employeeId+" "+el.employeeName);

			       var o = new Option(el.employeeName, el.employeeId);

		                 /// jquerify the DOM object 'o' so we can use the html method

		                 $(o).html(el.employeeName);

		                 $("#employee").append(o)

			      });

			    }

			    else {

			    	console.log('I m in else');

			    	$("div#msg").html("No Employee exist for the given project...");

			    	$('#employee').empty()

			    	$("#employee").hide();

			    }

			   });

			

		});

	</script>

</body>

</html>