package ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.apache.logging.log4j.Level;
import javax.swing.JButton;

import entities.*;
import business.*;
import util.ApplicationException;
import util.SuperLogger;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ABMCPersonaje {
	
	private CtrlABMCPersonaje ctrl;

	private JFrame frame;
	private JTextField txtEnergia;
	private JTextField txtVida;
	private JTextField txtNombre;
	private JTextField txtId;
	private JTextField txtDefensa;
	private JTextField txtEvasion;
	private JTextField txtPtsTotales;
	private int puntosAnteriores;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCPersonaje window = new ABMCPersonaje();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public ABMCPersonaje() {
		initialize();
		ctrl= new CtrlABMCPersonaje();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 424, 341);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(12, 28, 70, 15);
		frame.getContentPane().add(lblId);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(142, 28, 114, 19);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
	
		JLabel lblDni = new JLabel("Nombre:");
		lblDni.setBounds(12, 56, 70, 15);
		frame.getContentPane().add(lblDni);
		
		
		txtNombre = new JTextField();
		txtNombre.setBounds(142, 57, 114, 19);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Vida:");
		lblNombre.setBounds(12, 84, 70, 15);
		frame.getContentPane().add(lblNombre);

		txtVida = new JTextField();
		txtVida.setBounds(142, 85, 114, 19);
		frame.getContentPane().add(txtVida);
		txtVida.setColumns(10);
		
		
		JLabel lblApellido = new JLabel("Energia:");
		lblApellido.setBounds(12, 113, 70, 15);
		frame.getContentPane().add(lblApellido);
		
		txtEnergia = new JTextField();
		txtEnergia.setBounds(142, 113, 114, 19);
		frame.getContentPane().add(txtEnergia);
		txtEnergia.setColumns(10);
		
		JLabel lblDefensa = new JLabel("Defensa:");
		lblDefensa.setBounds(12, 142, 79, 14);
		frame.getContentPane().add(lblDefensa);
		
		txtDefensa = new JTextField();
		txtDefensa.setBounds(142, 142, 114, 20);
		frame.getContentPane().add(txtDefensa);
		txtDefensa.setColumns(10);
		
		JLabel lblEvasion = new JLabel("Evasion:");
		lblEvasion.setBounds(12, 169, 86, 14);
		frame.getContentPane().add(lblEvasion);
		
		txtEvasion = new JTextField();
		txtEvasion.setBounds(142, 171, 114, 20);
		frame.getContentPane().add(txtEvasion);
		txtEvasion.setColumns(10);
		
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregar();
			}
		});
		btnAgregar.setBounds(285, 129, 117, 25);
		frame.getContentPane().add(btnAgregar);
		//Porq buscar es mouseAdapter y modificar es actionPerformed?
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificar();
			}
		});
		btnModificar.setBounds(285, 158, 117, 25);
		frame.getContentPane().add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eliminar();
			}
		});
		btnEliminar.setBounds(285, 191, 117, 25);
		frame.getContentPane().add(btnEliminar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscar();
			}
		});
		btnBuscar.setBounds(285, 17, 117, 25);
		frame.getContentPane().add(btnBuscar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] args = null;
				frame.dispose();
				Inicio.main(args);
			}
		});
		btnVolver.setBounds(285, 268, 114, 25);
		frame.getContentPane().add(btnVolver);
		
		JLabel lblPtsTotales = new JLabel("Puntos disponibles:");
		lblPtsTotales.setBounds(10, 202, 105, 14);
		frame.getContentPane().add(lblPtsTotales);
		
		txtPtsTotales = new JTextField();
		txtPtsTotales.setEnabled(false);
		txtPtsTotales.setBounds(142, 202, 114, 20);
		frame.getContentPane().add(txtPtsTotales);
		txtPtsTotales.setColumns(10);
		
			
		
	}
	
	protected void eliminar() {
		try 
		{
			ctrl.delete(MapearDeFormulario());
		}
		catch (ApplicationException appe)
		{
			notifyUser(appe.getMessage(),appe, Level.DEBUG);
		}
		limpiarCampos();
	}

	protected void modificar() {
		/*if(datosValidos()){
			
		try {
			
			Personaje p=MapearDeFormulario();
			
			if(ctrl.validarPuntos(p))
			{
			notifyUser("Personaje modificado con exito");
			limpiarCampos();
			}
			else
			{
				notifyUser("La distribucion de puntos no puede exceder los puntos disponibles");
			}
		} catch (ApplicationException ae) {
			notifyUser(ae.getMessage(),ae, Level.DEBUG);
		}
		 catch (ArithmeticException are){
			notifyUser("Ha ocurrido algo inesperado, consulte al administrador de sistemas.", are, Level.ERROR);
		} catch (Exception e){
			notifyUser("Ha ocurrido algo totalmente inesperado, consulte al administrador de sistemas.",e, Level.FATAL);
		} 
	}*/
		if(datosValidos()){
			try {
					
				//recuperar puntos
				Personaje p=MapearDeFormulario();
				
				if(200-ctrl.setPtsTotales(p)>=0)
				{
					ctrl.update(MapearDeFormulario());
					notifyUser("Personaje modificado con exito");
					limpiarCampos();
				}
				 
				else
				{
					if((ctrl.setPtsTotales(p)-puntosAnteriores)-200<0)
					{
						notifyUser("No se pueden asignar mas puntos que los disponibles");
					}
					
					else
					{
						ctrl.update(MapearDeFormulario());
						notifyUser("Personaje modificado con exito");
						limpiarCampos();
					}
				
			}
				
			} catch (ApplicationException ae) {
				notifyUser(ae.getMessage(),ae, Level.DEBUG);
			}
		}
	}

	protected void agregar() {
		if(datosValidos()){
			try {
							
				Personaje p=MapearDeFormulario();
				
				if(ctrl.validarPuntos(p))
				{
					notifyUser("La distribucion de puntos no puede ser mayor a 200");
				}
				else
				{
				ctrl.add(p);
				MapearAFormulario(p);
				
				notifyUser("Personaje agregado exitosamente");
				limpiarCampos();
				}
				
			} catch (ApplicationException ae) {
				notifyUser(ae.getMessage(),ae, Level.DEBUG);
			}
		}
	}
	
	
	
	
	private void limpiarCampos() {
		txtId.setText("");
		txtNombre.setText("");
		txtEnergia.setText("");
		txtVida.setText("");
		txtDefensa.setText("");
		txtEnergia.setText("");
		txtEvasion.setText("");
		txtPtsTotales.setText("");
		
	}

	protected void buscar() {
		Personaje p = ctrl.getPersonaje(MapearDeFormulario().getNombre());
		if(p!=null){
			MapearAFormulario(p);
		}
		else
		{
			notifyUser("No se ha encontrado el personaje");
		}
		
		puntosAnteriores=p.getPuntosTotales();
	}

	public void MapearAFormulario(Personaje p){
		
		
		txtId.setText(String.valueOf(p.getId()));
		txtNombre.setText(p.getNombre());
		txtVida.setText(String.valueOf(p.getVida()));
		txtEnergia.setText(String.valueOf(p.getEnergia()));
		txtDefensa.setText(String.valueOf(p.getDefensa()));
		txtEvasion.setText(String.valueOf(p.getEvasion()));
		//funcionaba
		
		if(p.getPuntosTotales()>=200)
		{
			txtPtsTotales.setText(String.valueOf(p.getPuntosTotales()-ctrl.setPtsTotales(p)));
		}
		else
		{
			txtPtsTotales.setText(String.valueOf(200-ctrl.setPtsTotales(p)));
		}
		
	}
	
	public Personaje MapearDeFormulario(){
		Personaje p = new Personaje();
		//adaptacion hecha para que haga 2 cosas diferentes si quiero buscar o agregar 
		if(txtVida.getText().isEmpty()) 
		{
			p.setNombre(txtNombre.getText());
		}
		else
		{
			p.setNombre(txtNombre.getText());
			p.setVida(Integer.parseInt(txtVida.getText()));
			p.setEnergia(Integer.parseInt(txtEnergia.getText()));
			p.setDefensa(Integer.parseInt(txtDefensa.getText()));
			p.setEvasion(Integer.parseInt(txtEvasion.getText()));
			p.setPuntosTotales(ctrl.setPtsTotales(p));
			
			/*if(this.setPtsTotales()<0)
			{
				p.setPuntosTotales(this.setPtsTotales());
				
			}
			else
			{
		
				p.setPuntosTotales(Integer.parseInt(txtPtsTotales.getText()));
			}*/
			
			
			
		}
			
		return p;
	}
	
	
	
	public boolean datosValidos(){
		boolean valido=true;
		if(txtNombre.getText().trim().length()==0
			|| txtVida.getText().trim().length()==0
			|| txtEnergia.getText().trim().length()==0
			|| txtDefensa.getText().trim().length()==0
			|| txtEvasion.getText().trim().length()==0)
		{
			valido=false;
			notifyUser("Complete todos los campos");
		}
			
		/*if(valido && !txtNombre.getText().matches("[0-9]*")){
			valido=false;
			notifyUser("DNI inválido");
		}*/
			
		return valido;
	}
	
	private void notifyUser(String mensaje) {
		JOptionPane.showMessageDialog(this.frame, mensaje);
	}

	private void notifyUser(String mensaje, Exception e, Level l) {
		notifyUser(mensaje);
		SuperLogger.logger.log(l, mensaje, e);
	}
}

