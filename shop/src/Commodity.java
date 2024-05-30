// 商品类
class Commodity {

    public String id; // id

    public String name; // 商品名称
    public String unit; // 单位
    public double price; // 价格
    public String manufacturer;//厂家

    // 商品类构造函数
    public Commodity(String id, String name, String unit, double price, String manufacturer) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.manufacturer = manufacturer;
    }
}
