package partidoDeTenis;

public class Jugador {

	private String nombre;
	private Integer puntuacion;
	private Integer games;
	private Integer set;

	public Jugador(String nombre) {
		this.nombre = nombre;
		this.puntuacion = 0;
		this.games = 0;
		this.set = 0;
	}

	public String getNombre() {
		return nombre;
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
		this.set = this.set+1;
	}

	public String getGames() {
		return "Los games de " + this.nombre + " son " + this.games.toString();
	}
	
	public String getSet() {
		return "Los set de " +this.nombre+ " son "+ this.set.toString();
	}

}
