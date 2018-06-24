import javax.swing.table.DefaultTableModel;

import javax.swing.table.DefaultTableModel;
public class HrManagerSwingAdapter {
	private HRManager hrManager;
	public HrManagerSwingAdapter(HRManager hrManager) {
		this.hrManager = hrManager;
	}
	public void addNewEmployee(DefaultTableModel tableModel, String firstName, String lastName, String
		dateOfBirth){
		Employee newEmployee = hrManager.create(firstName, lastName, dateOfBirth);
		tableModel.addRow(new Object[]{newEmployee.getFirstName(), newEmployee.getLastName(), newEmployee.getDateOfBirth()});
	}
}