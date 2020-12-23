package io.mitts.houisegame.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;

import io.mitts.houisegame.model.Ticket;
import io.mitts.houisegame.service.TicketService;

@Service
public class TicketServiceImpl  implements TicketService{

	final static int START=1;
	final static int END=90;
	
	@Override
	public Ticket generateTicket(Collection<Ticket> excludedTickets) {
		
		Ticket ticket=null;
		do {
			ticket=generateTicket();
		}
		while(excludedTickets.contains(ticket));
		excludedTickets.add(ticket);
		return ticket;
	}
	private Ticket generateTicket()
	{
		 Ticket ticket=new Ticket();
		 ticket.setNumbers(generateRandomRow());
		 return ticket;
	}
	
	
	private ArrayList<Integer> generateRandomRow()
	{
	
		ArrayList<Integer> row=new ArrayList<Integer>(27);
		for(int i=0;i<27;i++)
		{
			row.add(-1);
		}
		 ArrayList<Integer>  randomPositions=generateRandomPosition(15);
		for(Integer i : randomPositions)
		{
			Integer randomNumber=getRandomNumberBetween(START,END, row);
			row.set(i,randomNumber);
		}
		return row;
		
	}
	
	private ArrayList<Integer>  generateRandomPosition(int totalPositions)
	{
		ArrayList<Integer> positions= new ArrayList<Integer>();
		do 
		{
			positions.add(getRandomNumberBetween(0, 26,positions));
		}
		while(positions.size()<totalPositions);
		return positions;
	}
	
	private int getRandomNumberBetween(int minimum,int maximum,ArrayList<Integer> excludedNumbers)
	{
		Integer randomNumber=0;
		do
		{
			randomNumber=(minimum + (int)(Math.random() * maximum));
		}
		while(excludedNumbers.contains(randomNumber));
		return  randomNumber;
	}
	
}
