package utils;

public class TestDataGenerator{
    public static String generateText(int length){
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < length; i++) {
            builder.append("0");
        }
        return builder.toString();
    }
}
