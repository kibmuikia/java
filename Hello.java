public class Hello {

  public static double Square(double number)
  {
    System.out.println( "You have provided [ "+ number +" ] to be squared." );
    double result = number * number;
    return result;
  }

  public static void main(String[] args) {
    System.out.println("Hello, from Kibcode");
    // int a = 10; double b = 3.142; char c = 'r'; boolean d = true;
    // System.out.println(a);
    // System.out.println(b);
    // System.out.println(c);
    // System.out.println(d);
    // boolean e = false;
    // System.out.println(d&e); // logical AND
    // System.out.println(d|e); // logical OR
    // if( a == 5 )
    // {
    //   System.out.println("a is equal to 5");
    // }
    // // else if( a > 5 )
    // // {
    // //   System.out.println("a is greater than 5");
    // // }
    // else if( a >= 10 )
    // {
    //   System.out.println("a is greater or equal to 10");
    // } else
    // {
    //   System.out.println("invalid op");
    // }
    // int f = -5;
    // while( f <= 5 )
    // {
    //   System.out.println(f);
    //   f++;
    // }
    // for( double g = 0.01; g <= 2; g= g + 0.01 )
    // // for( double g = 0.01; g < 5; g++ )
    // {
    //   System.out.println(g);
    // }
    // int arr[] = new int[5];
    // for(int i=0; 1<5; i++)
    // {
    //   arr[i] = i+2;
    //   System.out.println(arr[i]);
    // }
    System.out.println( Square(5.5) );
    double sq = Square(6.57);
    System.out.println( sq );
  }
}
