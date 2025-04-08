// Обработчик ERROR
class ErrorHandler extends BaseHandler {
    @Override
    public void handleRequest(Request request) {
        if (request.getLevel() == Level.ERROR) {
            System.out.println("ERROR: " + request.getMessage());
        } else {
            super.handleRequest(request);
        }
    }
}