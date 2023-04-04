package pojos;

import java.util.List;

public class Routine {

	private String name;

	private List<String> machineSerialCodes;

	public Routine(String name, List<String> machineSerialCodes) {
		this.name = name;
		this.machineSerialCodes = machineSerialCodes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getMachineSerialCodes() {
		return machineSerialCodes;
	}

	public void setMachineSerialCodes(List<String> machineSerialCodes) {
		this.machineSerialCodes = machineSerialCodes;
	}
}
