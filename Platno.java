import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

/**
 * Področje za risanje črt.
 * 
 * @author andrej
 *
 */
public class Platno extends JPanel implements MouseListener, MouseMotionListener {
	
	/**
	 * Vse zaključene lomljene črte, ki smo jih narisali do zdaj.
	 */
	private List<Lomljenka> vseCrte;

	/**
	 * Lomljena črta, ki jo trenutno rišemo ({@code null} če trenutno ne rišemo črte)
	 */
	private Lomljenka trenutnaCrta;
	protected Color izbranaBarva;
	protected int debelina;
	
	public Platno() {
		super(); //pokli�i konstruktor
		trenutnaCrta = null;
		vseCrte = new ArrayList<Lomljenka>();
		setBackground(Color.white);
		addMouseListener(this);
		addMouseMotionListener(this);
		izbranaBarva = Color.BLUE;
		debelina = 5;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Lomljenka l : vseCrte) {
			l.narisi((Graphics2D)g); //pretvori graphics v graphic2d
		}
		if (trenutnaCrta != null) {
			trenutnaCrta.narisi((Graphics2D)g);
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(640, 480);
	}
	
	public void zbrisi(){
		vseCrte = new ArrayList<Lomljenka>();
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (trenutnaCrta != null) {
			// Uporabnik je spustil miško, torej smo končali z risnjem črte
			vseCrte.add(trenutnaCrta);
		}
		trenutnaCrta = null;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (trenutnaCrta == null) {
			// nimam trenutne čte, zato jo naredimo
			trenutnaCrta = new Lomljenka(e.getX(), e.getY(), izbranaBarva, debelina);
		} else {
			// trenutno črto že imamo, zato ji dodamo točko
			trenutnaCrta.dodajTocko(e.getX(), e.getY());
		}
		repaint();  //ta komponenta se �eli ponovno narisati.
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}
}
