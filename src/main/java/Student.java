public class Student {
    private int id;
    private String name;
    private String lastName;
    private String city;
    private int age;

    public Student(String name, String lastName, String city, int age) {
        this.name = name;
        this.lastName = lastName;
        this.city = city;
        this.age = age;
    }

    public Student() {
    }

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return
                "id= " + id +
                        ", name= " + name  +
                        ", lastName= " + lastName +
                        ", city= " + city +
                        ", age= " + age;
    }


    public String getLastname() {
        return null;
    }

    public void setLastname(String lastname) {
    }
}
