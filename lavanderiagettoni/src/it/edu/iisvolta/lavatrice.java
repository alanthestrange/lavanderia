package it.edu.iisvolta;

import static java.time.temporal.ChronoUnit.SECONDS;

import java.time.LocalTime;

public class lavatrice {
	private int capacità, livelloacqua, temperatura, velocitàrotazione, stato;
	LocalTime dataOraAvvio;
	private boolean detersivo;
	private float credito;
	
	public lavatrice(int capacità) throws Exception{
		super();
		if (capacità != 8 && capacità != 10 && capacità != 14)
		{ System.out.println("Le lavatrici disponibili sono 8, 10 e 14 chilogrammi"); }
		else {
		this.capacità = capacità;
		inizializza();
		}
	}
	
	public void aggiungiAcqua(int litri) {
		if (litri<=0)
		{ System.out.println("Livello acqua non valido"); }
		else if (livelloacqua+litri > capacità || litri > 6)
		{ System.out.println("Quantità di acqua maggiore della capacità della lavatrice selezionata o maggiore di 6 litri"); }
		else
		{ livelloacqua=livelloacqua+litri; }
	}
	
	public void setTemperatura(int gradi) {
		if (gradi != 40 || gradi != 60 ||gradi != 90)
		{ System.out.println("Le temperature disponibili sono 40, 60 e 90 gradi"); }
		else
		{ temperatura = gradi;}		
	}
	
	public void setVelocitàRotazione(int VelocitàRotazione) {
		if (VelocitàRotazione != 600 || VelocitàRotazione != 800 ||VelocitàRotazione != 1000)
		{ System.out.println("Le velocità di rotazione disponibili sono 600, 800 o 1000 giri/minuto"); }
		else
		{ this.velocitàrotazione=VelocitàRotazione; }
	}
	
	public void aggiungiDetersivo() {
		if (detersivo=true)
		{ System.out.println("Detersivo già presente"); }
		else
		{ detersivo=true; }
	}
	
	void aggiungiMoneta(float moneta) {
		if (moneta != 0.5 || moneta != 1 || moneta != 2)
		{ System.out.println("La lavatrice accetta solo monete da 0.50, 1 o 2 euro"); }
		else
		{ credito+=moneta; }
	}
	
	public float getCredito() {
		return credito;
	}

	public float getCosto() {
		switch(capacità) {
			case 8:
				return 4.50f;
			case 10:
				return 5.50f;
			case 14:
				return 6.50f;
			default:
				return 0;
		}
	}
	
	public void start() {
		if (credito<getCosto())
		{ System.out.println("Il credito non è sufficiente"); }
		else if (livelloacqua<4)
		{ System.out.println("Livello di acqua minore di 4 litri, impossibile avviare il lavaggio"); }
		else if(temperatura == 0)
		{ System.out.println("Devi impostare prima la temperatura"); }
		else if(velocitàrotazione == 0)
		{ System.out.println("Devi impostare prima la centrifuga"); }
		else if (detersivo=false)
		{ System.out.println("Devi aggiungere il detersivo per iniziare il lavaggio"); }
		else if (stato!=0)
		{ System.out.println("La lavatrice non è libera"); }
		else
		{ stato=1;
		dataOraAvvio=LocalTime.now();
		}
	}
	
	public void stop() {
		if (stato==1)
		{ stato=2; }
		else
		{ System.out.println("Lavatrice non in funzione"); }
	}
	
	String getStato() {
		LocalTime lt=LocalTime.now();
		if (stato==1 && SECONDS.between(dataOraAvvio, lt)>60)
		{ stato = 2; }
		switch (stato)
		{
			case 0:
				return "Lavatrice pronta per il lavaggio";
			case 1:
				return "Lavaggio in corso";
			case 2:
				return "Lavaggio terminato";
			default:
				return "";
		}
	}	
	
	public void svuota() {
		if (stato==2)
		{ stato=0; }
		else
		{ System.out.println("");}
	}

	private void inizializza() {
		livelloacqua=0;
		temperatura=0;
		velocitàrotazione=0;
		stato=0;
		credito=0;
		detersivo=false;
	}
	
	public int getCapacità() {
		return capacità;
	}

	public int getLivelloacqua() {
		return livelloacqua;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public int getVelocitàrotazione() {
		return velocitàrotazione;
	}
	
	public boolean detersivoAggiunto() {
		return detersivo;
	}
	
}