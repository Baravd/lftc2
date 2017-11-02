package lftc.structures;

import lftc.model.Transition;

public class Pereche {
    private  String x;
    private Transition y;

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public Transition getY() {
        return y;
    }

    public void setY(Transition y) {
        this.y = y;
    }

    public Pereche(String x, Transition y) {

        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Pereche{" +
                "x='" + x + '\'' +
                ", y=" + y +
                '}';
    }
}
