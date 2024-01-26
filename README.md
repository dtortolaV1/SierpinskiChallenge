# Sierpinski Pattern Challenges

## Feel free to use helper functions and whatever is needed!

## Forbidden:
- ChatGPT/CoPilot
- StackOverflow etc

## Hints:
- https://en.wikipedia.org/wiki/Sierpi%C5%84ski_carpet
- https://en.wikipedia.org/wiki/Sierpi%C5%84ski_triangle
- Recursion! https://runestone.academy/ns/books/published/pythonds/Recursion/pythondsSierpinskiTriangle.html
- There are variety of implementation of those algorithms =)

## Judging criteria:
- Clean code: The code should be well-structured, easy to read, and maintainable. It should follow good programming practices and conventions.
- Correctness: The program should produce the correct output for the given input.
- Efficiency: The program should be efficient in terms of time and space complexity. It should not take too long to run or consume too much memory. (Recursion depth, redundancy, collections, floating unused variables etc)
- Edge cases

### Step 1 Sierpinski triangle n=1
Write a Java program to draw Triangle as below.

```java
drawTriangle(4);

Output:
   *   
  * *  
 *   * 
*******
```
### Step 2: Sierpinski Carpet
Implement a Java program to generate and display a Sierpinski Carpet using recursion. The provided code gives you a starting point with a function drawSierpinskiCarpet that takes two parameters - order and size. The order determines the level of recursion, and size sets the size of the carpet. The program initializes a 2D char array representing the carpet, fills it with empty spaces, and then populates it with '*' characters based on the Sierpinski pattern.

```
Output for drawSierpinskiCarpet(3, 27)
***************************
* ** ** ** ** ** ** ** ** *
***************************
***   ******   ******   ***
* *   * ** *   * ** *   * *
***   ******   ******   ***
***************************
* ** ** ** ** ** ** ** ** *
***************************
*********         *********
* ** ** *         * ** ** *
*********         *********
***   ***         ***   ***
* *   * *         * *   * *
***   ***         ***   ***
*********         *********
* ** ** *         * ** ** *
*********         *********
***************************
* ** ** ** ** ** ** ** ** *
***************************
***   ******   ******   ***
* *   * ** *   * ** *   * *
***   ******   ******   ***
***************************
* ** ** ** ** ** ** ** ** *
***************************
```

### Step 3: Sierpinski Triangle Implementation

Write a Java program to draw a Sierpinski Triangle Implement the drawSierpinskiTriangle function that takes an integer parameter n representing the order of the triangle. The function should draw an equilateral triangle of size 2^n - 1 using '*' characters. The triangle should be centered in the console. The program should have a main method to demonstrate the function.


```java
drawSierpinskiTriangle(3);

Output:
    *           
    **          
                
   *  *         
   ** **        
                
                
  *     *       
 **     **                      
*  *   *  *     
** **  ** **    

```

## The output does not need to be exactly the same. The closer to the best results the better!
