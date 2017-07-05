package ec.utpl.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static boolean validarCedula(String cedula) {
        boolean cedulaCorrecta;
        if (cedula.length() == 10) // ConstantesApp.LongitudCedula
        {
            try {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));

                if (tercerDigito < 6) {
                    // Coeficientes de validaciÃ³n cÃ©dula
                    // El decimo digito se lo considera dÃ­gito verificador

                    int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1))
                                * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }

                } else {
                    cedulaCorrecta = false;
                }
            } catch (NumberFormatException nfe) {
                cedulaCorrecta = false;
            } catch (Exception err) {
                cedulaCorrecta = false;
            }

        } else {
            cedulaCorrecta = false;
        }
        return cedulaCorrecta;
    }

    public static boolean validarEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\."
                + "[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*"
                + "(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        if (email != null) {
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        } else {
            return false;
        }
    }

    public static boolean validarEsNumerico(String campo) {
        try {
            Double.parseDouble(campo);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static boolean validarEsEntero(String campo) {
        try {
            Integer.parseInt(campo);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static boolean validarEsPositivo(String campo) {
        try {
            if (Integer.parseInt(campo) > 0) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static String validarSexo(String sexo, long fila) {

        // revision 11 Marzo
        String resultado = "";
        fila++;
        if (sexo.equals("HOMBRE") || sexo.equals("MUJER")) {
            resultado = "";
        } else {
            resultado = "Fila: "
                    + fila
                    + " Sexo no corresponde.  Valor esperado:  HOMBRE, MUJER.\n";
        }
        return resultado;

    }

    public static void fileMove(String sourceFile, String destinationFile) {
        // System.out.println("Desde: " + sourceFile);
        // System.out.println("Hacia: " + destinationFile);

        try {
            File inFile = new File(sourceFile);
            File outFile = new File(destinationFile);

            FileInputStream in = new FileInputStream(inFile);
            FileOutputStream out = new FileOutputStream(outFile);

            int c;
            while ((c = in.read()) != -1)
                out.write(c);

            in.close();
            out.close();

            File file = new File(sourceFile);
            if (file.exists()) {
                file.delete();
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Hubo un error de entrada/salida!!!");
        }
    }

}
