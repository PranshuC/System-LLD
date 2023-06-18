package systems.pen.models;

public abstract class Pen {

    private String brand;
    private String name;
    private PenType type;
    private double price;

    public abstract void write();
}
