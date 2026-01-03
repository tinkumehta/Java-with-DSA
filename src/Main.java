import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try (FileReader fr = new FileReader("note.text")){
            int letters = fr.read();
            while (fr.ready()) {
                System.out.println((char) letters);
                letters = fr.read();
            }
            System.out.println();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

//        try (InputStreamReader isr = new InputStreamReader(System.in)) {
//            System.out.println("Enter some letter:");
//            int letters = isr.read();
//            while (isr.ready()) {
//                System.out.println((char) letters);
//                letters = isr.read();
//            }
//          //  isr.close();
//            System.out.println();
//        } catch (IOException e){
//            System.out.println(e.getMessage()  );
//        }
    }

}
