package util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class TestScanInput {

    public static void ScanInput(String inputed){
        InputStream in = new ByteArrayInputStream(inputed.getBytes());
        System.setIn(in);
    }
}
