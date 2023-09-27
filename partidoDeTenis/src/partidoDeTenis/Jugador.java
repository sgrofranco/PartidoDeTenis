package partidoDeTenis;

public class Jugador {

	private String nombre;
	private Integer puntuacion;
	private Integer games;
	private Integer set;
	private Boolean enDeuce;

	public Jugador(String nombre) {
		this.nombre = nombre;
		this.puntuacion = 0;
		this.games = 0;
		this.set = 0;
		this.enDeuce = false;
	}

	public String getNombre() {
		return nombre;
	}

	 public void setDeuce(boolean enDeuce) {
	        this.enDeuce = enDeuce;
	 }
	 
	 public Boolean getDeuce() {
	        return this.enDeuce;
	 }
	
	public String getPuntuacion() {
		return "La puntuacion de " + this.nombre + " es " + this.puntuacion.toString();
	}

	public void pelotaGanada() {
		if (this.puntuacion == 40) {
			this.puntuacion = 0;
			gameGanado();
		} else if (this.puntuacion < 30) {
			this.puntuacion = this.puntuacion + 15;
		} else {
			this.puntuacion = this.puntuacion + 10;
		}
	}

	private void gameGanado() {
		
		if( this.games<5) {
			this.games = this.games + 1;
		} else {
			this.games = 0;
			setGanado();
		}
	}
	
	private void setGanado() {
		if(this.set< 2) {	
			this.set = this.set+1;
		} else {
			jugadorGano();
		}
	}

	private void jugadorGano() {
		System.out.println("Ha ganado el jugador "+this.nombre);
		reiniciarEstadisticas();
		
	}

	public String getGames() {
		return "Los games de " + this.nombre + " son " + this.games.toString();
	}
	
	public String getSet() {
		return "Los set de " +this.nombre+ " son "+ this.set.toString();
	}
	
	private void reiniciarEstadisticas() {
		this.games = 0;
		this.puntuacion = 0;
		this.set = 0;
	}

}
