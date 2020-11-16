package codeforces.com.tasks.bookEfJava.singleton;

import java.io.*;

public class Program {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var sbyf = SingletonByField.INSTANCE;
        System.out.println(sbyf.getCounter());
        var sbyf1 = SingletonByField.INSTANCE;
        System.out.println(sbyf1.getCounter());
        System.out.println(sbyf == sbyf1);

        System.out.println("--------------------------");
        var sbym = SingletonByMethod.instance();
        System.out.println(sbym.getCounter());
        var sbym1 = SingletonByMethod.instance();
        System.out.println(sbym1.getCounter());
        System.out.println(sbym == sbym1);

        System.out.println("--------------------------");
        var ss = SingletonSerializable.INSTANCE;
        serialize(ss, "/tmp/ser_sing.ser");
        var ss1 = deserialize("/tmp/ser_sing.ser");
        System.out.println(ss == ss1);

        System.out.println("--------------------------");
        var sbye = SingletonByEnum.INSTANCE;
        System.out.println(sbye.getCounter());
        var sbye1 = SingletonByEnum.INSTANCE;
        System.out.println(sbye.getCounter());
        System.out.println(sbye == sbye1);
    }

    private static void serialize(SingletonSerializable obj, String fileName) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(obj);
        out.close();
        fileOut.close();
    }

    private static SingletonSerializable deserialize(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(fileName);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        var obj = (SingletonSerializable) in.readObject();
        in.close();
        fileIn.close();
        return obj;
    }

}
