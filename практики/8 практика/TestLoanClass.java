public class Main {
    public static void main(String[] args) {
        String[] months = {"январь", "февраль", "март", "апрель", "май",
                "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"};
        int[] dom = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        Scanner input = new Scanner(System.in);
        System.out.print("Введите целое число от 1 до 12: ");
        int month = input.nextInt();

        if (month == 2) {
            System.out.print("Введите год: ");
            int year = input.nextInt();
            if (isLeapYear(year)) {
                dom[1] = 29;
            }
        }

        try {
            System.out.println("Месяц: " + months[month - 1]);
            System.out.println("Количество дней в месяце: " + dom[month - 1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Недопустимое число");
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}