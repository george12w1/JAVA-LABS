import java.util.Date;
import java.time.LocalDate;

public abstract class Project {
    public enum Topic {
        ALGORITHMS, DATA_STRUCTURES, WEB, DATABASES
    }
    public enum Language {
JAVA,PHYTON,PHP
    }
    @Override
    public boolean equals(Object o){
        return this == o;

    }
    public int counter=0;
    public String name;
    public LocalDate date;
    public Language lang;
    public Topic topic;
    abstract public void display();
Project(){

}

}
