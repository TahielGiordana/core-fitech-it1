package pojos;

import java.util.List;
import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Routine routine = (Routine) o;
		return name.equals(routine.name) && machineSerialCodes.equals(routine.machineSerialCodes);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, machineSerialCodes);
	}

	@Override
	public String toString() {
		return "Routine{" +
				"name='" + name + '\'' +
				", machineSerialCodes=" + machineSerialCodes +
				'}';
	}
}
