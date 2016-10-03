package rubrica;

import java.util.Map;
import java.util.TreeMap;

public class Rubrica {
	
	private Map<String,Voce> voci=new TreeMap<String,Voce>();

	
	public Voce aggiungiVoce(String nome, String cognome, String tel) throws VoceGiaEsiste{
		
		if(voci.containsKey(nome+" "+cognome)){
			throw new VoceGiaEsiste("era dentro class Rubrica metodo aggiungi");
		}
		
		Voce v=new Voce(nome,cognome,tel);
		
		voci.put(nome+" "+cognome, v);
		
		return v;
	}
	
	
}
