// 生活用品类继承商品类
class DailyNecessities extends Commodity {
    // 生活用品类构造函数
    public DailyNecessities(String id,String name, String unit, double price, String manufacturer) {
        super(id, name, unit, price, manufacturer);
    }
}