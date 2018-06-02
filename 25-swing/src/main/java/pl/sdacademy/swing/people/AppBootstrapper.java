package pl.sdacademy.swing.people;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

class AppBootstrapper {

	private DefaultTableModel peopleTableModel;

	AppBootstrapper() {
		peopleTableModel = new DefaultTableModel();
	}

	static void start() {
		new AppBootstrapper().renderRoot();
	}

	private void renderRoot() {
		SwingUtilities.invokeLater(() -> {
			final JFrame jFrame = new JFrame();
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			content(jFrame);

			jFrame.setPreferredSize(new Dimension(320, 240));
			jFrame.pack();
			jFrame.setVisible(true);
		});
	}

	private void content(JFrame root) {
		JPanel content = new JPanel(new GridLayout(2, 1));

		addTable(content);
		addButtons(content);

		root.add(content);
	}

	private void addButtons(JPanel content) {
		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton readPeopleButton = new JButton("Read People");
		readPeopleButton.addActionListener(event -> {
			peopleTableModel.addRow(new Object[]{"George", "Martin", "60"});
		});
		buttonsPanel.add(readPeopleButton);
		content.add(buttonsPanel);
	}

	private void addTable(JPanel content) {
		JPanel tablePanel = new JPanel(new GridLayout(1, 0));

		peopleTableModel.addColumn("First Name");
		peopleTableModel.addColumn("Last Name");
		peopleTableModel.addColumn("Age");

		JTable table = new JTable(peopleTableModel);
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane
			.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.createHorizontalScrollBar();

		tablePanel.add(scrollPane);

		content.add(tablePanel);
	}
}
