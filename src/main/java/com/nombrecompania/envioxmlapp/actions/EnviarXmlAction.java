package com.nombrecompania.envioxmlapp.actions;

import com.nombrecompania.envioxmlapp.exceptions.ErrorEnviandoDatosException;
import com.nombrecompania.envioxmlapp.ConexionCliente;

public class EnviarXmlAction {
    private ConexionCliente conexionCliente;
    private final static String XML_Head="<?xml version=\"1.0\" encoding=\"UTF-8\"?><Msg Name=\"OpenStudies\" Type=\"XA\"><Param Name=\"ProcessId\">";
    private final static String XML_TAIL="</Param></Msg>";

    public EnviarXmlAction(ConexionCliente conexionCliente) { this.conexionCliente = conexionCliente; }

    public  void enviarXML(String identificador) throws ErrorEnviandoDatosException {
        StringBuilder xmlEnviable=new StringBuilder(XML_Head).append(identificador).append(XML_TAIL);
        conexionCliente.enviarDatos(xmlEnviable.toString());
    }
}
