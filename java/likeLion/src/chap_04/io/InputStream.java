package chap_04.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static chap_04.io.address.input;
import static chap_04.io.address.output;

public class InputStream {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(input);
        FileOutputStream fos = new FileOutputStream(output);


        int n;
        byte[] buf = new byte[1024];
        while ((n = fis.read(buf)) != -1) {
            String str = new String(buf,0,n);
            System.out.println("str = " + str);
            fos.write(buf,0,n);

        }

        fos.flush();
        fos.close();
        fos.close();
    }
}
