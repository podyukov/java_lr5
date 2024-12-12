public class CachedFraction11 extends Fraction11 implements FractionInterface11 {

    private double cachedValue; // кэшированное значение

    public CachedFraction11(int numerator, int denominator) {
        super(numerator, denominator);
        cachedValue = 0.0; // инициализируем кэшированное значение
    }

    @Override
    public double getRealValue() { // получение вещественного значения
        if (cachedValue == 0.0) { // если кэш пуст
            cachedValue = (double) numerator / denominator; // вычисляем кэш
        }
        System.out.println(String.format("%d/%d", numerator, denominator));
        return cachedValue;
    }

    @Override
    public void setNumeratorDenominator(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator > 0) this.denominator = denominator;
        else {
            System.out.println("Знаменатель не может быть отрицательным или равен нулю! Тогда будет 1!");
            this.denominator = 1;
        }
        this.cachedValue = 0.0; // сбрасываем когда задаем новый числитель и знаменатель
    }
}
