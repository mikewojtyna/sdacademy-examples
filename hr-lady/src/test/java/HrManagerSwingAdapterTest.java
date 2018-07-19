import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class HrManagerSwingAdapterTest {
	@DisplayName("should add to empty table model new row matching employee created by HrManager given Adam " +
		"Miauczyński"
		)
	@Test
	void test01() {
		//given
		// create empty table model
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("First Name");
		tableModel.addColumn("Last Name");
		tableModel.addColumn("Date of Birth");
		HrManagerSwingAdapter adapter = new HrManagerSwingAdapter(fakeCreateHrManager());
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
	private HRManager fakeCreateHrManager() {
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

	@DisplayName("should add two rows to empty table model matching sorted HrManager data ")
	@Test
	void test02(){
		//given
		// create empty table model
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("First Name");
		tableModel.addColumn("Last Name");
		tableModel.addColumn("Date of Birth");
		HrManagerSwingAdapter adapter = new HrManagerSwingAdapter(fakeSortHrManager());
		//when
		adapter.sortByLastName(tableModel);
		//then
		//row 0
		Object firstNameFromTableModel = tableModel.getValueAt(0, 0);
		assertThat(firstNameFromTableModel).isEqualTo("Tomek");
		Object lastNameFromTableModel = tableModel.getValueAt(0, 1);
		assertThat(lastNameFromTableModel).isEqualTo("Tomczuk");
		Object dateOfBirth = tableModel.getValueAt(0, 2);
		assertThat(dateOfBirth).isEqualTo("09-09-1999");
		// row1
		Object firstNameFromTableMode2 = tableModel.getValueAt(1, 0);
		assertThat(firstNameFromTableMode2).isEqualTo("Igor");
		Object lastNameFromTableMode2 = tableModel.getValueAt(1, 1);
		assertThat(lastNameFromTableMode2).isEqualTo("Nowak");
		Object dateOfBirth2 = tableModel.getValueAt(1, 2);
		assertThat(dateOfBirth2).isEqualTo("08-08-1899");
	}

	private HRManager fakeSortHrManager() {
		return new HRManager(){
			@Override
			public List<Employee> sortByFirstName() {
				return Arrays.asList(new Employee("Tomek", "Tomczuk", "09-09-1999"),
					new Employee("Igor", "Nowak", "08-08-1899"));

			}
		};
	}

	@DisplayName("zakladajac ze table model nie jest pusty, powinien zostac zastapiony table modelem zwroconym " +
		"przez metode sort z HrManagera")
	@Test
	void test03 (){
		//given
		// create empty table model
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("First Name");
		tableModel.addColumn("Last Name");
		tableModel.addColumn("Date of Birth");
		tableModel.addRow(new Object[]{"George", "Martin", "11-01-2010"});
		HrManagerSwingAdapter adapter = new HrManagerSwingAdapter(fakeSortHrManager());
		//when
		adapter.sortByLastName(tableModel);
		//then
		//row 0
		Object firstNameFromTableModel = tableModel.getValueAt(0, 0);
		assertThat(firstNameFromTableModel).isEqualTo("Tomek");
		Object lastNameFromTableModel = tableModel.getValueAt(0, 1);
		assertThat(lastNameFromTableModel).isEqualTo("Tomczuk");
		Object dateOfBirth = tableModel.getValueAt(0, 2);
		assertThat(dateOfBirth).isEqualTo("09-09-1999");
		// row1
		Object firstNameFromTableMode2 = tableModel.getValueAt(1, 0);
		assertThat(firstNameFromTableMode2).isEqualTo("Igor");
		Object lastNameFromTableMode2 = tableModel.getValueAt(1, 1);
		assertThat(lastNameFromTableMode2).isEqualTo("Nowak");
		Object dateOfBirth2 = tableModel.getValueAt(1, 2);
		assertThat(dateOfBirth2).isEqualTo("08-08-1899");
	}

}
