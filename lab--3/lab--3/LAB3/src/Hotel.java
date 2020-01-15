public class Hotel extends Node implements Visitable {

public void setHour(int Hour){
    this.hour=Hour;

}
Hotel(String name,int hour){
    this.name=name;
    setHour(hour);
}



}
