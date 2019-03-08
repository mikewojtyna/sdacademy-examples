package pl.sdacademy.docmanagement.simple;

/**
 * Główny wyjątek rzucany przez repozytorium. Takie wyjątki stosuje się czasami, aby ułatwić łapanie wyjątków po
 * zadanych kategoriach, ich obsługę, logowanie oraz ukryć szczegóły techniczne rzucanych przez niższe warstwy
 * wyjątków. Np. zamiast deklarować rzucanie SqlException czy IOException, można rzucić wyjątek taki jak ten,
 * opakowując wyjątek warstwy niższej i dodając dodatkową wiadomość z danego kontekstu, co ułatwia później czytanie
 * logów i np. naprawianie problemów.
 */
public class DocumentRepositoryException extends RuntimeException {
	public DocumentRepositoryException(String message) {
		super(message);
	}

	public DocumentRepositoryException(String message, Throwable cause) {
		super(message, cause);
	}
}
