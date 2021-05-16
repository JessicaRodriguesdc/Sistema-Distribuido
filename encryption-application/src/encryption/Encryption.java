package encryption;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Encryption {
	/*
	 * Será ultilizado o KeyGenerator para gerar a chave controlar a criptografia e
	 * descriptografia das informacoes
	 * 
	 * 
	 * É passado o parametro/string de criptografia de criptografia
	 * 
	 * Algoritimos de criptografia simétricos: AES , RC2 , RC4 , RC5, IDEA, Blowfish
	 * Algoritimos de criptografia acimetricos: RSA HASH: MD5
	 */
	public static void encryptAndDecrypt(String mensagem) {
		try {
			KeyGenerator key = KeyGenerator.getInstance("AES");
			SecretKey secretKey = key.generateKey();
			Cipher cipher;
			cipher = Cipher.getInstance("AES");

			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] mensagemCriptografada = cipher.doFinal(mensagem.getBytes());

			System.out.println("======== Criptografia ========");
			System.out.println(mensagemCriptografada);

			System.out.println();

			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			byte[] descriptografia = cipher.doFinal(mensagemCriptografada);
			String mensagemDescriptografada = new String(descriptografia);

			System.out.println("======= Descriptografia =======");
			System.out.println(mensagemDescriptografada);

		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
		} catch (NoSuchPaddingException ex) {
			Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvalidKeyException ex) {
			Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalBlockSizeException ex) {
			Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
		} catch (BadPaddingException ex) {
			Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
