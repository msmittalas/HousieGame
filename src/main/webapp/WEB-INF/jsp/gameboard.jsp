



<h1>Welcome to Gameboard</h1>

<% if(session.getAttribute("isHost")!=null ) { %>

Hi HOST!!! 
<br/>
Your Game Id is :${sessionScope.gameId} 
<br/>
Your Game Passcode is : ${sessionScope.gamepasscode}
<% } %>

