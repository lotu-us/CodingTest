package baekjoon;

import org.junit.jupiter.api.Test;
import util.TestScanInput;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Main1966Test {
    @Test
    void test1() throws IOException {
        TestScanInput.ScanInput("3\n" +
                "1 0\n" +
                "5\n" +
                "4 2\n" +
                "1 2 3 4\n" +
                "6 0\n" +
                "1 1 9 1 1 1");
        Main1966.main(new String[0]);
    }

    @Test
    void test2() throws IOException {
        TestScanInput.ScanInput("1\n" +
                "6 3\n" +
                "1 1 9 2 1 2");
        Main1966.main(new String[0]);
    }

}