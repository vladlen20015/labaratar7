package Seriazible;
import java.io.*;
import  java.util.Scanner;

class Tovary implements Serializable{
    String proizvodiel;
    String naimenovanie;
    int kolichestvo;
    int cena;
    @Override
    public String toString(){
        return "Tovary{"+ "naimenovanie'" + naimenovanie +'\"' +
                ",proizvodiel'" + proizvodiel + '\"' +
                ",kolichestvo'" + kolichestvo + '\"' +
                ",cena'" + cena+
                '}';
    }
}
public class Seriazibleclass {
   public static void main(String[] args) throws IOException, ClassNotFoundException{
       FileOutputStream fos = null;
       ObjectOutputStream oos = null;
       FileInputStream fin = null;
       ObjectInputStream oin = null;

       FileOutputStream fos2 = null;
       ObjectOutputStream oos2 = null;
       FileInputStream fin2 = null;
       ObjectInputStream oin2 = null;
       try {
           File f= new File("tovary.txt");
           if (f.exists()) f.delete();
           f.createNewFile();
           fos = new FileOutputStream(f);
           oos = new ObjectOutputStream(fos);
           System.out.println("Введите количество товара для записи в файл");
           Scanner sc = new Scanner(System.in);
           int count = sc.nextInt();
           sc.nextLine();
           Tovary tovary;
           for (int i=0; i< count; i++){
               tovary = new Tovary();
               System.out.println("Введите  наименование");
               tovary.naimenovanie= sc.nextLine();
               System.out.println("Введите производитель");
               tovary.proizvodiel= sc.nextLine();
               System.out.println("Введите количество");
               tovary.kolichestvo= sc.nextInt();
               System.out.println("Введите цену");
               tovary.cena= sc.nextInt();
               sc.nextLine();
               oos.writeObject(tovary);
           }

           System.out.println("Информация о товарах записана в файл");

           fin = new FileInputStream(f);
           oin =new ObjectInputStream(fin);

           File fOut = new File("tovaryOut");
           if (fOut.exists()) fOut.delete();
           fOut.createNewFile();
           fos2 = new FileOutputStream(fOut);
           oos2 = new ObjectOutputStream(fos2);

           fin2= new FileInputStream(fOut);
           oin2= new ObjectInputStream(fin2);
           int tovaryOver1000 =0;
           for (int i=0; i< count; i++){
               tovary = (Tovary) oin.readObject();
               if (tovary.cena > 1000) {
                   oos2.writeObject(tovary);
                   tovaryOver1000++;
               }
           }
           System.out.println("Товары дороже 1000");
           if (tovaryOver1000!=0){
               for (int i=0; i< tovaryOver1000; i++){
                  System.out.println((Tovary) oin2.readObject());
               }
           }
           else {
               System.out.println("Нет товаров дороже 1000");
           }
       }catch (IOException ie){
           ie.printStackTrace();
       }catch (ClassNotFoundException cne){
           cne.printStackTrace();
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           oos2.flush();
           oos2.close();
           fos2.flush();
           fos2.close();
           oin2.close();
           fin2.close();
           oos.flush();
           oos.close();
           fos.flush();
           fos.close();
           oin.close();
           fin.close();
       }

   }
}
