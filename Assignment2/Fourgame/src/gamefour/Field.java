package gamefour;

/**
 * Mboh Ekale
 */


import java.awt.Color;


public class Field {

    private Color color;
    private int number;
    private int count;

    public Field() {
        color = null;
        number = -1;
        count = -1;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
