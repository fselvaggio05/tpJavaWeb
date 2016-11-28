package business;

import entities.*;
import data.*;

public class CtrlCombate {
	
	private static CtrlCombate ctrlCombate;
	
	public Personaje jugador1, jugador2, persTurno, persSinTurno;
	private dataPersonaje dataPer;
	private int turno=0;
	public boolean jugadorSinVida, jugadorEvadio, jugadorSinEnergia;
		
	
	
	private CtrlCombate()
	{
		dataPer = new dataPersonaje();
		persTurno = new Personaje();
	}
	
	
	public static CtrlCombate getInstanciaUnica()
	{
		if (ctrlCombate==null)
		{
			ctrlCombate = new CtrlCombate();
		}
		
		else
		{
			//
		}
		
		return ctrlCombate;
		
	}
	
	
	public void setJugadores(Personaje p1, Personaje p2)
	{
		this.jugador1=p1;
		this.jugador2=p2;
		this.persTurno=this.jugador1;
		this.persSinTurno=this.jugador2;
	}
	
	public Personaje getJugador1()
	{
		return this.jugador1;
	}
	
	public Personaje getJugador2()
	{
		return jugador2;
	}
	
	public boolean atacar(int energiaUsada)
	{
		if(this.persSinTurno.getVidaActual()>0 && this.persTurno.getVidaActual()>0)
		{
		  if(this.persTurno.getEnergiaActual()>= energiaUsada)
		  {
			this.persTurno.atacar(energiaUsada);
			
			if(this.persSinTurno.recibirAtaque(energiaUsada))
				{
					this.jugadorEvadio = true;
					this.jugadorSinEnergia = false;
					this.jugadorSinVida = false;
					return false;
				} else{
						/*if(this.persTurno.getEnergiaActual()<energiaUsada)
							{
								this.jugadorSinEnergia = true; //cambiado por false 
								this.jugadorSinVida = false;
								this.jugadorEvadio = false;*/
								return true;
							}
					   }		
		  this.jugadorSinEnergia = true; //cambiado por false 
		  this.jugadorSinVida = false;
		  this.jugadorEvadio = false;
		  return false;
		  
		} else
			{
				jugadorSinVida = true;
				jugadorEvadio = false;
				jugadorSinEnergia = false;
				return false;
			}
	}
	
	public void defender(){
		persTurno.defender();
	}
	
	public void finTurno()
	{
		
			if(!(turno%2==0))
			{
				persTurno=jugador1;
				persSinTurno=jugador2;
			}
			else
			{
				persTurno=jugador2;
				persSinTurno=jugador1;
			}
			
			turno++;		
	}
	
	
	public Personaje getPersonajeTurno()
	{			
			return persTurno;
	}
	
	
	public Personaje getPersSinTurno(){
		return persSinTurno;
	}	
	
	public void asignarPuntos()
	{
		dataPer.updatePuntos(this.persSinTurno,10);
	}

}
