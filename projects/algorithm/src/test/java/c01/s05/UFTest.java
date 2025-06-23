package c01.s05;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class UFTest {
    private static Path tinyUF;
    private static Path largeUF;

    @BeforeAll
    public static void beforeAll() throws URISyntaxException {
        URL r1 = UFTest.class.getClassLoader().getResource("c01/s05/tinyUF.txt");
        URL r2 = UFTest.class.getClassLoader().getResource("c01/s05/largeUF.txt");

        assert r1 != null;
        assert r2 != null;

        tinyUF = Paths.get(r1.toURI());
        largeUF = Paths.get(r2.toURI());
    }

    @Test
    public void test() throws IOException {

        List<String> large = Files.readAllLines(largeUF);



        System.out.println();
    }

    @Test
    public void testTiny() throws IOException {
        List<String> tiny = Files.readAllLines(tinyUF);
        UFData ufData = new UFData(tiny);

        SimpleUF simpleUF = new SimpleUF(ufData.n);
        union(ufData, simpleUF);

        QuickFindUF quickFindUF = new QuickFindUF(ufData.n);
        union(ufData, quickFindUF);

        QuickUnionUF quickUnionUF = new QuickUnionUF(ufData.n);
        union(ufData, quickUnionUF);

        System.out.println(simpleUF.count());
        System.out.println(quickFindUF.count());
        System.out.println(quickUnionUF.count());
    }

    @Test
    public void testLarge() throws IOException {
        List<String> large = Files.readAllLines(largeUF);
        UFData ufData = new UFData(large);

        SimpleUF simpleUF = new SimpleUF(ufData.n);
        union(ufData, simpleUF);

        QuickFindUF quickFindUF = new QuickFindUF(ufData.n);
        union(ufData, quickFindUF);

        QuickUnionUF quickUnionUF = new QuickUnionUF(ufData.n);
        union(ufData, quickUnionUF);

        System.out.println(simpleUF.count());
        System.out.println(quickFindUF.count());
        System.out.println(quickUnionUF.count());
    }

    private void union(UFData ufData, UF uf) {
        for (int[] data : ufData.data) {
            uf.union(data[0], data[1]);
        }
    }

    private static class UFData {
        private int n;
        private int[][] data;
        public UFData(List<String> input) {
            n = Integer.parseInt(input.get(0));
            data = new int[input.size() - 1][2];
            for (int i = 1; i < input.size(); i++) {
                String[] split = input.get(i).split("\\s");
                data[i -1][0] = Integer.parseInt(split[0]);
                data[i -1][1] = Integer.parseInt(split[1]);
            }
        }
    }
}