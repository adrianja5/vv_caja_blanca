package com.practica.cajablanca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class numPalabrasTest {

	private Editor editor;

	private final String textoVacio = "./src/test/java/com/practica/cajablanca/ficheros/textoVacio.txt";
	private final String textoUnaPalabra = "./src/test/java/com/practica/cajablanca/ficheros/textoUnaPalabra.txt";
	private final String textoDosLineasIguales = "./src/test/java/com/practica/cajablanca/ficheros/textoDosLineasIguales.txt";

	@BeforeEach()
	void cargarEditor(TestInfo info) {
		String textPath = (String) info.getTags().toArray()[0];
		editor = new Editor();
		editor.leerFichero(textPath);
	}

	@DisplayName("numPalabras - Camino 1")
	@Test()
	@Tag(textoVacio) // Cualquiera
	void numPalabras1() {
		int inicio = 0;
		int fin = 5; // Cualquiera
		String palabra = "cualquiera";

		assertThrows(IllegalArgumentException.class, () -> {
			editor.numPalabras(inicio, fin, palabra);
		});
	}

	@DisplayName("numPalabras - Camino 2")
	@Test()
	@Tag(textoUnaPalabra)
	void numPalabras2() {
		int inicio = 1;
		int fin = 2;
		String palabra = "cualquiera";

		assertThrows(IllegalArgumentException.class, () -> {
			editor.numPalabras(inicio, fin, palabra);
		});
	}

	@DisplayName("numPalabras - Camino 3")
	@Test()
	@Tag(textoVacio)
	void numPalabras3() {
		int inicio = 1;
		int fin = 0;
		String palabra = "cualquiera";
		int expectedNumPalabras = 0;

		assertEquals(expectedNumPalabras, editor.numPalabras(inicio, fin, palabra));
	}

	@DisplayName("numPalabras - Camino 4")
	@Test()
	@Tag(textoDosLineasIguales)
	void numPalabras4() {
		int inicio = 1;
		int fin = 1;
		String palabra = "cualquiera";
		int expectedNumPalabras = 0;

		assertEquals(expectedNumPalabras, editor.numPalabras(inicio, fin, palabra));
	}

	@DisplayName("numPalabras - Camino 6")
	@Test()
	@Tag(textoDosLineasIguales)
	void numPalabras6() {
		int inicio = 1;
		int fin = 2;
		String palabra = "noEsHola";
		int expectedNumPalabras = 0;

		assertEquals(expectedNumPalabras, editor.numPalabras(inicio, fin, palabra));
	}

	@DisplayName("numPalabras - Camino 7")
	@Test()
	@Tag(textoDosLineasIguales)
	void numPalabras7() {
		int inicio = 1;
		int fin = 2;
		String palabra = "hola";
		int expectedNumPalabras = 2;

		assertEquals(expectedNumPalabras, editor.numPalabras(inicio, fin, palabra));
	}

}
