import java.io.*;

public class Main {
    public static void main(String[] args) {

        // reading a file
        try (BufferedReader br = new BufferedReader(new FileReader("new-file.txt"))){
            while (br.ready()) {
                System.out.println(br.readLine());
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

//        try{
//            File fo = new File("new-file.txt");
//            fo.createNewFile();
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//        }

//        try (FileWriter fw = new FileWriter("note.text", true)){
//            fw.write("शुक्लांबरधरं देवं शशिवर्णं चतुर्भुजम्।\n" +
//                    "प्रसन्नवदनं ध्यायेत् सर्वविद्या दातृम्॥");
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//        }

//        try (OutputStreamWriter os = new OutputStreamWriter(System.out)){
//            os.write("Hello world ");
//            os.write(89);
//            os.write(8);
//            os.write('A');
//            os.write('\n');
//            char arr[] = "Mush kumari".toCharArray();
//            os.write(arr);
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//        }

//        try (FileReader fr = new FileReader("note.text")){
//            int letters = fr.read();
//            while (fr.ready()) {
//                System.out.println((char) letters);
//                letters = fr.read();
//            }
//            System.out.println();
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//        }


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
