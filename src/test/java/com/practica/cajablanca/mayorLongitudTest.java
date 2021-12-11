package com.practica.cajablanca;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.cajanegra.EmptyCollectionException;

class mayorLongitudTest {

	private Editor editor;

	private final String textoVacio = "./src/test/java/com/practica/cajablanca/ficheros/textoVacio.txt";
	private final String textoEspacio = "./src/test/java/com/practica/cajablanca/ficheros/textoEspacio.txt";
	private final String textoUnaPalabra = "./src/test/java/com/practica/cajablanca/ficheros/textoUnaPalabra.txt";
	private final String textoDosPalabrasMayorMenor = "./src/test/java/com/practica/cajablanca/ficheros/textoDosPalabrasMayorMenor.txt";
	private final String textoDosPalabrasMenorMayor = "./src/test/java/com/practica/cajablanca/ficheros/textoDosPalabrasMenorMayor.txt";

	@BeforeEach()
	void cargarEditor(TestInfo info) {
		String textPath = (String) info.getTags().toArray()[0];
		editor = new Editor();
		editor.leerFichero(textPath);
	}

	@DisplayName("mayorLongitud - Camino 1")
	@Test()
	@Tag(textoVacio)
	void mayorLongitud1() {
		try {
			assertEquals(null, editor.mayorLongitud());
		} catch (EmptyCollectionException e) {
			e.printStackTrace();
		}
	}

	@DisplayName("mayorLongitud - Camino 3")
	@Test()
	@Tag(textoEspacio)
	void mayorLongitud3() {
		try {
			assertEquals(null, editor.mayorLongitud());
		} catch (EmptyCollectionException e) {
			e.printStackTrace();
		}
	}

	@DisplayName("mayorLongitud - Camino 4")
	@Test()
	@Tag(textoUnaPalabra)
	void mayorLongitud4() {
		try {
			assertEquals("hola", editor.mayorLongitud());
		} catch (EmptyCollectionException e) {
			e.printStackTrace();
		}
	}

	@DisplayName("mayorLongitud - Camino 5 Mod")
	@Test()
	@Tag(textoDosPalabrasMayorMenor)
	void mayorLongitud5() {
		try {
			assertEquals("adios", editor.mayorLongitud());
		} catch (EmptyCollectionException e) {
			e.printStackTrace();
		}
	}

	@DisplayName("mayorLongitud - Camino 6 Mod")
	@Test()
	@Tag(textoDosPalabrasMenorMayor)
	void mayorLongitud6() {
		try {
			assertEquals("adios", editor.mayorLongitud());
		} catch (EmptyCollectionException e) {
			e.printStackTrace();
		}
	}

}
