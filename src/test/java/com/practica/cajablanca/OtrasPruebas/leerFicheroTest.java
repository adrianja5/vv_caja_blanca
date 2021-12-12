package com.practica.cajablanca.OtrasPruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.cajanegra.EmptyCollectionException;
import com.practica.cajablanca.Editor;

class leerFicheroTest {

	private final String ficherosPath = "./src/test/java/com/practica/cajablanca/ficheros/";

	@Test
	void leerFicheroVacioTest() {
		Editor editor = new Editor();
		editor.leerFichero(ficherosPath + "textoVacio.txt");

		assertEquals(0, editor.size());
	}

	@Test
	void leerFicheroUnaPalabraTest() {
		Editor editor = new Editor();
		editor.leerFichero(ficherosPath + "textoUnaPalabra.txt");

		assertEquals(1, editor.size());

		try {
			assertEquals("[hola]", editor.getLinea(1).toString());
		} catch (EmptyCollectionException e) {
			e.printStackTrace();
		}
	}

	@Test
	void leerFicheroDosPalabrasTest() {
		Editor editor = new Editor();
		editor.leerFichero(ficherosPath + "textoDosPalabrasMenorMayor.txt");

		assertEquals(1, editor.size());

		try {
			assertEquals("[hola, adios]", editor.getLinea(1).toString());
		} catch (EmptyCollectionException e) {
			e.printStackTrace();
		}
	}

	@Test
	void leerFicheroDosLineasTest() {
		Editor editor = new Editor();
		editor.leerFichero(ficherosPath + "textoDosLineasIguales.txt");

		assertEquals(2, editor.size());

		try {
			assertEquals("[hola]", editor.getLinea(1).toString());
			assertEquals("[hola]", editor.getLinea(2).toString());
		} catch (EmptyCollectionException e) {
			e.printStackTrace();
		}
	}

	@Test
	void leerFicheroUnEspacioTest() {
		Editor editor = new Editor();
		editor.leerFichero(ficherosPath + "textoEspacio.txt");

		assertEquals(1, editor.size());

		try {
			assertEquals("[]", editor.getLinea(1).toString());
		} catch (EmptyCollectionException e) {
			e.printStackTrace();
		}
	}
}
