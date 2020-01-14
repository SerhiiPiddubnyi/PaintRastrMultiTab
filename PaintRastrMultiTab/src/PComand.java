import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PComand 
{
	private static PComand instance;
	
	PData data;
	int x, y, indexTab = 2;

	PButonPanel butonPanel;
	ActionColor aColor;
	ActionWidth aWidth;
	ActionPress aPress;
	ActionDragged aDragged;
	ActionSlider slider;
	ActionRadio aRadio;
	ContextMenu cMenu;
	ActionSawe aSawe;
	ActionLoad aLoad;
	ActionAddTab aAdd;
	ActionDelTab aDel;
	BufferedImage bi; 
	PPanel pan;
	PTabbed tabbedPane;
	
	public static PComand getInstance()
	{
		if (instance == null)
		{
			instance = new PComand();
		}

		return instance;

	}
	public PTabbed setTabbedPane(PTabbed tabbetPane){
		this.tabbedPane = tabbetPane;
		return tabbetPane;
	}
	
	public void setPanel(PPanel pan){
		this.pan = pan;
		
	}
	
	public void getButonPanel (PButonPanel butonPanel) {
		this.butonPanel = butonPanel;
	}

	private PComand()
	{
		data = PData.getInstance();
		aColor = new ActionColor();
		aWidth = new ActionWidth();
		aPress = new ActionPress();
		aDragged = new ActionDragged();
		slider = new ActionSlider();
		aRadio = new ActionRadio();
		cMenu = ContextMenu.getInstance();
		aSawe = new ActionSawe();
		aLoad = new ActionLoad();
		aAdd = new ActionAddTab();
		aDel = new ActionDelTab();
	
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
				break;

			case "Red": 
				data.color = Color.RED;
				break;

			case "Green": 
				data.color = Color.GREEN;
				break;

			case "Other": 
				Color newColor = JColorChooser.showDialog(null, "Choose a color", data.color);
				data.color = newColor;
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
				butonPanel.slider.setValue(data.width);
				break;

			case "5px": 
				data.width = 5;
				butonPanel.slider.setValue(data.width);
				break;

			case "10px": 
				data.width = 10;
				butonPanel.slider.setValue(data.width);
				break;
			}
		}
	}

	class ActionPress implements MouseListener
	{

		@Override
		public void mousePressed(MouseEvent e) 
		{
			x = e.getX();
			y = e.getY();
			cMenu.setVisible(false);

		}

		@Override
		public void mouseReleased(MouseEvent e) 
		{
			PPanel pPanel = (PPanel) e.getComponent();
			String figure = data.figure;
			int x2, y2, sizeWidth, sizeHeigth;

			if (SwingUtilities.isLeftMouseButton(e))
			{

				switch (figure) 
				{
				case "Line":
					x2 = e.getX();
					y2 = e.getY();

					pPanel.drawLine(x, y, x2, y2, data.width, data.color);
					break;

				case "Oval":
					x2 = e.getX();
					y2 = e.getY();

					if (x > x2)
					{
						int tmp = x;
						x = x2;
						x2 = tmp;
					}

					if (y > y2)
					{
						int tmp = y;
						y = y2;
						y2 = tmp;
					}

					sizeWidth = x2 - x;
					sizeHeigth = y2 - y;

					pPanel.drawOwal(x, y, sizeWidth, sizeHeigth, data.width, data.color);
					break;

				case "Rect":
					x2 = e.getX();
					y2 = e.getY();

					if (x > x2)
					{
						int tmp = x;
						x = x2;
						x2 = tmp;
					}

					if (y > y2)
					{
						int tmp = y;
						y = y2;
						y2 = tmp;
					}

					sizeWidth = x2 - x;
					sizeHeigth = y2 - y;

					pPanel.drawRect(x, y, sizeWidth, sizeHeigth, data.width, data.color);
					break;

				default:
					break;
				}
			}else {
	
				cMenu.setLocation(x, y);
				cMenu.setVisible(true);
			}

		}

		@Override
		public void mouseClicked(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}


	}

	class ActionDragged implements MouseMotionListener
	{

		@Override
		public void mouseDragged(MouseEvent e) 
		{
			if (SwingUtilities.isLeftMouseButton(e) && data.figure.equals("Creve"))
			{
				int x2 = e.getX();
				int y2 = e.getY();

				PPanel pPanel = (PPanel) e.getComponent();

				pPanel.drawLine(x, y, x2, y2, data.width, data.color);

				x = x2;
				y = y2;
			}

		}

		@Override
		public void mouseMoved(MouseEvent e) {}

	}

	class ActionSlider implements ChangeListener
	{

		@Override
		public void stateChanged(ChangeEvent e) 
		{
			JSlider slider = (JSlider) e.getSource();
			data.width = slider.getValue();

		}

	}

	class ActionRadio implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			String radio = e.getActionCommand();

			data.figure = radio;

		}
	}

	class ActionSawe implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{

			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("C:\\Users\\Serhii\\Documents"));

			fileChooser.setFileFilter(new FileNameExtensionFilter("JPG and JPEG", new String [] {"jpg", "jpeg"}));
			
			fileChooser.setAcceptAllFileFilterUsed(true);

			int flag = fileChooser.showDialog(null, "Sawe File");

			if (flag == 0)
			{
				File file = fileChooser.getSelectedFile();
				
				if (!file.toString().endsWith(".jpg"))
					file = new File(file.toString() + ".jpg");

				try 
				{
					pan = (PPanel) tabbedPane.getSelectedComponent();
					bi = pan.getBufferedImage();
					ImageIO.write(bi, "jpg", file);
				} 

				catch (Exception e2) 
				{
					e2.printStackTrace();

				}
			}	
		}
	}

	class ActionLoad implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JFileChooser load = new JFileChooser();
			load.setCurrentDirectory(new File("C:\\Users\\56270\\Pictures\\JawaPaint"));

			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG and JPEG", new String [] {"jpg", "jpeg"});
			load.setFileFilter(filter);
			load.setAcceptAllFileFilterUsed(false);

			int flag = load.showDialog(null, "Load File");

			if (flag == 0)
			{
				File file = load.getSelectedFile();

				try 
				{
					ImageIO.read(file);
					pan = (PPanel) tabbedPane.getSelectedComponent();
					bi = pan.getBufferedImage();
					pan.bi = ImageIO.read(file);
					pan.repaint();
					
				} 

				catch (Exception e2) 
				{
					e2.printStackTrace();

				}

			}
		}
	}

	class ActionAddTab implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			tabbedPane.addTab("Tab " + indexTab++, new PPanel());

		}

	}

	class ActionDelTab implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			int select = tabbedPane.getSelectedIndex();
			if (select >= 0) {
				tabbedPane.removeTabAt(select);
			}
		}
	}
}
