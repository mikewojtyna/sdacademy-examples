package Programik.Szyfrowanie;

import javax.crypto.Cipher;
import java.security.PrivateKey;

public class Encrypt {
	public static byte[] encrypt(PrivateKey privateKey, String message) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);

		return cipher.doFinal(message.getBytes());

	}
}
