import java.io.Serializable;

public class SerializableTransient implements Serializable {
    private static final long serialVersionUID = 1L;
    static String country = "ITALY";
    private int age;
    private String name;
    transient int height; //ignored while serializing, while deserializing it will give default value, ie0, false etc.

    public static String getCountry() {
        return country;
    }

    public static void setCountry(String country) {
        SerializableTransient.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
