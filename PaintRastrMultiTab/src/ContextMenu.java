import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class ContextMenu extends JPopupMenu
{
	
	private static ContextMenu instance;
	
	PData data = PData.getInstance();
//	PComand pComand = PComand.getInstance();
	
	ActionColor aColor;
	ActionWidth aWidth;

	private ContextMenu() 
	{
		
		aColor = new ActionColor();
		aWidth = new ActionWidth();
		
		JMenuItem btnBlack, btnRed, btnGreen, btnOther, btn1px, btn5px, btn10px;
		
		btnBlack = new JMenuItem("Black");
		btnRed = new JMenuItem("Red");
		btnGreen = new JMenuItem("Green");
		btnOther = new JMenuItem("Other");
		btn1px = new JMenuItem("1px");
		btn5px = new JMenuItem("5px");
		btn10px = new JMenuItem("10px");
		
		btnBlack.setActionCommand("Black");
		btnRed.setActionCommand("Red");
		btnGreen.setActionCommand("Green");
		btnOther.setActionCommand("Other");
		btn1px.setActionCommand("1px");
		btn5px.setActionCommand("5px");
		btn10px.setActionCommand("10px");
		
		btnBlack.addActionListener(aColor);
		btnRed.addActionListener(aColor);
		btnGreen.addActionListener(aColor);
		btnOther.addActionListener(aColor);
		btn1px.addActionListener(aWidth);
		btn5px.addActionListener(aWidth);
		btn10px.addActionListener(aWidth);
		
		
		add(btnBlack);
		add(btnRed);
		add(btnGreen);
		add(btnOther);
		add(btn1px);
		add(btn5px);
		add(btn10px);
		
		setVisible(false);
		
	}
	
	public static ContextMenu getInstance() 
	{
		if (instance == null)
		{
			instance = new ContextMenu();
		}

		return instance;
	}
	
	class ActionColor implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			String color = e.getActionCommand();

			switch (color)
			{
			case "Black": 
				data.color = Color.BLACK;
				instance.setVisible(false);
				break;

			case "Red": 
				data.color = Color.RED;
				instance.setVisible(false);
				break;

			case "Green": 
				data.color = Color.GREEN;
				instance.setVisible(false);
				break;

			case "Other": 
				Color newColor = JColorChooser.showDialog(null, "Choose a color", data.color);
				data.color = newColor;
				instance.setVisible(false);
				break;
			}
		}
	}

	class ActionWidth implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			String width = e.getActionCommand();
			

			switch (width)
			{
			case "1px": 
				data.width = 1;
				instance.setVisible(false);
				break;

			case "5px": 
				data.width = 5;
				instance.setVisible(false);
				break;

			case "10px": 
				data.width = 10;
				instance.setVisible(false);
				break;
			}
		}
	}
}
