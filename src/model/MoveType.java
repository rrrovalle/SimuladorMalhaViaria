package model;

public enum MoveType {

    UP("img/car-cima.png", 1), RIGHT("img/car-dir.png", 2), DOWN("img/car-baixo.png", 3),
    LEFT("img/car-esq.png", 4);

    private String filePath;
    private int side;

    private MoveType(String filePath, int side) {
        this.filePath = filePath;
        this.side = side;
    }

    public String toString() {
        return filePath;
    }

    public static String getMoveType(int side) {
        for (MoveType moveType : MoveType.values()) {
            if (moveType.side == side)
                return moveType.toString();
        }
        return null;
    }

    public static String convertMoveType(int side){
        switch(side){
            case 5:
            case 9 :
                return UP.toString();
            case 6:
            case 11:
                return RIGHT.toString();
            case 7:
            case 12:
                return DOWN.toString();
            case 8:
            case 10:
                return LEFT.toString();
        }
        return null;
    }
}
