<html>
<head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</head>
<body>
<div class="jumbotron text-center">
<h1> Welcome To Housie World </h1><br/><br/>
</div>


<div class="container">
  <div class="row">
    <div class="col-sm-5 center">
<form action="/game/joinplayer" method="POST">
<input type="text" name="gameId" value="Enter GAME ID TO JOIN"/> <br/><br/>
<input type="text" name="playerName" value="Enter NAME"/> <br/><br/>
<input type="text" name="emailId" value="Enter EMAILD ID"/> <br/><br/>

<input type="submit" value="Join the Game" />
</form>
</div>
 <div class="col-sm-2 center">
 <h3>-OR-</h3>
</div>
 <div class="col-sm-5 center">
<form action="/host/showhostgame">
<input type="submit" value="Host Game/ Re Join As Host" />
</form>
</div>
</div>
</div>
</body>

</html>