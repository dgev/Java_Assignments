public interface Currency {
    static double converter(String from, double money, double rate){
        switch (from.toUpperCase()){
            case "USD":
                return money/rate;
            case "EURO":
                return money* 1.11/rate;
            case "POUND":
                return money* 1.33/rate;
            case "RUBLE":
                return money* 0.016/rate;
            case "AMD":
                return money* 0.0021/rate;
            default:
                return 0;
        }
    }
}
