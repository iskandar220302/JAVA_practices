/**
 * Класс для конвертации единиц измерения.
 */
class Converter {
    /**
     * Конвертирует значение из одной единицы измерения в другую.
     */
    public static double convert(double value, String from, String to) {
        // Преобразование значений (метры, километры и т. д.)
        switch (from) {
            case "meters":
                if (to.equals("kilometers")) {
                    return value / 1000; // Преобразование метров в километры.
                }
                break;
            case "kilometers":
                if (to.equals("meters")) {
                    return value * 1000; // Преобразование километров в метры.
                }
                break;
            // Добавьте здесь другие единицы измерения.
            // weight, temperature и т. д.
            default:
                throw new IllegalArgumentException("Неизвестная единица измерения: " + from);
        }
        throw new IllegalArgumentException("Неверное преобразование с " + from + " на " + to);
    }
}
