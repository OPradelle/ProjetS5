package display;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import simulation.Agent;
import simulation.Map;
import simulation.Position;

public class DisplaySimulation extends JPanel
{
	private static final long serialVersionUID = 1L;

	private Map map;
	private List<Agent> agents;
	
	Image[] images;
	
	public DisplaySimulation(Map map, List<Agent> agents)
	{
		this.map = map;
		this.agents = agents;
		
		this.images = new Image[11];
		try
		{
			this.images[0] = ImageIO.read(new File("img/mur_haut_gauche.png"));
			this.images[1] = ImageIO.read(new File("img/mur_bas_gauche.png"));
			this.images[2] = ImageIO.read(new File("img/mur_gauche.png"));
			this.images[3] = ImageIO.read(new File("img/mur_haut_droit.png"));
			this.images[4] = ImageIO.read(new File("img/mur_bas_droit.png"));
			this.images[5] = ImageIO.read(new File("img/mur_droit.png"));
			this.images[6] = ImageIO.read(new File("img/mur_haut.png"));
			this.images[7] = ImageIO.read(new File("img/mur_bas.png"));
			this.images[8] = ImageIO.read(new File("img/apple2.png"));
			this.images[9] = ImageIO.read(new File("img/case_vide.png"));
			this.images[10] = ImageIO.read(new File("img/pacman.png"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		//g.clearRect(0, 0, getWidth(), getHeight());
		
		int blocWidth = getWidth() / (this.map.getWidth() + 2);
		int blocHeight = getHeight() / (this.map.getHeight() + 2);

		// colonnes
		for (int i = 0; i < this.map.getWidth() + 2; i++)
		{
			// lignes
			for (int j = 0; j < this.map.getHeight() + 2; j++)
			{
				// Upper left corner of this terrain rect
				int x = i * blocWidth;
				int y = j * blocHeight;

				Image img = null;

				if (i == 0)
				{
					// Dessiner mur de gauche
					if (j == 0)
						img = images[0];
					else if (j == this.map.getHeight() + 1)
						img = images[1];
					else
						img = images[2];
				}
				else if (i == this.map.getWidth() + 1)
				{
					// Dessiner mur de droite
					if (j == 0)
						img = images[3];
					else if (j == this.map.getHeight() + 1)
						img = images[4];
					else
						img = images[5];
				}
				else
				{
					if (j == 0)
						img = images[6];
					else if (j == this.map.getHeight() + 1)
						img = images[7];
					else
					{
						if (this.map.getPatchIndex(new Position(i - 1, j - 1)) >= 0)
						{
							img = this.images[8];
						}
						else
						{
							img = this.images[9];
						}
					}
				}

				g.drawImage(img, x, y, blocWidth, blocHeight, this);
			}
		}

		if(this.agents != null)
		{
			for (Agent agent : this.agents)
			{
				Image img = images[10];
				int x = ((int) (agent.getPosition().getX() + 1)) * blocWidth;
				int y = ((int) (agent.getPosition().getY() + 1)) * blocHeight;
				g.drawImage(img, x, y, blocWidth, blocHeight, this);
			}
		}
	}
}