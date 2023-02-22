package CellTypes;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class BaseCell extends Rectangle {
    int id;
    int x;
    int y;
    int width;
    int height;
    int arcWidth;
    int arcHeight;
    int xVelocity;
    int yVelocity;
    Random rand;
    static final int CELL_SIZE = 25;

    public BaseCell(int id, int x, int y) {
        setRect(x, y, CELL_SIZE, CELL_SIZE, CELL_SIZE, CELL_SIZE);

        this.id = id;

        // Calculating direction. MISSING: Add random speed
        rand = new Random();
        int direction = rand.nextInt(2);
        if (direction == 0) {
            xVelocity = -1;
        }
        else {
            xVelocity = 1;
        }

        direction = rand.nextInt(2);
        if (direction == 0) {
            yVelocity = -1;
        }
        else {
            yVelocity = 1;
        }
    }

    public int move() {
        x += xVelocity;
        y += yVelocity;
        return -1;
    }

    public void draw(Graphics g) {
        g.setColor(Color.pink);
        g.fillRoundRect((int) getX(), (int) getY(), (int) getWidth(), (int) getHeight(), getArcWidth(), getArcHeight());
    }

    public void setRect(int x, int y, int w, int h, int arcWidth, int arcHeight) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
    }

    public void changeSize(double w, double h) {
        this.width = (int) w;
        this.height = (int) h;
    }


    public double getX() {
        return x;
    }


    public double getY() {
        return y;
    }


    public double getWidth() {
        return width;
    }


    public double getHeight() {
        return height;
    }

    public int getArcWidth() {
        return arcWidth;
    }

    public int getArcHeight() {
        return arcHeight;
    }

    public void invertXVelocity() {
        this.xVelocity *= -1;
    }

    public void invertYVelocity() {
        this.yVelocity *= -1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Rectangle2D getBounds2D() {
        return null;
    }
}
