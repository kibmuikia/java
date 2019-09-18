package com.dentech;

import java.util.*;
public class Tree_set {
    public  void compares()
    {
        TreeSet<Student> tree_set = new TreeSet<Student>(new The_Comparator());

        tree_set.add(new Student(456,"Brian",17));
        tree_set.add(new Student(455,"Dennis",9));
        tree_set.add(new Student(457,"Adunya",7));

        System.out.println("Set before using the comparator: ");

        System.out.println("The elements sorted in descending"+
                "order:");
        for (Student element : tree_set)
            System.out.println(element.registrationNumber +" "+element.age+" "+element.name );
    }
    public boolean equals(){
        boolean flag= true;
        return flag;
    }
}
