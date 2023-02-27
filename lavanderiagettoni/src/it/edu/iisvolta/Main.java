package it.edu.iisvolta;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		// inizializzo le lavatrici
				Scanner s=new Scanner(System.in);
				String scelta, lav;
				int numLavatrice=1;
				
				lavatrice l1=new lavatrice(8);
				lavatrice l2=new lavatrice(10);
				lavatrice l3=new lavatrice(14);
				
				lavatrice lavatriceSelezionata=l1;
				
				do {
					menu();
					Console.setCursorPosition(1, 70);
					System.out.print("Lavatrice selezionata: "+numLavatrice);
					Console.setCursorPosition(2, 70);
					System.out.print("  Capacità: "+lavatriceSelezionata.getCapacità());
					Console.setCursorPosition(3, 70);
					System.out.print("  Stato: "+lavatriceSelezionata.getStato());
					Console.setCursorPosition(4, 70);
					System.out.print("  Livello acqua: "+lavatriceSelezionata.getLivelloacqua());
					Console.setCursorPosition(5, 70);
					System.out.print("  Temperatura: "+lavatriceSelezionata.getTemperatura());
					Console.setCursorPosition(6, 70);
					System.out.print("  Velocità rotazione: "+lavatriceSelezionata.getVelocitàrotazione());
					Console.setCursorPosition(7, 70);
					System.out.print("  Detersivo: "+lavatriceSelezionata.detersivoAggiunto());
					Console.setCursorPosition(8, 70);
					System.out.print("  Costo: "+lavatriceSelezionata.getCosto());
					Console.setCursorPosition(9, 70);
					System.out.print("  Credito: "+lavatriceSelezionata.getCredito());
					
					Console.setCursorPosition(15, 1);
					
					System.out.print("Inserisci la tua scelta: ");
					scelta=s.nextLine();
					switch (scelta) {
					case "1":		//scelta lavatrice
						System.out.print("Quale lavatrice vuoi scegliere (1-3)? ");
						lav=s.nextLine();
						switch(lav) {
						case "1":
							lavatriceSelezionata=l1;
							numLavatrice=1;
							break;
						case "2":
							lavatriceSelezionata=l2;
							numLavatrice=2;
							break;
						case "3":
							lavatriceSelezionata=l3;
							numLavatrice=3;
							break;
						default:
							System.out.println("Lavatrice non valida!");
							break;
						}
						break;
						
					case "2": 	//aggiungi acqua 
						System.out.print("Quanta acqua vuoi aggiungere? ");
						int litri=Integer.parseInt(s.nextLine());
						lavatriceSelezionata.aggiungiAcqua(litri);
						break;
						
					case "3": 	//imposta temperatura 
						System.out.print("Che temperatura vuoi impostare? ");
						int temp=Integer.parseInt(s.nextLine());
						lavatriceSelezionata.setTemperatura(temp);
						break;
						
					case "4": 	//imposta numero di giri 
						System.out.print("Inserisci il numero di giri: ");
						int giri=Integer.parseInt(s.nextLine());
						lavatriceSelezionata.setVelocitàRotazione(giri);;
						break;
						
					case "5": 	//aggiungi detersivo 				
						lavatriceSelezionata.aggiungiDetersivo();
						break;
						
					case "6": 	//aggiungi moneta 	
						System.out.print("Che moneta vuoi aggiungere? ");
						float moneta=Float.parseFloat(s.nextLine());
						lavatriceSelezionata.aggiungiMoneta(moneta);
						break;
						
					case "7": 	//avvio 				
						lavatriceSelezionata.start();
						break;
						
					case "8": 	//stop 				
						lavatriceSelezionata.stop();
						break;
						
					case "9":
						lavatriceSelezionata.svuota();
						break;
						
					}
					System.out.println();
					System.out.println("Premi Enter per continuare...");
					s.nextLine();
					
					
				} while (!scelta.equals("9"));
				s.close();
				

			}
			
			private static void menu() {
				Console.clear();
				System.out.println("**** LAVANDERIA A GETTONI ****");
				System.out.println();
				System.out.println("1) Scegli lavatrice");
				System.out.println("2) Aggiungi acqua");
				System.out.println("3) Imposta temperatura");
				System.out.println("4) Imposta numero giri");
				System.out.println("5) Aggiungi detersivo");
				System.out.println("6) Aggiungi moneta");		
				System.out.println("7) Avvio");
				System.out.println("8) Stop");
				System.out.println("9) Svuota");
				System.out.println("0) Esci");
	}
}
