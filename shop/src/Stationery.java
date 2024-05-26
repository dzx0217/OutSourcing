// 文具类继承商品类
class Stationery extends Commodity {
    public String manufacturer; // 制造商

    // 文具类构造函数
    public Stationery(String name, String unit, double price, String manufacturer) {
        super(name, unit, price, manufacturer);
        this.manufacturer = manufacturer;
    }
}
