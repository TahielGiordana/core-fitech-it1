package pojos;

import java.util.Objects;

public class Person {

	private String username;
	private boolean feedPaid;
	private Routine routine;

	public Person() {
	}

	public Person(String username, boolean feedPaid, Routine routine) {
		this.username = username;
		this.feedPaid = feedPaid;
		this.routine = routine;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isFeedPaid() {
		return feedPaid;
	}

	public void setFeedPaid(boolean feedPaid) {
		this.feedPaid = feedPaid;
	}

	public Routine getRoutine() {
		return routine;
	}

	public void setRoutine(Routine routine) {
		this.routine = routine;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return feedPaid == person.feedPaid && Objects.equals(username, person.username) && Objects.equals(routine, person.routine);
	}

	@Override
	public int hashCode() {
		return Objects.hash(username, feedPaid, routine);
	}

	@Override
	public String toString() {
		return "Person{" +
				"username='" + username + '\'' +
				", feedPaid=" + feedPaid +
				", routine=" + routine +
				'}';
	}
}
