// Базовый класс для простого текста
class SimpleText implements Text {
    private final String text;

    public SimpleText(String text) {
        this.text = text;
    }

    @Override
    public String display() {
        return text;
    }
}