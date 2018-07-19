import javax.swing.table.DefaultTableModel;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.List;

public class HrManagerSwingAdapter {
	private HRManager hrManager;
	public HrManagerSwingAdapter(HRManager hrManager) {
		this.hrManager = hrManager;
	}
	public void addNewEmployee(DefaultTableModel tableModel, String firstName, String lastName, String
		dateOfBirth){
		Employee newEmployee = hrManager.create(firstName, lastName, dateOfBirth);
		addRow(tableModel, newEmployee);
	}

	private void addRow(DefaultTableModel tableModel, Employee newEmployee) {
		tableModel.addRow(new Object[]{newEmployee.getFirstName(), newEmployee.getLastName(), newEmployee.getDateOfBirth()});
	}

	public void sortByLastName(DefaultTableModel tableModel) {
		tableModel.getDataVector().clear();
		List<Employee> sortedEmployees = hrManager.sortByFirstName();
		for (Employee employee: sortedEmployees) {
			addRow(tableModel, employee);
		}
	}
}