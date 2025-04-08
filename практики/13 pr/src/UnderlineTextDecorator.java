// Декоратор для подчеркнутого текста
class UnderlineTextDecorator implements Text {
    private final Text text;

    public UnderlineTextDecorator(Text text) {
        this.text = text;
    }

    @Override
    public String display() {
        return "<u>" + text.display() + "</u>";
    }
}