import java.util.Random;

import javax.swing.JComponent;
import java.awt.image.*;
import java.awt.*;

public class ImageGeneree extends JComponent {
    Random graine = new Random();
    Expr exp_r;
    Expr exp_g;
    Expr exp_b;

    int width;
    int height;

    RenderedImage final_img;

    public ImageGeneree() {
        width = 650;
        height = 600;
    }

    public ImageGeneree(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Expr random_expr(int level) {
        if (level == 0) {
            if (graine.nextBoolean()) {
                return new X();
            } else {
                return new Y();
            }
        } else {
            Expr e;
            int rdn_int = graine.nextInt(4);
            System.out.print(rdn_int + " ");
            switch (rdn_int) {
                case 0:
                    e = new Sin(random_expr(level - 1));
                    break;
                case 1:
                    e = new Cos(random_expr(level - 1));
                    break;
                case 2:
                    e = new Moyenne(random_expr(level - 1), random_expr(level - 1));
                    break;
                case 3:
                    e = new Mult(random_expr(level - 1), random_expr(level - 1));
                    break;
                default:
                    e = new Expr();
                    break;
            }
            return e;
        }
    }

    public double scale(double x, int size) {
        return x / size;
    }

    public double get_color(double eval) {
        if (eval >= 1) {
            System.out.println(eval);
        }
        return (255 / 2) + ((255 / 2) * eval);
    }

    public void contruitImage(int width, int height) {
        ImageGeneree im = new ImageGeneree();
        Expr monExp = im.random_expr(6);
        BufferedImage buff = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int r = (int) im.get_color(monExp.eval(im.scale(i, width), im.scale(j, height)));
                int g = (int) im.get_color(monExp.eval(im.scale(i, width), im.scale(j, height)));
                int b = (int) im.get_color(monExp.eval(im.scale(i, width), im.scale(j, height)));
                buff.setRGB(i, j, (new Color(r, g, b)).getRGB());
            }
            this.final_img = buff;
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawRenderedImage(final_img, null);
    }

    public static void main(String[] args) {
        ImageGeneree im = new ImageGeneree();
        Expr monExp = im.random_expr(2);
        System.out.println(monExp);
        System.out.println(monExp.eval(3, 5));
    }

}
