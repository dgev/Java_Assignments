import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);

        System.out.println("Please enter the currency");
        String from = in.nextLine();

        System.out.println("Please enter the currency to be converted to");
        String currency = in.nextLine();

        System.out.println("Please enter the amount to be converted to");
        double money = in.nextDouble();

        switch (currency.toUpperCase()){
            case "USD":
                System.out.println(Usd.converter(from, money) + " USD");
                break;
            case "EURO":
                System.out.println(Euro.converter(from, money) + " EURO");
                break;
            case "POUND":
                System.out.println(Pound.converter(from, money) + " POUND");
                break;
            case "RUBLE":
                System.out.println(Ruble.converter(from, money) + " RUBLE");
                break;
            case "AMD":
                System.out.println(Amd.converter(from, money) + " AMD");
                break;
            default:
                System.out.println("Invalid input :(");
        }
        in.close();
    }
}
