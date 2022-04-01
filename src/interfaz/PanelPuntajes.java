package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mundo.Puntaje;

public class PanelPuntajes extends JPanel implements ActionListener {

	private static final String ORDEN_HEADSHOT = "Filtrar por tiros a la cabeza";
	private static final String ORDEN_BAJAS = "Filtrar por bajas";
	private static final String ORDEN_SCORE = "Filtrar por puntaje";
	private static final String BUSCAR_NOMBRE = "Buscar por nombre";
	private static final String SALIR = "salir";

	private JLabel titulo;
	private JLabel[] labScores;
	private JLabel[] labNombres;
	private JLabel[] labHeadShots;
	private JLabel[] labBajas;
	private JButton butFiltroHeadShot;
	private JButton butBuscarNombre;
	private JButton butFiltroBajas;
	private JButton butFiltroScore;
	private JButton butSalir;
	private InterfazZombieKiller principal;

	public PanelPuntajes(InterfazZombieKiller inter) {
		principal = inter;
		setBackground(Color.black);
		Font f = new Font("Chiller", Font.BOLD, 26);
		titulo = new JLabel("Puntajes");
		titulo.setForeground(Color.WHITE);
		butFiltroHeadShot = new JButton(ORDEN_HEADSHOT);
		butFiltroHeadShot.addActionListener(this);
		butFiltroHeadShot.setActionCommand(ORDEN_HEADSHOT);
		butBuscarNombre = new JButton(BUSCAR_NOMBRE);
		butBuscarNombre.addActionListener(this);
		butBuscarNombre.setActionCommand(BUSCAR_NOMBRE);
		butFiltroBajas = new JButton(ORDEN_BAJAS);
		butFiltroBajas.addActionListener(this);
		butFiltroBajas.setActionCommand(ORDEN_BAJAS);
		butFiltroScore = new JButton(ORDEN_SCORE);
		butFiltroScore.addActionListener(this);
		butFiltroScore.setActionCommand(ORDEN_SCORE);
		butSalir = new JButton();
		configurarBoton(butSalir, getClass().getResource("/img/Palabras/volver.png"), SALIR);
		butSalir.setActionCommand(SALIR);
		JLabel texto = new JLabel("No se encontraron puntajes");
		texto.setForeground(Color.WHITE);
		titulo.setFont(f);
		setLayout(new BorderLayout());
		add(titulo, BorderLayout.NORTH);
		add(texto, BorderLayout.CENTER);
		add(butSalir, BorderLayout.SOUTH);
	}

	public void actualizarPuntajes(ArrayList<Puntaje> scores) {
		if (scores.size() != 0) {
			removeAll();
			add(titulo, BorderLayout.NORTH);
			generaryAgregarLabels(scores);
			generarYAgregarBotones();
			updateUI();
		}
	}

	private void generaryAgregarLabels(ArrayList<Puntaje> scores) {
		int SCORES_LIMIT = 2;
		labScores = new JLabel[scores.size()];
		labNombres = new JLabel[scores.size()];
		labHeadShots = new JLabel[scores.size()];
		labBajas = new JLabel[scores.size()];
		JPanel auxPuntajes = new JPanel();
		auxPuntajes.setBackground(Color.black);
		if (scores.size() > SCORES_LIMIT) {
			auxPuntajes.setLayout(new GridLayout(11, 4));
			titulo.setText(String.format("Top %d Mejores Puntajes", SCORES_LIMIT));
		} else
			auxPuntajes.setLayout(new GridLayout(scores.size() + 1, 4));
		JLabel labScore = new JLabel("Score");
		labScore.setForeground(Color.WHITE);
		JLabel labNombre = new JLabel("Nombre");
		labNombre.setForeground(Color.WHITE);
		JLabel labTC = new JLabel("Headshots");
		labTC.setForeground(Color.WHITE);
		JLabel labKills = new JLabel("Bajas");
		labKills.setForeground(Color.WHITE);
		auxPuntajes.add(labNombre);
		auxPuntajes.add(labScore);
		auxPuntajes.add(labKills);
		auxPuntajes.add(labTC);
		ListIterator<Puntaje> scoresIterator = scores.listIterator();
		while (scoresIterator.hasNext()) {
			int scoreIndex = scoresIterator.nextIndex();
			if (scoreIndex < SCORES_LIMIT) {
				Puntaje scoreValue = scoresIterator.next();
				labScores[scoreIndex] = new JLabel(scoreValue.getPuntaje() + "");
				labScores[scoreIndex].setForeground(Color.WHITE);
				labNombres[scoreIndex] = new JLabel(scoreValue.getNombreKiller());
				labNombres[scoreIndex].setForeground(Color.WHITE);
				labHeadShots[scoreIndex] = new JLabel(scoreValue.getTirosALaCabeza() + "");
				labHeadShots[scoreIndex].setForeground(Color.WHITE);
				labBajas[scoreIndex] = new JLabel(scoreValue.getBajas() + "");
				labBajas[scoreIndex].setForeground(Color.WHITE);
				auxPuntajes.add(labNombres[scoreIndex]);
				auxPuntajes.add(labScores[scoreIndex]);
				auxPuntajes.add(labBajas[scoreIndex]);
				auxPuntajes.add(labHeadShots[scoreIndex]);
			}
		}
		add(auxPuntajes, BorderLayout.CENTER);
	}
	
	private void generarYAgregarBotones () {
		JPanel auxBotones = new JPanel();
		auxBotones.setBackground(Color.black);
		auxBotones.setLayout(new GridLayout(5, 1));
		auxBotones.add(butFiltroHeadShot);
		auxBotones.add(butFiltroBajas);
		auxBotones.add(butFiltroScore);
		auxBotones.add(butBuscarNombre);
		auxBotones.add(butSalir);
		add(auxBotones, BorderLayout.SOUTH);
	}

	public void mostrarPuntajeDe(Puntaje buscado) {
		if (buscado != null) {
			JLabel encontrado = new JLabel("Mejor puntaje del nombre buscado");
			Font f = new Font("Chiller", Font.BOLD, 26);
			encontrado.setFont(f);
			encontrado.setForeground(Color.WHITE);
			removeAll();
			add(encontrado, BorderLayout.NORTH);
			generarYAgregarBotones();
			ArrayList<Puntaje> aMostrar = new ArrayList<>();
			aMostrar.add(buscado);
			generaryAgregarLabels(aMostrar);
			updateUI();
		} else
			JOptionPane.showMessageDialog(this, "No se encontr� el nombre buscado en los puntajes");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String c = arg0.getActionCommand();
		if (c.equals(ORDEN_BAJAS))
			principal.ordenarPorBajas();
		else if (c.equals(ORDEN_HEADSHOT))
			principal.ordenarPorHeadshot();
		else if (c.equals(BUSCAR_NOMBRE))
			principal.buscarPorNombre();
		else if (c.equals(ORDEN_SCORE))
			principal.ordenarPorScore();
	}

	public void configurarBoton(JButton aEditar, URL rutaImagen, String comando) {
		aEditar.setBorder(null);
		aEditar.setFocusable(false);
		aEditar.setContentAreaFilled(false);
		aEditar.setActionCommand(comando);
		ImageIcon letras = new ImageIcon(rutaImagen);
		aEditar.setIcon(letras);
		aEditar.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon iI = new ImageIcon(getClass().getResource("/img/Palabras/volver.png"));
				butSalir.setIcon(iI);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				ImageIcon iI = new ImageIcon(getClass().getResource("/img/Palabras/volver_p.png"));
				butSalir.setIcon(iI);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				principal.mostrarPuntajes();
			}
		});
	}
}
