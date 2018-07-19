package Programik.Szyfrowanie;

import javax.crypto.Cipher;
import java.security.PublicKey;

public class Decrypt {

	public static byte[] decrypt(PublicKey publicKey, byte[] encrypted) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, publicKey);

		return cipher.doFinal(encrypted);
	}
}
