import java.time.LocalDate;

public class P2 {

    public static void main(String[] args){
        /**
         *  in this method i do all the work
         */
        Student s1=new Student("s1",2);
Student s2=new Student("s2",2);
Student s3=new Student("s3",2);
Student s4=new Student("s4",2);
//initializarea proiectelor
Project A1= new Application("A1",LocalDate.parse("2019-06-01"), Project.Language.PHYTON);
Project A2= new Application("A2",LocalDate.parse("2019-01-01"), Project.Language.JAVA);
Project A3= new Application("A3",LocalDate.parse("2019-01-01"), Project.Language.PHP);

Project E1=new Essay("E1",LocalDate.parse("2019-07-01"),Project.Topic.ALGORITHMS);
Project E2=new Essay("E2",LocalDate.parse("2019-08-01"),Project.Topic.WEB);

//initializarea preferintelor pentru fiecare student
s1.setPreferences(A1,A2);
s2.setPreferences(A1);
s3.setPreferences(A3,E1);
s4.setPreferences(A3);
//instantierea unei noi probleme
Problem problem=new Problem();
problem.setStudents(s1,s2,s3,s4);
        System.out.println("BAD IMPLEMENTATION OF PROBLEM");
System.out.println(problem);

//REZOLVARE PRIN ALGORITMUL EFICIENT
HALL dem=new HALL();
dem.setProblem(problem);
dem.display_maximum();


    }

}
