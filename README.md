# Accumulate function with Functional Programming
### Implemented in 2 languages - Java, Racket

Purpose is comparing functional programming in languages that have different paradigms
* Java - Imperative and OOP
* Racket - Declarative and Functional

### What is accumulate function?
It accumulates different things that change with some constant value

### Examples
1 + 3 + 5 + 7 = ?
```.java
int result = Accumulate.<Integer>accumulate(
        (arg1, arg2) -> arg1 + arg2,
        1,
        4,
        current -> current + 2
);
```
```.rkt
(accumulate + 1 4 (lambda (x) (+ x 2)))
```

<br/>

5 * 25 * 625 = ?
```.java
int result = Accumulate.<Integer>accumulate(
        (arg1, arg2) -> arg1 * arg2,
        5,
        3,
        current -> current * current
);
```
```.rkt
(accumulate * 5 3 (lambda (x) (square x)))
```

<br />

Concatenates all letters of english alphabet: "ABCD...Z"
```.java
String result = Accumulate.<String>accumulate(
        (arg1, arg2) -> arg1.concat(arg2),
        "A",
        26,
        current -> String.valueOf((char) ((current.charAt(0)) + 1))
);
```
```.rkt
(accumulate string-append "a" 26
	    (lambda (letter) (string
			      (integer->char (+ 1 (char->integer (string-ref letter 0)))))))
```

<br />

And many other things...
<br />
<br />
### Bonus Java Example
Calculates total salary of all employees in one list 
```.java
List<Employee> employees = Arrays.asList(
        new Employee("Farhad", 1000), new Employee("Namiq", 2000),
        new Employee("Emin", 1300), new Employee("Cemil", 800),
        new Employee("Elmir", 2300), new Employee("Rasim", 4000)
);
// counter is some global variable for keeping index and is 0 as initial value
double totalSalary = Accumulate.<Double>accumulate(
        (arg1, arg2) -> arg1 + arg2,
        employees.get(counter).getSalary(),
        employees.size(),
        current -> employees.get(++counter).getSalary()
);
```
