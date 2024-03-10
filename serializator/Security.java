package serializator;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {
    //Funcion que convierte un array de bytes en cadena hexadecimal
    /**
     * Funcion que convierte un array de bytes en cadena hexadecimal
     * @param hash es el array de bytes que se van a pasar a hex
     * @return devuelve una cadena hexadecimal del array de bytes
     * Se crea un StringBuilder para pasar a hexadecimal para crear la cadena
     * Recoore el array de bytes y lo transforma en hexadecimal y la cadena se guarda en el StringBuilder
     */
    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
    //Funcion que hashea la contraseña hexadecimal con el algoritmo
    /**
     * Funcion que hashea la contraseña hexadecimal con el algoritmo
     * @param password contraseña a hashear
     * @return devuelve el hash de la contraseña en formato hexadecimal
     * @throws NoSuchAlgorithmException indica una excepcion del algoritmo
     * Se crea una isntancia de MessageDigest que usa el algoritmo SHA·-256
     * Se convierte la contraseña en bytes usando la codificacion UTF-8 y se aplica el SHA3-256 para hashear la contraseña
     */
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        final MessageDigest digest = MessageDigest.getInstance("SHA3-256");
        final byte[] hashbytes = digest.digest(
                password.getBytes(StandardCharsets.UTF_8));
        String sha3Hex = bytesToHex(hashbytes);
        return sha3Hex;
    }
}
