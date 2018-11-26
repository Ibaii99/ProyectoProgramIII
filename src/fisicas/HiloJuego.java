package fisicas;

import entidades.Equipo;
import objetos.Pelota;
import ventanas.ventanaPartido;

public class HiloJuego extends Thread {
	
	private FisicasNuevas fisicas = new FisicasNuevas();
	private Pelota p;
	private Equipo eLocal;
	private Equipo eVisitante;
	private ventanaPartido v;

	public HiloJuego(Pelota p, Equipo eLocal, Equipo eVisitante, ventanaPartido v) {
		this.p = p;
		this.eLocal = eLocal;
		this.eVisitante = eVisitante;
		this.v = v;
	}
		
	@Override
	public synchronized void start() {
		while(true) {
		fisicas.choquePelotaBorde(v, p);
		fisicas.choquePelotaEquipo(p, eLocal);
		fisicas.muevePelota(p, fisicas.TIEMPO, v);
		fisicas.choquePelotaEquipo(p, eVisitante);
		fisicas.muevePelota(p, fisicas.TIEMPO, v);
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		v.actualizarPosicionObjetos();
		v.actualizarCampo();
		System.out.println("--------------------------Pelota-------------------------------------");
		System.out.println("x: "+p.getX()+ "  y: "+ p.getY());	
		System.out.println("velX: "+p.getVelX() + "  velY: "+p.getVelY());
		System.out.println("--------------------------Equipo local -------------------------------------");
		System.out.println("x: "+eLocal.getBolaEquipo().getX()+ "  y: "+ eLocal.getBolaEquipo().getY());	
		System.out.println("velX: "+eLocal.getBolaEquipo().getVelX() + "  velY: "+eLocal.getBolaEquipo().getVelY());
		System.out.println("--------------------------Equipo visitante -------------------------------------");
		System.out.println("x: "+eVisitante.getBolaEquipo().getX()+ "  y: "+ eVisitante.getBolaEquipo().getY());	
		System.out.println("velX: "+eVisitante.getBolaEquipo().getVelX() + "  velY: "+eVisitante.getBolaEquipo().getVelY());}
		
		}
	}


