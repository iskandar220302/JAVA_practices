// Обработчик CRITICAL
class CriticalHandler extends BaseHandler {
    @Override
    public void handleRequest(Request request) {
        if (request.getLevel() == Level.CRITICAL) {
            System.out.println("CRITICAL: " + request.getMessage());
        } else {
            super.handleRequest(request);
        }
    }
}