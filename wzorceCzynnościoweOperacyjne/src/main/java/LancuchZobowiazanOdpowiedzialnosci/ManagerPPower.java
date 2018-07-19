package LancuchZobowiazanOdpowiedzialnosci;

class ManagerPPower extends PurchasePower {

	protected double getAllowable() {
		return BASE * 10;
	}

	protected String getRole() {
		return "Manager";
	}
}
