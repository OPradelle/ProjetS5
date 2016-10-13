public class Agent
{
	private AgentController agentController;
	private Position position;
	private float rotation;
	private boolean moving;

	public Agent()
	{
		this.setRotation(0);
		this.position = new Position();
		this.moving = false;
	}

	public Position getPosition()
	{
		return this.position;
	}

	public void setPosition(Position position)
	{
		this.position = position;
	}

	public float getRotation()
	{
		return this.rotation;
	}

	public void setRotation(float rotation)
	{
		this.rotation = rotation;
	}

	public boolean isMoving()
	{
		return moving;
	}

	public void setMoving(boolean moving)
	{
		this.moving = moving;
	}

	public void update(Map map)
	{
		if (map == null)
			return;
		
		if (this.agentController != null)
			this.agentController.update(this, map);

		move(map);

		map.removePatch(position);
	}

	public void move(Map map)
	{
		if (!moving)
			return;

		float deltaX = (float) Math.cos(Math.toRadians(this.rotation));
		float deltaY = (float) Math.sin(Math.toRadians(this.rotation));
		this.position.move(deltaX, deltaY);

		/*
		 * Si l'agent d�passe les bornes de l'ar�ne (tricheur), on le replace
		 * sur la bordure et on lui dit d'arreter de bouger (comme �a le
		 * controleur peut le detecter)
		 */
		if (this.position.getX() < 0)
		{
			this.position.setX(0);
			setMoving(false);
		}
		else if (this.position.getX() >= map.getWidth())
		{
			this.position.setX(map.getWidth() - 1);
			setMoving(false);
		}

		if (this.position.getY() < 0)
		{
			this.position.setY(0);
			setMoving(false);
		}
		else if (this.position.getY() >= map.getHeight())
		{
			this.position.setY(map.getHeight() - 1);
			setMoving(false);
		}
	}

	public void setAgentController(AgentController agentController)
	{
		this.agentController = agentController;
		this.agentController.init(this);
	}
}
