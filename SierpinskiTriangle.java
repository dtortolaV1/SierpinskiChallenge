import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SierpinskiTriangle {
    public static void main(String[] args) {
        drawTriangle(4);

        drawSierpinskiTriangle(3);
    }

    public static void drawTriangle(int height) {
        getTriangleLines(height).forEach(System.out::println);
    }

    /**
     * lines that draw a triangle with *. All lines have length 2*height-1
     *
     * @param height rows for the triangle
     * @return lines to draw an empty triangle
     */
    private static List<String> getTriangleLines(int height) {
        int size = 2 * height - 1;
        List<String> lines = new ArrayList<>();
        // bottom line
        lines.add(StringHelp.getCharLine(size, '*'));

        for (int shift = 1; shift < height; shift++) {
            char[] line = new char[size];
            Arrays.fill(line, ' ');
            line[shift] = '*';
            line[size - 1 - shift] = '*';
            lines.add(0, new String(line));
        }
        return lines;
    }

    public static void drawSierpinskiTriangle(int order) {
        getSierpinskiTriangleLines(order).forEach(System.out::println);
    }

    /**
     * @param order order of the triangle
     * @return lines to draw a Sierpinski triangle. The size of the list is 2^(1+order)
     */
    private static List<String> getSierpinskiTriangleLines(int order) {
        if (order == 0) {
            return getTriangleLines(2);
        } else {
            List<String> lesser = getSierpinskiTriangleLines(order - 1);
            List<String> compound = new ArrayList<>();
            // each row in bottom half shifts the top triangle by 1
            String emptySide = StringHelp.getEmptyLine(lesser.size());
            // top
            for (String s : lesser) {
                compound.add(emptySide + s + emptySide);
            }
            // bottom
            for (String s : lesser) {
                compound.add(s + ' ' + s);
            }
            return compound;
        }
    }
}
