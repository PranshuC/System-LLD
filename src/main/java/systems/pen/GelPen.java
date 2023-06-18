package systems.pen;

import systems.pen.models.Refill;
import systems.pen.models.RefillablePen;

public class GelPen extends RefillablePen {

    @Override
    public void write() {
        System.out.println("Write with Gel Pen");
    }

    @Override
    public void changeRefill(Refill refill) {
        this.refill = refill;
    }
}
