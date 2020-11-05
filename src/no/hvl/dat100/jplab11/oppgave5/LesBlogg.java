package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {

		Blogg blogg;

		try {

			File file = new File(mappe + filnavn);
			BufferedReader reader = new BufferedReader(new FileReadeer(file));

			int antallInnlegg = Integer.valueOf(reader.readLine());
			blogg = new Blogg(antallInnlegg);

			while (reader.ready()) {

				String type = reader.readLine();
				int id = Integer.valueOf(reader.readLine());
				String bruker = reader.readLine();
				String dato = reader.readLine();
				int likes = Integer.valueOf(reader.readLine());
				String tekst = reader.readLine();

				if (type.equals(BILDE)) {
					String url = reader.readLine();

					Bilde bildeInnlegg = new Bilde(id, bruker, dato, likes, tekst, url);
					blogg.leggTil(bildeInnlegg);

				} else if (type.equals(TEKST)) {

					Tekst tekstInnlegg = new Tekst(id, bruker, dato, likes, tekst);
					blogg.leggTil(tekstInnlegg);
				}
			}

			reader.close();

		} catch (Exception e) {
			blogg = new Blogg();
		}

		return blogg;

	}
}
