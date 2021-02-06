package model;

public enum MoveType {

    UP("img/car-cima.png", 1), RIGHT("img/car-dir.png", 2),
    DOWN("img/car-baixo.png", 3), LEFT("img/car-esq.png", 4),
    C_UP("img/cruzamento-cima.png",5), C_RIGHT("img/cruzamento-dir.png",6),
    C_DOWN("img/cruzamento-down.png",7), C_LEFT("img/cruzamento-left.png",8);

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

    public static int convertMoveType(int side){
        switch(side){
            case 5:
                return 1;
            case 6:
                return 2;
            case 7:
                return 3;
            case 8:
                return 4;
            default:
                break;
        }
        return 0;
    }
}
