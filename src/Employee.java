public abstract class Employee extends Person {
    int months_worked;
    double salary;
    public Employee(String name, int age, int months_worked, double salary) {
        super(name, age);
        this.months_worked = months_worked;
        this.salary = salary;

    }

    public double thirteenthMonth(double salary, int months_worked) {
        double total = salary / (12 / (double) months_worked);
        return total;
    }

    public static class Manager extends Employee {
        public Manager (String name, int age, int months_worked, double salary){
            super(name, age, months_worked, salary);
        }
    }

    public static class Clerk extends Employee {
        public Clerk (String name, int age, int months_worked, double salary){
            super(name, age, months_worked, salary);
        }

        @Override
        public String toString() {
            return "How may I help you?";
        }
    }
}