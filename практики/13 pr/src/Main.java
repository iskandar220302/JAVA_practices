public class Main {
    public static void main(String[] args) {
        // Создаем простой текст
        Text simpleText = new SimpleText("Hello, world!");
        System.out.println("Simple text: " + simpleText.display());


        // Добавляем форматирование с помощью декораторов
        Text boldText = new BoldTextDecorator(simpleText);
        System.out.println("Bold text: " + boldText.display());

        Text italicBoldText = new ItalicTextDecorator(boldText);
        System.out.println("Italic and Bold text: " + italicBoldText.display());

        Text underlinedItalicBoldText = new UnderlineTextDecorator(italicBoldText);
        System.out.println("Underlined, Italic and Bold text: " + underlinedItalicBoldText.display());


        //Порядок декораторов не важен
        Text boldUnderlinedText = new BoldTextDecorator(new UnderlineTextDecorator(simpleText));
        System.out.println("Bold and Underlined text: " + boldUnderlinedText.display());

    }
}