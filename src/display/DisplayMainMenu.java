package display;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Button;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.JFileChooser;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SpinnerNumberModel;

import simulation.SimulationParameters;

import java.awt.Color;
import java.awt.SystemColor;

public class DisplayMainMenu extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 1L;

	private JButton launchButton;
	private boolean choiceMade;
	private JPanel contentPane;

	private JComboBox comboBox;
	private JSpinner numericAgentNumber;
	private JButton btnParcourir;
	private JSpinner numericTime;
	private JLabel lblNewLabel;
	private JLabel lblFichier;
	private JButton btnMapGenerator;

	private JFileChooser fileChooser;
	private String filePath;
	
	private GUIManager guiManager;

	public DisplayMainMenu(GUIManager guiManager)
	{
		this.guiManager = guiManager;
		
		fileChooser = new JFileChooser();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 636);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		contentPane.setLayout(null);

		labelCreation();

		this.numericAgentNumber = new JSpinner(new SpinnerNumberModel(1, 0, 100, 1));
		this.numericAgentNumber.setBounds(334, 368, 131, 20);
		contentPane.add(this.numericAgentNumber);

		this.comboBox = new JComboBox();
		comboBox.setForeground(SystemColor.infoText);
		this.comboBox.setBounds(334, 322, 203, 20);
		this.comboBox.addItem("Marche aléatoire");
		this.comboBox.addItem("Marche moins aléatoire");
		this.comboBox.addItem("Marche de Levy");
		this.comboBox.addItem("Déplacement case par case");
		this.comboBox.addItem("Exploration en Largeur");
		this.comboBox.addItem("Marqueur de case séparé");
		this.comboBox.addItem("Marqueur de case commun");
		contentPane.add(this.comboBox);

		this.btnParcourir = new JButton("Parcourir ...");
		this.btnParcourir.setBounds(367, 412, 98, 23);
		this.btnParcourir.addActionListener(this);
		contentPane.add(this.btnParcourir);

		this.numericTime = new JSpinner(new SpinnerNumberModel(1000, 0, 10000, 100));
		this.numericTime.setBounds(334, 459, 131, 20);
		contentPane.add(this.numericTime);
		
		this.btnMapGenerator = new JButton("");
		this.btnMapGenerator.addActionListener(this);
		this.btnMapGenerator.setBounds(334, 412, 23, 23);
		
		try 
		{
			this.btnMapGenerator.setIcon(new ImageIcon(ImageIO.read(new File("img/build.png"))));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		contentPane.add(this.btnMapGenerator);		

		this.launchButton = new JButton("Lancer la simulation");
		this.launchButton.setBounds(228, 542, 164, 25);
		this.launchButton.addActionListener(this);
		contentPane.add(this.launchButton);

		try
		{
			lblNewLabel = new JLabel(new ImageIcon(ImageIO.read(new File("img/fond_accueil.png"))));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		lblNewLabel.setBounds(0, 0, 600, 600);
		contentPane.add(lblNewLabel);

		this.choiceMade = false;
	}

	private void labelCreation()
	{
		JLabel lblApplication = new JLabel("A path to the food");
		lblApplication.setForeground(new Color(255, 255, 255));
		lblApplication.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblApplication.setBounds(218, 159, 184, 25);
		contentPane.add(lblApplication);

		JLabel lblTypeDeDplacment = new JLabel("Nombre d'agents");
		lblTypeDeDplacment.setForeground(new Color(255, 255, 255));
		lblTypeDeDplacment.setFont(new Font("Aharoni", Font.PLAIN, 15));
		lblTypeDeDplacment.setBounds(133, 366, 191, 25);
		contentPane.add(lblTypeDeDplacment);

		JLabel label = new JLabel("Type de déplacement");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Aharoni", Font.PLAIN, 15));
		label.setBounds(133, 320, 191, 25);
		contentPane.add(label);

		JLabel lblFichierTexteDe = new JLabel("Fichier texte de la carte");
		lblFichierTexteDe.setForeground(new Color(255, 255, 255));
		lblFichierTexteDe.setFont(new Font("Aharoni", Font.PLAIN, 15));
		lblFichierTexteDe.setBounds(133, 411, 191, 25);
		contentPane.add(lblFichierTexteDe);

		JLabel lblTempsDattenteen = new JLabel("Temps d'attente (en ms)");
		lblTempsDattenteen.setForeground(new Color(255, 255, 255));
		lblTempsDattenteen.setFont(new Font("Aharoni", Font.PLAIN, 15));
		lblTempsDattenteen.setBounds(133, 457, 191, 25);
		contentPane.add(lblTempsDattenteen);

		lblFichier = new JLabel("");
		lblFichier.setForeground(new Color(255, 255, 255));
		lblFichier.setFont(new Font("Aharoni", Font.PLAIN, 15));
		lblFichier.setBounds(473, 411, 127, 25);
		contentPane.add(lblFichier);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == this.launchButton)
		{
			this.choiceMade = true;
		}

		else if (e.getSource() == this.btnParcourir)
		{
			this.fileChooser.setCurrentDirectory(new File("."));

			int returnVal = this.fileChooser.showOpenDialog(this);

			if (returnVal == JFileChooser.APPROVE_OPTION)
			{
				File file = this.fileChooser.getSelectedFile();
				this.filePath = file.getAbsolutePath();

				lblFichier.setText(file.getName());
			}
		}
		else if (e.getSource() == this.btnMapGenerator)
		{
			guiManager.showMapGenerator();
		}
	}

	public SimulationParameters waitForAction()
	{
		this.choiceMade = false;

		while (!choiceMade)
		{
			try
			{
				Thread.sleep(100);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

		SimulationParameters simulation = new SimulationParameters();
		simulation.setAgentNumber((int) this.numericAgentNumber.getValue());
		simulation.setMovementType(this.comboBox.getSelectedIndex());
		simulation.setSleepTime((int) this.numericTime.getValue());
		simulation.setFilePath(filePath);

		return simulation;
	}
}
