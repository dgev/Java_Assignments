public class Amd implements Currency {
    public static double rate = 0.0021;
    public static double converter(String from, double money){
        return Currency.converter(from, money, rate);
    }
}
