class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
class Rhombus {
    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;

    public Rhombus() {
        
        this(new Point(0, 0), new Point(1, 0), new Point(0, 1), new Point(1, 1));
    }

    public Rhombus(Point p1, Point p2, Point p3, Point p4) {
        
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    private double calculate(Point point1, Point point2) {
        double deltaX = point1.getX() - point2.getX();
        double deltaY = point1.getY() - point2.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    public double getArea() {
        double a = calculate(p1, p2);
        return a * a / 2.0;
    }

    public double getPerimeter() {
        double b = calculate(p1, p2);
        return b * 4.0;
    }

    public boolean contains(double x, double y) {

        double d1 = calculate(new Point(x, y), p1);
        double d2 = calculate(new Point(x, y), p2);
        double d3 = calculate(new Point(x, y), p3);
        double d4 = calculate(new Point(x, y), p4);

        return d1 + d3 == d2 + d4;
    }

    public boolean contains(Rhombus r) {
        // Перевірка, чи інший ромб повністю знаходиться всередині поточного ромба
        return contains(r.p1.getX(), r.p1.getY())
                && contains(r.p2.getX(), r.p2.getY())
                && contains(r.p3.getX(), r.p3.getY())
                && contains(r.p4.getX(), r.p4.getY());
    }
}
enum FoodType {
    ITALIAN("Italian", 25.0),
    CHINESE("Chinese", 20.0),
    MEXICAN("Mexican", 18.0),
    FAST_FOOD("Fast Food", 15.0),
    VEGETARIAN("Vegetarian", 22.0);

    private String typeName;
    private double defaultPrice;


    FoodType(String typeName, double defaultPrice) {
        this.typeName = typeName;
        this.defaultPrice = defaultPrice;
    }


    public String getTypeName() {
        return typeName;
    }


    public double getDefaultPrice() {
        return defaultPrice;
    }
}


public class Main {
    public static void main(String[] args) {
        Point point1 = new Point(1.0, 2.0);
        Point point2 = new Point(3.0, 4.0);
        Point point3 = new Point(5.0, 6.0);

        Rhombus rhombus1 = new Rhombus(point1, point2, point3, new Point(7.0, 8.0));
        Rhombus rhombus2 = new Rhombus(new Point(0.0, 0.0), new Point(2.0, 0.0), new Point(1.0, 1.0), new Point(3.0, 1.0));


        double totalArea = calculateTotalArea(rhombus1, rhombus2);

        System.out.println("Total Area of Rhombi: " + totalArea);
        //Завд 4
        FoodType[] foodTypes = FoodType.values();


        for (FoodType foodType : foodTypes) {
            System.out.println("Food Type: " + foodType.getTypeName());
            System.out.println("Default Price: " + foodType.getDefaultPrice());
            System.out.println("-------------");
        }
    }

    public static double calculateTotalArea(Rhombus... rhombi) {
        double total = 0.0;

        for (Rhombus rhombus : rhombi) {
            total += rhombus.getArea();
        }

        return total;
    }
}
