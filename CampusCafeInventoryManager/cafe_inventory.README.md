# Campus Cafe Inventory

A beginner-friendly Java console application for managing up to 10 cafe products. Each product stores a name, price, and quantity. The menu supports adding, displaying, valuing, averaging, restocking, and duplicating products.

## Files

- `Product.java` — product fields, constructors, stock value, display method, and shared object counter.
- `Main.java` — menu-driven inventory program.
- `Warmup.java` — type-casting and switch fall-through exercise.
- `output.txt` — sample full test session.

## Compile and run

Open a terminal in this folder and run:

```bash
javac Product.java Main.java Warmup.java
java Main
```

To run the warm-up separately:

```bash
java Warmup
```

The program uses only the standard Java library (`java.util.Scanner`).

## Warmup.java: predicted and actual output

I predicted that the first line would be `7 5.0 -126`, followed by `Two` and `Three`. That is also the actual output: casting `7.9` to `int` removes the decimal part, assigning the integer `5` to a `double` produces `5.0`, and casting `130` to a signed byte wraps it to `-126`. The switch prints both `Two` and `Three` because there are no `break` statements, so execution falls through to the next case.

## Static variable versus instance variable

`totalProducts` is static, so there is one shared counter for the whole `Product` class rather than a separate counter in each object. `name` is an instance variable, so every `Product` object has its own name and changing one object's name does not change another object's name.

## Copy constructor and independent objects

The copy constructor receives another `Product` and copies its `name`, `price`, and `quantity` into a newly created object. The new object has its own fields, so changing `p2.name` changes only `p2`; it does not change `p1.name`, and the constructor increments `totalProducts` for the new object.

## Explicit casting from double to int

Java requires `(int)` because converting a `double` to an `int` is a narrowing conversion that may lose information. The cast discards the fractional part toward zero, so `(int) 12.75` becomes `12` (for positive averages, this is the same as rounding down).

## Test notes

The sample session in `output.txt` exercises all six menu options, rejects a product with a negative price, verifies the stock value and average, restocks Tea, duplicates Samosa, and exits. Three valid `Product` objects are created: Samosa, Tea, and Samosa (copy); the invalid product is not counted.
