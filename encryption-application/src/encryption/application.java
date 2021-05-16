package encryption;

import java.util.Scanner;

public class application {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Informe a mensagem a ser criptografada: ");
		String mensagem = scan.next();
		
		Encryption.encryptAndDecrypt(mensagem);
	}

}