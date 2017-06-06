import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JToolBar;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Preprost program za risanje slikic.
 * 
 * @author andrej
 *
 */
public class Slikarija extends JFrame implements ActionListener, ChangeListener {
	public static Object izbranaBarva;
	private JButton zbrisiGumb;
	private JButton barvaGumb;
	private Platno platno;
	private JSpinner spin;


	public Slikarija() {
		getContentPane().setLayout(new GridBagLayout());

		// Orodna vrstica
		JToolBar toolBar = new JToolBar();
		GridBagConstraints barConstraint = new GridBagConstraints();
		barConstraint.gridx = 0;
		barConstraint.gridy = 0;
		barConstraint.weightx = 1; // se razteguje vodoravno
		barConstraint.anchor = GridBagConstraints.WEST; // je na levi strani
		getContentPane().add(toolBar, barConstraint);

		// podroƒçje za risanje
		platno = new Platno();
		GridBagConstraints platnoConstraint = new GridBagConstraints();
		platnoConstraint.gridx = 0;
		platnoConstraint.gridy = 1;
		platnoConstraint.fill = GridBagConstraints.BOTH; // se razteguje v vse smeri
		platnoConstraint.weightx = 1; // zavzame ves prostor vodoravno
		platnoConstraint.weighty = 1; // zavzame ves prostor navpiƒçno
		getContentPane().add(platno, platnoConstraint);

		// gumb za brisanje
		zbrisiGumb = new JButton("Zbriöi");
		zbrisiGumb.addActionListener(this);
		toolBar.add(zbrisiGumb);

		// gumba za izbiranje barve
		barvaGumb = new JButton("Barva");
		barvaGumb.setOpaque(true); // da se bo videlo barvo gumba
		barvaGumb.setBorderPainted(false); // da se bo dejansko pobarvalo ozadje
		barvaGumb.addActionListener(this);
		toolBar.add(barvaGumb);
		pobarvajBarvaGumb(platno.izbranaBarva);
		
		//Nastavljanje debeline
		spin = new JSpinner(new SpinnerNumberModel(platno.debelina, 1, 100, 1));
		spin.addChangeListener(this);
		toolBar.add(spin);
	}

	/**
	 * Nastavi ozadje gumba na podano barvo
	 * in barvo besedila na njej komplementarno barvo.
	 */
	/**
	 * @param barva barva ozadja
	 */
	private void pobarvajBarvaGumb(Color barva) {
		Color komplementarna =
				new Color(255 - barva.getRed(),
						  255 - barva.getGreen(),
						  255 - barva.getBlue());
		barvaGumb.setForeground(komplementarna);
		barvaGumb.setBackground(barva);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == zbrisiGumb) {
			platno.zbrisi();
		} else if (e.getSource() == barvaGumb) {
			Color izbranaBarva = JColorChooser.showDialog(this, "Barva »rte", platno.izbranaBarva);
			if (izbranaBarva!=null) {
			pobarvajBarvaGumb(izbranaBarva);
			platno.izbranaBarva = izbranaBarva; 
			}
		}

	}

	public static void main(String args[]) {
		Slikarija okno = new Slikarija();
		okno.pack();
		okno.setVisible(true);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		platno.debelina = (int) spin.getValue();
		
	}
}
