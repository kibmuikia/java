package StoreApplication;

import java.util.Comparator;

public class ProductComparator implements Comparator<Products> {
    public int compare(Products prod,Products prod1)
            {
            String first_Str;
            String second_Str;
            first_Str=prod.name;
            second_Str=prod1.name;

            return first_Str.compareTo(second_Str);

            }
        }


