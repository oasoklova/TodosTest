package utils;

/**
 * Класс для генерации тестовых данных
 */
public class TestDataGenerator{
    /**
     * Генерирует строку нужной длины
     * @param length - Количество символов
     * @return строка нужной длины
     */
    public static String generateText(int length){
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < length; i++) {
            builder.append("0");
        }
        return builder.toString();
    }
}
