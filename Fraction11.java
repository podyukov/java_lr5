public class Fraction11 implements FractionInterface11 { // дробь
    int numerator; // числитель
    int denominator; // знаменатель

    Fraction11 cachedValue; // кэшированное значение

    public Fraction11(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator == 0) {
            System.out.println("Знаменатель не может быть равен 0! Заменен на 1!");
            this.denominator = 1;
        }
        else this.denominator = denominator;
        simplify(); // упрощаем дробь
    }



    private void saveToCache(Fraction11 fraction) { cachedValue = fraction; }

    // получение вещественного значения
    @Override
    public Fraction11 getRealValue() { return cachedValue; }

    @Override
    public void setNumeratorDenominator(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator > 0) this.denominator = denominator;
        else {
            System.out.println("Знаменатель не может быть отрицательным или равен нулю! Тогда будет 1!");
            this.denominator = 1;
        }
    }



    public Fraction11 sum(Fraction11 other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        Fraction11 newValue = new Fraction11(newNumerator, newDenominator);
        saveToCache(newValue);
        return newValue;
    }

    public Fraction11 minus(Fraction11 other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        Fraction11 newValue = new Fraction11(newNumerator, newDenominator);
        saveToCache(newValue);
        return newValue;
    }

    public Fraction11 multiply(Fraction11 other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        Fraction11 newValue = new Fraction11(newNumerator, newDenominator);
        saveToCache(newValue);
        return newValue;
    }

    public Fraction11 div(Fraction11 other) {
        if (other.denominator == 0) {
            System.out.println("Деление на ноль! Знаменатель будет заменён на 1!");
            int newNumerator = this.numerator;
            int newDenominator = this.denominator * other.numerator;
            Fraction11 newValue = new Fraction11(newNumerator, newDenominator);
            saveToCache(newValue);
            return newValue;
        }
        else {
            int newNumerator = this.numerator * other.denominator;
            int newDenominator = this.denominator * other.numerator;
            Fraction11 newValue = new Fraction11(newNumerator, newDenominator);
            saveToCache(newValue);
            return newValue;
        }
    }

    private void simplify() { // упрощение дроби
        int gcd = gcd(numerator, denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    private int gcd(int a, int b) { // greatest common divisior - наибольший общий делитель
        if (b == 0) return a; // алгоритм Евклида
        return gcd(b, a % b);
    }

    @Override
    public String toString() {
        return String.format("%d/%d", numerator, denominator);
    }
}
