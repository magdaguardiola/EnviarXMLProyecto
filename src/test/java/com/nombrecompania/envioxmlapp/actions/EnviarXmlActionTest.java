package com.nombrecompania.envioxmlapp.actions;


import com.nombrecompania.envioxmlapp.exceptions.ErrorDeConexionException;
import com.nombrecompania.envioxmlapp.exceptions.ErrorEnviandoDatosException;
import com.nombrecompania.envioxmlapp.utils.ConexionCliente;
import org.junit.jupiter.api.Test;

class EnviarXmlActionTest {
      /**
       * En este caso, es necesario correr en primer lugar ServITTest de esta forma hay un servidor
       * levantado que pueda recibir los datos de enviados. El auténtico test se realizara en la clase ServerITTest
       * ya que alli se comprueva que los datos recibidos son los correctos*/
    ConexionCliente conex;

    @Test
    void envioDatosCorrectos() throws ErrorEnviandoDatosException, ErrorDeConexionException {
        conex=new ConexionCliente("127.0.0.1", 45000);
        EnviarXmlAction envio= new EnviarXmlAction(conex);
        envio.enviarXML("prueba");
    }

    @Test
    void  envioDatosINCorrectos() throws ErrorEnviandoDatosException, ErrorDeConexionException{
        conex=new ConexionCliente("127.0.0.1", 45000);
        EnviarXmlAction envio= new EnviarXmlAction(conex);
        envio.enviarXML("no pasa prueba");
    }
}