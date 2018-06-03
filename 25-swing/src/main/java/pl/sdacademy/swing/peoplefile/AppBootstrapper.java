package pl.sdacademy.swing.peoplefile;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class AppBootstrapper {

	private static DefaultTableModel tableModel = new DefaultTableModel();

	static void start() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// prepare the jframe
				final JFrame jFrame = new JFrame();
				LayoutManager layout = new GridLayout(2, 1);
				jFrame.setLayout(layout);
				jFrame.setTitle("First Swing App");
				jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				// content
				addTable(jFrame);
				addButton(jFrame);

				// pack and show
				jFrame.setPreferredSize(new Dimension(640, 480));
				jFrame.pack();
				jFrame.setVisible(true);
			}

			private void addTable(JFrame jFrame) {
				tableModel.addColumn("First Column");
				tableModel.addColumn("Second Column");
				tableModel.addColumn("Number");

				JTable table = new JTable(tableModel);
				JScrollPane scrollPane = new JScrollPane(table);
				jFrame.add(scrollPane);
			}

			private void addButton(JFrame jFrame) {
				JPanel buttonPanel = new JPanel();
				buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
				JButton button = new JButton("Read People");
				button.addActionListener(e -> new Thread(AppBootstrapper::readFile).start());
				buttonPanel.add(button);
				jFrame.add(buttonPanel);
			}
		});
	}

	private static void readFile() {
		List<String> people = readPeopleLines();
		people.forEach(line -> readPersonLine(line));
	}

	private static List<String> readPeopleLines() {
		// we are using a classpath resource (inside src/main/resources), so we cannot use Paths to create a
		// path (the resource is relative inside the project structure)

		// We need a "/" when using getResourceAsStream - it will search for the file with "people.txt" name
		// inside the root classpath. Note that if we placed the file inside another directory (e.g.
		// files/people.txt) then we would need to use "/files/people.txt" name in getResourceAsStream method

		// using try-with-resources to avoid system resource leakage
		try (BufferedReader resource = new BufferedReader(new InputStreamReader(AppBootstrapper.class
			.getResourceAsStream("/people.txt"), Charset.forName("UTF-8")))) {
			return resource.lines().collect(Collectors.toList());
		}
		catch (IOException e) {
			// wrap the checked exception in runtime exception so we are not forced to handle it outside
			// this method
			throw new RuntimeException(e);
		}
	}

	private static void readPersonLine(String personLine) {
		Person person = parsePerson(personLine);
		tableModel.addRow(new Object[]{person.getFirstName(), person.getLastName(), person.getAge()});
		simulateLongOperation();
	}

	private static void simulateLongOperation() {
		try {
			Thread.sleep(2_000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static Person parsePerson(String personLine) {
		Scanner scanner = new Scanner(personLine);
		scanner.useDelimiter(" ");
		return new Person(scanner.next(), scanner.next(), scanner.nextInt());
	}
}
