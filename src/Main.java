/**
 * Created by Mihran Galstyan
 * All rights reserved
 */
public class Main {
    public static void main(final String[] args) {
        String source = "AAfAAaAAABB2BBCCcCDDDDDDOooooooOOOOPPPP";

        String zipped = zip(source);
        String unzipped = unzip(zipped);

        System.out.println("Source text: " + source);
        System.out.println("Zipped: " + zipped);
        System.out.println("Unzipped: " + unzipped);

    }

    public static String zip(String source) {
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();

        while (index < source.length()) {
            int repeats = repeats(source.charAt(index), source.substring(index));

            if (Character.isLetter(source.charAt(index))) { // Filter for letters
                stringBuilder.append(source.charAt(index));
                stringBuilder.append(repeats);
            }
            index += repeats;

        }
        return stringBuilder.toString();
    }

    public static String unzip(String zipped) {
        int count;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < zipped.length(); i += 2) {
            char letter = zipped.charAt(i);
            count = Integer.parseInt(String.valueOf(zipped.charAt(i + 1)));
            for (int j = 0; j < count; j++) {
                stringBuilder.append(letter);
            }
        }
        return stringBuilder.toString();
    }

    private static int repeats(char ch, String substring) {
        int repeats = 0;
        for (int i = 0; i < substring.length(); i++) {
            if (substring.charAt(i) == ch) {
                repeats++;
            } else break;
        }
        return repeats;
    }
}
