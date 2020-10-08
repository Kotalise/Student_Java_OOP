public class Lab1 {
    public static void main(String[] args) {
        Point3d[] points = new Point3d[3];
        for (int i = 0; i < args.length; i = i + 3){
            double x = Double.parseDouble(args[i]);
            double y = Double.parseDouble(args[i+1]);
            double z = Double.parseDouble(args[i+2]);
            points[i / 3] = new Point3d(x, y, z);
        }
        if ( (points[0].equals(points[1])) | (points[0].equals(points[2])) | (points[1].equals(points[2])) ){
            System.out.println("Some points are equal, there's no triangle");
        }
        else{
            System.out.printf("Area of triangle: %.2f \n", computeArea(points[0], points[1], points[2]));
        }

    }
    public static double computeArea(Point3d first, Point3d second, Point3d third) {
        // Возвращение треугольника
        double a = first.distanseTo(second);
        double b = first.distanseTo(third);
        double c = second.distanseTo(third);
        double p = (a + b + c) / 2.0;
        double s = p * (p - a) * (p - b) * (p - c);
        return Math.sqrt(s);
    }

}