import java.util.*;

public class Ex45 {

    Map<Integer, Integer> minPrice; // жирность - минимальная цена
    Map<Integer, Integer> storeCountsMin; // жирность - количество магазинов минимальной цены

    public Ex45() { // при создании объекта
        minPrice = new HashMap<>(); // создаём объекты мапов
        storeCountsMin = new HashMap<>();

        minPrice.put(15, Integer.MAX_VALUE); // заполняем минимальную цену максимальными
        minPrice.put(20, Integer.MAX_VALUE);
        minPrice.put(25, Integer.MAX_VALUE);
    }

    public void setStore(String input) { // принимает построчно инфу о каждом магазине и записывает в класс
        String[] data = input.split(" "); // разбиваем строку по пробелам
        int soupCreamFat = Integer.parseInt(data[2]); // вытягиваем из строки жирность
        int price = Integer.parseInt(data[3]); // вытягиваем из строки цену

        // обновляем минимальную цену у жирности и количество магазинов с минимальной ценой
        if (price < minPrice.get(soupCreamFat)) { // если цена меньше чем минимальная цена у жирности
            minPrice.put(soupCreamFat, price); // обновляем минимальную цену у жирности
            storeCountsMin.put(soupCreamFat, 1); // так как нашли меньшую цену у данной жирности, сбрасываем счётчик магазинов с минимальной ценой
        } else if (price == minPrice.get(soupCreamFat)) { // иначе, если цена совпадает с минимальной
            storeCountsMin.put(soupCreamFat, storeCountsMin.get(soupCreamFat) + 1); // увеличиваем счётчик магазинов с минимальной ценой у определённой жирности
        }
    }

    @Override
    public String toString() {
        String out = "";
        if (storeCountsMin.get(15) == null) out += "0 ";
        else out += storeCountsMin.get(15).toString() + " ";
        if (storeCountsMin.get(20) == null) out += "0 ";
        else out += storeCountsMin.get(20).toString() + " ";
        if (storeCountsMin.get(25) == null) out += "0";
        else out += storeCountsMin.get(25).toString();
        return out;
    }
}
