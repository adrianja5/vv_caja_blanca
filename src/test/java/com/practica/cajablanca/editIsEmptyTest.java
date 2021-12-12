package com.practica.cajablanca;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class editIsEmptyTest {

	private final String ficherosPath = "./src/test/java/com/practica/cajablanca/ficheros/";
	
	@ParameterizedTest(name = "[{index}] -> fichero=''{0}'', salidaEsperada={1}")
	@CsvSource({
		"textoVacio.txt, true",
		"textoDosPalabrasMayorMenor.txt, false",
		"textoUnaPalabra.txt, false",
		"textoDosLineasEspacios.txt, false",
		"textoDosLineasIguales.txt, false",
		})
	void editIsEmptyTest(String fichero, boolean salidaEsperada) {
		Editor editor = new Editor();
		editor.leerFichero(ficherosPath + fichero);

		assertEquals(salidaEsperada, editor.editIsEmpty());
	}

}
