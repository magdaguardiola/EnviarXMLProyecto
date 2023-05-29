package com.nombrecompania.envioxmlapp.exceptions;

import java.io.IOException;

public class ErrorCerrandoConexionException extends Throwable{
    public ErrorCerrandoConexionException (IOException e) {super (e);}
}
