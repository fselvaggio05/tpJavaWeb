package business;

import java.io.InvalidClassException;


import data.dataPersonaje;
import entities.*;
import util.ApplicationException;

public class CtrlABMCPersonaje {
	private dataPersonaje dataPer;
    ///comentario Florencia2
	//otro comment andrea1
	public CtrlABMCPersonaje(){
		
		dataPer = new dataPersonaje();

	}
	
	public void add(Personaje p) throws ApplicationException{
	
			Personaje per=dataPer.getByNombre(p.getNombre());
			
			 if(per==null)
			 
			{
				dataPer.add(p);
			}
			
			else
			{
				throw new ApplicationException("El personaje ya existe");
			}
		//}
		
	}
	
	
	public void update(Personaje p) throws ApplicationException{
		
		
				dataPer.update(p);
				
			
	}
	
	public void delete(Personaje p) throws ApplicationException
	{
		
				dataPer.delete(p);
			
	}
	
	
	public Personaje getPersonaje(String nombre){
		return dataPer.getByNombre(nombre);
 	}
	
	public boolean validarPuntos(Personaje p)
	{
		int ptsTotales;
		ptsTotales=0;
		ptsTotales=p.getDefensa()+p.getEnergia()+p.getEvasion()+p.getVida();
		if(ptsTotales>200)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int setPtsTotales(Personaje p)
	{
		int pts; 
		pts=p.getDefensa()+p.getEnergia()+p.getEvasion()+p.getVida();
		
		return pts;
		
			
	}
	

}
