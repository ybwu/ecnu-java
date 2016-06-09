/******************************************************************************
 *  Compilation:  javac Ngon.java
 *  Execution:    java Ngon N
 *  Dependencies: Turtle.java
 *
 *  Plots a regular N-gon.
 *
 *  The side length s of a regular N-gon inscribed in a circle 
 *  of diameter 1 is sin(pi/N).
 *
 ******************************************************************************/

public class Ngon {

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int width = 128;
        int height = 128;

        double angle = 360.0 / N;
        double step  = Math.sin(Math.toRadians(angle/2.0));   // sin(pi/N)

        Turtle turtle = new Turtle(0.5, 0.0, angle/2.0);
        turtle.setCanvasSize(width, height);

        for (int i = 0; i < N; i++) {
            turtle.goForward(step);
            turtle.turnLeft(angle);
        }

    }
}
