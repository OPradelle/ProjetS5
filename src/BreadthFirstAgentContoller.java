import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstAgentContoller extends AgentController
{
	private Position initialPosition;
	private float distance;

	private Queue<Position> toVisit;
	private List<Position> visited;

	public BreadthFirstAgentContoller()
	{
		this.distance = 0;
		this.numberOfMoves = 0;

		this.toVisit = new LinkedList<Position>();
		this.visited = new ArrayList<Position>();
	}

	@Override
	public void init(Agent agent)
	{
		this.initialPosition = new Position(agent.getPosition());

		// this.toVisit.add(new Position(this.initialPosition));
	}

	@Override
	public void update(Agent agent, Map map)
	{
		if (agent.isMoving() && agent.getPosition().getDistance(this.initialPosition) < distance)
			return;

		if (!agent.isMoving())
			agent.setMoving(true);

		map.removePatch(agent.getPosition());
		this.numberOfMoves += 1;

		agent.setPosition(new Position((int)agent.getPosition().getX(), (int)agent.getPosition().getY()));
		this.initialPosition = new Position(agent.getPosition());

		for (int x = -1; x <= 1; x++)
		{
			for (int y = -1; y <= 1; y++)
			{
				if ((x == 0 && y == 0) || (x != 0 && y != 0))
					continue;

				Position pos = new Position((int) this.initialPosition.getX() + x, (int) this.initialPosition.getY() + y);

				if ((int) pos.getX() < 0 || (int) pos.getX() >= map.getWidth() || (int) pos.getY() < 0
						|| (int) pos.getY() >= map.getHeight())
					continue;

				if (this.visited.contains(pos))
					continue;

				this.toVisit.add(pos);
			}
		}

		// TODO poll == NULL
		this.visited.add(new Position(this.initialPosition));
		Position newTarget = this.toVisit.poll();
		this.distance = newTarget.getDistance(this.initialPosition);
		agent.setRotation(getAngle(this.initialPosition, newTarget));

		System.out.println(this.initialPosition + "->" + newTarget + ": " + agent.getRotation());
	}

	private float getAngle(Position origin, Position target)
	{
		Position ref = new Position(origin.getX() + 100, origin.getY());
		
		return (float)(Math.acos((Math.pow(origin.getDistance(target), 2) + Math.pow(origin.getDistance(ref), 2) - Math.pow(target.getDistance(ref), 2))/(2 * origin.getDistance(target) * origin.getDistance(ref))) * 180 / Math.PI);
	}
}
