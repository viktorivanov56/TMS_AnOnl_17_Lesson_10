package Lesson_10_1;

public class DocumentNumberProcessor {

    public static void main(String[] args) {
        java.lang.String documentNumber = "1111-abc-1111-def-1a2b";
        processDocumentNumber(documentNumber);
    }

    public static void processDocumentNumber(String documentNumber) {
        // Первые два блока по 4 цифры
        System.out.println("Первые два блока по 4 цифры: " + documentNumber.substring(0, 9));

        // Замена блоков из трех букв на ***
        StringBuilder replacedDocumentNumber = new StringBuilder();
        int index = 0;
        while (index < documentNumber.length()) {
            char currentChar = documentNumber.charAt(index);
            if (Character.isLetter(currentChar)) {
                // Заменяем блоки из трех букв на ***
                replacedDocumentNumber.append("***");
                // Пропускаем блок букв
                while (index < documentNumber.length() && Character.isLetter(documentNumber.charAt(index))) {
                    index++;
                }
            } else {
                // Копируем цифры
                replacedDocumentNumber.append(currentChar);
                index++;
            }
        }
        System.out.println("Номер документа с заменой блоков из трех букв: " + replacedDocumentNumber.toString());

        // Буквы в формате yyy/yyy/y/y в нижнем регистре
        StringBuilder lettersLowercase = new StringBuilder();
        for (char currentChar : documentNumber.toCharArray()) {
            if (Character.isLetter(currentChar)) {
                lettersLowercase.append(Character.toLowerCase(currentChar)).append("/");
            }
        }
        System.out.println("Буквы в формате yyy/yyy/y/y в нижнем регистре: " +
                lettersLowercase.toString().replaceAll("/$", ""));

        // Буквы в формате "Letters:yyy/yyy/y/y" в верхнем регистре с использованием StringBuilder
        StringBuilder lettersUppercase = new StringBuilder("Letters:");
        for (char currentChar : documentNumber.toCharArray()) {
            if (Character.isLetter(currentChar)) {
                lettersUppercase.append(Character.toUpperCase(currentChar));
            }
        }
        System.out.println("Буквы в формате \"Letters:yyy/yyy/y/y\" в верхнем регистре: " + lettersUppercase.toString());
    }
}