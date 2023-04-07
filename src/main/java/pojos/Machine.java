package pojos;

public class Machine {

	private String serialCode;
	private String name;

	public Machine() {
	}

	public Machine(String serialCode, String name) {
		this.serialCode = serialCode;
		this.name = name;
	}

	public String getSerialCode() {
		return serialCode;
	}

	public void setSerialCode(String serialCode) {
		this.serialCode = serialCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
