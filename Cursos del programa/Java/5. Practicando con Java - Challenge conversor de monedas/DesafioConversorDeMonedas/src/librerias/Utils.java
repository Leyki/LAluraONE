package librerias;

public class Utils {
    /**
     * Returns if the provided string is numeric.
     * This does not check if a number fits inside a type, only if it's a valid number.
     * @param str the string to check.
     * @param period can be set to 'n' for integer numbers.
     */
    public static boolean isNumeric(String str, char period) {
        if (str == null)
            return false;
        char[] data = str.toCharArray();
        if (data.length == 0)
            return false;
        int index = 0;
        if (data[0] == '-' && data.length > 1)
            index = 1;

        if (period == 'n') {
            for (char chr : data) {
                if (chr < '0' || chr > '9') // Character.isDigit() can go here too.
                    return false;
            }
        }
        else {
            for (char chr : data) {
                if (((chr < '0' || chr > '9') && chr != period)) // Character.isDigit() can go here too.
                    return false;
            }
        }
        return true;
    }

    static public void printTabulated(String[] printables, int padding, int printablesPerLine) {
        for (int i = 0; i < printables.length; i++) {
            System.out.printf("%-" + printablesPerLine + "s", printables[i]);
            if (i % padding == 0)
                System.out.println();
        }

    }
}
