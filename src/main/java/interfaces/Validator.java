package interfaces;

public interface Validator {

	boolean validate(String username, String machineCode);

    String getName();
}
