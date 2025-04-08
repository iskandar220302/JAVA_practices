// Декоратор для жирного текста
class BoldTextDecorator implements Text {
    private final Text text;

    public BoldTextDecorator(Text text) {
        this.text = text;
    }

    @Override
    public String display() {
        return "**" + text.display() + "**";
    }
}