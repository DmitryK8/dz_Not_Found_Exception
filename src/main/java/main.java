public class main {


    private static String text;

    public static void main(String[] args) {
        System.out.println("Приветище");

        String text = "Все совпало";

        try {
            boolean actual = is0eq10(text);
            System.out.println("Совпало? " + actual);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("ОШИБКА!!!");
        } catch (Exception e) {
    }

        System.out.println("Пока");
    }

    public static boolean is0eq10(String text) throws Exception {
        if (text.length() < 11) {
            throw new RuntimeException(
                    "Текст должен быть 11 символов а у Вас: " + text);
        }
        System.out.println("вошли в метод");
        char c0 = text.charAt(0);
        char c10 = text.charAt(10);
        if (c0 == c10) {
            return true;
        } else {
            return false;
        }
    }
}
