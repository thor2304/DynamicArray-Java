# About DynamicArray-Java

This project has been made for the course Object oriented Programming at SDU.
It shows a Dynamic Array in Java. <br> 
The purpose is to help communicate the ideas behind Javas ArrayList.

In the class DynamicArray, methods have been implemented to add elements, remove elements, get the size of the array and more. 

The purpose of each method is described through the JavaDocs found in the interface. 
When using IntelliJ, JavaDocs can be shown by hovering the mouse, or placing the text 
cursor on the method, followed by pressing `ctrl + q`. 
JavaDocs are inherited, so this can be done on the implementation as well. 

## Where to start?
Try cloning the project and running the main method in ArrayDemo.java. 
It has been made to showcase how similar the HomeMadeList is to Javas ArrayList.

The output has colored headers to help orient you in the different sections. I hope you enjoy it.

## Inspiration
The interface of the HomeMadeList has been constructed to mimic that of ArrayList. <br>
This similarity is displayed in ArrayDemo.java, where the same operations are performed on both lists. 

## Automated tests?
For this project I have chosen not to implement automated tests despite my deep love for them.
The reason is that when this demo is introduced to the students, they have not yet seen automated testing.
Therefore, I have assumed that this would add unnecessary complexity, for the students.

I would gladly add automated tests if this is something that is deemed valuable for the students. 
I personally believe that it could be a great example to demonstrate how the elements in ArrayDemo would be translated into automated tests.

# Changes from the project description
The following changes have been made to conform to the interface of ArrayList:
- `getFill()` has been renamed to `size()` 
- `ìndex()` has been renamed to `indexOf(int)`
- `ìnsert()` has been renamed to `add(int)`

The following methods have been added to show more of how a dynamic array functions:
- `set(int, int)`
- `remove(int)`
- `get(int)`

I think the following change makes the demo easier to understand: 
- `getSize()` has been renamed to `getUnderlyingSize()`  
 
# Problems?
If you spot any errors, please either contact me directly or open a pull request with the proposed fix.

If you have problems understanding my reasoning for the structure, 
or simply have trouble understandign the code, **please** reach out.
If you dont understand it, i dont think the students will either.

# Author
Author: Thor Malmby Jørgin <br>
Email: tjoer21@student.sdu.dk

Based on a description from Aslak Johansen
