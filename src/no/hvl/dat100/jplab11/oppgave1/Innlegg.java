package no.hvl.dat100.jplab11.oppgave1;

import no.hvl.dat100.jplab11.common.TODO;

public abstract class Innlegg {

	private int id, likes;
	private String bruker, dato;

	public Innlegg() {

	}

	public Innlegg(int id, String bruker, String dato) {

		// TODO
		this(id, bruker, dato, 0);
	}

	public Innlegg(int id, String bruker, String dato, int likes) {

		// TODO - START
		this.id = id;
		this.bruker = bruker;
		this.dato = dato;
		this.likes = likes;
	}

	public String getBruker() {
		return bruker;
	}

	public void setBruker(String bruker) {
		this.bruker = bruker;
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public int getId() {
		return id;
	}

	public int getLikes() {
		return likes;
	}

	public void doLike () {
		likes++;
	}

	public boolean erLik(Innlegg innlegg) {
		return id == innlegg.getId();
	}

	@Override
	public String toString() {
		return id + "/n" + bruker + "/n" + dato + "/n" + likes + "/n";
	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		return "\t\t<h2>" + bruker + "@" + dato + " [" + likes + "]</h2>\n";
	}
}
