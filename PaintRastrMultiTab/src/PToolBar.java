import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JToolBar;

public class PToolBar extends JToolBar
{
	PComand pComand = PComand.getInstance();
	
	public PToolBar()
	{
		setBackground(Color.pink);
		setBounds(0, 30, 605, 30);
		
		JButton btnBlack, btnRed, btnGreen, btnOther, btn1px, btn5px, btn10px, Creve, Line, Oval, Rect, addTab, delTab;
		
		btnBlack = new JButton("Black");
		btnRed = new JButton("Red");
		btnGreen = new JButton("Green");
		btnOther = new JButton("Other");
		btn1px = new JButton("1px");
		btn5px = new JButton("5px");
		btn10px = new JButton("10px");
		Creve = new JButton("Creve");
		Line = new JButton("Line");
		Oval = new JButton("Oval");
		Rect = new JButton("Rect");
		addTab = new JButton("New Tab");
		delTab = new JButton("Close Tab");
		
		btnBlack.setActionCommand("Black");
		btnRed.setActionCommand("Red");
		btnGreen.setActionCommand("Green");
		btnOther.setActionCommand("Other");
		btn1px.setActionCommand("1px");
		btn5px.setActionCommand("5px");
		btn10px.setActionCommand("10px");
		Creve.setActionCommand("Creve");
		Line.setActionCommand("Line");
		Oval.setActionCommand("Oval");
		Rect.setActionCommand("Rect");
		
		btnBlack.addActionListener(pComand.aColor);
		btnRed.addActionListener(pComand.aColor);
		btnGreen.addActionListener(pComand.aColor);
		btnOther.addActionListener(pComand.aColor);
		btn1px.addActionListener(pComand.aWidth);
		btn5px.addActionListener(pComand.aWidth);
		btn10px.addActionListener(pComand.aWidth);
		Creve.addActionListener(pComand.aRadio);
		Line.addActionListener(pComand.aRadio);
		Oval.addActionListener(pComand.aRadio);
		Rect.addActionListener(pComand.aRadio);
		addTab.addActionListener(pComand.aAdd);
		delTab.addActionListener(pComand.aDel);

		add(btnBlack);
		add(btnRed);
		add(btnGreen);
		add(btnOther);
		add(btn1px);
		add(btn5px);
		add(btn10px);
		add(Creve);
		add(Line);
		add(Oval);
		add(Rect);
		add (addTab);
		add (delTab);


	}
}
