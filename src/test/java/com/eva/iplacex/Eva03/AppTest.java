package com.eva.iplacex.Eva03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DAO.LoginDAO;
import DB.conexion;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUsuarioCorrecto() throws Exception {
		System.out.println("Prueba de Usuario Correcto");
		try {
			
			LoginDAO instance = new LoginDAO();
			String rut = instance.validar("leo", "123123");
			assertEquals(rut, "15737935-6");
			
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testUsuarioIncorrecto() throws Exception {
		System.out.println("Prueba de Usuario Incorrecto");
		try {
			LoginDAO instance = new LoginDAO();
			String rut = instance.validar("leo", "00000");
			assertEquals(rut, "");
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testUsuarioVacio() throws Exception {
		System.out.println("Prueba de Usuario Vacío");
		try {
			LoginDAO instance = new LoginDAO();
			String rut = instance.validar("", "");
			assertEquals(rut, "");
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testConexion() {
		System.out.println("Prueba de Conexión");
		try {
			conexion instance = new DB.conexion();
			String resultado = "";
			if(instance.conectar() != null) {
				resultado = "Conexion Establecida..";
			}else {
				resultado = "Conexion fallo";
			}
			assertEquals(resultado, "Conexion Establecida..");
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}
}
