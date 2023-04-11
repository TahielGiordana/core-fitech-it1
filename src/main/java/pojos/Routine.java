package pojos;

import java.util.List;
import java.util.Objects;

public class Routine {

	private String name;

	private List<Machine> machines;

	public Routine(String name, List<Machine> machines) {
		this.name = name;
		this.machines = machines;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Machine> getMachines() {
		return machines;
	}

	public void setMachines(List<Machine> machines) {
		this.machines = machines;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Routine routine = (Routine) o;
		return name.equals(routine.name) && machines.equals(routine.machines);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, machines);
	}

	@Override
	public String toString() {
		return "Routine{" +
				"name='" + name + '\'' +
				", machineSerialCodes=" + machineSerialCodes +
				'}';
	}
}
