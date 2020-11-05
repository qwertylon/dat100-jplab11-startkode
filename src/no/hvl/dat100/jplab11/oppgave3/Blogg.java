package no.hvl.dat100.jplab11.oppgave3;

import java.util.Arrays;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	// TODO: objektvariable
	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {
		this(20);
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}

	public Innlegg[] getSamling() {
		return innleggtabell;
	}

	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i].erLik(innlegg)) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i].erLik(innlegg)) {
				return true;
			}
		}
		return false;
	}

	public boolean ledigPlass() {
		return nesteledig < innleggtabell.length;
	}

	public boolean leggTil(Innlegg innlegg) {
		if (finnes(innlegg) || !ledigPlass()) {
			return false;
		}
		innleggtabell[nesteledig] = innlegg;
		nesteledig++;
		return true;
	}

	public String toString() {
		String bloggTekst = "";
		for (int i = 0; i < nesteledig; i++) {
			bloggTekst += innleggtabell[i].toString();
		}
		return nesteledig + "\n" + bloggTekst;
	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		Innlegg[] nytab = new Innlegg[innleggtabell.length * 2];
		for (int i = 0; i < nesteledig; i++) {
			nytab[i] = innleggtabell[i];
		}
		innleggtabell = nytab;
	}

	public boolean leggTilUtvid(Innlegg innlegg) {
		if (finnes(innlegg)) {
			return false;
		}
		if(!ledigPlass()) {
			utvid();
		}
		innleggtabell[nesteledig] = innlegg;
		nesteledig++;
		return true;
	}

	public boolean slett(Innlegg innlegg) {
		// Finner indeksen til innlegget som skal slettes
		int index = finnInnlegg(innlegg);

		if (index >= 0) {
			// Flytter alle elementene fra og med indeksen ned med 1 posisjon i tabellen.
			for (int i = index; i < innleggtabell.length-1; i++) {
				innleggtabell[i] = innleggtabell[i+1];
			}

			// Elementet i indeksen "nesteledig" og "nesteledig+1" er nå duplikater. Vi må nullstille det siste elementet vi har kommet til.
			nesteledig--;
			innleggtabell[nesteledig] = null;
			return true;

			// Hvis innlegget ikke finnes i tabellen, returneres det "false".
		} else {
			return false;
		}
	}

	public int[] search(String keyword) {
		int[] nytab = new int[nesteledig];
		int antall = 0;
		for (int i = 0; i < nesteledig; i++) {
			Innlegg innlegg = innleggtabell[i];

			// Siden bare tekst-objekter kan inneholde tekst, sjekker vi om innlegget er av type tekst, og så kaster det til tekst.
			if (innlegg instanceof Tekst) {
				Tekst innleggTekst = (Tekst) innlegg;

				if (innleggTekst.getTekst().contains(keyword)) {
					nytab[antall] = innlegg.getId();
					antall++;
				}
			}
		}
		int[] idtab = new int[antall];
		for (int i = 0; i < antall; i++) {
			idtab[i] = nytab[i];
		}
		return idtab;
	}
}
