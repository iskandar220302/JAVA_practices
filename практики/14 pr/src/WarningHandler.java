// Обработчик WARNING
class WarningHandler extends BaseHandler {
    @Override
    public void handleRequest(Request request) {
        if (request.getLevel() == Level.WARNING) {
            System.out.println("WARNING: " + request.getMessage());
        } else {
            super.handleRequest(request);
        }
    }
}