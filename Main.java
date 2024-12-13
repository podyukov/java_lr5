import java.io.*;
import java.nio.file.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.print("\n> Введите номер задания (1.1 это 11) (0 для выхода): ");
            int num = intInputer();
            if (num == 0) break;
            switch (num) {
                case 11: { // задание "шаблоны"
                    Fraction11 cf1 = new Fraction11(1,2);
                    Fraction11 cf2 = new Fraction11(1,2);
                    Fraction11 result;

                    System.out.println("Дробь 1: " + cf1);
                    System.out.println("Дробь 2: " + cf2);
                    result = cf1.sum(cf2); // давайте сложим
                    System.out.println("Сумма дробей: " + result);
                    System.out.println("Кэшированное значение: " + cf1.getRealValue());


                    System.out.println("\nЗадаём числитель и знаменатель для 1 дроби.");
                    cf1.setNumeratorDenominator(3,4);
                    System.out.println("Обновлённое значение дроби 1: " + cf1);

                    System.out.println("Умножим новую дробь 1 на кешированное значение");
                    result = cf1.multiply(cf1.getRealValue());
                    System.out.println("Результат: " + result);

                    break;
                }
                case 35: { // задание "список"
                    // пример использования со списком строк
                    List<String> stringList = new ArrayList<>();
                    stringList.add("яблоко");
                    stringList.add("банан");
                    stringList.add("яблоко");

                    System.out.println("Список строк до удаления: " + stringList);
                    Ex35 Sre = new Ex35(stringList, "яблоко"); // удаляем строку
                    System.out.println("Список строк после удаления: " + Sre);


                    // пример использования со списком чисел
                    List<Integer> intList = new ArrayList<>();
                    intList.add(5);
                    intList.add(2);
                    intList.add(5);

                    System.out.println("Список строк до удаления: " + intList);
                    Ex35 Ire = new Ex35(intList, 5); // удаляем число
                    System.out.println("Список строк после удаления: " + Ire);

                    break;
                }
                case 45: { // задание "мап"
                    String filePath = "text45.txt";

                    // Чтение текста из файла
                    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                        int n = Integer.parseInt(reader.readLine()); // Считываем количество магазинов

                        Ex45 ex45 = new Ex45();

                        // заносим информацию о каждом магазине в экземпляр класса
                        for (int i = 0; i < n; i++) {
                            String input = reader.readLine();
                            ex45.setStore(input);
                        }

                        System.out.println(ex45); // выводим результаты

                    } catch (IOException e) {
                        System.out.println("Ошибка чтения файла: " + e.getMessage());
                        return;
                    }

                    break;
                }
                case 55: { // задание "сет"
                    String filePath = "text55.txt";

                    // Чтение текста из файла
                    String input;
                    try { // считываем и сразу понижаем регистр
                        input = Files.readString(Paths.get(filePath)).toLowerCase();
                    } catch (IOException e) {
                        System.out.println("Ошибка чтения файла: " + e.getMessage());
                        return;
                    }

                    // Определяем набор звонких согласных
                    Set<Character> voicedConsonants = new HashSet<>();
                    voicedConsonants.add('б');
                    voicedConsonants.add('в');
                    voicedConsonants.add('г');
                    voicedConsonants.add('д');
                    voicedConsonants.add('ж');
                    voicedConsonants.add('з');
                    voicedConsonants.add('л');
                    voicedConsonants.add('м');
                    voicedConsonants.add('н');
                    voicedConsonants.add('р');

                    Ex55 ex55 = new Ex55(voicedConsonants, input);
                    System.out.println(ex55);

                    break;
                }
                case 65: { // задание "очередь"
                    // пример с числами
                    System.out.println("Пример с числами:");
                    Queue<Integer> L1 = new LinkedList<>();
                    L1.add(1);
                    L1.add(2);
                    L1.add(3);
                    System.out.println("L1: " + L1);

                    Ex65 ex65 = new Ex65();
                    Queue <Integer> L2;
                    L2 = ex65.reverseQueue(L1); // вызываем метод реверса и записываем в L2
                    System.out.println("L2: " + L2);

                    // пример со строками
                    System.out.println("Пример со строками:");
                    Queue<String> SL1 = new LinkedList<>();
                    SL1.add("first");
                    SL1.add("second");
                    SL1.add("third");
                    System.out.println("L1: " + SL1);

                    Ex65 sEx65 = new Ex65();
                    Queue <Integer> SL2;
                    SL2 = sEx65.reverseQueue(SL1); // вызываем метод реверса и записываем в L2
                    System.out.println("L2: " + SL2);
                    break;
                }
                default: {
                    System.out.println("Неверный номер задачи!");
                }
            }
        }
    }
    private static int intInputer() {
        int i;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("\n>>> ");
                i = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введите корректное целое число.");
                scanner.next();
                continue;
            }
            return i;
        }
    }
}
