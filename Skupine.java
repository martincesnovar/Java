import java.awt.Color;
import java.awt.Graphics;
public class Skupine extends Lik {

	private Lik[] liki;

	public Skupine(int x, int y, Lik[] liki, Color barva) {
		super(x, y, barva);
		this.liki = liki;
		}
	
	@Override
	public double ploscina() {
		double vsota_ploscin = 0;
		for (Lik lik: liki) {
			vsota_ploscin += lik.ploscina();
			
		}
		return vsota_ploscin;
	}
	
	@Override
	public void narisiSe(Graphics g) {
		g.translate(x, y);
		for (Lik lik: liki) {
			lik.narisiSe(g);	
		}
	
	}

}