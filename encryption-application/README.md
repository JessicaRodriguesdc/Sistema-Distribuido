### Implementação do Algoritmo de criptografia

<hr>

> KeyGenerator - Gera uma chave secreta <br>
SecretKey <br>
Cipher
```xml
KeyGenerator key = KeyGenerator.getInstance("AES");
SecretKey secretKey = key.generateKey();
Cipher cipher;
cipher = Cipher.getInstance("AES");
```

> Criptografia
```xml
cipher.init(Cipher.ENCRYPT_MODE, secretKey);
byte[] mensagemCriptografada = cipher.doFinal(mensagem.getBytes());
```

> Descriptografia
```xml
cipher.init(Cipher.DECRYPT_MODE, secretKey);
byte[] descriptografia = cipher.doFinal(mensagemCriptografada);
String mensagemDescriptografada = new String(descriptografia);
```
