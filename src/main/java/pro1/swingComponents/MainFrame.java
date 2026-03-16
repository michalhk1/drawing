package pro1.swingComponents;

import pro1.drawingModel.*;
import pro1.drawingModel.Rectangle;
import pro1.utils.ColorUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class MainFrame extends JFrame {
    DisplayPanel displayPanel;
    private int _lastX = 0;
    private int _lastY = 0;
    private String _color;


    public MainFrame() {
        _color = "#000000";

        this.setTitle("PRO1 Drawing");
        this.setVisible(true);
        this.setSize(800, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.displayPanel = new DisplayPanel();
        this.add(this.displayPanel, BorderLayout.CENTER);

        OptionsPanel leftPanel = new OptionsPanel(this);
        leftPanel.setPreferredSize(new Dimension(200, 0));
        this.add(leftPanel, BorderLayout.WEST);

        this.displayPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                _lastX = e.getX();
                _lastY = e.getY();
                showExample();
            }
        });
    }

    private Drawable example() {
        var d1 = new Ellipse(0, 0, 150, 250, _color);
        var d2 = new Text(0, 0, _color);
        var d3 = new Line(0, 50,170,170,3, _color);
        return new Group(new Drawable[]{d1, d2, d3}, _lastX, _lastY, 40, 1, 1);
    }

    public void showExample(){
        displayPanel.setDrawable(example());
    }

    public void setColor(String color){
        _color = color;
    }
}