public class Main {
    public static void main(String[] args) {
        // Создаем обработчиков
        RequestHandler infoHandler = new InfoHandler();
        RequestHandler warningHandler = new WarningHandler();
        RequestHandler errorHandler = new ErrorHandler();
        RequestHandler criticalHandler = new CriticalHandler();
        RequestHandler debugHandler = new DebugHandler();

        // Настраиваем цепочку обработчиков
        infoHandler.setNext(warningHandler);
        warningHandler.setNext(errorHandler);
        errorHandler.setNext(criticalHandler);
        criticalHandler.setNext(debugHandler);

        // Тестируем обработку запросов
        Request request1 = new Request("This is an info message.", Level.INFO);
        Request request2 = new Request("This is a warning message.", Level.WARNING);
        Request request3 = new Request("This is an error message.", Level.ERROR);
        Request request4 = new Request("This is a critical message.", Level.CRITICAL);
        Request request5 = new Request("This is a debug message.", Level.DEBUG);

        infoHandler.handleRequest(request1);
        infoHandler.handleRequest(request2);
        infoHandler.handleRequest(request3);
        infoHandler.handleRequest(request4);
        infoHandler.handleRequest(request5);
    }
}
