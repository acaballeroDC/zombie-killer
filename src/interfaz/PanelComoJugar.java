package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelComoJugar extends Componente {

	private static final String SALIR = "Salir";
	private PanelDatosCuriosos panelDatosC;
	private PanelArmas panelArmas;
	private JScrollPane scroll;
	private JButton butSalir;
	
	
	public PanelComoJugar (IInterfazZombieKiller inter) {
		setBackground(Color.BLACK);
		setLayout(new BorderLayout());
		super.setMediador(inter);
		panelDatosC = new PanelDatosCuriosos();
		panelArmas = new PanelArmas(super.m);
		butSalir = new JButton();
		configurarBoton(butSalir, getClass().getResource("/img/Palabras/volver.png"), SALIR);
		butSalir.setActionCommand(SALIR);
		JPanel aux = new JPanel ();
		aux.setLayout(new BorderLayout());
		aux.add(panelDatosC, BorderLayout.NORTH);
		aux.add(panelArmas, BorderLayout.CENTER);
		scroll = new JScrollPane(aux);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scroll, BorderLayout.CENTER);
		add(butSalir, BorderLayout.SOUTH);
	}
	
	public void configurarBoton (JButton aEditar, URL rutaImagen, String comando) {
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
				m.mostrarComoJugar();
			}
		});
	}
}
