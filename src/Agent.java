public class Agent
{
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

	public void update()
	{
		move();
	}

	public void move()
	{
		if (!moving)
			return;

		float deltaX = (float) Math.cos(Math.toRadians(this.rotation));
		float deltaY = (float) Math.sin(Math.toRadians(this.rotation));
		this.position.move(deltaX, deltaY);
	}
}
