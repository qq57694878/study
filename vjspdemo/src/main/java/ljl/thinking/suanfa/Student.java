package ljl.thinking.suanfa;

/**
 * Created by Administrator on 2017/8/16/016.
 */
public class Student implements Comparable<Student>{
    private String name;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.getName());
    }
}
