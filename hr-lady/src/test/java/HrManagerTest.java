import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class HrManagerTest {

	HRManager hrManager = new HRManager();

	@DisplayName("Should create non-null employee when are given first name, last name and date of birth.")
	@Test
	void test0() {
		//given
		String firstName = "Adam";
		String lastName = "Nowak";
		String dateOfBirth = "01-02-1970";

		//when
		Employee employee = hrManager.create(firstName, lastName, dateOfBirth);

		//then
		assertThat(employee).isNotNull();
	}

	@DisplayName("Should create a new employee with all fields.")
	@Test
	void test1() {
		//given
		String firstName = "Adam";
		String lastName = "Nowak";
		String dateOfBirth = "01-02-1970";

		//when
		Employee employee = hrManager.create(firstName, lastName, dateOfBirth);

		//then
		assertThat(employee.getFirstName()).isEqualTo(firstName);
		assertThat(employee.getLastName()).isEqualTo(lastName);
		assertThat(employee.getDateOfBirth()).isEqualTo(dateOfBirth);
	}

	@DisplayName("Should check if new employee is add to the database.")
	@Test
	void test2() {
		//given
		String firstName = "Adam";
		String lastName = "Nowak";
		String dateOfBirth = "01-02-1970";
		Employee newEmployee = hrManager.create(firstName, lastName, dateOfBirth);

		//when
		List<Employee> allEmployees = hrManager.findAll();

		//then
		assertThat(allEmployees).containsOnly(newEmployee);
	}
	@DisplayName("Should check if two new employees are added to the database.")
	@Test
	void test3() {
		//given
		Employee adam = hrManager.create("Adam", "Nowak", "01-02-1970");
		Employee jurgen = hrManager.create("Jurgen", "Muller", "13-12-1966");

		//when
		List<Employee> allEmployees = hrManager.findAll();

		//then
		assertThat(allEmployees).containsOnly(adam, jurgen);

	}
	@DisplayName("Should find single employee when given last name.")
	@Test
	void test4() {
		//given
		Employee adam = hrManager.create("Adam", "Nowak", "01-02-1970");
		Employee jurgen = hrManager.create("Jurgen", "Muller", "13-12-1966");
		//when
		List<Employee> foundEmployees = hrManager.searchByLastName("Muller");
		//then
		assertThat(foundEmployees).containsOnly(jurgen);
	}
	@DisplayName("Should find every employee when given last name")
	@Test
	void test5() {
		//given
		Employee adam = hrManager.create("Adam", "Nowak", "01-02-1970");
		Employee jurgen = hrManager.create("Jurgen", "Muller", "13-12-1966");
		Employee stefan = hrManager.create("Stefan", "Muller", "13-02-1996");
		//when
		List<Employee> foundEmployees = hrManager.searchByLastName("Muller");
		//then
		assertThat(foundEmployees).containsOnly(jurgen, stefan);
	}
	@DisplayName("Should find no employee when there is no employee with given last name.")
	@Test
	void test6() {
		//given
		Employee adam = hrManager.create("Adam", "Nowak", "01-02-1970");
		Employee jurgen = hrManager.create("Jurgen", "Muller", "13-12-1966");
		Employee stefan = hrManager.create("Stefan", "Muller", "13-02-1996");
		//when
		List<Employee> foundEmployees = hrManager.searchByLastName("Kowalski");
		//then
		assertThat(foundEmployees).isEmpty();
	}
	@DisplayName("Should find two employees when their first name matches given search phrase .")
	@Test
	void test7() {
		//given
		Employee adam = hrManager.create("Adam", "Nowak", "01-02-1970");
		Employee jurgenMuller = hrManager.create("Jurgen", "Muller", "13-12-1966");
		Employee jurgenKowalski = hrManager.create("Jurgen", "Kowalski", "13-02-1996");
		//when
		List<Employee> foundEmployees = hrManager.searchByPhrase("Jurgen");
		//then
		assertThat(foundEmployees).containsOnly(jurgenKowalski, jurgenMuller);
	}
	@DisplayName("Should find two employees when their last name matches given search phrase .")
	@Test
	void test8() {
		//given
		Employee adam = hrManager.create("Adam", "Nowak", "01-02-1970");
		Employee jurgenNowak = hrManager.create("Jurgen", "Nowak", "13-12-1966");
		Employee jurgenKowalski = hrManager.create("Jurgen", "Kowalski", "13-02-1996");
		//when
		List<Employee> foundEmployees = hrManager.searchByPhrase("Nowak");
		//then
		assertThat(foundEmployees).containsOnly(adam, jurgenNowak);
	}
	@DisplayName("Should find two employees when their date of birth matches given search phrase .")
	@Test
	void test9() {
		//given
		Employee adam = hrManager.create("Adam", "Nowak", "01-02-1970");
		Employee jurgenNowak= hrManager.create("Jurgen", "Nowak", "01-02-1970");
		Employee jurgenKowalski = hrManager.create("Jurgen", "Kowalski", "13-02-1996");
		//when
		List<Employee> foundEmployees = hrManager.searchByPhrase("01-02-1970");
		//then
		assertThat(foundEmployees).containsOnly(adam, jurgenNowak);
	}
	@DisplayName("Should sort by first name ascending")
	@Test
	void test10() {
		//given
		Employee adam = hrManager.create("Adam", "Nowak", "01-02-1970");
		Employee jurgen = hrManager.create("Jurgen", "Nowak", "01-02-1970");
		Employee zenon = hrManager.create("Zenon", "Kowalski", "13-02-1996");

		//when
		List<Employee> sortedEmployees = hrManager.sortByFirstName();

		//then
		assertThat(sortedEmployees).containsExactly(adam,jurgen, zenon);
	}
	@DisplayName("should sort two employees by first name descending")
	@Test
	void test11(){
		//given
		Employee adam = hrManager.create("Adam", "Nowak", "01-02-1970");
		Employee jurgen = hrManager.create("Jurgen", "Krycha", "01-02-1970");
		//when
		List<Employee> sortEmployees = hrManager.sortByFirstNameBubble();

		//then
		assertThat(sortEmployees).containsExactly(jurgen, adam);
	}
	@DisplayName("should sort ")
	@Test
	void test12(){
		//given
		Employee adam = hrManager.create("Adam", "Nowak", "01-02-1970");
		Employee jurgen = hrManager.create("Jurgen", "Nowak", "01-02-1970");
		Employee zenon = hrManager.create("Zenon", "Kowalski", "13-02-1996");
		//when
		List<Employee> sortEmployees = hrManager.sortByFirstNameBubble();
		//then
		assertThat(sortEmployees).containsExactly(zenon, jurgen, adam);
	}
	@DisplayName("disgusting example")
	@Test
	void test13(){
		//given
		Employee adam = hrManager.create("Adam", "Nowak", "01-02-1970");
		Employee jurgen = hrManager.create("Jurgen", "Nowak", "01-02-1970");
		Employee zenon = hrManager.create("Zenon", "Kowalski", "13-02-1996");
		Employee beata = hrManager.create("Beata", "KFDD", "01-06-1970");
		//when
		List<Employee> sortEmployees = hrManager.sortByFirstNameBubble();
		//then
		assertThat(sortEmployees).containsExactly(zenon, jurgen, beata, adam);
	}
}
