import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        final double ROUBLES_PER_YUAN = 11.91;
        int yuan, digit; // сумма денег в китайских юанях
        double roubles;

        Scanner input = new Scanner(System.in);
        System.out.print("Введите сумму в юанях: ");
        yuan = input.nextInt();

        roubles = yuan * ROUBLES_PER_YUAN;

        digit = yuan % 10;

        if (digit == 0 || digit == 5 || digit == 6 || digit == 7 || digit == 8 || digit == 9 || (yuan > 9 && yuan <= 20)){
            System.out.printf("вы ввели " + yuan + " юаней");
        }
        else if (digit == 1){
            System.out.printf("вы ввели " + yuan + " юань");
        }
        else {
            System.out.printf("вы ввели " + yuan + " юаня");
        }

    }
}