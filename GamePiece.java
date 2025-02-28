public class GamePiece {
    private String name;
    private int value;

    public GamePiece(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name.substring(0, 2) + " (" + value + ")";
    }
}

