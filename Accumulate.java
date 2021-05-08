import java.util.*;

/**
 * @author Farhad Mehdizada
 */
public class Accumulate {
    private static int counter = 0;

    public static <T> T accumulate(Operation<T> operation, T initialTerm,
                                      int numOfTerms, NextOperation<T> nextOperation) {
        T result = initialTerm;
        int counter = 0;
        while (counter < numOfTerms - 1) {
            T next = nextOperation.next(initialTerm);
            result = operation.operate(result, next);
            initialTerm = next;
            counter++;
        }
        return result;
    }

    public static void main(String[] args) {
	// calculates 2 + 4 + 6
        int result = Accumulate.<Integer>accumulate(
                (arg1, arg2) -> arg1 + arg2,
                2,
                3,
                current -> current + 2
        );

        // calculates 2 + 4 + 16 + 256
        int resultPow = Accumulate.<Integer>accumulate(
                (arg1, arg2) -> arg1 + arg2,
                2,
                4,
                current -> current * current
        );

	// concatenates all letters of english alphabet
        String resultLetters = Accumulate.<String>accumulate(
                (arg1, arg2) -> arg1.concat(arg2),
                "A",
                26,
                current -> String.valueOf((char) ((current.charAt(0)) + 1))
        );

	// calculates total salary of list of employees
        List<Employee> employees = Arrays.asList(
                new Employee("Farhad", 1000), new Employee("Namiq", 2000),
                new Employee("Emin", 1300), new Employee("Cemil", 800),
                new Employee("Elmir", 2300), new Employee("Rasim", 4000)
        );
        double totalSalary = Accumulate.<Double>accumulate(
                (arg1, arg2) -> arg1 + arg2,
                employees.get(counter).getSalary(),
                employees.size(),
                current -> employees.get(++counter).getSalary()
        );
    }
}


@FunctionalInterface
interface Operation<T> {
    T operate(T arg1, T arg2);
}


@FunctionalInterface
interface NextOperation<T> {
    T next(T current);
}


class Employee {
    private String name;
    private double salary;

    Employee(String name, double salary) {
	this.name = name;
	this.salary = salary;
    }

    double getSalary() {
	return salary;
    }
}
