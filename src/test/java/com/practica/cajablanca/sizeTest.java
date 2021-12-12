package com.practica.cajablanca;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class sizeTest {

	private final String ficherosPath = "./src/test/java/com/practica/cajablanca/ficheros/";

	@ParameterizedTest(name = "[{index}] -> fichero=''{0}'', salidaEsperada={1}")
	@CsvSource({
		"textoVacio.txt, 0",
		"textoDosPalabrasMayorMenor.txt, 1",
		"textoUnaPalabra.txt, 1",
		"textoDosLineasEspacios.txt, 2",
		"textoDosLineasIguales.txt, 2",
		})
	void sizeTest(String fichero, int salidaEsperada) {
		Editor editor = new Editor();
		editor.leerFichero(ficherosPath + fichero);

		assertEquals(salidaEsperada, editor.size());
	}

}
