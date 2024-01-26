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


}
