public class Ruble implements Currency {
    public static double rate = 0.016;
    public static double converter(String from, double money){
        return Currency.converter(from, money, rate);
    }
}
