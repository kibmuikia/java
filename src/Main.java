public class Main {
    public static void main(String[] args) {
      /*  TestCollection1 a =new TestCollection1();
        a.arrayList();
        a.testerList();
        a.testProduct();

        LinkedList s1 = new LinkedList();
        LinkedList s2 = new LinkedList();
        //Pupil w = new Pupil();
        s1.setP(new Pupil("Ngesa",13));
        s2.setP(new Pupil("Dennis",13));
        s1.setNext(s2);
        s2.setPrevious(s1);
        do{
            System.out.println(s1.getP().getName());
        }while((s1=s1.getNext())!= null);
    */
        DbList add = new DbList();

            add.populate();

        add.display();



    }
}
