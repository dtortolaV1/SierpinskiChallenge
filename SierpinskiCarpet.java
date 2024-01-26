import java.util.ArrayList;
import java.util.List;

public class SierpinskiCarpet {

    public static void main(String[] args) {
        drawSierpinskiCarpet(3, 27);
    }

    public static void drawSierpinskiCarpet(int order, int size) {
        if (size % Math.pow(3, order) != 0) {
            throw new IllegalArgumentException("size must be a multiple of 3^order");
        }
        innerDrawSierpinskiCarpet(order, size);
    }

    /**
     * Draws a Sierpinski carpet of the order and size, using *
     *
     * @param order order of the triangle
     * @param size  size, multiple of 3^order
     */
    private static void innerDrawSierpinskiCarpet(int order, int size) {
        getLinesSierpinskiCarpet(order, size).forEach(System.out::println);
    }

    /**
     * See Sierpinski Triangle for why we use String.
     * Base case order = 0 just gets size lines filled with stars.
     * Each Carpet is a 3x3 compound, with center empty (spaces) and each of the other 8 a carpet of 1 order less.
     * We build the carpet by calculating the lesser order, then composing the lines to go at the top and bottom
     * (which are the same), and the lines that go in the middle (with the middle space)
     * Having top/bottom and middle, final result is concatenating those
     *
     * @param order order of the carpet
     * @param size  size of side
     * @return list of (side = size) strings to draw
     */
    private static List<String> getLinesSierpinskiCarpet(int order, int size) {
        if (order == 0) {
            List<String> lines = new ArrayList<>();
            String filled = StringHelp.getCharLine(size, '*');
            for (int i = 0; i < size; i++) {
                lines.add(filled);
            }
            return lines;
        } else {
            int third = size / 3;
            List<String> lesser = getLinesSierpinskiCarpet(order - 1, third);
            List<String> upDown = new ArrayList<>();
            List<String> middle = new ArrayList<>();
            String emptyThird = StringHelp.getEmptyLine(third);
            for (int i = 0; i < third; i++) {
                String lineTopBottom = lesser.get(i);
                upDown.add(lineTopBottom + lineTopBottom + lineTopBottom);
                middle.add(lineTopBottom + emptyThird + lineTopBottom);
            }
            middle.addAll(upDown);
            middle.addAll(0, upDown);
            return middle;
        }
    }

    private SierpinskiCarpet() {
        // utility class
    }
}
