package com.nombrecompania.envioxmlapp.actions;

import com.nombrecompania.envioxmlapp.utils.ValidacionUtil;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class UtilTest {

    @Test
    void testisValidPuerto(){
        assertTrue(ValidacionUtil.isValidPuerto(0));
        assertTrue(ValidacionUtil.isValidPuerto(32500));
        assertTrue(ValidacionUtil.isValidPuerto(65535));
        assertTrue(ValidacionUtil.isValidPuerto(-1));
        assertTrue(ValidacionUtil.isValidPuerto(65536));
    }
    @Test
    void testisValidIp(){
        assertTrue(ValidacionUtil.isValidIp("192.168.0.1"));
        assertTrue(ValidacionUtil.isValidIp("10.0.0.12"));
        assertTrue(ValidacionUtil.isValidIp("172.10.0.0"));
        assertTrue(ValidacionUtil.isValidIp("127.0.0.1"));
    }
    @Test
    void testisInValidIp(){
        assertFalse(ValidacionUtil.isValidIp(""));// valor vacio
        assertFalse(ValidacionUtil.isValidIp("256.0.0.1"));// primer número fuera de rango
        assertFalse(ValidacionUtil.isValidIp("255.256.255.255"));// segundo número fuera de rango
        assertFalse(ValidacionUtil.isValidIp("255.255.256.255"));// tercer número fuera de rango
        assertFalse(ValidacionUtil.isValidIp("255.255.255.256"));// último número fuera de rango
        assertFalse(ValidacionUtil.isValidIp("192.168.0"));// faltan números
        assertFalse(ValidacionUtil.isValidIp("192.168.0.1.2"));// sobran números
        assertFalse(ValidacionUtil.isValidIp("192.-1.0.1"));// número negativo
    }
    /**
     * Aqui se lanza una NumberFormatException que se captura y se devuelve un false, mostrando un mensaje
     * por pantalla que indica que se debe introducir la ip en formato decimal*/

    @Test
    void testInvalidIPForma(){
        assertFalse(ValidacionUtil.isValidIp("192.168..0.1"));// dos puntos entre números
        assertFalse(ValidacionUtil.isValidIp("192.1680.1"));// falta un punto
        assertFalse(ValidacionUtil.isValidIp("abc.168.0.1"));// letras en la primera posicion
        assertFalse(ValidacionUtil.isValidIp("192.abc.0.1"));// letras en la segunda posicion
        assertFalse(ValidacionUtil.isValidIp("192.168.a.1"));// letras en la tercera posicion
        assertFalse(ValidacionUtil.isValidIp("192.168.0.1a1"));// letras en la cuarta posicion
    }
    /**
     * se comprueba que se lanza la excepcion numberFormatException*/

    @Test
    public void testInvalidIPTextFormat(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outcontent=new ByteArrayOutputStream();
        System.setOut(new PrintStream(outcontent));
        ValidacionUtil.isValidIp("abc.168.0.1");
        assertEquals("Formato no valido: Por favor recuerde que la ip debe estar en formato de números decimales", outcontent.toString().trim());
        System.setOut(originalOut);
    }

}
