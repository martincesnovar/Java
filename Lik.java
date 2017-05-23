import java.awt.Color;
import java.awt.Graphics;

public abstract class Lik {
	protected int x;
	protected int y;
	protected Color barva;
	
	/**
	 * @param x abcisa referenčne točke
	 * @param y ordinata referenčne točke
	 */
	public Lik(int x, int y, Color barva) {
		super();
		this.x = x;
		this.y = y;
		this.barva = barva;
	}
	
	public void premakni(int dx, int dy) {
		x += dx;
		y += dy;
	}
	
	public abstract double ploscina();
	
	public abstract void narisiSe(Graphics g);

}
