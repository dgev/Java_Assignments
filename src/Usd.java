public class Usd implements Currency {
    public static double rate = 1;
    public static double converter(String from, double money){
        return Currency.converter(from, money, rate);
    }
}

