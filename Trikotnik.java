import java.awt.Color;
import java.awt.Graphics;

public class Trikotnik extends Lik {

	private int x2;
	private int x3;
	private int y2;
	private int y3;

	/**
	 * @param x - abcisa spodnjega levega vozlišča
	 * @param y - ordinata spodnjega levega vozlišča
	 * @param x2,y2,... - ostale to�ke
	 */
	public Trikotnik(int x, int y, int x2, int y2, int x3, int y3, Color barva) {
		super(x, y, barva);
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
	}
	
	public double ploscina() {
		int dx2 = x2-x;
		int dx3 = x3-x;
		int dy2 = y2-x;
		int dy3 = y3-y;
		return 1/2*Math.abs(dx2*dy3-dx3*dy2);
	}
	
	@Override
	public void narisiSe(Graphics g) {
		g.fillPolygon(new int[] {x, x2, x3}, new int[] {y, y2, y3}, 3);
	}
	
}
