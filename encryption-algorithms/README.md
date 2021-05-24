## Algoritmo de criptografia

<hr>

### Uso

> A criptografia tem como propósito diminuir/impedir que dados armazenados sejam lidos e permitir que dados sejam transmitidos de forma segura por um canal inseguro. Isso significa manter a confidencialidade, integridade e identidade desses dados.
* Confidencialidade
* Integridade
* Identidade

AES - O padrão de criptografia avançada - advanced encryption standard, também conhecido por seu nome original Rijndael, é uma especificação para a criptografia de dados eletrônicos estabelecida pelo instituto nacional de padrões e tecnologia dos E.U.A

### Implementação

* Classe Encrypt

> Criptografia
```xml
    public static String encrypt(String key, String iv, String cleartext) throws Exception {
            Cipher cipher = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] encrypted = cipher.doFinal(cleartext.getBytes());
            return new String(encodeBase64(encrypted));
    }
```
> Descriptografia
```xml
    public static String decrypt(String key, String iv, String encrypted) throws Exception {
            Cipher cipher = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            byte[] enc = decodeBase64(encrypted);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] decrypted = cipher.doFinal(enc);
            return new String(decrypted);
    }
```
