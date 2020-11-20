# Exceptions
## & Enumerations

---
## Today
1. Enumerated types.
1. Exceptions.
1. Wrapper Classes.

---
## Resources
1. Deitel, chapter 11.
1. The Oracle Java Tutorials 
  + [Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html)
  + [Enumerated Types](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html)
1. A good explanation of [Exceptions](https://stackabuse.com/exception-handling-in-java-a-complete-guide-with-best-and-worst-practices/).


---
## Enumerated Types

Let variables span over a fixed set of values:
```java code-noblend
public enum Direction {
    NORTH, SOUTH, EAST, WEST
}
```
Can be used:
```java code-noblend
Direction d = Direction.NORTH;
if (d == Direction.NORTH)
	 d = Direction.EAST;
System.out.println(d); // EAST
```
This is the simple and common use of enumerated types.
---

Enumerated types are actually just like classes, but:
1. Have a predefined set of instances.
1. Cannot be instantiated in any other way.
1. Have some more default methods.

```java code-noblend
public enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY;
}
```




---
@code[java code-max code-noblend](src/MainForDay.java)



---
An enumerated type be extended with fields and methods just like any class.
@box[rounded](The only difference is the initialization)
+ Constructor must be `private`.
+ There is a first line specifying and initializing all instances.


---
@code[java code-max code-noblend](src/Planet.java)
@[1-5](This is the special part.)
@[7-14](The constructor **must** be private.)
@[16-25]
@[27-37](we can override `toString` if we want.)



---
# Exceptions

---
An exception is an event that occurs during the execution of a program that disrupts the normal flow of instructions.

Exceptions are normally (but not always) used for handling error conditions such as programming bugs, network errors, file system errors, etc.

@css[fragment](*Here is an example you already know:*)

---
@code[java code-max code-noblend](src/NullExample.java)
@[1-7]
@[9-19](what would we see?)


---
@img[span-80](resources/null.png)
+ The exception was thrown inside `g`, which immediately returns. 
+ This causes `f` to throw it immediately, and then `main` does the same.
+ It is all shown in the **stack trace**, as well as the type of exception thrown.


---
### Throwing an Exception
+ When an error occurs, an **exception object** is created and then the method **throws** it.
+ This object contains information about the error.
+ It is created with the `new` keyword, just like any other object. 
+ It is thrown with the `throw` keyword.


---
@code[java code-max code-noblend](src/NullThrower.java)
@[2-11]
@[13-15]


---
@img[](resources/null2.png)
+ Actually, this exception would have been thrown automatically even without the check (where?).
+ We used a constructor of the `NullPointerException` class that takes a string message (see the message printed above).
+ We could have also thrown a different exception.

---
### Java Exceptions Class Diagram
@img[span-80](resources/exceptionTree.png)

and there are more...


---
### Exception Handling
We saw how to create and throw exceptions. 
But we can also **catch** an exception.
+ If we do, it does not propagate further.
+ If we don't, the method stops, and the exception is passed to the calling method.
+ This is done using a `try`-`catch` block.






---
@img[span-80](resources/exceptions.gif)

@css[fragment](*An example:*)






---
@code[java code-noblend](src/Catcher.java)

Execution does not stop, because we caught the exception.


---
### Catching
+ `catch (WhateverException e)` defines a new variable `e` of type 
`WhateverException`
+ If this type of exception is thrown within the `try` block, instead of the method returning, execution jumps immediately to the catch block.
  + `e` holds the exception object.
  + You can call `e.getMessage()`.
  + `e.printStackTrace()`, prints to standard error all the information as we saw before.
+ Afterwards, the exception disappears and the program continues normally.      
---
+ If `SubException` is a subclass of `WhateverException`, it will also be caught.
+ There can be many `catch` statements, and the first that matches, catches. 


---
@code[java code-max code-noblend](src/TryCatch.java)
@[1-5](`g` just throws a `NullPointerException`.)
@[7-17](What would this print?)
@css[fragment]("BXD", and there is no error: the exception was caught.)





---
### Defining new Exceptions
+ To create your own exception type, just extend any exception you want.
```java code-noblend
public class MyException extends Exception {
}
```
+ If you want it to be able to hold a message, you must add a constructor:
```java code-noblend
public class MyException extends Exception {
	public MyException(String msg) {
		super(msg);
	}
}
```

---
+ You can also add other fields and methods, and so have more information about the error that occurred.
+ It is good practice to end the name with `Exception`.
+ For a `Stack` class, we might declare `StackException`, and two subclasses 
`EmptyStackException` and `FullStackException`, so that we can use different `catch` statements to differentiate between them.
 

---
### Declaring
A method that **may** throw an exception must declare this in the method signature with the `throws` keyword.
+ It is enough to specify a superclass of the thrown exception.
+ Can specify a number of thrown exceptions, e.g., `throws StackException, IOException`.
+ `RuntimeException`s and `Error`s don't need to be specified.


---
For example,
```java code-noblend
public File getFile(String url) 
		throws FileNotFoundException {
    // some code
    throw new FileNotFoundException();
}
```
But we could have also specified `throws IOException` or `throws Exception`.



---
### Why use Exceptions?

It seems like we can do all this with return statements. However, exceptions are very useful for a few reasons.

See [here](https://www.iitk.ac.in/esc101/05Aug/tutorial/essential/exceptions/advantages.html) for the full examples.


---
#### Separating Error Handling from Regular Code
Instead of complicated error codes and many if-then-elses, we can write:

```java code-noblend
public String readFile(String fileName) {
   try {
        open the file;
        determine its size;
        allocate that much memory;
        read the file into memory;
        close the file;
    } catch (fileOpenFailed) {
        doSomething;
    } catch (sizeDeterminationFailed) {
        doSomething;
    } catch (memoryAllocationFailed) {
        doSomething;
    } catch (readFailed) {
        doSomething;
    } catch (fileCloseFailed) {
        doSomething;
    }
}
```


---
#### Propagating Errors Up 
```java code-noblend
void method1() {
    try {
        call method2;
    } catch (exception e) {
        doErrorProcessing;
    }
}
void method2() throws exception {
    call method3;
}
void method3() throws exception {
    call readFile;
}
```
Instead of all methods having to consider all errors, they just declare they may throw the exception.


    

---
### Three Kinds of Exceptions
All exceptions extend the class `Throwable`.
+ **Errors:** core problems, like an error in the JVM. 
  + Don't throw it yourself. 
  + Normally don't catch them.
+ **Checked exceptions:** subclasses of `Exception`.
  + Problems that should generally be handled.
  + Must be caught or specified with a `throws`.
  + `IOException`, `FileNotFoundException`, etc. 


  
---
+ **Runtime exceptions:** subclasses of `RuntimeException`, which is a special subclass of `Exception`.
  + Problems that should normally terminate the program
    + like programming errors.
  + No need to specify them with `throws`, but can be caught if needed.
  + `NullPointerException`, `ArithmeticException` (divide by 0), etc.
  + Are not recommended for general use.
  
  
    
---
@code[java code-max code-noblend](src/StringArray.java)
@[3-15](`StringArrayException` is our own, and extends `Exception`.)
@[17-28](`setRange` may throw this exception because `set` can throw it. what if `StringArrayException` was a subclass of `RuntimeException`?)



---
@code[java code-max code-noblend](src/MainForStringArray.java)
@[4-7]
@[9-16](User enters start index, number of repetitions, and string to fill.)
@[17-25](Here we handle the different possible errors.)


---
### `finally`
+ After `try` and `catch`, we can have one `finally` block.
+ The code in it is executed no matter what happened in the try-catch:
  + If an exception is thrown,  
  + or the `try` block completes normally,
  + or even if the `return` statement is executed!
+ You can have `finally` even without `catch`.


---
## Exercise

This was asked in a test. It just checks you know the basic rules for catching exceptions.

`ExceptionA` and `ExceptionB` both extend `Exception`, and you should say what the program eventually prints.


---
@code[java code-max code-noblend](src/Thrower.java)
@[2-8](starting point.)
@[10-21] 
@[23-34](What is printed? and why is the last line commented?)
@css[fragment]("g1g2gFf3fFfEnd")


---
### Fine Print

Writing code that java knows is unreachable results in a compilation error.
+ Like after a return statement, or a statement that surely throws an exception.
+ Where there are several catches for a try, and we first catch an exception that is a superclass of an exception we catch later. 



---
### Chained Exceptions
1. Java exceptions have another constructor:
  + `new Exception(Exception cause)`
1. When doing `catch (Exception e)`, you can:
  + `e.getCause()` to get this exception back.
1. Use it when you want to catch an exception and throw another kind instead.
  
@css[fragment](*We'll see it in our exercise.*)


  
---
# Wrapped Types

---
Every atomic variable type has a class that is just a wrapper for the primitive variable.
<table>
	<tr>
		<th>primitive type</th>
		<th>wrapper class</th>
	</tr>
	<tr>
		<td>`int`</td>
		<td>`Integer`</td>
	</tr>
	<tr>
		<td>`char`</td>
		<td>`Character`</td>
	</tr>
	<tr>
		<td>`boolean`</td>
		<td>`Boolean`</td>
	</tr>
</table>
Other wrapper class names are like `Boolean`: the same as the primitive type name, but capitalized.



---
@code[java code-max code-noblend](src/IntegerExample.java)

Wrapper classes have many static methods (such as `toString` which gets a radix as above), and non static ones.



---
### Auto-boxing & Auto-unBoxing
+ Java can convert automatically between a primitive type and the wrapper class instance. so we can write:
```java code-noblend
Integer x = 6;
int y = x;
```
+ This works for method calls as well.
+ so we can use primitive types and wrapper classes interchangeably.


---
### Why use them?
Wrapper classes have many advantages:
+ Access to all their methods.
+ Can be used by any function expecting an `Object`.
+ Can be `null`. 
  + For example, as a special return value from a method.

Why not use them?
@css[fragment](computational and memory cost.)



---
## `Number`
An abstract superclass of all numerical wrappers.
+ It has methods: `doubleValue()`, `intValue()`, etc.
+ Useful for designing general numeric methods, like:
```java code-noblend
public double sum(Number[] numbers) {
	double sum = 0;
	for (Number n : numbers)
		sum += n.doubleValue();
	return sum;  
}
```
It can take a `Double[]`, an `Integer[]`, etc.
@css[fragment](But cannot take a `double[]`.)


---
### Comment

Use `equals` and not `==` when comparing wrapper classes (although `==` may work in some cases).



---
## Exercise

Actually to exercise interfaces, and then we add exceptions. For now, ignore the `throws`.
```java code-noblend
public interface Scorer {
	int score(int n) throws ScorerException;
}
```
`score` returns a value for an int. 

---
Write the following implementing classes:
1. `SquareScore` which gives a score of `3` to a number if it is an exact square (25, 81, etc.).
1. `DivideScore`, is constructed with an integer `d`, and gives a score of `1` if `n` is divisible by `d`.

In the class `Util` write the method:
```java code-noblend
public static int sumScores(Scorer[] ss, int n)
```
which gives for the number `n`, the sum of scores that the scorers in `ss` give s.



---
@code[java code-max code-noblend](src/ex1noExceptions/Main.java)
This is an example usage.
All answers are in the source code, in package `ex1noExceptions`.


---
Next, add exception handling:
1. Define an exception `ScorerException` (non runtime).
1. In `SquareScorer`, throw it if `n < 0`.
1. In `DivideScorer`, if `d <= 0`.
1. In `sumScores`, if `ScoreException` happens, catch it and throw an 
`IllegalArgumentException`.
1. In `Main`, if a `ScoreException` happens, print trace and exit.
  + Don't catch `IllegalArgumentException`. What will happen if it is thrown?
  
---

Answers are in the package `ex1`.