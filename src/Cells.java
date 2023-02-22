import CellTypes.BaseCell;
import CellTypes.SomaticCell;

import java.awt.*;
import java.util.HashMap;
import java.util.Random;

public class Cells {
    HashMap<Integer, BaseCell> cells;
    int cellCount;
    public Cells() {
        this.cells = new HashMap<>();
        this.cellCount = 0; // Use for setting unique Cell ID's

    }

    // Type: 1 = Somatic, 2 = Infected, 3 = Vaccine
    public void createCell(int type) {
        Random rand = new Random();
        int x = rand.nextInt(1000);
        int y =  rand.nextInt((int)(1000*0.5555));

        createCellHelper(type, x, y);
    }

    public void createCell(int type, int x, int y) {
        createCellHelper(type, x, y);
    }

    private void createCellHelper(int type, int x, int y) {
        switch (type) {
            case 1:
                cells.put(cellCount, new SomaticCell(cellCount, x, y));
                cellCount++; // Remove this and uncomment the one after the switches AFTER implementing Infected/Vaccine
                break;
            case 2:
                //cells.put(cellCount, new InfectedCell(cellCount, x, y));
                break;
            case 3:
                //cells.put(cellCount, new VaccineCell(cellCount, x, y));
                break;

        }
//        cellCount++;
    }

    public int move() {

        for (int i=0; i<cellCount; i++) {
            checkCollision(i);

            int moveResult = cells.get(i).move(); // If returns -1 then it does not need to split.

            if (moveResult > -1) { // If moveResult > -1 then split the cell into two
                split(i);
            }
        }
        return -1;
    }

    private void checkCollision(int id) {
        BaseCell cellA = cells.get(id);

        for (int i=0; i<cellCount; i++) {
            if (i==id)
                continue;
            BaseCell cellB = cells.get(i);

            if (cellA.intersects(cellB)) {
                cellA.invertYVelocity();
                cellA.invertXVelocity();
                cellA.move();
                cellB.invertXVelocity();
                cellB.invertYVelocity();
                cellB.move();
            }
//            int ALeft = cellA.getX();
//            int ARight = cellA.getX() + cellA.getWidth();
//            int ATop = cellA.getY();
//            int ABot = cellA.getY() + cellA.getHeight();
//            int BLeft = cellB.getX();
//            int BRight = cellB.getX() + cellA.getWidth();
//            int BTop = cellB.getY();
//            int BBot = cellB.getY() + cellB.getWidth();
//
//            if (ALeft < BRight && ARight > BLeft && ATop < BBot && ABot > BTop) {
//                if (ALeft >= BLeft && ALeft <= BRight) {
//                    cellA.invertXVelocity();
//                    cellB.invertXVelocity();
////                    cellA.move();
//                }
//                else if (ARight >= BLeft && ARight <= BRight) {
//                    cellA.invertXVelocity();
//                    cellB.invertXVelocity();
////                    cellA.move();
//                }
//                else if (ATop >= BTop && ATop <= BBot) {
//                    cellA.invertYVelocity();
//                    cellB.invertYVelocity();
////                    cellA.move();
//                }
//                else if (ABot >= BTop && ABot <= BBot) {
//                    cellA.invertYVelocity();
//                    cellB.invertYVelocity();
////                    cellA.move();
//                }
//                else {
//                    cellA.invertYVelocity();
//                    cellA.invertXVelocity();
//                    cellB.invertXVelocity();
//                    cellB.invertYVelocity();
//                }
//            }


        }
    }

    private void split(int id) {
        BaseCell mother = cells.get(id);
        mother.changeSize(25, 25); // 25 is default cell size
        createCell(1, (int) (mother.getX() + 30), (int) mother.getY()); // 30 = default cell side + 5
    }

    public void draw(Graphics g) {
        for (int i=0; i<cellCount; i++) {
            cells.get(i).draw(g);
        }

    }
}
