import java.awt.Color;

public interface IPaintComponent 
{
	public void drawLine(int x, int y, int x2, int y2, int width, Color color);
	public void drawOwal(int x, int y, int sizeWidth, int sizeHeigth, int width, Color color);
	public void drawRect(int x, int y, int sizeWidth, int sizeHeigth, int width, Color color);
}
