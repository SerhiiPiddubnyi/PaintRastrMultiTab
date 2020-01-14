import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PMenu extends JMenuBar
{
	PComand pComand = PComand.getInstance();

	public PMenu()
	{
		setBackground(Color.magenta);
		setBounds(0, 0, 605, 30);
		
		
		
		add (new FileMenu());
		add (new ColorMenu());
		add (new WidthMenu());
	}	
	
	class FileMenu extends JMenu
	{
		
		public FileMenu()
		{
			super ("File");
			
			JMenuItem btnSawe, btnLoad;
			
			btnSawe = new JMenuItem("Sawe");
			btnLoad = new JMenuItem("Load");
			
			btnSawe.setActionCommand("Sawe");
			btnLoad.setActionCommand("Load");
			
			btnSawe.addActionListener(pComand.aSawe);
			btnLoad.addActionListener(pComand.aLoad);
			
			add(btnSawe);
			add(btnLoad);
			
		}
	}
	
	class ColorMenu extends JMenu
	{
		
		public  ColorMenu() 
		{
			super ("Color");
			
			JMenuItem btnBlack, btnRed, btnGreen, btnOther;
			
			btnBlack = new JMenuItem("Black");
			btnRed = new JMenuItem("Red");
			btnGreen = new JMenuItem("Green");
			btnOther = new JMenuItem("Other");
			
			btnBlack.setActionCommand("Black");
			btnRed.setActionCommand("Red");
			btnGreen.setActionCommand("Green");
			btnOther.setActionCommand("Other");
			
			btnBlack.addActionListener(pComand.aColor);
			btnRed.addActionListener(pComand.aColor);
			btnGreen.addActionListener(pComand.aColor);
			btnOther.addActionListener(pComand.aColor);
			
			add(btnBlack);
			add(btnRed);
			add(btnGreen);
			add(btnOther);			
		}
	}
	
	class WidthMenu extends JMenu
	{
		
		public WidthMenu()
		{
			super ("Width");
			
			JMenuItem btn1px, btn5px, btn10px;
			
			btn1px = new JMenuItem("1px");
			btn5px = new JMenuItem("5px");
			btn10px = new JMenuItem("10px");
			
			btn1px.setActionCommand("1px");
			btn5px.setActionCommand("5px");
			btn10px.setActionCommand("10px");
			
			btn1px.addActionListener(pComand.aWidth);
			btn5px.addActionListener(pComand.aWidth);
			btn10px.addActionListener(pComand.aWidth);
			
			add(btn1px);
			add(btn5px);
			add(btn10px);
		}
	}
	
}
