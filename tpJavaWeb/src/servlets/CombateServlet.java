package servlets;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import business.*;
import entities.Personaje;

/**
 * Servlet implementation class CombateServlet
 */
@WebServlet("/CombateServlet")
public class CombateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CtrlCombate ctrl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CombateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Personaje p1 = (Personaje)request.getSession().getAttribute("Jugador1");
		Personaje p2 = (Personaje)request.getSession().getAttribute("Jugador2");
		
		String btn_accion = request.getParameter("accion");
		String energAtaque = request.getParameter("energiaAtaque");
		
		ctrl=CtrlCombate.getInstanciaUnica();
			if(ctrl == null){
				JOptionPane.showMessageDialog(null, "Ha habido un problema creando el controlador");
			}
			//this.setJugadores();
					
		
		
		if(btn_accion.equals("Atacar"))
		{
			if( energAtaque == null)
			{
				System.out.println("No se puede atacar con 0 energía");
			} 
			else{ 
				if(ctrl.atacar(Integer.parseInt(energAtaque)))
					{
						
						ctrl.finTurno();
						
					}else{
							if(ctrl.jugadorEvadio)
								{
									//JOptionPane.showMessageDialog(null, "Ataque Evadido");
								    System.out.println("ataque evadido");
									ctrl.finTurno();
						
						
								}else{
										if(ctrl.jugadorSinEnergia)
											{
											    System.out.println(ctrl.persTurno.getNombre() + "no dispone esa energia");
												//JOptionPane.showMessageDialog(null, ctrl.persTurno.getNombre() + " no dispone de esa energía");
											}else{
												System.out.println("fin del juego");
												System.out.println("ha ganado el personaje" + ctrl.persSinTurno.getNombre());
													//JOptionPane.showMessageDialog(null, "Fin del Juego");
													//JOptionPane.showMessageDialog(null, "Ha ganado el personaje " + ctrl.persSinTurno.getNombre());
													ctrl.asignarPuntos();
													
												 }
									  }
						  }
				}
		}

		else if(btn_accion.equals("Defender"))
		{
			ctrl.defender();
			ctrl.finTurno();
			 
			ctrl.getPersonajeTurno().getNombre(); //setTurno reemplazado por esta linea
		}
		
		//String name = request.getParameter("energiaAtaque");
		
		request.getRequestDispatcher("Combate.jsp").forward(request, response);
		
		
	}

}
