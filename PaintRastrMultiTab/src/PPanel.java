import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class PPanel extends JPanel implements IPaintComponent
{
	BufferedImage bi = new BufferedImage(600, 500, BufferedImage.SCALE_DEFAULT);
	PComand pComand = PComand.getInstance();
	
	
	public PPanel()
	{
		setLayout(null);
		setBackground(Color.white);
		setBounds(5, 60, 595, 500);

		addMouseListener(pComand.aPress);
		addMouseMotionListener(pComand.aDragged);

		Graphics2D gg = (Graphics2D) bi.getGraphics();
		gg.setBackground(Color.white);
		gg.fillRect(0, 0, 600, 500);
		
		pComand.setPanel(this);
		setComponentPopupMenu(ContextMenu.getInstance());
	
	}

	public BufferedImage getBufferedImage()
	{
		return bi;
	}

	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);

		Graphics2D gg = (Graphics2D) g;
		gg.drawImage(bi, null, 0, 0);
	}

	@Override
	public void drawLine(int x, int y, int x2, int y2, int width, Color color) 
	{
		Graphics2D gg =  (Graphics2D) bi.getGraphics();
		gg.setColor(color);
		gg.setStroke(new BasicStroke(width));
		gg.drawLine(x, y, x2, y2);

		repaint();

	}

	@Override
	public void drawOwal(int x, int y, int sizeWidth, int sizeHeigth, int width, Color color) 
	{
		Graphics2D gg =  (Graphics2D) bi.getGraphics();
		gg.setColor(color);
		gg.setStroke(new BasicStroke(width));
		gg.drawOval(x, y, sizeWidth, sizeHeigth);

		repaint();

	}
	@Override
	public void drawRect(int x, int y, int sizeWidth, int sizeHeigth, int width, Color color) 
	{
		Graphics2D gg =  (Graphics2D) bi.getGraphics();
		gg.setColor(color);
		gg.setStroke(new BasicStroke(width));
		gg.drawRect(x, y, sizeWidth, sizeHeigth);

		repaint();

	}


}
