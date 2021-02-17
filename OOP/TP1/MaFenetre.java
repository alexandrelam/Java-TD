import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class MaFenetre extends JFrame {
    static final int WIDTH = 1100;
    static final int HEIGHT = 800;
    static final int RGB_MIN = 1;
    static final int RGB_MAX = 10;
    static final int RGB_INIT = 4;

    private int red_value = RGB_INIT;
    private int green_value = RGB_INIT;
    private int blue_value = RGB_INIT;

    MaFenetre() {
        super("Mon magnifique TP");
        setSize(WIDTH, HEIGHT);
        ImageGeneree im = new ImageGeneree();

        Container c = this.getContentPane();

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        p1.add(new JLabel("rouge"));
        JSlider red = this.RGB_Slider();
        red.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                red_value = red.getValue();
            }
        });
        p1.add(red);

        p1.add(new JLabel("vert"));
        JSlider green = this.RGB_Slider();
        green.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                green_value = green.getValue();
            }
        });
        p1.add(green);

        p1.add(new JLabel("bleu"));
        JSlider blue = this.RGB_Slider();
        blue.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                blue_value = blue.getValue();
            }
        });
        p1.add(blue);

        c.add(im);

        Button generer = new Button("Generer");
        generer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                im.contruitImage(WIDTH, HEIGHT, red_value, green_value, blue_value);
                repaint();
            }
        });
        p2.add(generer);

        Button sauvegarder = new Button("Sauvegarder");
        sauvegarder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                im.save();
            }
        });
        p2.add(sauvegarder);

        Button quit = new Button("quit");
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        p2.add(quit);

        c.add(p1, BorderLayout.NORTH);
        c.add(p2, BorderLayout.SOUTH);

        setVisible(true);
    }

    public JSlider RGB_Slider() {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, RGB_MIN, RGB_MAX, RGB_INIT);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setLabelTable(slider.createStandardLabels(1));
        return slider;
    }

    public static void main(String[] args) {
        MaFenetre w = new MaFenetre();
    }
}