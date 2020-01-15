public interface Visitable {
    public void setHour(int s);
    default  String openingHour(){
        return "9:30";
    }
    default String closingHour(){
        return "20:00";
    }
    static Duration getVisitingDuration(){
        return new Duration("9:30","20:00");
    }

}
