import java.sql.Struct;
import java.util.Collections;
import java.util.Objects;

public class Problem {
    public Student[] students;
    public Project[] free=new Project[100];
    Problem(){

    }
    public void setStudents(Student... st){
        boolean good=true;
        for(int i=0;i<st.length;i++){
        for(int j=0;j<st.length;j++) {
            if (i != j && st[i].equals(st[j])) good = false;

        }
            if (!good) {
                System.out.println("YOU CAN T ADD THE SAME STUDENT TWICE");
                System.exit(0);

            }
        }

        students=st;
    }
    public int its_free(Project s){
        int its_freee=1;
        for(int i=0;i<free.length;i++)
            if(free[i]==s)its_freee=0;
            return its_freee;

    }
    public void search(Student s,int c){

        for(int i=0;i<s.preferences.length;i++)
            if(its_free(s.preferences[i])==1){
                free[c]=s.preferences[i];
                System.out.println(s.preferences[i].name);
                break;
            }
    }
    @Override
    public String toString() {
        for(int i=0;i<students.length;i++){
            System.out.print(students[i].name+"-");
            search(students[i],i);
        }
       return "";
    }

    public void display(){
        for(Student i:students){
           for(int j=0;j<i.preferences.length;j++){
               System.out.print(i.preferences[j].name);

           }
            System.out.println();
        }

    }
    public Project[] getProjects() {
        Project[] d_p = new Project[100];
        int counter = 0;
        for (Student i : students) {
            for (int j = 0; j < i.preferences.length; j++) {
                int ok = 1;
                if (d_p.length >= 1) for (int d = 0; d < d_p.length; d++) {

                    if (i.preferences[j] == d_p[d]) ok = 0;
                }
                else d_p[counter++] = i.preferences[j];
                if (ok == 1) {
                    d_p[counter++] = i.preferences[j];

                }

            }

        }
       Project[] d_p_clear = new Project[counter];
        for(int i=0;i<counter;i++)d_p_clear[i]=d_p[i];
        return d_p_clear;
    }

}
