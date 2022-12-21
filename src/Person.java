public abstract class Person {
    // TODO implement Person and its subclasses in other Java files
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Hello, my name is " + name;
    }

    public static class Customer extends Person {
        public Customer(String name, int age) {
            super(name, age);
        }
    }

}


