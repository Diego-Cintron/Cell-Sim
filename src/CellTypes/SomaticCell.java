package CellTypes;

public class SomaticCell extends BaseCell {

    private int mitosisCount;
    private int reproStage; // Interphase, Prophase, Metaphase, Anaphase, Telophase/Cytokinesis

    public SomaticCell(int id, int x, int y) {
        super(id, x, y);
        this.mitosisCount = 0;
        this.reproStage = 0;
    }

    // Updates mitosis stage, increases size over time and returns the ID of a cell if it has entered Telophase
    int mitosisTimer() {
        mitosisCount++;

        if (mitosisCount == 10*10) { // Prophase
            reproStage++;
            this.changeSize((int) (getWidth()+4), (int) getHeight());
            System.out.println("Prophase");
        }
        else if (mitosisCount == 20*10) { // Metaphase
            reproStage++;
            this.changeSize((int) (getWidth()+4), (int) getHeight());
            System.out.println("Metaphase");
        }
        else if (mitosisCount == 30*10) { // Anaphase
            reproStage++;
            this.changeSize((int) (getWidth()+4), (int) getHeight());
            System.out.println("Anaphase");
        }
        else if (mitosisCount >= 40*10) { // Telophase
            reproStage++;
            this.changeSize((int) (getWidth()+4), (int) getHeight());
            System.out.println("Telophase");
            mitosisCount = 0;
            return this.id; // RETURN THE ID OF THE CELL TO BE SPLIT
        }
        return -1;
    }

    public int move() {

        // Cell reached bottom or top border
        if (getY()+getHeight()+Math.abs(yVelocity) >= (int)(1000*0.5555) || getY()-Math.abs(yVelocity) <= 0) {
            yVelocity *= -1;
        }
        // Cell reached left or right border
        if (getX()+getWidth()+Math.abs(xVelocity) >= 1000 || getX()-Math.abs(xVelocity) <= 0) {
            xVelocity *= -1;
        }
        this.x += xVelocity;
        this.y += yVelocity;
        this.setLocation(x, y);

        return mitosisTimer(); // Returns the ID if the cell should be split.
//        return -1; // for testing without mitosis
    }
}
