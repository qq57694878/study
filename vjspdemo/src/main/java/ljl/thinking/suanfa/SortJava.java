package ljl.thinking.suanfa;

import java.util.*;

/**
 * Created by Administrator on 2017/8/16/016.
 */
public class SortJava {
    public static Student[]  initData(int n){
        List<Student> list =new ArrayList<Student>();
        for (int i = 0; i < n; i++) {
            Random random =new Random();
            Student s =new Student(String.valueOf(random.nextInt(100)));
            list.add(s);
        }
        return list.toArray(new Student[n]);
    }
    public static void main(String[] args) {
        Student[] students = initData(10);
        collectionSort(students);
        System.out.println(Arrays.toString(students));
    }

    public static void  collectionSort(Student[] students){
      //  Arrays.sort(students);
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int name1 = Integer.parseInt(o1.getName());
                int name2 = Integer.parseInt(o2.getName());
                return (name1 < name2) ? -1 : ((name1 == name2) ? 0 : 1);
            }
        });
    }
}
