package pojos;

import java.util.Objects;

public class Routine {

	private String exercise;

	private Machine machine;

	public Routine() {
	}

	public Routine(String name, Machine machine) {
		this.exercise = name;
		this.machine = machine;
	}

	public String getName() {
		return exercise;
	}

	public void setName(String name) {
		this.exercise = name;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Routine routine = (Routine) o;
		return exercise.equals(routine.exercise) && machine.equals(routine.machine);
	}

	@Override
	public int hashCode() {
		return Objects.hash(exercise, machine);
	}

	@Override
	public String toString() {
		return "Routine{" +
				"name='" + exercise + '\'' +
				", machine=" + machine +
				'}';
	}
}
