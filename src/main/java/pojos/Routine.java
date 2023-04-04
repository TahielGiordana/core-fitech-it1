package pojos;

import java.util.List;

public class Routine {

	private List<String> machineSerialCodes;

    public Routine(List<String> machineSerialCodes) {
        this.setMachineSerialCodes(machineSerialCodes);
    }

	public List<String> getMachineSerialCodes() {
		return machineSerialCodes;
	}

	public void setMachineSerialCodes(List<String> machineSerialCodes) {
		this.machineSerialCodes = machineSerialCodes;
	}
}
