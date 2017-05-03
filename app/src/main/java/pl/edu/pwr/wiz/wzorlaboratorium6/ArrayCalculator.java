package pl.edu.pwr.wiz.wzorlaboratorium6;

/**
 * Kalkulator dla danych przesyłanych w postaci listy liczb
 */

public class ArrayCalculator {
    private Float[] array;

    /* Konstruktor - przyjmuje dane w postaci Stringa i przerabia na tablicę */
    public ArrayCalculator(String str) {
        String[] items = str.split(",");
        array = new Float[items.length];

        for (int i = 0; i < items.length; i++) {
            array[i] = Float.parseFloat(items[i]);
        }
    }

    /* Getter */
    public Float[] getArray() {
        return array;
    }

    /* Sumowanie */
    public Float getSum() {
        Float result = new Float(0.0);

        for(int i = 0; i < array.length; i++) {
            result += array[i];
        }

        return result;
    }

    /* Mnożenie */
    public Float getMultiplied() {
        Float result = new Float(1.0);

        for(int i = 0; i < array.length; i++) {
            result *= array[i];
        }

        return result;
    }

    /* Ilość elementów */
    public Integer getSize() {
        /* TODO - zwracać ilość elementów */
        return 0;
    }

    /* Srednia */
    public Float getAverage() {
        /* TODO - zwracać srednia */
        return Float.valueOf(0);
    }
}
