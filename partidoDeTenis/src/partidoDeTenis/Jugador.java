package partidoDeTenis;

public class Jugador {

	private String nombre;
	private Integer puntuacion;
	private Integer games;
	private Integer set;
	private Boolean enDeuce;
	private Boolean enVentaja;
	private Boolean ganador;
	private Boolean enTieBreak;

	public Jugador(String nombre) {
		this.nombre = nombre;
		this.puntuacion = 0;
		this.games = 0;
		this.set = 0;
		this.enDeuce = false;
		this.enVentaja = false;
		this.ganador = false;
		this.enTieBreak = false;
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

	public Integer getPuntuacion() {
		return this.puntuacion;
	}

	public void pelotaGanada() {
		if(enDeuce) {
			if(enVentaja) {
				this.puntuacion = 0;
				gameGanado();
			} else {
				setVentaja(true);
			}
			
		} else {		
			if (this.puntuacion == 40) {
				this.puntuacion = 0;
				gameGanado();
			} else if (this.puntuacion < 30) {
				this.puntuacion = this.puntuacion + 15;
			} else {
				this.puntuacion = this.puntuacion + 10;
			}
		}
	}

	public void setVentaja(boolean enVentaja) {
		if (enVentaja) {
			if (this.enDeuce) {
				this.enVentaja = enVentaja;
			}
		} else {
			this.enVentaja = enVentaja;
		}
	}

	public Boolean getVentaja() {
		return this.enVentaja;
	}

	private void gameGanado() {

		if (this.games < 5) {
			this.games = this.games + 1;
		} else {
			this.games = 0;
			setGanado();
		}
	}

	public Integer getGames() {
		return this.games;
	}

	private void setGanado() {
		if (this.set < 2) {
			this.set = this.set + 1;
		} else {
			jugadorGano();
		}
	}

	public Integer getSet() {
		return this.set;
	}

	private void jugadorGano() {
		this.ganador = true;
		reiniciarEstadisticas();
	}

	public Boolean getGanador() {
		return this.ganador;
	}

	public Boolean getEnTieBreak() {
		return this.enTieBreak;
	}
	
	public void setEnTieBreak(boolean enTieBreak) {
		this.enTieBreak = enTieBreak ;
	}
	
	private void reiniciarEstadisticas() {
		this.games = 0;
		this.puntuacion = 0;
		this.set = 0;
	}
	
	public void imprimirPuntuacionDeJugador() {
		System.out.println(this.nombre+": "+ this.set+"/"+this.games+"/"+this.puntuacion);
	}

}
