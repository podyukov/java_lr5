import java.util.*;

public class Ex35 {

    List list;

    public <T> Ex35(List<T> list, T value) {
        List<T> list2 = new ArrayList<>(list); // дублируем список, чтобы первоначальный не менять
        Iterator<T> iterator = list2.iterator(); // создаём итератор
        while (iterator.hasNext()) { // пока есть следующий элемент в списке
            if (iterator.next().equals(value)) { // если элемент совпадает со значением, который нужно удалить
                iterator.remove(); // удаляем элемент
            }
        }
        this.list = list2;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
