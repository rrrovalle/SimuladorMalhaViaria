package model;

public enum MoveType {

    RIGHT("img/car-dir.png", 1), lEFT("img/car-esq.png", 2), UP("img/car-cima.png", 3),
    DOWN("img/car-baixo.png", 4);

    private String filePath;
    private int side;

    private MoveType(String filePath, int side) {
        this.filePath = filePath;
        this.side = side;
    }

    public String toString() {
        return filePath + ".png";
    }

    public MoveType getMoveType(int side) {
        for (MoveType moveType : MoveType.values()) {
            if (moveType.side == side)
                return moveType;
        }
        return null;
    }
}
