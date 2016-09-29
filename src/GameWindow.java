import java.util.List;

import javax.swing.JFrame;

public class GameWindow extends JFrame
{
	private static final long serialVersionUID = 1L;

	public static final int WINDOW_WIDTH = 1024;
	public static final int WINDOW_HEIGHT = 768;

	public GameWindow(Map map, List<Agent> agents)
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Exploration Map");

		setContentPane(new DisplayMap(map, agents));

		this.setVisible(true);
	}
}
