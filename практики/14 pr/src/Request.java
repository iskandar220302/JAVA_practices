// Класс, представляющий запрос
class Request {
    private String message;
    private Level level;

    public Request(String message, Level level) {
        this.message = message;
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public Level getLevel() {
        return level;
    }
}
