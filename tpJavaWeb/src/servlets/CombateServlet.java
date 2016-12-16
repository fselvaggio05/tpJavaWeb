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
		
		String energAtaque = request.getParameter("energiaAtaque");
			
		
		if(request.getParameter("atacar") != null)
		{
			if( energAtaque == null)
			{
				System.out.println("No se puede atacar con 0 energía");
			} else{ 
					if(ctrl.atacar(Integer.parseInt(energAtaque)))
						{
							
							/* Ver como haver para setear los valores de vida y energia en el formulario web
							 * p1.setEnergia();
							 * p2.setEnergia();
							 */
							ctrl.finTurno();
							//ctrl.setTurno();
							ctrl.getPersonajeTurno().getNombre(); //setTurno reemplazado por esta linea
							
						}else{
								if(ctrl.jugadorEvadio)
									{
										System.out.println("Ataque Evadido");
										ctrl.finTurno();
										//setEnergia();
										ctrl.getPersonajeTurno().getNombre(); //setTurno reemplazado por esta linea 
									}else{
											if(ctrl.jugadorSinEnergia)
												{
													System.out.println(ctrl.persTurno.getNombre() + " no dispone de esa energía");
												}else{
														
														System.out.println("Fin del Juego");
														System.out.println("Ha ganado el personaje " + ctrl.persSinTurno.getNombre());
														ctrl.asignarPuntos();
														
													 }
										  }
							  }
					}
			
		}
		else if(request.getParameter("defender") != null )
		{
			ctrl.defender();
			ctrl.finTurno();
			//setVida();
			//setEnergia();
			//setTurno(); 
			ctrl.getPersonajeTurno().getNombre(); //setTurno reemplazado por esta linea
		}
		
		String name = request.getParameter("energiaAtaque");
		
		
		
		
	}

}
