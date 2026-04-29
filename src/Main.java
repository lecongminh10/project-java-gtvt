import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Shape> shapes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- CHƯƠNG TRÌNH QUẢN LÝ HÌNH HỌC (PAINT) ---");
            System.out.println("1. Thêm Point");
            System.out.println("2. Thêm Line");
            System.out.println("3. Thêm Circle");
            System.out.println("4. Thêm Rectangle");
            System.out.println("5. Thêm Triangle");
            System.out.println("6. Hiển thị danh sách các hình");
            System.out.println("7. Tính tổng diện tích và chu vi");
            System.out.println("8. Tìm hình có diện tích lớn nhất / nhỏ nhất");
            System.out.println("9. Phóng to / Thu nhỏ tất cả các hình");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1: addPoint(); break;
                case 2: addLine(); break;
                case 3: addCircle(); break;
                case 4: addRectangle(); break;
                case 5: addTriangle(); break;
                case 6: displayShapes(); break;
                case 7: calculateTotals(); break;
                case 8: findMinMaxArea(); break;
                case 9: zoomAll(); break;
                case 0: exit = true; break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void addPoint() {
        System.out.print("Nhập x: "); double x = scanner.nextDouble();
        System.out.print("Nhập y: "); double y = scanner.nextDouble();
        shapes.add(new Point(x, y));
        System.out.println("Đã thêm điểm.");
    }

    private static void addLine() {
        System.out.print("Nhập x1: "); double x1 = scanner.nextDouble();
        System.out.print("Nhập y1: "); double y1 = scanner.nextDouble();
        System.out.print("Nhập x2: "); double x2 = scanner.nextDouble();
        System.out.print("Nhập y2: "); double y2 = scanner.nextDouble();
        shapes.add(new Line(x1, y1, x2, y2));
        System.out.println("Đã thêm đoạn thẳng.");
    }

    private static void addCircle() {
        System.out.print("Nhập x tâm: "); double x = scanner.nextDouble();
        System.out.print("Nhập y tâm: "); double y = scanner.nextDouble();
        System.out.print("Nhập bán kính: "); double r = scanner.nextDouble();
        shapes.add(new Circle(x, y, r));
        System.out.println("Đã thêm hình tròn.");
    }

    private static void addRectangle() {
        System.out.print("Nhập x góc trên trái: "); double x = scanner.nextDouble();
        System.out.print("Nhập y góc trên trái: "); double y = scanner.nextDouble();
        System.out.print("Nhập chiều rộng: "); double w = scanner.nextDouble();
        System.out.print("Nhập chiều cao: "); double h = scanner.nextDouble();
        shapes.add(new Rectangle(x, y, w, h));
        System.out.println("Đã thêm hình chữ nhật.");
    }

    private static void addTriangle() {
        System.out.println("Nhập tọa độ 3 đỉnh:");
        System.out.print("P1(x,y): "); double x1 = scanner.nextDouble(); double y1 = scanner.nextDouble();
        System.out.print("P2(x,y): "); double x2 = scanner.nextDouble(); double y2 = scanner.nextDouble();
        System.out.print("P3(x,y): "); double x3 = scanner.nextDouble(); double y3 = scanner.nextDouble();
        shapes.add(new Triangle(new Point(x1,y1), new Point(x2,y2), new Point(x3,y3)));
        System.out.println("Đã thêm hình tam giác.");
    }

    private static void displayShapes() {
        if (shapes.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        System.out.println("--- Danh sách các hình ---");
        for (int i = 0; i < shapes.size(); i++) {
            System.out.println((i + 1) + ". " + shapes.get(i).toString());
        }
    }

    private static void calculateTotals() {
        double totalArea = 0;
        double totalPerimeter = 0;
        for (Shape s : shapes) {
            totalArea += s.area();
            totalPerimeter += s.perimeter();
        }
        System.out.printf("Tổng diện tích: %.2f\n", totalArea);
        System.out.printf("Tổng chu vi: %.2f\n", totalPerimeter);
    }

    private static void findMinMaxArea() {
        if (shapes.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        Shape maxShape = shapes.get(0);
        Shape minShape = shapes.get(0);
        for (Shape s : shapes) {
            if (s.area() > maxShape.area()) maxShape = s;
            if (s.area() < minShape.area()) minShape = s;
        }
        System.out.println("Hình có diện tích lớn nhất: " + maxShape);
        System.out.println("Hình có diện tích nhỏ nhất: " + minShape);
    }

    private static void zoomAll() {
        System.out.print("Nhập tỉ lệ zoom (ratio): ");
        double ratio = scanner.nextDouble();
        for (Shape s : shapes) {
            s.zoom(ratio);
        }
        System.out.println("Đã thực hiện zoom tất cả các hình.");
    }
}