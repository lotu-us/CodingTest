package baekjoon;

import org.junit.jupiter.api.Test;
import util.TestScanInput;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Main10828Test {

    @Test
    void test1() throws IOException {
        TestScanInput.ScanInput("14\n" +
                "push 1\n" +
                "push 2\n" +
                "top\n" +
                "size\n" +
                "empty\n" +
                "pop\n" +
                "pop\n" +
                "pop\n" +
                "size\n" +
                "empty\n" +
                "pop\n" +
                "push 3\n" +
                "empty\n" +
                "top");
        Main10828.main(new String[0]);
    }

    @Test
    void test2() throws IOException {
        TestScanInput.ScanInput("7\n" +
                "pop\n" +
                "top\n" +
                "push 123\n" +
                "top\n" +
                "pop\n" +
                "top\n" +
                "pop");
        Main10828.main(new String[0]);
    }
}