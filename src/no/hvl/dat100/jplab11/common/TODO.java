package no.hvl.dat100.jplab11.common;

import java.util.Arrays;

import no.hvl.dat100.jplab11.oppgave2.Bilde;
import no.hvl.dat100.jplab11.oppgave2.Tekst;
import no.hvl.dat100.jplab11.oppgave3.Blogg;

public class TODO {

	public static String method() {

		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();

		return "Metoden " + methodName + " er ikke implementert";
	}


	public static String constructor(String className) {

	   return "Konstruktøren for klassen " + className + " er ikke implementert";

	}

	// Main-metode for testing
	
	public static void main(String[] args) {

		// Test av opgave 3m, search()
		Blogg samling = new Blogg(6);

		Tekst tekst1 = new Tekst(11, "Ole Olsen", "23-10-2019", "en tekst");
		Tekst tekst2 = new Tekst(72, "Ole Olsen", "23-10-2019", "fjdklsfsjk");
		Tekst tekst3 = new Tekst(298, "Ole Olsen", "23-10-2019", "djasklsjakl");
		Tekst tekst4 = new Tekst(721, "Ole Olsen", "23-10-2019", "djsakldajskldjaskl");
		Tekst tekst5 = new Tekst(35, "Ole Olsen", "23-10-2019", "djsakldjaskldjskadjaskl");
		Bilde bilde1 = new Bilde(1, "Ole Olsen", "23-10-2019", "et bilde", "http://www.picture.com/oo.jpg");

		samling.leggTil(tekst1);
		samling.leggTil(tekst2);
		samling.leggTil(tekst3);
		samling.leggTil(tekst4);
		samling.leggTil(tekst5);
		samling.leggTil(bilde1);

		int[] test = samling.search("bla");
		System.out.println(Arrays.toString(test));

	}


}
