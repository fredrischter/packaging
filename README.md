# packaging
Packaging logic solution using spring batch and Kotlin

## How to build and run

mvn install

java -jar target/packaging-0.0.1-SNAPSHOT.jar example.txt

Output:

4
-
2,7
8,9

## What does it do?

It finds the most valuable set of things to put in the package regarding the given capacity.

For each line in the input (example.txt) file, it knows the capacity of package and list of things with index, weight and value.

The output tells the value of the built package having the highest possible sum of values of things regarding the capacity constraint.

## Structure

The project is a simple runnable jar receiving input by given file and writing response in the standard output.

Althrought it requires minimum java, I've used Kotlin and modern classes structure (Exceptions, Models, etc) and it's perfectly easy to turn it into a REST API.