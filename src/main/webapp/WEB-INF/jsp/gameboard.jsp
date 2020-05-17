
<%
	if (session.getAttribute("gameId") == null) {
		response.sendRedirect("/");
	}
%>
<html>
<head>
<link rel="stylesheet" href="../css/gameboard.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="../js/gameboard.js"></script>
<script src="../js/groupchat.js"></script>
<script src="../webjars/sockjs-client/sockjs.min.js"></script>
<script src="../webjars/stomp-websocket/stomp.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var player=getPlayer();
		if(player!=null && player.ticket!=null)
		{
			displayTicket(player.ticket);
			$("#generate").hide();
		}
		else
		{
			$("#playerTicket").hide();
		}
		generateGameBoard();
		var id = ${sessionScope.gameId};
		getGame(id);
		connectToChat(id);
		$("#generate").click(function() {
			generateNextNumber(id);
		});
		$("#sendMsgbtn").click(function()
				{
			sendMessage(id,player.playerName,$("#message").val());
				});
		
		setInterval(function() {
			getGame(id); 
		}, 5000);
		
	});
</script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		
		<div class="row">
		 	<div class="col-lg-2 ">
		 	<h4 class="text-center">Players</h4>
		 	<ul id="totalPlayers" class="list-group"></ul>
		 	</div>
			<div class="col-lg-8">
			<h1 class="text-center">Gameboard</h1>
			<div class="row">
				<div  class="col-lg-12" id="gameboard"></div>
			</div>
			<div class="row">
				<div  class="col-lg-12" id="playerTicket">
				
				</div>
			</div>
				
			</div>
			<div class="col-lg-2">
				<div class="card">

					<div class="card-body rounded-sm">

						<h4 id="nextvalue" class="card-title text-center"></h4>
					</div>
					<a id="generate" href="#" class="btn btn-info " role="button">Generate</a>

				</div>
				<div class="card mt-3 mb-3">
					<h4 class="text-center">Chat With Friends</h4>
					<div class="card-body">
						<div class="scroll">
						<ul id="groupchatul">
						   <li>Mittal : HI</li>
						</ul>
						</div>
					</div>
					<form action="#">
						<input type="text"
							class="form-control " id="message" placeholder="Enter Message"
							name="message">
						<a class="form-control btn btn-info"  href="#"  role="button" id="sendMsgbtn">Send</a>
					</form>
				</div>
			</div>



		</div>
	</div>
<audio id="mymusic">
  <source src="../sound/juntos.mp3" type="audio/mpeg">
Your browser does not support the audio element.
</audio>

</body>


</html>










