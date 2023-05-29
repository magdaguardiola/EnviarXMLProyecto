package com.nombrecompania.envioxmlapp.exceptions;

import java.io.IOException;

public class ErrorEnviandoDatosException extends Throwable {
    public ErrorEnviandoDatosException(IOException e) { super(e); }
}
