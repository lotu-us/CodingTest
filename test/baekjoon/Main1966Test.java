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
        /*
        1-1  1-2  9  2-1  1-3  2-2
        1-2  9  2-1  1-3  2-2  1-1
        9  2-1  1-3  2-2  1-1  1-2

        2-1  1-3  2-2  1-1  1-2
        * */
    }

    @Test
    void test3() throws IOException {
        TestScanInput.ScanInput("1\n" +
                "38 29\n" +
                "7 1 8 4 7 1 3 4 6 5 7 8 3 2 8 5 9 4 6 8 2 1 8 7 4 8 5 3 7 6 3 4 6 1 5 2 8 5");
        Main1966.main(new String[0]);
        //정답 15
    }



}