import java.awt.Color;
import java.awt.Graphics;

public class Elipsa extends Lik {
	private int a;
	private int b;

	public Elipsa(int x, int y, int a, int b, Color barva) {
		super(x, y, barva);
		this.a = a;
		this.b = b;
	}
	
	public double ploscina() {
		return Math.PI*a*b;
	}
	
	@Override
	public void narisiSe(Graphics g) {
		g.fillOval(x - a, y - b, 2 * a, 2 * b);
	}
}
