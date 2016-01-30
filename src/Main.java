import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
	
	static Turista[] turistas;
	
	private static void reset(){
		
		// prepara as listas de possibilidades para cada característica das turistas
		
		List<Integer> idades = new ArrayList<Integer>();
		idades.add(new Integer(20));
		idades.add(new Integer(21));
		idades.add(new Integer(22));
		idades.add(new Integer(23));
		idades.add(new Integer(24));

		List<String> nacionalidades = new ArrayList<String>();
		nacionalidades.add("Argentina");
		nacionalidades.add("Chile");
		nacionalidades.add("Espanha");
		nacionalidades.add("Belgica");
		nacionalidades.add("Italia");
		
		List<String> esportesPessoais = new ArrayList<String>();
		esportesPessoais.add("Triathlon");
		esportesPessoais.add("Tenis");
		esportesPessoais.add("Corrida");
		esportesPessoais.add("Handebol");
		esportesPessoais.add("Futebol");
		
		List<String> turismos = new ArrayList<String>();
		turismos.add("Maracana");
		turismos.add("Pao de Acucar");
		turismos.add("Ipanema");
		turismos.add("Praia do Pepe");
		turismos.add("Copacabana");
		
		List<String> esportes = new ArrayList<String>();
		esportes.add("Volei de Praia");
		esportes.add("Hipismo");
		esportes.add("Atletismo");
		esportes.add("Saltos Ornamentais");
		esportes.add("Natacao");
		
		List<String> hoteis = new ArrayList<String>();
		hoteis.add("Urca");
		hoteis.add("Botafogo");
		hoteis.add("Ipanema");
		hoteis.add("Barra da Tijuca");
		hoteis.add("Copacabana");
		
		// prepara as turistas
		turistas = new Turista[5];
		
		// escolhe aleatoriamente elementos para cada turista
		for(int i = 0; i <= 4; i++){
			turistas[i] = new Turista();
			int escolhido;
			
			escolhido = (int)((Math.random()*100)%idades.size());
			turistas[i].idade = idades.get(escolhido);
			idades.remove(escolhido);
			
			escolhido = (int)((Math.random()*100)%nacionalidades.size());
			turistas[i].nacionalidade = nacionalidades.get(escolhido);
			nacionalidades.remove(escolhido);
			
			escolhido = (int)((Math.random()*100)%esportesPessoais.size());
			turistas[i].esportePessoal = esportesPessoais.get(escolhido);
			esportesPessoais.remove(escolhido);
			
			escolhido = (int)((Math.random()*100)%turismos.size());
			turistas[i].turismo = turismos.get(escolhido);
			turismos.remove(escolhido);
			
			escolhido = (int)((Math.random()*100)%esportes.size());
			turistas[i].esporte = esportes.get(escolhido);
			esportes.remove(escolhido);
			
			escolhido = (int)((Math.random()*100)%hoteis.size());
			turistas[i].hotel = hoteis.get(escolhido);
			hoteis.remove(escolhido);
			
		}
		
	}
	
	private static void printa(){
		
		System.out.println("--------------");
		for(int i = 0; i <= 4; i++){
			System.out.println(turistas[i]);
		}
		System.out.println("--------------");
	}
	
	public static void main(String[] args){
		
		// roda até encontrar uma combinação válida
		while(true){
			
			// embaralha todas as informações aleatoriamente
			reset();
			
			

		}

	}
	

}
