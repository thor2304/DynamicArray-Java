# About DynamicArray-Java

This project has been made for the course Object oriented Programming at SDU.
It shows a Dynamic Array in Java. <br> 
The purpose is to help communicate the ideas behind Javas ArrayList.

In the class DynamicArray, methods have been implemented to add elements, remove elements, get the size of the array and more. 

The purpose of each method is described through the JavaDocs found in the interface. 
When using IntelliJ, JavaDocs can be shown by hovering the mouse, or placing the text 
cursor on the method, followed by pressing `ctrl + q`. 
JavaDocs are inherited, so this can be done on the implementation as well. 

## Inspiration
The interface of the HomeMadeList has been constructed to mimic that of ArrayList. <br>
This similarity is displayed in ArrayDemo.java, where the same operations are performed on both lists. 

# Changes from the brief
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
 