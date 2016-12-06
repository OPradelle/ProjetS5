package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import simulation.Agent;
import simulation.Map;
import simulation.Position;

public class CaseMarkerAgentController extends AgentController
{
	private List<Position> toVisit;
	private boolean toVisitInitialised = false;

	private Position initialPosition;
	private float distance;

	private Random rand;
	private Position nextPosition;

	public CaseMarkerAgentController()
	{
		this.toVisit = new ArrayList<Position>();
		this.distance = 0;
		this.numberOfMoves = 0;

		this.rand = new Random();
	}

	@Override
	public void init(Agent agent)
	{
		this.initialPosition = new Position(agent.getPosition());
		this.nextPosition = new Position(agent.getPosition());
	}

	@Override
	public void update(Agent agent, Map map)
	{
		
		if (!this.toVisitInitialised)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
				for (int y = 0; y < map.getHeight(); y++)
				{
					this.toVisit.add(new Position(x, y));
				}
			}
			System.out.println(this.toVisit.size());
			this.toVisitInitialised = true;
			this.toVisit.remove(this.initialPosition);
			System.out.println(this.toVisit.size());
		}

		if (agent.isMoving() && agent.getPosition().getDistance(this.initialPosition) < distance)
			return;

		// Correction of float errors
		agent.setPosition(this.nextPosition);
		this.initialPosition = new Position(agent.getPosition());
		
		System.out.println(agent.getPosition());

		map.removePatch(agent.getPosition());
		this.numberOfMoves += 1;
		
		if (this.toVisit.isEmpty())
			return;

		if (!agent.isMoving())
			agent.setMoving(true);

		int nextTargetId = this.rand.nextInt(this.toVisit.size());
		this.nextPosition = this.toVisit.remove(nextTargetId);

		this.distance = this.nextPosition.getDistance(this.initialPosition);
		agent.setRotation(getAngle(this.initialPosition, this.nextPosition));
	}

	private float getAngle(Position origin, Position target)
	{
		// http://stackoverflow.com/a/38024982
		double x = target.getX() - origin.getX();
		double y = target.getY() - origin.getY();

		double magnitude = Math.sqrt(x * x + y * y);
		double angle = 0;

		if (magnitude > 0)
			angle = Math.acos(x / magnitude);

		angle = angle * 180 / Math.PI;
		if (y < 0)
			angle = 360 - angle;

		return (float) angle;
	}
}
