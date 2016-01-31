import java.util.ArrayList;
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
		
		int testes = 0;
		// roda até encontrar uma combinação válida
		while(true){

			// embaralha todas as informações aleatoriamente
			reset();

			if(testa()) {
				printa();
				break;
			}
			
			testes++;
			
			if(testes%1000000 == 0) System.out.println(testes);
		}
	}

	/****************************
	 * Bloco de buscadores
	 ****************************/
	// busca por idade
	private static int buscaIdade(int n){
		
		for (int i = 0; i < turistas.length; i++) {
			if(turistas[i].idade == n) return i;
		}
		return -1;
	}
	
	// busca por nacionalidade
	private static int buscaNacionalidade(String x){
		
		for (int i = 0; i < turistas.length; i++) {
			if(turistas[i].nacionalidade.equalsIgnoreCase(x)) return i;
		}
		return -1;
	}
	
	// busca por hotel
	private static int buscaHotel(String x){

		for (int i = 0; i < turistas.length; i++) {
			if(turistas[i].hotel.equalsIgnoreCase(x)) return i;
		}
		return -1;
	}


	// busca por esportePessoal
	private static int buscaEsportePessoal(String x){

		for (int i = 0; i < turistas.length; i++) {
			if(turistas[i].esportePessoal.equalsIgnoreCase(x)) return i;
		}
		return -1;
	}


	// busca por esporte
	private static int buscaEsporte(String x){

		for (int i = 0; i < turistas.length; i++) {
			if(turistas[i].esporte.equalsIgnoreCase(x)) return i;
		}
		return -1;
	}

	// busca por turismo
	private static int buscaTurismo(String x){

		for (int i = 0; i < turistas.length; i++) {
			if(turistas[i].turismo.equalsIgnoreCase(x)) return i;
		}
		return -1;
	}
	
	
	/****************************
	 * Bloco de regras do Teste de Einstein modificado
	 ****************************/
	private static boolean testa(){
		
		// A chilena pratica triathlon.
		int chilena = buscaNacionalidade("Chile");
		if(!turistas[chilena].esportePessoal.equals("Triathlon")) return false;
		
		// A espanhola ficará hospedada no bairro da Urca.
		int espanhola = buscaNacionalidade("Espanha");
		if(!turistas[espanhola].hotel.equals("Urca")) return false;
		
		// A italiana gostaria de realizar um passeio turístico para conhecer o estádio do Maracanã.
		int italiana = buscaNacionalidade("Italia");
		if(!turistas[italiana].turismo.equals("Maracana")) return false;
		
		// A turista que pratica tênis é mais de um ano mais velha do que a que possui corrida como esporte pessoal.
		int tenista = buscaEsportePessoal("Tenis");
		int corredora = buscaEsportePessoal("Corrida");
		if(!(turistas[tenista].idade > turistas[corredora].idade+1)) return false;
		
		// A turista que gosta de praticar corrida gostaria de conhecer o Pão de Açúcar.
		if(!turistas[corredora].turismo.equals("Pao de Acucar")) return false;
		
		// A turista que pretende assistir Vôlei de Praia está hospedada em um hotel em Botafogo.
		int veVolei = buscaEsporte("Volei de Praia");
		if(!turistas[veVolei].hotel.equals("Botafogo")) return false;
		
		// A turista que pratica handebol deseja assistir às competições de Hipismo.
		int praticaHandebol = buscaEsportePessoal("Handebol");
		if(!turistas[praticaHandebol].esporte.equals("Hipismo")) return false;
		
		// A turista de 22 anos gostaria de conhecer a praia de Ipanema.
		int idade22 = buscaIdade(22);
		if(!turistas[idade22].turismo.equals("Ipanema")) return false;
		
		// A argentina possui 20 anos.
		int argentina = buscaNacionalidade("Argentina");
		if(!(turistas[argentina].idade == 20)) return false;
		
		// Quem irá assistir Atletismo nos Jogos Olímpicos tem um ano de diferença em relação a quem está hospedada em Ipanema.
		int veAtletismo = buscaEsporte("Atletismo");
		int hotelIpanema = buscaHotel("Ipanema");
		if(!(Math.abs( turistas[veAtletismo].idade - turistas[hotelIpanema].idade ) == 1)) return false;
		
		// A turista hospedada na Barra da Tijuca tem um ano de diferença em relação à turista que pretende assistir às competições de Hipismo.
		int hotelBarra = buscaHotel("Barra da Tijuca");
		int veHipismo = buscaEsporte("Hipismo");
		if(!(Math.abs( turistas[hotelBarra].idade - turistas[veHipismo].idade ) == 1)) return false;
		
		// A turista que deseja assistir às competições de Saltos Ornamentais deseja conhecer a Praia do Pepê.
		int veSaltos = buscaEsporte("Saltos Ornamentais");
		if(!turistas[veSaltos].turismo.equals("Praia do Pepe")) return false;
		
		// A belga quer assistir às competições de Natação nos Jogos Olímpicos.
		int belga = buscaNacionalidade("Belgica");
		if(!turistas[belga].esporte.equals("Natacao")) return false;
		
		// A argentina tem um ano de diferença em relação à turista que gosta de jogar futebol.
		int praticaFutebol = buscaEsportePessoal("Futebol");
		if(!(Math.abs( turistas[argentina].idade - turistas[praticaFutebol].idade ) == 1)) return false;
		
		// Quem deseja assistir às competições de Atletismo tem um ano de diferença em relação a quem pretende conhecer a praia de Copacabana.
		int turismoCopa = buscaTurismo("Copacabana");
		if(!(Math.abs( turistas[veAtletismo].idade - turistas[turismoCopa].idade ) == 1)) return false;
		
		// a combinação sugerida passou por todos os testes e deve ser a correta
		return true;
		
	}
	
	
	
	
	
	

}
