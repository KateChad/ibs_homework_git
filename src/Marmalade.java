public class Marmalade extends Sweet{
    public Marmalade(String name, double weigth, double price, String parameter) {
        this.name = name;
        this.price = price;
        this.weight = weigth;
        this.parameter = parameter;
    }
    public Marmalade(String name, double weigth, double price) {
        this.name = name;
        this.price = price;
        this.weight = weigth;
    }
}
