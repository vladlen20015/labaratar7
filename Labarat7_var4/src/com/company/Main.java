package com.company;
import java.io.IOException;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
	Scanner sc = new Scanner(System.in);
	System.out.println("Введите количество товара для записи в файл\n" + "=>");
	int count = sc.nextInt();
	sc.nextLine();
	RandomAccessFile rf = null;
	RandomAccessFile rfout = null;
	try {
	    File f = new File("Tovary");
	    if (f.exists()) f.delete();
	    rf = new RandomAccessFile(f, "rw");
	    String proizvoditell,naimenovaniee,;
	    int kolichestvoo, cenaa;
	    rf.seek(0);

	    for (int i=0; i< count; i++){
	        System.out.println("Введите  наименование \" + (i + 1) + \" товара => \"");
            naimenovaniee = sc.next();
            rf.seek(rf.length());
            rf.writeUTF(naimenovaniee);
            for (int j = 0; j < 20 - naimenovaniee.length(); j++)
                rf.writeByte(1);

            System.out.print("Введите  производитель => ");
            proizvoditell = sc.next();
            rf.writeUTF(proizvoditell);
            for (int j = 0; j < 20 - proizvoditell.length(); j++)
                rf.writeByte(1);

            System.out.print("Введите количество => ");
            kolichestvoo = sc.nextInt();
            sc.nextLine();
            rf.writeInt(kolichestvoo);

            System.out.print("Введите цену => ");
            cenaa = sc.nextInt();
            sc.nextLine();
            rf.writeInt(cenaa);
        }
	    String proizvoditellr,naimenovanieer;
        int kolichestvoor, cenaar;
        rf.seek(0);
        for (int i=0; i< count; i++;
        {naimenovanieer = rfout.readUTF();
            for (int i=0; i<20 -naimenovanieer.length(); i++) rf.readByte();
            proizvoditellr = rf.readUTF();
            for (int j = 0; j < 20 - proizvoditellr.length(); j++) rf.readByte();
            kolichestvoor = rf.readInt();
            cenaar=rf.readInt();
            System.out.println(naimenovanieer + "\t\t\t" + proizvoditellr + "\t\t\t" + kolichestvoor +"\t\t\t" + cenaar);

        }

    }
    }
}
