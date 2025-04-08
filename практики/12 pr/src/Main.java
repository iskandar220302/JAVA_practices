import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
class Main {
    public static void main(String[] args) throws InterruptedException {
        AppSettings appSettings = AppSettings.getInstance();
        Scanner scanner = new Scanner(System.in);

        // Многопоточный режим (для демонстрации singleton)
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executor.submit(new SettingThread(i, appSettings));
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);


        // Ввод/вывод данных пользователем
        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Set setting");
            System.out.println("2. Get setting");
            System.out.println("3. Print all settings");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter key: ");
                    String key = scanner.nextLine();
                    System.out.print("Enter value: ");
                    String value = scanner.nextLine();
                    appSettings.setSetting(key, value);
                    break;
                case 2:
                    System.out.print("Enter key: ");
                    key = scanner.nextLine();
                    String retrievedValue = appSettings.getSetting(key);
                    System.out.println("Value: " + retrievedValue);
                    break;
                case 3:
                    appSettings.printAllSettings();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}