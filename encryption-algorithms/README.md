### Implementação do Algoritmo de criptografia
## Algoritmo de criptografia

<hr>

### Uso

> A criptografia tem como propósito diminuir/impedir que dados armazenados sejam lidos e permitir que dados sejam transmitidos de forma segura por um canal inseguro. Isso significa manter a confidencialidade, integridade e identidade desses dados.
* Confidencialidade
* Integridade
* Identidade


### Implementação

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
