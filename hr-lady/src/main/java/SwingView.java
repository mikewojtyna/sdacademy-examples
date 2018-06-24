import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
public class SwingView {
	private static final HrManagerSwingAdapter adapter = new HrManagerSwingAdapter(new HRManager());
	private static DefaultTableModel tableModel = new DefaultTableModel();;
	public static void main(String[] args) {
		tableModel.addColumn("First Name");
		tableModel.addColumn("Second Name");
		tableModel.addColumn("Date of Birth");
		SwingUtilities.invokeLater(() -> {
			// prepare the jframe
			final JFrame jFrame = new JFrame();
			LayoutManager layout = new GridLayout(3, 1);
			jFrame.setLayout(layout);
			jFrame.setTitle("HrManager");
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			// content
			addFirstRow(jFrame);
			addSecondRow(jFrame);
			addThirdRow(jFrame);
			// pack and show
			jFrame.setPreferredSize(new Dimension(640, 480));
			jFrame.pack();
			jFrame.setVisible(true);
		});
	}
	private static void addThirdRow(JFrame jFrame) {
		JPanel row = new JPanel();
		LayoutManager layout = new GridLayout(3, 1);
		row.setLayout(layout);
		row.add(new JLabel("Filters"));
		JPanel lastNameFilter = new JPanel();
		lastNameFilter.add(new JLabel("last name"));
		lastNameFilter.add(new JTextField("domyslna wartość"));
		lastNameFilter.add(new JButton("Okejka"));
		row.add(lastNameFilter);
		JPanel lastNameFilter2 = new JPanel();
		lastNameFilter2.add(new JLabel("szukanie"));
		lastNameFilter2.add(new JTextField("domyslna wartość"));
		lastNameFilter2.add(new JButton("Oki doki"));
		row.add(lastNameFilter2);
		jFrame.add(row);
	}
	private static void addSecondRow(JFrame jFrame) {
		JTable table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		jFrame.add(scrollPane);
	}
	private static void addFirstRow(JFrame jFrame) {
		// populate row
		JPanel row = new JPanel();
		JButton addButton = new JButton("Add");
		JTextField firstNameTextField = new JTextField("firstName");
		JTextField lastNameTextField = new JTextField("lastName");
		JTextField dateOfBirthTextField = new JTextField("dateOfBirth");
		addButton.addActionListener(e -> {
			adapter.addNewEmployee(tableModel, firstNameTextField.getText(),lastNameTextField.getText(),dateOfBirthTextField
				.getText() );
		});
		row.add(addButton);
		row.add(new JLabel("fist name"));
		row.add(firstNameTextField);
		row.add(new JLabel("last name"));
		row.add(lastNameTextField);
		row.add(new JLabel("date of birth"));
		row.add(dateOfBirthTextField);
		// add row to jframe
		jFrame.add(row);
	}
}