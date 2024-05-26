import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManagement inventoryManagement = new InventoryManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 显示主菜单
            System.out.println("超市商品管理系统");
            System.out.println("1. 商品入库管理");
            System.out.println("2. 商品上架管理");
            System.out.println("3. 商品销售管理");
            System.out.println("4. 商品下架管理");
            System.out.println("0. 退出");

            // 获取用户选择
            int choice = -1;
            while (true) {
                System.out.print("请选择菜单：");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    break;
                } else {
                    System.out.println("无效的选择，请输入数字！");
                    scanner.next(); // 清除输入缓冲区
                }
            }

            switch (choice) {
                case 0:
                    System.out.println("感谢使用超市商品管理系统，再见！");
                    return;
                case 1:
                    handleInventoryManagement(scanner);
                    break;
                case 2:
                    handleShelfManagement(scanner);
                    break;
                case 3:
                    handleSalesManagement(scanner);
                    break;
                case 4:
                    handleRemoveFromShelf(scanner);
                    break;
                default:
                    System.out.println("无效的选择，请重新输入！");
            }
        }
    }

    // 处理商品入库管理子菜单
    private static void handleInventoryManagement(Scanner scanner) {
        while (true) {
            // 显示子菜单
            System.out.println("商品入库管理");
            System.out.println("1. 新增商品");
            System.out.println("2. 修改商品");
            System.out.println("3. 查询商品");
            System.out.println("4. 删除商品");
            System.out.println("0. 返回主菜单");

            // 获取用户选择
            int choice = -1;
            while (true) {
                System.out.print("请选择操作：");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    break;
                } else {
                    System.out.println("无效的选择，请输入数字！");
                    scanner.next(); // 清除输入缓冲区
                }
            }

            switch (choice) {
                case 0:
                    return;
                case 1:
                    // 处理新增商品操作
                    InventoryManagement.addCommodity(scanner);
                    break;
                case 2:
                    // 处理修改商品操作
                    InventoryManagement.modifyCommodity(scanner);
                    break;
                case 3:
                    // 处理查询商品操作
                    InventoryManagement.queryCommodity(scanner);
                    break;
                case 4:
                    // 处理删除商品操作
                    InventoryManagement.deleteCommodity(scanner);
                    break;
                default:
                    System.out.println("无效的选择，请重新输入！");
            }
        }
    }

    // 处理商品上架管理子菜单
    private static void handleShelfManagement(Scanner scanner) {
        while (true) {
            // 显示子菜单
            System.out.println("商品上架管理");
            System.out.println("1. 上架商品");
            System.out.println("0. 返回主菜单");

            // 获取用户选择
            // 获取用户选择
            int choice = -1;
            while (true) {
                System.out.print("请选择操作：");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    break;
                } else {
                    System.out.println("无效的选择，请输入数字！");
                    scanner.next(); // 清除输入缓冲区
                }
            }

            switch (choice) {
                case 0:
                    return;
                case 1:
                    // 处理新增商品操作
                    InventoryManagement.shelveCommodity(scanner);
                    break;
                default:
                    System.out.println("无效的选择，请重新输入！");
            }
        }
    }

    // 处理商品销售管理子菜单
    private static void handleSalesManagement(Scanner scanner) {
        while (true) {
            // 显示子菜单
            System.out.println("商品销售管理");
            System.out.println("1. 销售商品");
            System.out.println("2. 排序，输出销售信息");
            System.out.println("0. 返回主菜单");

            // 获取用户选择
            // 获取用户选择
            int choice = -1;
            while (true) {
                System.out.print("请选择操作：");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    break;
                } else {
                    System.out.println("无效的选择，请输入数字！");
                    scanner.next(); // 清除输入缓冲区
                }
            }

            switch (choice) {
                case 0:
                    return;
                case 1:
                    // 处理销售商品操作
                    InventoryManagement.recordSalesDetails(scanner);
                    break;
                case 2:
                    // 处理销售商品操作
                    InventoryManagement.listAndSortSalesRecords();
                    break;
                default:
                    System.out.println("无效的选择，请重新输入！");
            }
        }
    }

    // 处理商品下架管理子菜单
    private static void handleRemoveFromShelf(Scanner scanner) {
        while (true) {
            // 显示子菜单
            System.out.println("商品下架管理");
            System.out.println("1. 下架商品");
            System.out.println("2. 查询最近即将下架商品");
            System.out.println("0. 返回主菜单");

            // 获取用户选择
            // 获取用户选择
            int choice = -1;
            while (true) {
                System.out.print("请选择操作：");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    break;
                } else {
                    System.out.println("无效的选择，请输入数字！");
                    scanner.next(); // 清除输入缓冲区
                }
            }

            switch (choice) {
                case 0:
                    return;
                case 1:
                    // 处理新增商品操作
                    InventoryManagement.removeCommodity(scanner);
                    break;
                case 2:
                    InventoryManagement.queryExpiringCommodities();
                    break;
                default:
                    System.out.println("无效的选择，请重新输入！");
            }
        }
    }
}
