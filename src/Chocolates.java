public class Chocolates extends Sweet{
    public Chocolates(String name, double weigth, double price, String parameter) {
        this.name = name;
        this.price = price;
        this.weight = weigth;
        this.parameter = parameter;
    }
    public Chocolates(String name, double weigth, double price) {
        this.name = name;
        this.price = price;
        this.weight = weigth;
    }
}
