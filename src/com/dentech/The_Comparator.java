package com.dentech;

import java.util.Comparator;
public class The_Comparator implements Comparator<Student> {

    @Override
    public int compare(Student std, Student std2)
    {
        String first_Str;
        String second_Str;
        first_Str = std.name;
        second_Str = std2.name;
         return first_Str.compareTo(second_Str);
        /*if(first_Str>second_Str)
            return 1;
       else if(first_Str<second_Str)
            return -1;
        else
            return  0;*/

    }
}

