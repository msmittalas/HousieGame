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
<div class="text-center">
<h1> Welcome To Housie World </h1>
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="/">HOME</a>

  <!-- Links -->
  <ul class="navbar-nav">
   
    <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
       Re-Join Game As
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="#">Player</a>
        <a class="dropdown-item" href="/host/showhostgame">Host</a>
      </div>
    </li>
     <li class="nav-item">
      <a class="nav-link" >Upcoming Features</a>
    </li>
    
  </ul>
</nav>
<br>

<div class="container-fluid">
  <div class="row">
    <div class="col-lg-5 center">
    
  
  <div id="joinplayerform" >  
  <form action="/game/joinplayer" method="POST">
    <div class="form-group">
      <label for="gameId">Game ID:</label>
      <input type="text" class="form-control" id="playerName" placeholder="Enter Game Id" name="gameId">
    </div>
  
    <div class="form-group">
      <label for="emailId">Your Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="emailId">
    </div>
    <div class="form-group">
      <label for="playerName">Your Name</label>
      <input type="text" class="form-control" id="playerName" placeholder="Enter Your Name" name="playerName">
    </div>
  
    <button type="submit" class="btn btn-info " role="button">Join Game</button>
  </form>
</div>
</div>
 <div class="col-lg-2 center">
 <h3 class="text-center">-OR-</h3>
</div>
 <div class="col-lg-5 center">
    
  
  <div id="hostgameform" >  
 
<form action="/game/create" method="POST">
 <div class="form-group">
      <label for="emailId">Your Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
    <div class="form-group">
      <label for="hostname">Your Name</label>
      <input type="text" class="form-control" id="hostname" placeholder="Enter Your Name" name="hostname">
    </div>
    <div class="form-group">
      <label for="target">Winning Target:</label>
      <input type="text" class="form-control" id="target" placeholder="Enter Target" name="target">
    </div>
  

    <button type="submit" class="btn btn-info">Host Game</button>

</form>
</div>
</div>
</div>
</div>
</body>

</html>