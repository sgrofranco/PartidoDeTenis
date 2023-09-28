package partidoDeTenis;

public class Juego {
	
	private Jugador jugador1;
	private Jugador jugador2;
	
	public Juego(Jugador jugador1, Jugador jugador2) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
	}
	
	public void pelotaGanadaParaJugador(Jugador jugador1, Jugador jugador2) {
		if (verSiJugadoresEstanEnTieBreak()) {
			

		}
		if (verSiJugadoresEstanEnDeuce()) {
			if (jugador1.getVentaja()) {
				jugador1.pelotaGanada();
				jugador1.setVentaja(false);
				jugador2.setVentaja(false);
				jugador1.setDeuce(false);
				jugador2.setDeuce(false);
			} else if (jugador2.getVentaja()) {
				jugador1.pelotaGanada();
				jugador1.setVentaja(false);
				jugador2.setVentaja(false);
			} else {
				jugador1.pelotaGanada();
			}
		} else if (jugador1.getPuntuacion() == 30
				&& jugador2.getPuntuacion() == 40) {

			jugador1.pelotaGanada();
			jugador1.setDeuce(true);
			jugador2.setDeuce(true);
		} else {
			jugador1.pelotaGanada();
		}
	}
	
	public Boolean verSiJugadoresEstanEnDeuce() {
		return (this.jugador1.getPuntuacion() == 40 && this.jugador2.getPuntuacion() == 40);
	}

	public Boolean verSiJugadoresEstanEnTieBreak() {
		return (this.jugador1.getGames() == 6 && this.jugador2.getGames() == 6);
	}

}
