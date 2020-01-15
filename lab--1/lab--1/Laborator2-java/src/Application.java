import java.util.Date;
import java.time.LocalDate;

public class Application extends Project {
    public int counter;
    Application(String n,LocalDate d,Language g){
        this.date=d;
        this.name=n;
        this.lang=g;
    }
    public void display(){
        System.out.println(this.name+this.date+this.lang);

    }

}
