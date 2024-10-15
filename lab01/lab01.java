public class lab01 {
    public static void draw_line(double x1, double y1, double x2, double y2){
        double l = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
        int points = (int) l*100;
        double stepX = (x2-x1)/points;
        double stepY = (y2-y1)/points;

        double x = x1; double y = y1;
        for (int i = 0; i < points; i++){
            x+=stepX;
            y+=stepY;
            System.out.println(x+" "+y);
        }
        System.out.println(x2+" "+y2);
    }

    public static void draw_circle(double x, double y, double r){
        for (int i = 0; i < 360; i++){
            double x1 = x + Math.cos(i*Math.PI/180)*r;
            double y1 = y + Math.sin(i*Math.PI/180)*r;
            System.out.println(x1+" "+y1);
        }
    }

    public static void main(String[] args) {
        draw_line(28,65,28,84);
        draw_line(28,84,34,83);
        draw_line(34,83,38,79);
        draw_line(38,79,37,76);
        draw_line(37,76,34,73);
        draw_line(28,72,37,76);
        draw_line(58,25,53,23);
        draw_line(53,23,47,23);
        draw_line(47,23,44,25);
        draw_line(74,65,63,65);
        draw_line(63,65,73,74);
        draw_line(73,74,73,79);
        draw_line(73,79,70,82);
        draw_line(70,82,66,82);
        draw_line(66,82,63,80);
        draw_circle(50,74,9);
        draw_circle(50,29,14);
        draw_circle(55,34,2);
        draw_circle(46,34,2);
    }
}