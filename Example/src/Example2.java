import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Example2 {
    public static void main(String[] args) {
        InputStreamReader in = new InputStreamReader(System.in);
        OutputStreamWriter out = new OutputStreamWriter(System.out);

        try{
            int input = in.read();
            System.out.println(input);
            out.write(input);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
