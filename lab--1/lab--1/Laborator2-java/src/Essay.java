import java.util.Date;
import java.time.LocalDate;

public class Essay extends Project {
    public int counter;
    Essay(String n,LocalDate d,Topic g){
        this.date=d;
        this.name=n;
        this.topic=g;
    }
    public void display(){
        System.out.println(this.name+this.date+this.topic);

    }

}
