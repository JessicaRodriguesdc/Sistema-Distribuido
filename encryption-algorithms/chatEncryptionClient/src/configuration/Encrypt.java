package configuration;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64;

public class Encrypt {
	
	// Algoritmo que será utilizado (AES)
    private final static String alg = "AES";
    // Modo de criptografia a ser usado
    private final static String cI = "AES/CBC/PKCS5Padding";
    
    /**
    * Função do tipo string que recebe uma chave (key), um vetor de inicialização (iv)
    * e o texto a ser criptografado
    * @param key a chave do tipo String a ser usada
    * @param iv o vetor de inicialização a ser usado
    * @param cleartext o texto não criptografado a ser criptografado
    * @return o texto cifrado no modo String
    * @throws Exception pode retornar exceções dos seguintes tipos: NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException
    */
    public static String encrypt(String key, String iv, String cleartext) throws Exception {
            Cipher cipher = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] encrypted = cipher.doFinal(cleartext.getBytes());
            return new String(encodeBase64(encrypted));
    }
 
    /**
    * Função do tipo string que recebe uma chave (key), um vetor de inicialização (iv)
    * e o texto a ser decifrado
    * @param key a chave do tipo String a ser usada
    * @param iv o vetor de inicialização a ser usado
    * @param criptografou o texto cifrado no modo String
    * @return o texto descriptografado no modo String
    * @throws Exception pode retornar exceções dos seguintes tipos: NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException
    */
    public static String decrypt(String key, String iv, String encrypted) throws Exception {
            Cipher cipher = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            byte[] enc = decodeBase64(encrypted);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] decrypted = cipher.doFinal(enc);
            return new String(decrypted);
    }

}
