package partidoDeTenis;

public class Juego {
	
	private Jugador jugador1;
	private Jugador jugador2;
	
	public Juego(Jugador jugador1, Jugador jugador2) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
	}
	
	public void pelotaGanadaParaJugador1() {
		if(verSiJugadoresEstanEnDeuce()) {
			if(jugador1.getVentaja()) {
				this.jugador1.pelotaGanada();
				jugador1.setVentaja(false);
				jugador2.setVentaja(false);
				jugador1.setDeuce(false);
				jugador2.setDeuce(false);
			} else if( jugador2.getVentaja()) {
				this.jugador1.pelotaGanada();
				jugador2.setVentaja(false);
			} else {
				this.jugador1.pelotaGanada();
			}
		} else if (jugador1.getPuntuacion() == 30 && jugador2.getPuntuacion() == 40){

			this.jugador1.pelotaGanada();
			jugador1.setDeuce(true);
			jugador2.setDeuce(true);
		} else {
			this.jugador1.pelotaGanada();
		}
	}
	
	public void pelotaGanadaParaJugador2() {
		if(verSiJugadoresEstanEnDeuce()) {
			if(jugador2.getVentaja()) {
				this.jugador2.pelotaGanada();
				jugador1.setVentaja(false);
				jugador2.setVentaja(false);
				jugador1.setDeuce(false);
				jugador2.setDeuce(false);
			} else if( jugador1.getVentaja()) {
				this.jugador2.pelotaGanada();
				jugador1.setVentaja(false);
			} else {
				this.jugador2.pelotaGanada();
			}
		} else if (jugador2.getPuntuacion() == 30 && jugador1.getPuntuacion() == 40){
			this.jugador2.pelotaGanada();
			jugador1.setDeuce(true);
			jugador2.setDeuce(true);
		} else {
			this.jugador2.pelotaGanada();
		}
	}
	
	public Boolean verSiJugadoresEstanEnDeuce() {
		return (this.jugador1.getPuntuacion() == 40 && this.jugador2.getPuntuacion() == 40);
	}

}
