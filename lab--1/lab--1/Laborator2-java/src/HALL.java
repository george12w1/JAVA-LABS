public class HALL {
    Problem p=new Problem();
    HALL(){

    }
    public boolean setProblem(Problem m){
        this.p=m;
        boolean have_solution=false;
        if(p.getProjects().length>=p.students.length){have_solution=true; System.out.println("it is possible to allocate a project for every student.  ");}
        else System.out.println("it is not possible to allocate a project for every student.  ");
    return have_solution;
    }
    public void ordonate(Student[] s){
        boolean sorted=false;
        while(sorted==false){

            for(int i=0;i<s.length;i++)
                for(int j=0;j<s.length;j++)
                    if(i!=j)if(s[i].preferences.length<s[j].preferences.length) {
                        Student aux = s[i];
                        s[i]=s[j];
                        s[j]=aux;
                        sorted=false;
                    }
            sorted=true;
        }
    }
    public void ordonate(Project[] p){
        boolean sorted=false;
        while(sorted==false){

            for(int i=0;i<p.length;i++)
                for(int j=0;j<p.length;j++)
                    if(i!=j)if(p[i].counter<p[j].counter) {
                        Project aux = p[i];
                        p[i]=p[j];
                        p[j]=aux;
                        sorted=false;
                    }
            sorted=true;
        }

    }
   public void display_maximum() {

           System.out.println("This is the maximal solution ");
           Student[] students = p.students;
           ordonate(students);
           Project[] projects = p.getProjects();
           ordonate(projects);
           Problem hall_solved = new Problem();
           hall_solved.setStudents(students);
           for (Student n : students) {
               ordonate(n.preferences);
               n.setPreferences(n.preferences);

           }
           System.out.println(hall_solved);
       }
   }

