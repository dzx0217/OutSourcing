// 商品销售记录类
class SalesRecord {
    public String productName; // 商品名称
    public double price; // 单价
    public int quantity; // 数量
    public double totalPrice; // 总价
    public String saleTime; // 销售时间

    // 商品销售记录类构造函数
    public SalesRecord(String productName, double price, int quantity, String saleTime) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = price * quantity;
        this.saleTime = saleTime;
    }

    // 覆盖toString方法，方便打印销售详情
    @Override
    public String toString() {
        return productName + "," + price + "," + quantity + "," + totalPrice + "," + saleTime;
    }
}
