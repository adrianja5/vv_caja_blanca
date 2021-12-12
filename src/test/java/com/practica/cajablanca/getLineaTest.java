package com.practica.cajablanca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.cajanegra.EmptyCollectionException;

class getLineaTest {

	private final String ficherosPath = "./src/test/java/com/practica/cajablanca/ficheros/";

	@Test
	void getLineaUnaPalabraTest() {
		Editor editor = new Editor();
		editor.leerFichero(ficherosPath + "textoUnaPalabra.txt");

		try {
			assertEquals("[hola]", editor.getLinea(1).toString());
		} catch (EmptyCollectionException e) {
			e.printStackTrace();
		}
	}

	@Test
	void getLineaDosPalabrasTest() {
		Editor editor = new Editor();
		editor.leerFichero(ficherosPath + "textoDosPalabrasMenorMayor.txt");

		try {
			assertEquals("[hola, adios]", editor.getLinea(1).toString());
		} catch (EmptyCollectionException e) {
			e.printStackTrace();
		}
	}

	@Test
	void getLineaDosLineasTest() {
		Editor editor = new Editor();
		editor.leerFichero(ficherosPath + "textoDosLineasIguales.txt");

		try {
			assertEquals("[hola]", editor.getLinea(1).toString());
			assertEquals("[hola]", editor.getLinea(2).toString());
		} catch (EmptyCollectionException e) {
			e.printStackTrace();
		}
	}

	@Test
	void getLineaVacioTest() {
		Editor editor = new Editor();
		editor.leerFichero(ficherosPath + "textoVacio.txt");

		assertThrows(EmptyCollectionException.class, () -> {
			editor.getLinea(1);
		});
	}

	@ParameterizedTest(name = "[{index}] -> linea={0}")
	@CsvSource({ "0", "2", })
	void getLineaLineaErroneaTest(int linea) {
		Editor editor = new Editor();
		editor.leerFichero(ficherosPath + "textoUnaPalabra.txt");

		assertThrows(IllegalArgumentException.class, () -> {
			editor.getLinea(linea);
		});
	}

}
