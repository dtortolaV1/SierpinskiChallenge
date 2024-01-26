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
     * lines that draw a triangle with *. All lines have length 2*height-1.
     * It produces lines so that it's easy to concatenate them in Sierpinski Triangle.
     * Each line from base to top has the first star shifted by 1 respective to the lower line
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
     * The Sierpinski triangle can be seen in two parts. Bottom is two triangles of order 1 less, side by side,
     * top is a centered third triangle of order 1 less. To make it centered, base of the whole triangle is
     * 2*(base of the lesser triangle)+1. Each of bottom/top has height equal to lesser triangle's so the compound
     * has height equal to double the lesser triangle's.
     * We use a height 2 triangle as the smallest we can (for order = 0), so height = resulting list size = 2^(1+order)
     * The top, centered triangle, for it to be centered, has to shift as the lower ones. Since we use get triangle
     * lines, that's shift of 1 per lesser triangle's height
     *
     * @param order order of the triangle
     * @return lines to draw a Sierpinski triangle.
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

    private SierpinskiTriangle() {
        // utility class
    }
}
