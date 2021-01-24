
public enum BaseRoad {

    ONE(1,"img/setacima.png"), TWO(2,"img/setadir.png"),
    THREE(3,"img/setabaixo.png"), FOUR(4,"img/setaesq.png"), FIVE(5,"img/cruzamento.png"),
    SIX(6,"img/cruzamento.png"), SEVEN(7,"img/cruzamento.png"), EIGHT(8,"img/cruzamento.png"),
    NINE(9,"img/cruzamento.png"),
    TEN(10,"img/cruzamento.png"), ELEVEN(11,"img/cruzamento.png"),
    TWELVE(12,"img/cruzamento.png");

    private String filePath;
    private int number;

    private BaseRoad(int number, String filePath) {
        this.filePath = filePath;
        this.number   = number;
    }

    @Override
    public String toString() {
        return this.filePath;
    }
    
   public static String getRoadType(int number) {
      for (BaseRoad roadType : BaseRoad.values()) {
          if (roadType.number == number) return roadType.toString();
      }
        return null;
   }
}