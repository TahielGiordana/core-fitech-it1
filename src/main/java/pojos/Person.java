package pojos;

public class Person {

	private Routine routine;
	private String name;
	private String lastname;

	public Person() {
	}

	public Person(Routine routine, String name, String lastname) {
		this.routine = routine;
		this.name = name;
		this.lastname = lastname;
	}

	public Routine getRoutine() {
		return routine;
	}

	public void setRoutine(Routine routine) {
		this.routine = routine;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "Person{" +
				"routine=" + routine +
				", name='" + name + '\'' +
				", lastname='" + lastname + '\'' +
				'}';
	}
}
