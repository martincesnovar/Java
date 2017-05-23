import java.awt.Color;
import java.awt.Graphics;

public class Izsek extends Lik {
	private int r;
	private int a;
	private int b;

	public Izsek(int x, int y, int a, int b, int r, Color barva) {
		super(x, y, barva);
		this.r = r;
		this.a = a;
		this.b = b;
		}


	public double ploscina() {
		return Math.PI*r*r*a;
	}
	
	public void narisiSe(Graphics g) {
		g.fillArc(x - r, y - r, 2 * r, 2 * r,360-a,b);
	}

}
