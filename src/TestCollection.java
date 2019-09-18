import java.util.*;
class TestCollection1 {
    public  void arrayList() {
        ArrayList<String> list = new ArrayList<String>();//Creating arraylist
        list.add("Ngesa");//Adding object in arraylist
        list.add("Kelvin");
        //Traversing list through Iterator
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    public void testerList(){
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Dennis","100"));
        students.add(new Student("Ngesa","101"));
        students.add(new Student("Kelvin","102"));
        students.add(new Student("Sakwa","103"));

        for(Student s : students){
            System.out.println(s);
        }

    }
    public void testProduct(){
        ArrayList<Product> products = new ArrayList<>();
        //String pro=new Product("Pembe",4,68.8)
        products.add(new Product("Pembe",4,81.8));
        products.add(new Product("Sugar",5,45.8));
        products.add(new Product("Salt",6,34.8));
        products.add(new Product("Kiwi",7,64.8));
        products.add(new Product("Toothpaste",8,88.8));
        products.add(new Product("Ecclairs",9,6.8));
        //products.add(pro);
        for(Product p: products){
            System.out.println(p);
        }
        System.out.println("Trying to remove");
        products.remove(2);
        for(Product p: products){
            System.out.println(p);
        }
        System.out.println("Trying to clear");
        products.clear();
        for(Product p: products){
            System.out.println(p);
        }
        System.out.println("Adding at index");
        products.add(0,new Product("pp Butter",10,6.8));
        for(Product p: products){
            System.out.println(p);
        }

    }
}
class Student{
    String name;
    String id;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }
    public String toString(){
        return "Id "+id+" Name "+name;
    }

}
class Product{
    String name;
    int id;
    double price;

    public Product(String name, int id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }
    public String toString(){
        return "Id "+id+" Name "+name+" Price "+price;
    }
}