import java.util.Arrays;

public class StringHelp {
    private StringHelp() {
        // utility class
    }

    /**
     * @param length desired length for the line
     * @return a line made up length spaces
     */
    static String getEmptyLine(int length) {
        return getCharLine(length, ' ');
    }

    /**
     * @param length  desired length
     * @param content char to fill the string
     * @return string of desired length, each character is content
     */
    static String getCharLine(int length, char content) {
        char[] line = new char[length];
        Arrays.fill(line, content);
        return new String(line);
    }
}
