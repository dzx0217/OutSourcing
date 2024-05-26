import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// 食品类继承商品类
class Food extends Commodity {

    public String productionDate; // 生产日期
    public int shelfLife; // 保质期

    // 食品类构造函数
    public Food(String name, String unit, double price, String manufacturer, String productionDate, int shelfLife) {
        super(name, unit, price, manufacturer);
        this.productionDate = productionDate;
        this.shelfLife = shelfLife;
    }

    public LocalDate getExpirationDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate productionLocalDate = LocalDate.parse(productionDate, formatter);
        return productionLocalDate.plusDays(shelfLife);
    }
}