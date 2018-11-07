package entidades;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

import objetos.Objetos;
import objetos.Pelota;

/**
 * @author ibai
 *
 */
public class Equipo{
	private Pelota bolaEquipo;
	private String nombre;		
	
	private char siglas; // Char para crear un formato de reconocimiento de siglas con lo dado en clase
	
	private int puntos;
	

	
	private ArrayList<Partidos> arrayPartidosJugados;
	
////////////////////////////Atributos para estadísticas///////////////////////////////////////////////////
	private int golesEnContraTotales;
	private int golesEnContraVisitante;
	private int golesEnContraLocal;
	
	private int golesAFavorTotales;
	private int golesAFavorVisitante;
	private int golesAFavorLocal;
	
	private int victoriasTotales;
	private int victoriasLocal;
	private int victoriasVisitante;
	
	private int derrotasTotales;
	private int derrotasLocal;
	private int derrotasVisitante;
	
	private int empatesTotales;
	private int empatesLocal;
	private int empatesVisitante;
	

	

	public Equipo(String nombre, double radio, Color color, char siglas) {
		bolaEquipo = new Pelota(color,nombre,75);
		bolaEquipo.setBota(false);
	}

	public Equipo(String nombre, double radio, Image imagen, char[] siglas) {
		bolaEquipo = new Pelota(imagen,nombre,75);
		bolaEquipo.setBota(false);
	}
	/** Metodo para añadir puntos al equipo segun el partido
	 * @param puntos Puntos a sumar, seran 0, 1 o 3
	 */
	public void anyadirPuntos(int puntos) {
		this.puntos += puntos;
	}

	/** Metodo para guardar el partido jugado por el Equipo
	 * @param partido	Partido jugado
	 */
	public void anyadirPartidoJugado(Partidos partido) {
		arrayPartidosJugados.add(partido);
	}
	
	/**	Metodo para añadir estadisticas cuando el equipo juega de Visitante
	 * @param haGanado			true si gana, false si empata o pierde
	 * @param haEmpatado 		true si empata, false si pierde
	 * @param golesAFavor		goles marcados por el equipo
	 * @param golesEnContra		goles encajados al equipo
	 */
	public void anyadirEstadisticasVisitante(boolean haGanado, boolean haEmpatado, int golesAFavor, int golesEnContra) {
		if(!haGanado) {
			if(haEmpatado){empatesVisitante += 1;}
			else if(!haEmpatado) {derrotasVisitante += 1;}
			}
		else if(haGanado) {victoriasVisitante += 1;}
		
		golesAFavorVisitante += golesAFavor;
		golesEnContraVisitante += golesEnContra;
		calcularEstadisticasTotales();
	}
	
	/**	Metodo para añadir estadisticas cuando el equipo juega de LOCAL
	 * @param haGanado			true si gana, false si empata o pierde
	 * @param haEmpatado 		true si empata, false si pierde
	 * @param golesAFavor		goles marcados por el equipo
	 * @param golesEnContra		goles encajados al equipo
	 */
	public void anyadirEstadisticasLocal(boolean haGanado, boolean haEmpatado, int golesAFavor, int golesEnContra) {
		if(!haGanado) {
			if(haEmpatado){empatesLocal += 1;}
			else if(!haEmpatado) {derrotasLocal += 1;}
			}
		else if(haGanado) {victoriasLocal += 1;}
		
		golesAFavorLocal += golesAFavor;
		golesEnContraLocal += golesEnContra;
		calcularEstadisticasTotales();
	}
	
	/** Metodo que calcula las estadisticas totales partiendo de las estadisticas locales y visitantes
	 */
	private void calcularEstadisticasTotales() {
		derrotasTotales = derrotasVisitante + derrotasLocal;
		victoriasTotales = victoriasVisitante + victoriasLocal;
		empatesTotales = empatesVisitante + empatesLocal;
		
		golesAFavorTotales = golesAFavorVisitante + golesAFavorLocal;
		golesEnContraTotales = golesEnContraVisitante + golesEnContraLocal;
	}
	
	/** Metodo para añadir un partido a la lista de partidos jugados del equipo
	 * @param p	Partido jugado
	 */
	public void anyadirPartido(Partidos p) {
		arrayPartidosJugados.add(p);
		
	}

	public String getNombre() {
		return nombre;
	}

	public char getSiglas() {
		return siglas;
	}

	public int getPuntos() {
		return puntos;
	}


	public ArrayList<Partidos> getArrayPartidosJugados() {
		return arrayPartidosJugados;
	}

	public int getGolesEnContraTotales() {
		return golesEnContraTotales;
	}

	public int getGolesEnContraVisitante() {
		return golesEnContraVisitante;
	}

	public int getGolesEnContraLocal() {
		return golesEnContraLocal;
	}

	public int getGolesAFavorTotales() {
		return golesAFavorTotales;
	}

	public int getGolesAFavorVisitante() {
		return golesAFavorVisitante;
	}

	public int getGolesAFavorLocal() {
		return golesAFavorLocal;
	}

	public int getVictoriasTotales() {
		return victoriasTotales;
	}

	public int getVictoriasLocal() {
		return victoriasLocal;
	}

	public int getVictoriasVisitante() {
		return victoriasVisitante;
	}

	public int getDerrotasTotales() {
		return derrotasTotales;
	}

	public int getDerrotasLocal() {
		return derrotasLocal;
	}

	public int getDerrotasVisitante() {
		return derrotasVisitante;
	}

	public int getEmpatesTotales() {
		return empatesTotales;
	}

	public int getEmpatesLocal() {
		return empatesLocal;
	}

	public int getEmpatesVisitante() {
		return empatesVisitante;
	}
	
	

}
