package baekjoon;

import org.junit.jupiter.api.Test;
import util.TestScanInput;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Main9012Test {

    @Test
    void test1() throws IOException {
        TestScanInput.ScanInput("6\n" +
                "(())())\n" +
                "(((()())()\n" +
                "(()())((()))\n" +
                "((()()(()))(((())))()\n" +
                "()()()()(()()())()\n" +
                "(()((())()(");
        Main9012.main(new String[0]);
    }

    @Test
    void test2() throws IOException {
        TestScanInput.ScanInput("3\n" +
                "((\n" +
                "))\n" +
                "())(()");
        Main9012.main(new String[0]);
    }
}