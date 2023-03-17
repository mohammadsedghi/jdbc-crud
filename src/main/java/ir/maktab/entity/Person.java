package ir.maktab.entity;

public class Person {
    public Person(int id, String name, String family) {
        this.id = id;
        this.name = name;
        this.family = family;
    }
public Person(){}
  private   int id;
   private String name;
   private String family;

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

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                '}';
    }
}
