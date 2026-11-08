import edu.cymbal.graphics.CanvasAPI;
import edu.cymbal.graphics.Graphics;
import edu.cymbal.graphics.PainterAPI;
import java.awt.Color;
import java.util.Random;

public class Aquarium {
    public static void drawCircle(PainterAPI painter, int circleCirumference, Color color){
        painter.startFill(color);

        painter.circle(circleCirumference);

        painter.finishFill();
    }

    public static void drawTriangle(PainterAPI painter, int lineLength, Color color){

        painter.startFill(color);

        painter.turnLeft(90);
        painter.forward(lineLength);
        painter.turnLeft(120);
        painter.forward(lineLength);
        painter.turnLeft(120);
        painter.forward(lineLength);

        painter.finishFill();

    }

    public static void drawRectangle(PainterAPI painter, int height, int width, Color color){
        painter.startFill(color);

        painter.forward(width);
        painter.turnRight(90);
        painter.forward(height);
        painter.turnRight(90);
        painter.forward(width);
        painter.turnRight(90);
        painter.forward(height);
        painter.turnRight(90);

        painter.finishFill();
    }

    public static void drawSeaGrass(PainterAPI painter, int height, int width, Color color){
        painter.startFill(color);

        painter.forward(width);
        painter.turnLeft(90);
        painter.forward(height);
        painter.turnLeft(90);
        painter.forward(width);
        painter.turnLeft(90);
        painter.forward(height);
        painter.turnLeft(90);

        painter.finishFill();
    }

    public static void drawBigFish(PainterAPI painter, int x1, int y1, int x2, int y2, int x3, int y3, int lineLength, int circleCirumference, Color color){
        painter.reset();
        painter.liftPen();
        painter.moveTo(x1,y1);
        painter.lowerPen();

        drawCircle(painter, circleCirumference, color);
        painter.liftPen();
        painter.moveTo(x2,y2);
        painter.lowerPen();
        drawTriangle(painter, lineLength, color);
        painter.liftPen();
        painter.moveTo(x3,y3);
        painter.lowerPen();
        drawCircle(painter, 7, Color.BLACK);
    }

    public static void drawMinnow(PainterAPI painter, int x1, int y1, int x2, int y2, int x3, int y3, int lineLength, int height, int width, Color color){
        painter.reset();
        painter.liftPen();
        painter.moveTo(x1,y1);
        painter.lowerPen();

        drawRectangle(painter, height, width, color);
        painter.liftPen();
        painter.moveTo(x2,y2);
        painter.lowerPen();
        drawTriangle(painter, lineLength, color);
        painter.liftPen();
        painter.moveTo(x3,y3);
        painter.lowerPen();
        drawCircle(painter, 3, Color.BLACK);
    }

    public static void drawFishFood(PainterAPI painter, int x, int y, Color color){
        painter.liftPen();
        painter.moveTo(x,y);
        painter.lowerPen();

        //randomizer set-up
        int min = 5;
        int max = 20;

        for(int i = 0; i <= 10; i++){
            int randomizedCircleSize = min + (int)(Math.random() * ((max - min) + 1));

            drawCircle(painter, randomizedCircleSize, color);
            painter.liftPen();
            painter.forward(75);
            painter.lowerPen();
        }

    }

    public static void drawSeaGrassCluster(PainterAPI painter, int x, int y, int width, Color color){
        painter.liftPen();
        painter.moveTo(x,y);
        painter.lowerPen();

        //randomizer set-up
        int min = 10;
        int max = 50;

        for(int i = 0; i<= 80; i++){
            int randomizedHeight = min + (int)(Math.random() * ((max - min) + 1));

            drawSeaGrass(painter, randomizedHeight, width, color);
            painter.liftPen();
            painter.forward(width);
            painter.lowerPen();
        }
    }

    public static void drawSand(PainterAPI painter, int x, int y, int height, int width,Color color){
        painter.liftPen();
        painter.moveTo(x,y);
        painter.lowerPen();
        
        drawRectangle(painter, height, width, color);

    }

    public static void main(String[] args) {
        CanvasAPI canvas = Graphics.createCanvas(800, 600, "My First Drawing");
        canvas.setBackgroundColor(Color.CYAN);

        PainterAPI painter = canvas.getPainter();

        //Setting up decor
        drawSand(painter, -400, -250, 50, 800,Color.YELLOW);
        drawSeaGrassCluster(painter, -400,-250, 10, Color.GREEN);
        drawFishFood(painter, -375, 250, Color.ORANGE);

        //Drawing big fish
        drawBigFish(painter, -300, 100, -200, 125, -335, 175, 60, 60, Color.WHITE);
        drawBigFish(painter, 100, 75, 205, 100, 65, 150, 60, 60, Color.GRAY);

        //Drawing green and blue minnows
        drawMinnow(painter, -150, -150, -90, -165, -145, -160, 15, 15, 50, Color.BLUE);
        drawMinnow(painter, -115, -115, -40, -130, -110, -125, 15, 20, 65, Color.GREEN);
        drawMinnow(painter, -175, -90, -115, -105, -170, -100, 15, 15, 50, Color.BLUE);
        drawMinnow(painter, -90, -90, -15, -105, -85, -100, 15, 20, 65, Color.GREEN);
        drawMinnow(painter, -60, -60, 0, -75, -55, -70, 15, 15, 50, Color.BLUE); //Blue Minnow
        drawMinnow(painter, -30, -30, 45, -45, -25, -40, 15, 20, 65, Color.GREEN);
        drawMinnow(painter, -150, -150, -90, -165, -145, -160, 15, 15, 50, Color.BLUE); //Blue Minnow
    }
}
