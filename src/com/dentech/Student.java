package com.dentech;

public class Student implements Comparable<Student>{
        int registrationNumber;
        String name;
        int age;
        Student(int registrationNumber,String name,int age){
            this.registrationNumber=registrationNumber;
            this.name=name;
            this.age=age;
        }

        public int compareTo(Student st){
            if(age==st.age)
                return 0;
            else if(age<st.age)
                return -1;
            else
                return 1;
        }
    }

