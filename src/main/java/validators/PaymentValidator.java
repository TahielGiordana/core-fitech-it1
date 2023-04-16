package validators;

import interfaces.Validator;
import pojos.Machine;
import pojos.Person;
import services.PaymentFinder;

public class PaymentValidator implements Validator {

    private final PaymentFinder paymentFinder;

    public PaymentValidator(PaymentFinder paymentFinder) {
        this.paymentFinder = paymentFinder;
    }

    @Override
    public boolean validate(Person person, Machine machine) {
        return this.paymentFinder.paymentByPerson(person);
    }
}
