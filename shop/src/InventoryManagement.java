import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

public class InventoryManagement {
    private static final String FILE_PATH = "commodities.csv"; // 商品信息CSV文件路径
    private static final String SHELVE_PATH = "shelve.csv"; // 商品信息CSV文件路径
    private static final String SALES_FILE_PATH = "sales_records.csv"; // 商品销售记录CSV文件路径

    // 新增商品
    public static void addCommodity(Scanner scanner) {
        System.out.println("请选择商品类别：");
        System.out.println("1. 文具");
        System.out.println("2. 食品");
        System.out.println("3. 生活用品");
        System.out.print("请输入选择（1-3）：");
        int categoryIndex = scanner.nextInt();
        scanner.nextLine(); // 消费掉换行符

        String category;
        switch (categoryIndex) {
            case 1:
                category = "文具";
                addStationery(scanner);
                break;
            case 2:
                category = "食品";
                addFood(scanner);
                break;
            case 3:
                category = "生活用品";
                addDailyNecessities(scanner);
                break;
            default:
                System.out.println("无效的选择！");
                return;
        }
    }

    // 新增文具商品
    public static void addStationery(Scanner scanner) {
        System.out.println("请输入文具名称：");
        String name = scanner.nextLine();
        System.out.println("请输入单位：");
        String unit = scanner.nextLine();
        System.out.println("请输入价格：");
        double price;
        while (!scanner.hasNextDouble()) {
            System.out.println("输入不是有效的价格，请重新输入：");
            scanner.next(); // 消耗无效输入
        }
        price = scanner.nextDouble();
        scanner.nextLine(); // 消费掉换行符
        System.out.println("请输入制造商：");
        String manufacturer = scanner.nextLine();


        // 创建文具对象
        Stationery stationery = new Stationery(name, unit, price, manufacturer);

        // 将新增文具写入CSV文件
        writeCommodityToCSV(stationery);
    }

    // 新增食品商品
    public static void addFood(Scanner scanner) {
        System.out.println("请输入食品名称：");
        String name = scanner.nextLine();
        System.out.println("请输入单位：");
        String unit = scanner.nextLine();
        System.out.println("请输入价格：");
        double price;
        while (!scanner.hasNextDouble()) {
            System.out.println("输入不是有效的价格，请重新输入：");
            scanner.next(); // 消耗无效输入
        }
        price = scanner.nextDouble();
        scanner.nextLine(); // 消费掉换行符
        System.out.println("请输入食物制造商：");
        String manufacturer = scanner.nextLine();
        System.out.println("请输入生产日期：");
        System.out.print("请选择输入食品生产日期的方式（1. 手动输入 0. 使用本地时间）：");
        int option = scanner.nextInt();
        scanner.nextLine(); // 消费掉换行符

        String productionDate;
        if (option == 1) {
            System.out.println("请输入生产日期（格式：yyyyMMdd）：");
            productionDate = readValidDate(scanner);
        } else if (option == 0) {
            productionDate = java.time.LocalDate.now().toString();
            System.out.println("使用本地时间：" + productionDate);
        } else {
            System.out.println("无效的选择，默认使用本地时间");
            productionDate = java.time.LocalDate.now().toString();
        }
        System.out.println("请输入保质期（天）：");
        int shelfLife = scanner.nextInt();
        scanner.nextLine(); // 消费掉换行符

        // 创建食品对象
        Food food = new Food(name, unit, price, manufacturer, productionDate, shelfLife);

        // 将新增食品写入CSV文件
        writeCommodityToCSV(food);
    }

    // 新增生活用品商品
    public static void addDailyNecessities(Scanner scanner) {
        System.out.println("请输入生活用品名称：");
        String name = scanner.nextLine();
        System.out.println("请输入单位：");
        String unit = scanner.nextLine();
        System.out.println("请输入价格：");
        double price;
        while (!scanner.hasNextDouble()) {
            System.out.println("输入不是有效的价格，请重新输入：");
            scanner.next(); // 消耗无效输入
        }
        price = scanner.nextDouble();
        scanner.nextLine(); // 消费掉换行符

        System.out.println("请输入制造商：");
        String manufacturer = scanner.nextLine();

        // 创建生活用品对象
        DailyNecessities dailyNecessities = new DailyNecessities(name, unit, price, manufacturer);

        // 将新增生活用品写入CSV文件
        writeCommodityToCSV(dailyNecessities);
    }

    // 将商品信息写入CSV文件
    public static void writeCommodityToCSV(Commodity commodity) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            String category;
            if (commodity instanceof Stationery) {
                category = "文具";
                // 将商品信息写入CSV文件
                writer.write(commodity.id + "," + commodity.name + "," + commodity.unit + "," + commodity.price + "," + ((Stationery) commodity).manufacturer + "," + "," + "," + category + "\n");
                System.out.println("商品已成功新增并保存到CSV文件！");
            } else if (commodity instanceof Food) {
                category = "食品";
                // 将商品信息写入CSV文件
                writer.write(commodity.id + "," + commodity.name + "," + commodity.unit + "," + commodity.price + "," + ((Food) commodity).manufacturer + "," + ((Food) commodity).productionDate + "," + ((Food) commodity).shelfLife + "," + category + "\n");
                System.out.println("商品已成功新增并保存到CSV文件！");
            } else if (commodity instanceof DailyNecessities) {
                category = "生活用品";
                // 将商品信息写入CSV文件
                writer.write(commodity.id + "," + commodity.name + "," + commodity.unit + "," + commodity.price + "," + ((DailyNecessities) commodity).manufacturer + "," + "," + "," + category + "\n");
                System.out.println("商品已成功新增并保存到CSV文件！");
            } else {
                category = "未知";
                // 将商品信息写入CSV文件
                writer.write(commodity.id + "," + commodity.name + "," + commodity.unit + "," + commodity.price + "," + commodity.manufacturer + "," + "," + "," + category + "\n");
                System.out.println("商品已成功新增并保存到CSV文件！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 修改商品
    public static void modifyCommodity(Scanner scanner) {
        System.out.println("请输入要修改的商品名称：");
        scanner.nextLine();  // 消费掉上一个输入留下的换行符
        String targetName = scanner.nextLine();

        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("商品信息文件不存在！");
            return;
        }

        try {
            File tempFile = new File("temp.csv");
            FileWriter writer = new FileWriter(tempFile);

            Scanner fileScanner = new Scanner(file);
            boolean found = false;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                String id = parts[0];
                String name = parts[1];

                if (name.equals(targetName)) {
                    found = true;
                    System.out.println("找到商品：" + name + "，请输入新的商品信息：");
                    System.out.print("单位：");
                    String unit = scanner.nextLine();
                    System.out.print("价格：");
                    double price;
                    while (!scanner.hasNextDouble()) {
                        System.out.println("输入不是有效的价格，请重新输入：");
                        scanner.next(); // 消耗无效输入
                    }
                    price = scanner.nextDouble();
                    scanner.nextLine(); // 消费掉换行符

                    System.out.print("类别（文具/食品/生活用品）：");
                    String category = scanner.nextLine();
                    String newLine = "";

                    if (category.equals("食品")) {
                        System.out.print("生产日期（格式：yyyy-MM-dd）：");
                        String productionDate = scanner.nextLine();
                        System.out.print("保质期（天）：");
                        int shelfLife;
                        while (!scanner.hasNextInt()) {
                            System.out.println("输入不是有效的天数，请重新输入：");
                            scanner.next(); // 消耗无效输入
                        }
                        shelfLife = scanner.nextInt();
                        scanner.nextLine(); // 消费掉换行符
                        System.out.print("制造商：");
                        String manufacturer = scanner.nextLine();
                        newLine = id + "," + name + "," + unit + "," + price + "," + manufacturer + "," + productionDate + "," + shelfLife + "," + category;
                    } else if (category.equals("文具")) {
                        System.out.print("制造商：");
                        String manufacturer = scanner.nextLine();

                        newLine = id + "," + name + "," + unit + "," + price + "," + manufacturer + "," + "," + "," + category;
                    } else if (category.equals("生活用品")) {
                        System.out.print("制造商：");
                        String manufacturer = scanner.nextLine();
                        newLine = id + "," + name + "," + unit + "," + price + "," + manufacturer + "," + "," + "," + category;
                    } else {
                        System.out.println("未知类别！");
                        newLine = line;
                    }

                    line = newLine;
                }

                writer.write(line + "\n");
            }

            fileScanner.close();
            writer.close();

            // 删除原始文件并重命名临时文件
            if (found && file.delete()) {
                tempFile.renameTo(file);
                System.out.println("商品信息已成功修改！");
            } else if (!found) {
                System.out.println("未找到商品：" + targetName);
            } else {
                System.out.println("修改商品信息失败！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 删除商品
    public static void deleteCommodity(Scanner scanner) {
        System.out.println("请输入要删除的商品名称：");
        scanner.nextLine();
        String targetName = scanner.nextLine();

        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("商品信息文件不存在！");
            return;
        }

        try {
            File tempFile = new File("temp.csv");
            FileWriter writer = new FileWriter(tempFile);

            Scanner fileScanner = new Scanner(file);
            boolean found = false;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                String name = parts[1];

                if (name.equals(targetName)) {
                    found = true;
                    System.out.println("找到商品：" + name + "，已删除！");
                    continue;
                }

                writer.write(line + "\n");
            }

            fileScanner.close();
            writer.close();

            // 删除原始文件并重命名临时文件
            if (found && file.delete()) {
                tempFile.renameTo(file);
                System.out.println("商品已成功删除！");
            } else if (!found) {
                System.out.println("未找到商品：" + targetName);
            } else {
                System.out.println("删除商品失败！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 查询商品
    public static void queryCommodity(Scanner scanner) {
        System.out.println("请输入要查询的商品名称：");
        scanner.nextLine();
        String targetName = scanner.nextLine();

        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("商品信息文件不存在！");
            return;
        }

        try {
            Scanner fileScanner = new Scanner(file);
            boolean found = false;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                String name = parts[1];

                if (name.equals(targetName)) {
                    found = true;
                    System.out.println("找到商品：" + name);
                    System.out.println("商品信息：");
                    System.out.println("id：" + parts[0]);
                    System.out.println("名称：" + parts[1]);
                    System.out.println("单位：" + parts[2]);
                    System.out.println("价格：" + parts[3]);
                    System.out.println("厂商：" + parts[4]);
                    System.out.println("入库时间：" + parts[5]);
                    System.out.println("保质期：" + parts[6]);
                    System.out.println("类别：" + parts[7]);
                    System.out.println();
                }
            }

            fileScanner.close();
            if (!found) {
                System.out.println("未找到商品：" + targetName);
            }
        } catch (FileNotFoundException e) {
            System.out.println("商品信息文件不存在！");
            e.printStackTrace();
        }
    }

    // 商品上架管理
    public static void shelveCommodity(Scanner scanner) {
        System.out.println("请输入要上架的商品信息：");
        scanner.nextLine();
        System.out.print("商品名称：");
        String name = scanner.nextLine();

        System.out.print("请输入商品的摆放位置：");
        String location = scanner.nextLine();

        // 获取当前时间作为上架时间
        String shelveTime = java.time.LocalDate.now().toString();

        // 将商品信息写入CSV文件
        try (FileWriter writer = new FileWriter(SHELVE_PATH, true)) {
            writer.write(name + "," + location + "," + shelveTime + "\n");
            System.out.println("商品已成功上架并保存到CSV文件！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 记录商品销售详情
    public static void recordSalesDetails(Scanner scanner) {
        System.out.println("请输入销售的商品信息：");
        scanner.nextLine();
        System.out.print("商品名称：");
        String productName = scanner.nextLine();
        System.out.print("单价：");
        double price;
        while (!scanner.hasNextDouble()) {
            System.out.println("输入不是有效的价格，请重新输入：");
            scanner.next(); // 消耗无效输入
        }
        price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("数量：");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // 消费掉换行符

        // 获取当前时间作为销售时间
        String saleTime = java.time.LocalDate.now().toString();

        SalesRecord salesRecord = new SalesRecord(productName, price, quantity, saleTime);

        // 将销售记录写入CSV文件
        try (FileWriter writer = new FileWriter(SALES_FILE_PATH, true)) {
            writer.write(salesRecord.toString() + "\n");
            System.out.println("销售记录已成功保存到CSV文件！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 商品下架管理
    public static void removeCommodity(Scanner scanner) {
        System.out.println("请输入要下架的商品名称：");
        scanner.nextLine();
        String targetName = scanner.nextLine();

        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("商品信息文件不存在！");
            return;
        }

        try {
            File tempFile = new File("temp.csv");
            FileWriter writer = new FileWriter(tempFile);

            Scanner fileScanner = new Scanner(file);
            boolean found = false;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                String name = parts[1];

                if (name.equals(targetName)) {
                    found = true;
                    System.out.println("找到商品：" + name + "，请输入下架原因：");
                    String reason = scanner.nextLine();
                    String removalTime = java.time.LocalDate.now().toString();
                    line += "," + removalTime + "," + reason;
                }

                writer.write(line + "\n");
            }

            fileScanner.close();
            writer.close();

            // 删除原始文件并重命名临时文件
            if (found && file.delete()) {
                tempFile.renameTo(file);
                System.out.println("商品已成功下架！");
            } else if (!found) {
                System.out.println("未找到商品：" + targetName);
            } else {
                System.out.println("下架商品失败！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listAndSortSalesRecords() {
        List<SalesRecord> salesRecords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(SALES_FILE_PATH)), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 5) {
                    SalesRecord record = new SalesRecord(fields[0], Double.parseDouble(fields[1]), Integer.parseInt(fields[2]), fields[4]);
                    salesRecords.add(record);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        salesRecords.sort((r1, r2) -> Double.compare(r2.totalPrice, r1.totalPrice));

        for (SalesRecord record : salesRecords) {
            System.out.println(record);
        }
    }

    public static void queryExpiringCommodities() {
        List<Food> foodList = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            System.out.println("商品信息文件不存在！");
            return;
        }

        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length >= 7 && parts[7].equals("食品")) {
                    String name = parts[1];
                    String unit = parts[2];
                    double price = Double.parseDouble(parts[3]);
                    String manufacturer = parts[4];
                    String productionDate = parts[5];
                    int shelfLife = Integer.parseInt(parts[6]);
                    foodList.add(new Food(name, unit, price, manufacturer, productionDate, shelfLife));
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // 按过期时间离今天的时间大小排序
        foodList.sort(Comparator.comparing(InventoryManagement::getDaysUntilExpiration));

        System.out.println("即将过期的食品：");
        for (Food food : foodList) {
            System.out.println("id：" + food.id);
            System.out.println("商品名：" + food.name);
            System.out.println("单位：" + food.unit);
            System.out.println("单价：" + food.price);
            System.out.println("厂商：" + food.manufacturer);
            System.out.println("生产日期:" + food.productionDate);
            System.out.println("保质期:" + food.productionDate);
            System.out.println("还有多少天过期:" + getDaysUntilExpiration(food));
        }
    }

    public static long getDaysUntilExpiration(Food food) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date productionDate = sdf.parse(food.productionDate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(productionDate);
            cal.add(Calendar.DAY_OF_YEAR, food.shelfLife);
            Date expirationDate = cal.getTime();
            Date today = new Date();
            long diff = expirationDate.getTime() - today.getTime();
            return diff / (1000 * 60 * 60 * 24); // 转换为天数
        } catch (ParseException | java.text.ParseException e) {
            e.printStackTrace();
            return Long.MAX_VALUE;
        }
    }

    // 读取并验证日期格式
    public static String readValidDate(Scanner scanner) {
        String dateStr;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        sdf.setLenient(false); // 设置非宽松模式
        while (true) {
            dateStr = scanner.nextLine();
            try {
                sdf.parse(dateStr); // 尝试解析日期
                break; // 如果解析成功，跳出循环
            } catch (ParseException | java.text.ParseException e) {
                System.out.println("输入的日期格式不正确，请按格式 yyyyMMdd 输入：");
            }
        }
        return dateStr;
    }
}