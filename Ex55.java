import java.util.*;

public class Ex55 {

    Set<Character> vCmore2;

    public Ex55(Set<Character> voicedConsonants, String input) {

        // Разделяем текст на слова (оставляем только слова, без знаков препинания, без мусора)
        String[] words = input.split("[^а-яё]+");

        Set<Character> vCmore2 = new TreeSet<>(); // благодаря TreeSet сортировка сразу происходит

        for (Character voicedConsonant : voicedConsonants) { // идём по каждой звонкой согласной
            int count = 0; // количество повторений
            for (String word : words) { // идём по каждому слову
                if (word.indexOf(voicedConsonant) != -1) { // если символ найден в слове
                    count++; // увеличиваем количество повторений
                    if (count > 1) { // если нашли больше 1 повторения
                        vCmore2.add(voicedConsonant); // добавляем символ в список, всё равно больше 1 раза не добавится
                    }
                }
            }
        }

        this.vCmore2 = vCmore2;
    }

    @Override
    public String toString() {
        return "Звонкие согласные, которые встречаются более чем в одном слове:\n" + vCmore2.toString();
    }
}
