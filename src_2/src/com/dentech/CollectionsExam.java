package com.dentech;

import java.util.*;
import java.util.Map.Entry;

public class CollectionsExam {
    public void copy(){
        HashSet<Integer> hav = new HashSet<Integer>();

        hav.add(1);
        hav.add(2);
        hav.add(3);
        hav.add(3);
        hav.add(3);
        hav.add(4);
        System.out.println("prints items in the hashset");
        System.out.println(hav);
        for(Integer i: hav){
            System.out.println(i);
        }
        Object[] objarray =hav.toArray();
        System.out.println("Items copied to array");
        for(int index = 0; index <objarray.length;index++){
           System.out.println(objarray[index]);
        }



    }
    public int treeSize(){
        TreeSet<String> tree = new TreeSet<String>();
        tree.add("Dennis");
        tree.add("Brian");
        tree.add("Agnes");
        tree.add("Mugwasi");
        System.out.println("The size of the tree set is "+ tree.size());
        int i = tree.size();
        return i;
    }
    public void addingtoArrayList(){
        ArrayList<String> namelist = new ArrayList<String>();
        namelist.add("Dennis");
        namelist.add("John");
        namelist.add("Harriet");
        System.out.println(namelist);
        System.out.println("Adding items at Specified Index. Index 0 in this case");
        namelist.add(0,"Karanja");
        System.out.println(namelist);
    }
    public boolean hashContains() {
        HashMap<Integer, String> test = new HashMap<Integer, String>();

        test.put(2, "Dennis");
        test.put(3, "Kelvin");
        test.put(4, "Karanja");
        test.put(5, "Allan");

        boolean flag;
        flag = test.containsValue("Allan");
        System.out.println("The presence of Allan in our Hashmap is " + flag);
        return flag;
    }



    public void hashIteration(){
        HashMap<Integer,String> test = new HashMap<Integer, String>();

        test.put(2,"Dennis");
        test.put(3,"Kelvin");
        test.put(4,"Karanja");
        test.put(5,"Allan");



        //Iterator<Entry<Integer, String>> it =test.entrySet().iterator();
        //while(it.hasNext());
        System.out.println("Hash Iteration");
        for(Integer m : test.keySet()){
            System.out.println(m+" key ");
        }


    }


    public void sortTreeset(){
        TreeSet<Integer> tree = new TreeSet<Integer>();
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.first();
        tree.last();
        System.out.println("Finding the smallest and largest in a treeset");
        System.out.println("The smallest element is "+tree.first());
        System.out.println("The largest element is "+tree.last());
    }
}
