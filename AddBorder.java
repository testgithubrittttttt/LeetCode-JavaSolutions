import java.util.Arrays;

public class AddBorder {
    public static String[] addBorder(String[] picture) {
        int rows = picture.length;
        int cols = picture[0].length();
        
        String[] borderedPicture = new String[rows + 2];
        
        // Create the top border
        char[] border = new char[cols + 2];
        Arrays.fill(border, '*');
        borderedPicture[0] = new String(border);
        
        // Add borders to each row
        for (int i = 0; i < rows; ++i) {
            borderedPicture[i + 1] = "*" + picture[i] + "*";
        }
        
        // Create the bottom border
        borderedPicture[rows + 1] = new String(border);
        
        return borderedPicture;
    }

    public static void main(String[] args) {
        String[] picture = {"abc", "ded"};
        String[] result = addBorder(picture);
        
        for (String row : result) {
            System.out.println(row);
        }
    }
}
