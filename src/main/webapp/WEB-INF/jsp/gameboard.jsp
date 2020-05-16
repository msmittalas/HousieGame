<% if(session.getAttribute("gameId")==null)
	{
	response.sendRedirect("/");
	}
	%>

<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	
	var id=${sessionScope.gameId};
	$.get("/game/get?gameId="+id, function(data, status){
	if(status != "success")
	      	{
	      		 document.location.href = "/";
	      	}
	
	    });
	  
	  
	  
	  
	  
	});
</script>
</head>

<body>
<h1>Welcome to Gameboard</h1>

<% if(session.getAttribute("isHost")!=null ) { %>

Hi HOST!!! 
<br/>
Your Game Id is :${sessionScope.gameId} 
<br/>
Your Game Passcode is : ${sessionScope.gamepasscode}
<% } %>






</body>


</html>
