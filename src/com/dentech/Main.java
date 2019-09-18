package com.dentech;


import java.util.TreeSet;

public class Main {
    public static int total = 0;

    public static void main(String[] args) {
        CollectionsExam tell = new CollectionsExam();
        tell.addingtoArrayList();
        tell.copy();
        tell.hashContains();
        tell.hashIteration();
        tell.sortTreeset();
        tell.treeSize();

        TreeSet<Student> treeset = new TreeSet<Student>();
        treeset.add(new Student(101, "John", 23));
        treeset.add(new Student(106, "Brian", 27));
        treeset.add(new Student(105, "Denno", 21));
        treeset.add(new Student(110, "Kev", 25));

        for (Student st : treeset) {
            System.out.println(st.registrationNumber + " " + st.name + " " + st.age);
        }
        Tree_set tree = new Tree_set();
        tree.compares();

        StudentTwo child = new StudentTwo(45,"name",23);
        StudentTwo child1 = new StudentTwo(45,"name",23);
        if(child.registrationNumber == child1.registrationNumber){
            System.out.println("same");
        }
        Mythread t = new Mythread();
        AnotherThread t1 = new AnotherThread();
        //t.start();
        //t1.start();
        int[] nums=new int[1000];
        for(int i = 0; i<1000;i++){
            nums[i]=i;
        }

        
        System.out.println("done");
        ArrayThread at = new ArrayThread(0,250,nums);
        ArrayThread st = new ArrayThread(250,500,nums);
        ArrayThread tt = new ArrayThread(500,750,nums);
        ArrayThread ft = new ArrayThread(750,1000,nums);
        at.start();
        st.start();
        tt.start();
        ft.start();

        try {
            at.join();
            st.join();
            tt.join();
            ft.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(total);




    }

}