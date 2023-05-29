package com.nombrecompania.envioxmlapp.actions;


import org.junit.jupiter.api.Test;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * clase que sirve para hacer un test de integracion; genera un servidor que recibira los
 * datos enviados y comprueba que estos son los correctos, se haria lanzando el primer metodo
 * de la clase EnviarXmlActionTest*/
public class ServerITTest {

    @Test
    void recepcionServerCorrecto() throws IOException{
        ServerSocket serverSocket = new ServerSocket(45000);
        Socket clientSocket =serverSocket.accept();
        InputStream inputStream = clientSocket.getInputStream();
        DataInputStream dis = new DataInputStream(inputStream);
        String extension = dis.readUTF();
        if (extension !=null && !extension.isEmpty()){
            System.out.println(extension);
        }else{
            System.out.println("No se ha recibido la extensión o ha ocurrido un error.");
        }
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\"?><Msg Name=\"OpenStudies\" Type=\"XA\"><Param Name=\"ProcessId\">prueba</Param></Msg>",extension);
        dis.close();
        inputStream.close();
        clientSocket.close();
        serverSocket.close();
    }

    /**
     * en este caso habria que lanzar el segundo test de EnviarXmlActionTest que envia un identificador
     * distinto al esperado
     * @throws IOException*/

    @Test
    void recepcionServerInCorrecto() throws IOException{
        ServerSocket serverSocket = new ServerSocket(45000);
        Socket clientSocket =serverSocket.accept();
        InputStream inputStream = clientSocket.getInputStream();
        DataInputStream dis = new DataInputStream(inputStream);
        String extension = dis.readUTF();
        if (extension !=null && !extension.isEmpty()){
            System.out.println(extension);
        }else{
            System.out.println("No se ha recibido la extensión o ha ocurrido un error.");
        }
        assertNotEquals("<?xml version=\"1.0\" encoding=\"UTF-8\"?><Msg Name=\"OpenStudies\" Type=\"XA\"><Param Name=\"ProcessId\">prueba</Param></Msg>",extension);
        dis.close();
        inputStream.close();
        clientSocket.close();
        serverSocket.close();
    }

}
