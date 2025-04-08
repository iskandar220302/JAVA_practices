//  интерфейс, определяющий методы для установки следующего обработчика и обработки запроса.
interface RequestHandler {
    void setNext(RequestHandler nextHandler);
    void handleRequest(Request request);
}