import java.util.*;

public class Ex65 {

    public <T> Queue reverseQueue(Queue<T> L1) {
        Queue<T> L11 = new LinkedList<>(L1); // дублируем очередь, чтобы первоначальный не трогать
        Stack<T> stack = new Stack<>(); // создаём стек

        for (T item : L11) { // проходимся по всем элементам 1 2 3
            stack.push(item); // добавляем элементы 1 2 3
        }

        Queue<T> L2 = new LinkedList<>(); // создаём вторую очередь, куда будем копировать элементы из стека

        while (!stack.isEmpty()) { // пока элементы в стеке не закончатся
            L2.add(stack.pop()); // достаём элемент из стека, удаляем его, и кладем в очередь
        }

        return L2; // возвращаем очередь
    }

    @Override
    public String toString() {
        return "Для этого класса не определён вывод toString()";
    }
}
