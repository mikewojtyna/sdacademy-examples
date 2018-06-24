import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import javax.swing.table.DefaultTableModel;
import static org.assertj.core.api.Assertions.*;
public class HrManagerSwingAdapterTest {
	@DisplayName("should add to table model new row matching employee created by HrManager given Adam Miauczyński"
		+ " 11-11-1988")
	@Test
	void test01() {
		//given
		// create empty table model
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("First Name");
		tableModel.addColumn("Last Name");
		tableModel.addColumn("Date of Birth");
		HrManagerSwingAdapter adapter = new HrManagerSwingAdapter(fakeHrManager());
		//when
		adapter.addNewEmployee(tableModel, "Adam","Miauczyński","11-11-1988");
		//then
		Object firstNameFromTableModel = tableModel.getValueAt(0, 0);
		assertThat(firstNameFromTableModel).isEqualTo("Zoltan");
		Object lastNameFromTableModel = tableModel.getValueAt(0, 1);
		assertThat(lastNameFromTableModel).isEqualTo("Bloodhammer");
		Object dateOfBirth = tableModel.getValueAt(0, 2);
		assertThat(dateOfBirth).isEqualTo("11-01-1210");
	}
	private HRManager fakeHrManager() {
		return new HRManager() {
			@Override
			Employee create(String firstName, String lastName, String dateOfBirth) {
				if(firstName.equals("Adam") && lastName.equals("Miauczyński") && dateOfBirth.equals
					("11-11-1988"))
					return new Employee("Zoltan", "Bloodhammer", "11-01-1210");
				throw new IllegalArgumentException("Bad arguments");
			}
		};
	}
}
