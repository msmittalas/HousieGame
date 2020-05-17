var tik=null;
	function getGame(id)
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
		 if(data.players!=null)
		 {
			 var playersoutput="";
			 playersoutput=playersoutput+"<li class='list-group-item'>"+data.hostname+" (HOST)</li>";
			 for(i=0;i<data.players.length;i++)
			{
				 playersoutput=playersoutput+"<li class='list-group-item'>"+data.players[i].playerName+"</li>";
				
			}
			 playersoutput=playersoutput;
			 $("#totalPlayers").html(playersoutput);
		 }
		  $("#nextvalue").fadeOut();
			$("#nextvalue").fadeIn("slow");
			$("#nextvalue").html(data.nextNumber);
			displayTicket(tik,data.dashboardNumbers);
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
	
	
	
	
	
	
	
	
