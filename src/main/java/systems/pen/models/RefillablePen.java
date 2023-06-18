package systems.pen.models;

public abstract class RefillablePen extends Pen {

    protected Refill refill;

    public abstract void changeRefill(Refill refill);
}
