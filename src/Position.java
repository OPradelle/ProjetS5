public class Position
{
	private float x, y;

	public Position()
	{
		this(0, 0);
	}

	public Position(float x, float y)
	{
		this.setX(x);
		this.setY(y);
	}

	public float getX()
	{
		return this.x;
	}

	public void setX(float x)
	{
		this.x = x;
	}

	public float getY()
	{
		return this.y;
	}

	public void setY(float y)
	{
		this.y = y;
	}
	
	public void move(float deltaX, float deltaY)
	{
		this.x += deltaX;
		this.y += deltaY;
	}

	public void set(float x, float y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj)
	{
		Position pos = (Position) obj;
		return ((int)pos.getX() == (int)x && (int)pos.getY() == (int)y);
	}
	
	@Override
	public String toString()
	{
		return "(" + (int)x + ";" + (int)y + ")";
	}

	public float getDistance(Position pos)
	{
		return (float) Math.sqrt(Math.pow(pos.getX() - x, 2) + Math.pow(pos.getY() - y, 2));
	}
}
