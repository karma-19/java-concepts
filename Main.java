import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //***********************************************************************************
        RaceCondition raceCondition = new RaceCondition();
        raceCondition.raceCondition();

        //Serializable and transient keyword **************************************************
        SerializableTransient serializableTransient = new SerializableTransient();
        serializableTransient.setAge(10);
        serializableTransient.setName("Praveen");
        serializableTransient.setHeight(167);

        //serializing
        FileOutputStream fileOutputStream
                = new FileOutputStream("C:\\Users\\praveen\\Desktop\\java-concepts\\tempFile.txt");
        ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(serializableTransient);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream
                = new FileInputStream("C:\\Users\\praveen\\Desktop\\java-concepts\\tempFile.txt");
        ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);
        SerializableTransient serializableTransient1 = (SerializableTransient) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(serializableTransient1.getAge() == serializableTransient.getAge());
        System.out.println(serializableTransient1.getName().equals(serializableTransient.getName()));
        System.out.println(serializableTransient1.getHeight()==(serializableTransient.getHeight()));//false

        //****************************************************************************************
    }
}
