import java.awt.Color;
import java.util.Vector;

import javax.swing.JFrame;

public class GlavniProgram {

	public static void main(String[] args) {
		Vector<Lik> mojiLiki = new Vector<Lik>();
		mojiLiki.add(new Krog(30, 40, 100, Color.gray));
		mojiLiki.add(new Elipsa(200, 160, 100,120, Color.green));
		mojiLiki.add(new Trikotnik(380, 40, 400,20,20,40, Color.yellow));
		mojiLiki.add(new Izsek(480, 140, 80,120, 150, Color.red));
		for (int x = 100; x < 500; x += 40) {
			mojiLiki.add(new Kvadrat(x, 270, 30, Color.blue));
		}
		JFrame okno = new GeoFrame(mojiLiki);
		okno.pack();
		okno.setVisible(true);
	}

}
