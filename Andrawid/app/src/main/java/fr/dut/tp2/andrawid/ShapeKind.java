package fr.dut.tp2.andrawid;

public enum ShapeKind {
    SEGMENT (R.drawable.ic_regular_line),
    RECTANGLE (R.drawable.ic_rectangle),
    CURSIVE (R.drawable.ic_curved_line);

    private final int image;

    ShapeKind(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }
}
