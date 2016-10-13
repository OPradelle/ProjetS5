import javax.swing.JFrame;

public class GUI implements Runnable
{
	private JFrame window;
	private DisplayMainMenu mainMenu;
	
	public GUI()
	{
		this.window = new JFrame("Exploration map");
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setSize(600, 600);
		this.window.setLocationRelativeTo(null);
		this.window.setResizable(false);
		
		this.mainMenu = new DisplayMainMenu();
	}
	
	@Override
	public void run()
	{
		this.window.setVisible(true);
	}

	public void repaint()
	{
		this.window.repaint();
	}
	
	public void startDisplayMainMenu()
	{
		this.window.setContentPane(this.mainMenu);
		this.window.revalidate();
		this.window.repaint();
	}
	
	public void startDisplaySimulation(DisplaySimulation displaySimulation)
	{
		this.window.setContentPane(displaySimulation);
		this.window.revalidate();
		this.window.repaint();
	}

	public void waitForAction()
	{
		this.mainMenu.waitForAction();
	}
}
