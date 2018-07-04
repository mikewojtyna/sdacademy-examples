package pl.sdacademy.employee;

class AppBootstrapper {
	static void run(String[] args) {
		try {
			Employee employee = new Employee(args[0], args[1], args[2], args[3]);
			employee.setHeight(Integer.valueOf(args[4]));
			employee.addNewInterest(args[5]);

			System.out.println(employee);
		}
		catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}
}