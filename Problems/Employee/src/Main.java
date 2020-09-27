class Employee {

    String name;
    int salary;
    String address;

    public Employee() {
        name = "unknown";
        salary = 0;
        address = "unknown";
    }

    public Employee(String name, int salary) {
        this();
        this.name = name;
        this.salary = salary;
    }

    public Employee(String name, int salary, String address) {
        this(name, salary);
        this.address = address;
    }
}