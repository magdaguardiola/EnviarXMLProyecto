package com.nombrecompania.envioxmlapp.utils;

public class ValidacionUtil {
    /**
     * válida el número de puerto, debe estar entre 0 y 65535
     * @param puerto
     * @return
     */
    public static boolean isValidPuerto(int puerto){return !(puerto<0|puerto>65535);}

    public static boolean isValidIp(String ipDeEnvio){
        String[] numIP=ipDeEnvio.split("\\.");
        if(numIP.length !=4) return false;
        try {
            for (String numero : numIP
            ) {
                if (Integer.parseInt(numero) < 0 | Integer.parseInt(numero) > 255) return false;
            }
            return true;
        }catch (NumberFormatException e){
            System.out.println("Formato no válido: por favor recuerde que la IP debe estar en formato decimal");
            return false;
        }
    }
}
