package it.edu.iisvolta;

import static java.time.temporal.ChronoUnit.SECONDS;

import java.time.LocalTime;

public class lavatrice {
	private int capacità, livelloacqua, temperatura, velocitàrotazione, stato;
	LocalTime start;
	private boolean detersivo;
	private float credito;
	
	public void lavatrice(int capacità) throws Exception{
		if (capacità != 8 || capacità != 10 || capacità != 14)
		{ System.out.println("Le lavatrici disponibili sono 8, 10 e 14 chilogrammi"); }
		else {
		this.capacità = capacità;
		this.livelloacqua=0;
		this.temperatura=0;
		this.velocitàrotazione=0;
		this.stato=0;
		this.credito=0;
		this.detersivo=false;
		throw new Exception("Capacità non disponibile");
		}
	}
	
	public void aggiungiAcqua(int litri) {
		if (livelloacqua+litri > capacità || litri > 6)
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
		{ credito=credito+moneta; }
	}
	
	public void start() {
		if (livelloacqua<4)
		{ System.out.println("Livello di acqua minore di 4 litri, impossibile avviare il lavaggio"); }
		else
		{
			if(temperatura != 40 || temperatura != 60 || temperatura != 90)
			{ System.out.println("Devi impostare prima la temperatura"); }
			else
			{
				if (velocitàrotazione != 600 || velocitàrotazione != 800 || velocitàrotazione != 1000)
				{ System.out.println("Devi impostare prima la centrifuga"); }
				else
				{
					if (detersivo=false)
					{ System.out.println("Devi aggiungere il detersivo per iniziare il lavaggio"); }
					else
					{
						stato=1;
						start=LocalTime.now();
						
						switch (capacità)
						{
							case 8:
								if (credito<4.5)
								{ System.out.println("Il credito non è sufficiente"); }
								else
								{ credito=(float) (credito-4.5); }
								break;
							case 10:
								if (credito<5.50)
								{ System.out.println("Il credito non è sufficiente"); }
								else
								{ credito=(float) (credito-5.50); }
								break;
							case 14:
								if (credito<6.50)
								{ System.out.println("Il credito non è sufficiente"); }
								else
								{ credito=(float) (credito-6.50); }
								break;
							default:
								break;
						}
					}
				}
			}
		}	
	}
	
	public void stop() {
		if (stato==1)
		{ stato=2; }
	}
	
	String getStato() {
		switch (this.stato)
		{
			case 0:
				System.out.println("Lavatrice pronta per il lavaggio");
				break;
			case 1:
				System.out.println("Lavaggio in corso");
				break;
			case 2:
				System.out.println("Lavaggio terminato");
				break;
			default:
				break;				
		}
		return;
	}	
	
	public void svuota() {
		if (stato==2)
		{ stato=0; }
		else
		{ }
	}
	
	int getLivelloAcqua() {
		System.out.println("Livello acqua " + livelloacqua);
		
	}
	
	
	
}