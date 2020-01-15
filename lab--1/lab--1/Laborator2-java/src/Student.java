public class Student {
    public String name;
    public int year;
    public Project[] preferences;
    Student(String n,int y){
        this.name=n;
        this.year=y;
    }
    @Override
    public boolean equals(Object s1){
        return this == s1;
    }
    public void display(){
        System.out.println(name+" "+year);

    }
    public void setPreferences(Project... p){
       for(int i=0;i<p.length;i++)
       for(int j=0;j<p.length;j++)
           if(i!=j && p[i].equals(p[j])){
               System.out.println("YOU CAN T ADD THE SAME PROJECT TWICE");
               System.exit(0);
           }
        for(int i=0;i<p.length;i++)p[i].counter++;
            preferences=p;
    }
}
