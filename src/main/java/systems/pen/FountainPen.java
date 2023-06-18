package systems.pen;

import lombok.AllArgsConstructor;
import systems.pen.models.Ink;
import systems.pen.models.Nib;
import systems.pen.models.Pen;

@AllArgsConstructor
public class FountainPen extends Pen {

    private Ink ink;
    private Nib nib;

    @Override
    public void write() {
        System.out.println("Write with Fountain Pen");
    }

    public void changeInk(Ink ink) {
        this.ink = ink;
    }
}
