package model;

/**
 * Kelas Employee digunakan sebagai representasi model untuk entitas karyawan.
 */
public class Employee {
    private int id;
    private String name;
    private String position;
    private String department;
    private double salary;

    // Constructor kosong (jika diperlukan oleh MyBatis)
    public Employee() {
    }

    // Constructor dengan semua atribut
    public Employee(int id, String name, String position, String department, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.department = department;
        this.salary = salary;
    }

    // Getters dan Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
