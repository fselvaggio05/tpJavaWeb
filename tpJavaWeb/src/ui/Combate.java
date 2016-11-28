package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Combate extends JFrame {  

	private JPanel contentPane;
	private JTextField txtEnergiaAtaque;
	private CtrlCombate ctrl;
	private JLabel lblJugador1;
	private JLabel lblJuagdor2;
	private JLabel lblVidaJugador1;
	private JLabel lblVidaJugador2;
	private JLabel lblEnergiaJugador1;
	private JLabel lblEnergiaJugador2;
	private JLabel lblDefensaJugador1;
	private JLabel lblEvasionJugador1;
	private JLabel lblDefensaJugador2;
	private JLabel lblEvasionJugador2;
	private JLabel lblJugadorTurno;
	
	

	/**
	 * Launch the application.
	 */
	public static void main() { 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Combate frame = new Combate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Combate() { //el parametro fue agregado para conservar la instancia del controlador creada en seleccionPersonajes
		initialize();
		ctrl=CtrlCombate.getInstanciaUnica();
		if(ctrl == null){
			JOptionPane.showMessageDialog(null, "Ha habido un problema creando el controlador");
		}
		this.setJugadores();
		this.setVida();
		this.setEnergia();
		this.setTurno();
		this.setDefensa();
		this.setEvasion();		
	}
	
	public void initialize(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPersonaje = new JLabel("Personaje 1:");
		lblPersonaje.setBounds(10, 11, 71, 14);
		contentPane.add(lblPersonaje);
		
		JLabel lblPersonaje_1 = new JLabel("Personaje 2:");
		lblPersonaje_1.setBounds(166, 11, 71, 14);
		contentPane.add(lblPersonaje_1);
		
		JLabel lblEnergia = new JLabel("Energ\u00EDa:");
		lblEnergia.setBounds(10, 61, 46, 14);
		contentPane.add(lblEnergia);
		
		JLabel lblVida = new JLabel("Vida:");
		lblVida.setBounds(10, 36, 29, 14);
		contentPane.add(lblVida);
		
		JLabel lblDefensa = new JLabel("Defensa:");
		lblDefensa.setBounds(10, 90, 57, 14);
		contentPane.add(lblDefensa);
		
		JLabel lblEvasin = new JLabel("Evasi\u00F3n:");
		lblEvasin.setBounds(10, 115, 57, 14);
		contentPane.add(lblEvasin);
		
		JLabel label = new JLabel("Vida:");
		label.setBounds(166, 36, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Energ\u00EDa:");
		label_1.setBounds(166, 61, 46, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Defensa:");
		label_2.setBounds(166, 90, 62, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Evasi\u00F3n:");
		label_3.setBounds(166, 115, 62, 14);
		contentPane.add(label_3);
		
		JLabel lblTurno = new JLabel("Turno:");
		lblTurno.setBounds(10, 155, 46, 14);
		contentPane.add(lblTurno);
		
		JLabel lblEnerga_1 = new JLabel("Energ\u00EDa:");
		lblEnerga_1.setBounds(10, 200, 46, 14);
		contentPane.add(lblEnerga_1);
		
		txtEnergiaAtaque = new JTextField();
		txtEnergiaAtaque.setBounds(66, 197, 57, 20);
		contentPane.add(txtEnergiaAtaque);
		txtEnergiaAtaque.setColumns(10);
		
		JButton btnAtacar = new JButton("Atacar");
		btnAtacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtEnergiaAtaque.getText() == null)
					{
						JOptionPane.showMessageDialog(null, "No se puede atacar con 0 energía");
					} else{ 
							if(ctrl.atacar(Integer.parseInt(txtEnergiaAtaque.getText())))
								{
									setVida();
									setEnergia();
									ctrl.finTurno();
									setTurno();
								}else{
										if(ctrl.jugadorEvadio)
											{
												JOptionPane.showMessageDialog(null, "Ataque Evadido");
												ctrl.finTurno();
												setEnergia();
												setTurno();
											}else{
													if(ctrl.jugadorSinEnergia)
														{
															JOptionPane.showMessageDialog(null, ctrl.persTurno.getNombre() + " no dispone de esa energía");
														}else{
																
																JOptionPane.showMessageDialog(null, "Fin del Juego");
																JOptionPane.showMessageDialog(null, "Ha ganado el personaje " + ctrl.persSinTurno.getNombre());
																ctrl.asignarPuntos();
																
															 }
												  }
									  }
							}
					}
			});
		
		btnAtacar.setBounds(166, 196, 89, 23);
		contentPane.add(btnAtacar);
		
		JButton btnDefender = new JButton("Defender");
		btnDefender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrl.defender();
				ctrl.finTurno();
				setVida();
				setEnergia();
				setTurno();
			}
		});
		btnDefender.setBounds(166, 222, 89, 23);
		contentPane.add(btnDefender);
		
		lblJugador1 = new JLabel("");
		lblJugador1.setBounds(88, 11, 79, 14);
		contentPane.add(lblJugador1);
		
		lblJuagdor2 = new JLabel("");
		lblJuagdor2.setBounds(248, 11, 90, 14);
		contentPane.add(lblJuagdor2);
		
		lblVidaJugador1 = new JLabel("");
		lblVidaJugador1.setBounds(77, 36, 46, 14);
		contentPane.add(lblVidaJugador1);
		
		lblVidaJugador2 = new JLabel("");
		lblVidaJugador2.setBounds(238, 36, 46, 14);
		contentPane.add(lblVidaJugador2);
		
		lblDefensaJugador1 = new JLabel("");
		lblDefensaJugador1.setBounds(77, 90, 46, 14);
		contentPane.add(lblDefensaJugador1);
		
		lblEvasionJugador1 = new JLabel("");
		lblEvasionJugador1.setBounds(77, 115, 46, 14);
		contentPane.add(lblEvasionJugador1);
		
		lblEnergiaJugador2 = new JLabel("");
		lblEnergiaJugador2.setBounds(238, 61, 46, 14);
		contentPane.add(lblEnergiaJugador2);
		
		lblDefensaJugador2 = new JLabel("");
		lblDefensaJugador2.setBounds(238, 90, 46, 14);
		contentPane.add(lblDefensaJugador2);
		
		lblEvasionJugador2 = new JLabel("");
		lblEvasionJugador2.setBounds(238, 115, 46, 14);
		contentPane.add(lblEvasionJugador2);
		
		lblJugadorTurno = new JLabel("");
		lblJugadorTurno.setBounds(66, 155, 146, 14);
		contentPane.add(lblJugadorTurno);
		
		lblEnergiaJugador1 = new JLabel("");
		lblEnergiaJugador1.setBounds(77, 61, 46, 14);
		contentPane.add(lblEnergiaJugador1);
		
	}

	public void setJugadores()
	{
			lblJugador1.setText(ctrl.jugador1.getNombre());
			lblJuagdor2.setText(ctrl.jugador2.getNombre());
	}
	
	public void setResultado()
	{
		
	}
	public void setVida()
	{
		lblVidaJugador1.setText(String.valueOf(ctrl.getJugador1().getVidaActual()));
		lblVidaJugador2.setText(String.valueOf(ctrl.getJugador2().getVidaActual()));
	}
	
	public void setEnergia()
	{
		lblEnergiaJugador1.setText(String.valueOf(ctrl.getJugador1().getEnergiaActual()));
		lblEnergiaJugador2.setText(String.valueOf(ctrl.getJugador2().getEnergiaActual()));
	}
	
	public void setDefensa()
	{
		lblDefensaJugador1.setText(String.valueOf(ctrl.getJugador1().getDefensa()));
		lblDefensaJugador2.setText(String.valueOf(ctrl.getJugador2().getDefensa()));
	}
	
	public void setEvasion()
	{
		lblEvasionJugador1.setText(String.valueOf(ctrl.getJugador1().getEvasion()));
		lblEvasionJugador2.setText(String.valueOf(ctrl.getJugador2().getEvasion()));
	}
	
	public void setTurno()
	{
		lblJugadorTurno.setText(String.valueOf(ctrl.getPersonajeTurno().getNombre()));
	}
}
