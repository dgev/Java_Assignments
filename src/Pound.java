public class Pound implements Currency {
    public static double rate = 1.33;
    public static double converter(String from, double money){
        return Currency.converter(from, money, rate);
    }
}
