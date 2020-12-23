package io.mitts.houisegame.groupchat.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import io.mitts.houisegame.groupchat.dto.CustomMessage;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class MessageHandlingController {

	
	@MessageMapping("/sendmsg/{sendgrpid}")
	@SendTo("/topic/grpmsgs/{sendgrpid}")
	public CustomMessage sendMessageToBroker(CustomMessage message,@DestinationVariable String sendgrpid)
	{
		return message;
	}
	
}
