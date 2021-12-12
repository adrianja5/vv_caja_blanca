package com.practica.cajablanca.OtrasPruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.cajanegra.EmptyCollectionException;
import com.practica.cajablanca.Editor;

class numPalabrasNoParamTest {

	private final String ficherosPath = "./src/test/java/com/practica/cajablanca/ficheros/";

	@ParameterizedTest(name = "[{index}] -> fichero=''{0}'', salidaEsperada={1}")
	@CsvSource({
		"textoDosLineasEspacios.txt, 0",
		"textoUnaPalabra.txt, 1",
		"textoDosLineasIguales.txt, 2",
		"textoDosPalabrasMayorMenor.txt, 2"
		})
	void numPalabrasNoParamTest(String fichero, int salidaEsperada) {
		Editor editor = new Editor();
		editor.leerFichero(ficherosPath + fichero);

		try {
			assertEquals(salidaEsperada, editor.numPalabras());
		} catch (EmptyCollectionException e) {
			e.printStackTrace();
		}
	}

	@Test
	void numPalabrasNoParamTextoVacioTest() {
		Editor editor = new Editor();
		editor.leerFichero(ficherosPath + "textoVacio.txt");

		assertThrows(EmptyCollectionException.class, () -> {
			editor.numPalabras();
		});
	}

	@Test
	void numPalabrasNoParamSinLeerFicheroTest() {
		Editor editor = new Editor();

		assertThrows(EmptyCollectionException.class, () -> {
			editor.numPalabras();
		});
	}

}
