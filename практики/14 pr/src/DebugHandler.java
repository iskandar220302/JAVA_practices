// Обработчик DEBUG
class DebugHandler extends BaseHandler {
    @Override
    public void handleRequest(Request request) {
        if (request.getLevel() == Level.DEBUG) {
            System.out.println("DEBUG: " + request.getMessage());
        } else {
            super.handleRequest(request);
        }
    }
}