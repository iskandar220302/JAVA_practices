// Обработчик INFO
class InfoHandler extends BaseHandler {
    @Override
    public void handleRequest(Request request) {
        if (request.getLevel() == Level.INFO) {
            System.out.println("INFO: " + request.getMessage());
        } else {
            super.handleRequest(request);
        }
    }
}