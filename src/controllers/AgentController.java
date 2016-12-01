package controllers;

import simulation.Agent;
import simulation.Map;

public abstract class AgentController
{
	protected int numberOfMoves;
	
	public abstract void init(Agent agent);

	public abstract void update(Agent agent, Map map);
	
	public int getNumberOfMoves()
	{
		return this.numberOfMoves;
	}
}
