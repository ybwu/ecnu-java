
class Name{
    private String firstName;
    private String lastName;
    public Name(){ }
    public Name(String f, String l){
        firstName = f;
        lastName = l;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String f){
        firstName = f;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String l){
        lastName = l;
    }
    public String toString(){
        return firstName + " " + lastName;
    }
}

class Person{
    public Name name;
    final int age;
    private String gender;
    public Person(){
        age = -1;
    }
    public Person(Name n, int a, String g){
        name = n;
        age = a;
        gender = g;
    }
    public String getGender(){
        return gender;
    }
    public void setGender(String s){
        gender = s;
    }
    public void talk(){
        System.out.println("Hi, how is going");
    }
    public void talk(String s){
        System.out.println(s);
    }
    public void chatWith(Person p, String s){
        System.out.println(name+ " to " + p.name + ":" + s);
    }
}


class Teacher extends Person{
    public Teacher(){
        super();
    }
    public Teacher(Name n, int a, String g){
        super(n, a, g);
    }
    public void talk(){
        System.out.println("Hi, how is your paper going");
    }
}

class ElderTeacher extends Teacher{
    static private ElderTeacher e = new ElderTeacher();
    private ElderTeacher(){
        super();
    }
    public static ElderTeacher getInstance(){
        return e;
    }
}


class InheritanceBasic{
    public static void main(String []args){
        ElderTeacher e = ElderTeacher.getInstance();
        e.name = new Name("Tom", "Hanks");
        Person p = new Person(new Name("foo", "bar"), 10, "male");
        e.chatWith(p, "hello");
    }
}
