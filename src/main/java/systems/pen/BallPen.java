package systems.pen;

import systems.pen.models.Refill;
import systems.pen.models.RefillablePen;

public class BallPen extends RefillablePen {

    @Override
    public void write() {
        System.out.println("Write with Ball  Pen");
    }

    @Override
    public void changeRefill(Refill refill) {
        this.refill = refill;
    }
}
