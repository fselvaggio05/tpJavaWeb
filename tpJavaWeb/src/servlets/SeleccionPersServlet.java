package servlets;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.*;
import entities.Personaje;


/**
 * Servlet implementation class ABMServlet
 */
@WebServlet("/SeleccionPersServlet")
public class SeleccionPersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeleccionPersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Typo obj= (Typo)request.getSession().getAttribute("atrib");
		//request.getSession().setAttribute("atrib", objeto);
		//jsp -> session.getAttribute(...) o session.setAttribute(...) 
		String jugador1 = request.getParameter("txtJugador1");
		String jugador2 = request.getParameter("txtJugador2");
		Personaje per1, per2;
		
		CtrlABMCPersonaje ctrlABM = new CtrlABMCPersonaje();
		
		per1= ctrlABM.getPersonaje(jugador1);
		per2= ctrlABM.getPersonaje(jugador2);
		
		if(per1 == null )
		{
			System.out.println("El personaje 1 no existe");
		}
		
		else if(per2 == null)
		{
			System.out.println("El personaje 1 no existe");
		}
			else{
				per2 = ctrlABM.getPersonaje(jugador2);
				request.getSession().setAttribute("Jugador1", per1);
				request.getSession().setAttribute("Jugador", per2);
		
				}
		
		
		//response.sendRedirect("WEB-INF/war.jsp");
		request.getRequestDispatcher("/Combate.jsp").forward(request, response);
		
		
		
		
		
	}

}
