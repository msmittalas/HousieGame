var tik=null;
	function getGame(id,isGamelobby)
	{
		$.get("/game/get?gameId="+id, function(data, status){
			if(status != "success")
	      	{
	      		 document.location.href = "/";
	      	}
		 if(data.dashboardNumbers!=null)
			 {
				for( i=0;i<data.dashboardNumbers.length;i++)
				{
					var id="td"+data.dashboardNumbers[i];
					
					$("#"+id).css("background-color", "#17a2b8");
					$("#"+id).animate({opacity: '1.0'});
				}
			 }
		 $("#gameDetails").html("");
		 $("#gameDetails").append("<li>Game Id:"+data.gameId+"</li>");
		 $("#gameDetails").append("<li>Game Status:"+data.gameStatus+"</li>");
		 $("#gameDetails").append("<li>Game Prize:"+data.target+"</li>");
			
		 if(data.players!=null)
		 {
			 var playersoutput="";
			 for(i=0;i<data.players.length;i++)
			{
				 var player=data.players[i];
				 if(player.isHost==="true")
				{
					 playersoutput=playersoutput+"<li class='list-group-item'>"+player.playerName+"(HOST)</li>";
					 	 
				}	
				 else{
				 playersoutput=playersoutput+"<li class='list-group-item'>"+player.playerName+"</li>";
				 }
			}
			$("#totalPlayers").html(playersoutput);
		 }
		 if(data.gameStatus==="STARTED"){
		 var nextVal=$("#nextvalue").html();
		 if(nextVal=== null ||   nextVal!=data.nextNumber)
			 {
		  $("#nextvalue").fadeOut();
			$("#nextvalue").fadeIn("slow");
			$("#nextvalue").fadeOut();
			$("#nextvalue").fadeIn("slow");
			$("#nextvalue").html(data.nextNumber);
			 }
			displayTicket(tik,data.dashboardNumbers);
		 }
		 else if(data.gameStatus==="CREATED")
		 {
			 $("#nextvalue").html("WAITING FOR PLAYERS....");
			 $("#generate").hide();
			 $("#FinishGame").hide();
		}
		 else if(data.gameStatus==="FINISHED")
		{
			 $("#nextvalue").html("GAME FINISHED");
			 $("#generate").hide();
			 $("#FinishGame").hide();
			 $("#startGame").hide();
		}
	    });
	}
	
	
	function generateNextNumber(id)
	{
		$.get("/game/generateNext?gameId="+id, function(data, status){
			
			  	getGame(id);
				
				
				    });
	}

	function generateGameBoard()
	{
		var step=10;
		var output="<table class='table table-bordered' ><tr>";
		for ( i = 1; i <= 90; i++) 
		{
			output=output+"<td class='boardtds' id='td"+i+"'>"+i+"</td>";
			if (i === step && i != 90) {
				output=output+"</tr><tr>";
				step = step + 10;
			}
		}
		 output=output+"<tr></table>";
		 
		 $("#gameboard").html(output);
		
	}
	
	function changeGameStatus(id,gameStatus)
	{
		$.get("/game/changeStatus?gameId="+id+"&gameStatus="+gameStatus, function(data, status){
		getGame(id);
		
	});
	}

	
	
	function getPlayer()
	{
		var playerDetails=null;
		
	     $.ajax({
	         url: "/game/playerDetails",
	         type: 'get',
	         async: false,
	         success: function(data) {
	        	 playerDetails = data;
	         } 
	      });
		return playerDetails;
	}
	

	function displayTicket(ticket,dashboard)
	{
		if(ticket==null || ticket.numbers==null)
			{
			return ;
			}
		tik=ticket;
		var numbers=ticket.numbers;
		var displayOutput="<h3 class='text-center'>Your Ticket</h3><table class='table table-bordered'><tr>";
		var steps=9;
		
		for(i=0;i<numbers.length;i++)
		{
			
			if(dashboard!=null &&  $.inArray(numbers[i],dashboard) != -1)
			{
				displayOutput=displayOutput+"<td  style='opacity:1.0;background-color:orange;'>";
					
			}
			else
			{
				displayOutput=displayOutput+"<td >";
					
			}
			if(numbers[i]===-1)
			{
				displayOutput=displayOutput+"<span>&nbsp;&nbsp;&nbsp;&nbsp;</span>";
			}
			else
			{
				displayOutput=displayOutput+"<span> "+numbers[i]+"</span>";
			}
			displayOutput=displayOutput+"</td>";
			if(i+1 === steps)
			{
				displayOutput=displayOutput+"</tr><tr>";
				steps=steps+9;	
			}
		}
		
		displayOutput=displayOutput+"</tr></table>";
		
		
		$("#playerTicket").html(displayOutput);
	}
	
	
	
	
	
	
	
	
