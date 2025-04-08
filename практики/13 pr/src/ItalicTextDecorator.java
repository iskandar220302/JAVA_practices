// Декоратор для курсивного текста
class ItalicTextDecorator implements Text {
    private final Text text;

    public ItalicTextDecorator(Text text) {
        this.text = text;
    }

    @Override
    public String display() {
        return "*" + text.display() + "*";
    }
}