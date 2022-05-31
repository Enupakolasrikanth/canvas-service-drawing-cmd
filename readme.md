
# Given Code Challenge
You're given the task of writing a simple console version of a drawing program.
At this time, the functionality of the program is quite limited but this might change in the future.
In a nutshell, the program should work as follows:
1. Create a new canvas
2. Start drawing on the canvas by issuing various commands
3. Quit


Command 		Description
C w h           Should create a new canvas of width w and height h.
L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only
horizontal or vertical lines are supported. Horizontal and vertical lines
will be drawn using the 'x' character.
R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and
lower right corner is (x2,y2). Horizontal and vertical lines will be drawn
using the 'x' character.
B x y c         Should fill the entire area connected to (x,y) with "colour" c. The
behavior of this is the same as that of the "bucket fill" tool in paint
programs.
Q               Should quit the program.

__Sample I/O__

Below is a sample run of the program. User input is prefixed with enter command:

enter command: C 20 4
----------------------
|                    |
|                    |
|                    |
|                    |
----------------------

enter command: L 1 2 6 2
----------------------
|                    |
|xxxxxx              |
|                    |
|                    |
----------------------

enter command: L 6 3 6 4
----------------------
|                    |
|xxxxxx              |
|     x              |
|     x              |
----------------------

enter command: R 14 1 18 3
----------------------
|             xxxxx  |
|xxxxxx       x   x  |
|     x       xxxxx  |
|     x              |
----------------------

enter command: B 10 3 o
----------------------
|oooooooooooooxxxxxoo|
|xxxxxxooooooox   xoo|
|     xoooooooxxxxxoo|
|     xoooooooooooooo|
----------------------

enter command: Q

# Solution

### Project Structure
For the implementation of the _drawing program_,please have the following _components_:
It has written in java.Used the maven.
- A parser for parsing the input typed by the user into commands and for this we use `PaintFactory`.
- A new `Paint` class for each command we want to add to the canvas drawing program.
- A class which define the state of the program and for this we use `CanvasPaint`.

The main class that we will use to run the below class
- `CanvasPaintApp.java` as invoker main class.
- package `command` contains all concrete commands.
-And the `CanvasPaint.java` the receiver which defines what to do on each input command receiver. 

Example of _"create new canvas"_ implementation:


The project is composed by the following packages:
- `canvas.service.drawing.cmd.command`  Entry point of the application.
- `ccanvas.service.drawing.cmd.service` All command services supported by the application.
- `canvas.service.drawing.cmd.core` Core of the application, `CanvasPaint.java` in this case.
- `canvas.service.drawing.cmd.exception` All checked exceptions thrown by the application.

---
###	Bucket filler "algorithm"
The approach used for filling the area, in `CommandBucketFill`, is as follows:
1. Call the method which fill only one pixel (if free)
2. Call recursively same method for the 4 adjacent pixels: x+1, y; x, y+1; x-1, y; x, y-1.
3. Method exits when finds borders or already a filled pixel.

###	Tests

Choosed `TDD approach` for Canvas implementation. This means the TestCases had been created before or during the development phase and not in the end.
 
For each functionality is present a different test file:
- `PaintBucketFillTest.java` Test cases for BucketFiller command.
- `PaintLineTest.java` Test cases for drawing a line command.
- `CommandRectangleTest.java` Test cases for drawing a rectangle command.
- `UseCasesTest.java` Test cases covering bugs discovered in ta second moment.

###	A Working build
Using maven plugin `maven-jar-plugin` we can package our application in `canvas-service-drawing-cmd.jar`.
If you want to create a new jar use:
mvn clean install

Run: mvn clean install you can see the two jars will be created in target folder
```
canvas-service-drawing-cmd.jar
canvas-service-drawing-cmd-jar-with-dependencies.jar

You can test  the out put by running the canvas-service-drawing-cmd-jar-with-dependencies.jar 

The main java program is CanvasPaintApp.