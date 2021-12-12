package com.practica.cajablanca.PruebasPrincipales;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.cajanegra.EmptyCollectionException;
import com.practica.cajablanca.Editor;

class sustituirPalabraTest {
	
	private Editor editor;
	
	private final String textoVacio = "./src/test/java/com/practica/cajablanca/ficheros/textoVacio.txt";
	private final String textoEspacio = "./src/test/java/com/practica/cajablanca/ficheros/textoEspacio.txt";
	private final String textoUnaPalabra = "./src/test/java/com/practica/cajablanca/ficheros/textoUnaPalabra.txt";
	private final String textoDosLineasEspacios = "./src/test/java/com/practica/cajablanca/ficheros/textoDosLineasEspacios.txt";

	@BeforeEach()
	void cargarEditor(TestInfo info) {
		String textPath = (String) info.getTags().toArray()[0];
		editor = new Editor();
		editor.leerFichero(textPath);
	}

	@DisplayName("sustituirPalabra - Camino 1")
	@Test()
	@Tag(textoVacio)
	void sustituirPalabra1() {
		String palabra = "cualquiera";
		String nuevaPalabra = "cualquiera";
		
		editor.sustituirPalabra(palabra, nuevaPalabra);
		
		assertTrue(editor.editIsEmpty());
	}
	
	@DisplayName("sustituirPalabra - Camino 2")
	@Test()
	@Tag(textoEspacio)
	void sustituirPalabra2() {
		String palabra = "cualquiera";
		String nuevaPalabra = "cualquiera";
		String expectedLinea = "[]";
		
		editor.sustituirPalabra(palabra, nuevaPalabra);
		
		try {
			assertEquals(expectedLinea, editor.getLinea(1).toString());
		} catch (EmptyCollectionException e) {
			e.printStackTrace();
		}
	}
	
	@DisplayName("sustituirPalabra - Camino 3")
	@Test()
	@Tag(textoUnaPalabra)
	void sustituirPalabra3() {
		String palabra = "hola";
		String nuevaPalabra = "adios";
		String expectedLinea = "[adios]";
		
		editor.sustituirPalabra(palabra, nuevaPalabra);
		
		try {
			assertEquals(expectedLinea, editor.getLinea(1).toString());
		} catch (EmptyCollectionException e) {
			e.printStackTrace();
		}
	}
	
	@DisplayName("sustituirPalabra - Camino 4")
	@Test()
	@Tag(textoUnaPalabra)
	void sustituirPalabra4() {
		String palabra = "noEsHola";
		String nuevaPalabra = "adios";
		String expectedLinea = "[hola]";
		
		editor.sustituirPalabra(palabra, nuevaPalabra);
		
		try {
			assertEquals(expectedLinea, editor.getLinea(1).toString());
		} catch (EmptyCollectionException e) {
			e.printStackTrace();
		}
	}
	
	@DisplayName("sustituirPalabra - Camino 5")
	@Test()
	@Tag(textoDosLineasEspacios)
	void sustituirPalabra5() {
		String palabra = "cualquiera";
		String nuevaPalabra = "cualquiera";
		String expectedLinea = "[]";
		
		editor.sustituirPalabra(palabra, nuevaPalabra);
		
		try {
			assertEquals(expectedLinea, editor.getLinea(1).toString());
			assertEquals(expectedLinea, editor.getLinea(2).toString());
		} catch (EmptyCollectionException e) {
			e.printStackTrace();
		}
	}
}
