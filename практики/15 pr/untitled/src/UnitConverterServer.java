import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Класс для создания HTTP-сервера, который конвертирует единицы измерения.
 */
public class UnitConverterServer {
    private static final int PORT = 8080; // Порт, на котором будет запущен сервер.

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Unit Converter HTTP Server запущен на порту " + PORT);

            // Бесконечный цикл для обработки входящих соединений.
            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    handleClient(clientSocket); // Обработать клиента.
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка запуска сервера: " + e.getMessage());
        }
    }

    /**
     * Обрабатывает отдельное подключение от клиента.
     */
    private static void handleClient(Socket clientSocket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream());

        String line = in.readLine();
        if (line == null) return;

        // Разбить строку с запросом на части.
        String[] requestParts = line.split(" ");
        String method = requestParts[0];
        String path = requestParts[1];

        // Проверка на тип запроса.
        if (method.equals("GET") && path.startsWith("/convert")) {
            // Обработать запрос на конвертацию.
            handleConversion(requestParts[1], out);
        } else {
            // Обработать ошибку 404 для несуществующего ресурса.
            handleNotFound(out);
        }
        out.flush(); // Отправка ответа клиенту.
    }

    /**
     * Обрабатывает запрос на конвертацию единиц измерения.
     */
    private static void handleConversion(String query, PrintWriter out) {
        // Извлекаем параметры из строки запроса.
        String[] params = query.split("\\?");
        if (params.length < 2) {
            sendHttpResponse(out, 400, "Некорректный запрос. Используйте формат: /convert?value=123&from=units&to=units");
            return;
        }

        String[] queryParams = params[1].split("&");
        Double value = null;
        String fromUnit = null;
        String toUnit = null;

        // Извлечение значений из параметров.
        for (String param : queryParams) {
            String[] pair = param.split("=");
            if (pair.length == 2) {
                switch (pair[0]) {
                    case "value":
                        try {
                            value = Double.valueOf(pair[1]);
                        } catch (NumberFormatException e) {
                            sendHttpResponse(out, 400, "Некорректное значение для параметра 'value'");
                            return;
                        }
                        break;
                    case "from":
                        fromUnit = pair[1];
                        break;
                    case "to":
                        toUnit = pair[1];
                        break;
                }
            }
        }

        // Проверка наличия всех обязательных параметров.
        if (value == null || fromUnit == null || toUnit == null) {
            sendHttpResponse(out, 400, "Отсутствуют обязательные параметры 'value', 'from' или 'to'");
            return;
        }

        // Выполнение конвертации.
        double result = Converter.convert(value, fromUnit, toUnit);
        sendHttpResponse(out, 200, String.valueOf(result)); // Отправка результата.
    }

    /**
     * Отправляет 404 Not Found ответ.
     */
    private static void handleNotFound(PrintWriter out) {
        sendHttpResponse(out, 404, "<html><body><h1>404 Not Found</h1></body></html>");
    }

    /**
     * Отправляет HTTP ответ с заданным кодом статуса и телом ответа.
     */
    private static void sendHttpResponse(PrintWriter out, int statusCode, String body) {
        out.println("HTTP/1.1 " + statusCode + " OK");
        out.println("Content-Type: text/plain");
        out.println("Content-Length: " + body.length());
        out.println();
        out.println(body);
    }
}
