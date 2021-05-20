# Accumulate function with Functional Programming
### Implemented in 2 languages - Java, Racket

Purpose is comparing functional programming in languages that have different paradigms
* Java - Imperative and OOP
* Racket - Declarative and Functional

### What is accumulate function?
It accumulates different things that changes with some constant value

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

concatenates all letters of english alphabet: "ABCD...Z"
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

