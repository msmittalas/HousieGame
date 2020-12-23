var stompClient = null;
var mymusic = null;
function connectToChat(grpid) {
	mymusic=document.createElement('audio');
	mymusic.setAttribute('src', '../sound/juntos.mp3');

    var socket = new SockJS('/ysmchatendpoint');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        //setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/grpmsgs/'+grpid, function (greeting) {
        	
            showGreeting(JSON.parse(greeting.body));
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
   // setConnected(false);
    console.log("Disconnected");
}

function sendMessage(grpid,username,message) {
	
    stompClient.send("/app/sendmsg/"+grpid, {}, JSON.stringify({'username': username,"message":message}));
}

function showGreeting(message) {
	document.getElementById("mymusic").play();
	
    $("#groupchatul").append("<li>"+message.username+" : " + message.message + "</li>");
}


