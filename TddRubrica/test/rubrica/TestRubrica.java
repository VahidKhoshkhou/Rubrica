package rubrica;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestRubrica {

	static Rubrica r;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		r = new Rubrica("vahid");
	}

	@Test
	public void testCreazioneRubrica() {

		assertNotNull(r);

	}

	@Test
	public void testCollezioneRubrica() {

		Map<String, Voce> voci = r.getVoci();

		assertNotNull(voci);

	}

	@Test
	public void testAggiungiVoce() throws VoceGiaEsiste {

		Voce v = r.aggiungiVoce("AAA", "BBB", "1111111111");

		assertNotNull(v);

		Map<String, Voce> voci = r.getVoci();

		assertEquals(1, voci.size());

	}

	@Test
	public void testAggiungiVoce2() {

		try {
			Voce v = r.aggiungiVoce("AAA", "BBB", "1111111111");
			Voce v1 = r.aggiungiVoce("AAA", "BBB", "1111111111");
			fail("aspettavo che lanciava l' eccezione ");

		} catch (VoceGiaEsiste e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void testGetVoce() throws VoceGiaEsiste, VoceNonEsiste {
		Rubrica r2 = new Rubrica("aaaa");
		Voce v = r2.aggiungiVoce("hhh", "ggg", "1111111111");

		Voce voceTornata = r2.getVoce("hhh", "ggg");

		assertEquals(v, voceTornata);
	}

	@Test
	public void testGetVoce2() {
		Rubrica r2 = new Rubrica("aaaa");

		try {
			Voce voceTornata = r2.getVoce("zzzz", "zzzzzz");
			fail("non ha laciato ");
		} catch (VoceNonEsiste e) {

			e.printStackTrace();
		}

	}
	
	
	
	@Test
	public void testAggiornaVoce() throws VoceGiaEsiste{
		Rubrica r2 = new Rubrica("aaaa");
		Voce v = r2.aggiungiVoce("hhh", "ggg", "1111111111");
		
		String nomeVechio=v.getNome();
		String cognomeVechio=v.getCognome();
		String telVechio=v.getTel();
		
		
		Voce voceAggiornato=r2.aggiornaVoce("hhh","ggg","aaaa","bbbbb","33333333333");
		
		String nomeNuovo=voceAggiornato.getNome();
		String cognomeNuovo=voceAggiornato.getCognome();
		String telNuovo=voceAggiornato.getTel();
		
		assertNotEquals(nomeVechio, nomeNuovo);
		assertNotEquals(cognomeVechio, cognomeNuovo);
		assertNotEquals(telVechio, telNuovo);
		
	}

}
