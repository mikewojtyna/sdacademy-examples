package pl.sdacademy.printer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrinterQueueTest {

	@DisplayName("should print text")
	@Test
	void test01() {

		//given
		Printer printer = new Printer(1);
		Documents documents = new Documents(false);
		//when
		printer.print(documents);
		//then
		//document is printed
		Assertions.assertThat(documents.isPrinted()).isTrue();
	}

	@DisplayName("should print documents if thresh hold is reached")
	@Test
	void test02() {
		//given
		int documentsThreshHold = 3;
		Printer printer = new Printer(documentsThreshHold);
		Documents doc1 = notPrintedDocuments();
		Documents doc2 = notPrintedDocuments();
		Documents doc3 = notPrintedDocuments();
		//when
		printer.print(doc1);
		printer.print(doc2);
		printer.print(doc3);
		//then
		Assertions.assertThat(doc1.isPrinted()).isTrue();
		Assertions.assertThat(doc2.isPrinted()).isTrue();
		Assertions.assertThat(doc3.isPrinted()).isTrue();
	}


	@DisplayName("Should print documents if minimum number of documents is reached and then don't print if " +
		"there are next document.")
	@Test
	void test03() {
		//given
		int documentsThreshold = 2;
		Printer printer = new Printer(documentsThreshold);
		Documents doc0 = notPrintedDocuments();
		Documents doc1 = notPrintedDocuments();
		Documents doc2 = notPrintedDocuments();
		//when
		printer.print(doc0);
		printer.print(doc1);
		printer.print(doc2);
		//then
		assertThat(doc0.isPrinted()).isTrue();
		assertThat(doc1.isPrinted()).isTrue();
		assertThat(doc2.isPrinted()).isFalse();
	}

	private Documents notPrintedDocuments() {
		return new Documents(false);
	}
}
