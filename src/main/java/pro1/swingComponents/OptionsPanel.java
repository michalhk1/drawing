package pro1.swingComponents;

import pro1.utils.ColorUtils;

import javax.swing.*;

public class OptionsPanel extends JPanel {

    private final MainFrame _mainFrame;

    private JButton _colorButton;

    private JSlider _rSlider;
    private JSlider _gSlider;
    private JSlider _bSlider;

    public OptionsPanel(MainFrame mainFrame) {

        _mainFrame = mainFrame;

        _colorButton = new JButton("New Color");
        add(_colorButton);
        _colorButton.addActionListener(
                (e) -> {
                    mainFrame.setColor(ColorUtils.randomColor());
                    mainFrame.showExample();
                }
        );

        _rSlider = new JSlider(0, 255, 0);
        add(_rSlider);
        _gSlider = new JSlider(0, 255, 0);
        add(_gSlider);
        _bSlider = new JSlider(0, 255, 0);
        add(_bSlider);

        _rSlider.addChangeListener(
                (e) ->{
                    sliderChanged();
                }
        );
        _bSlider.addChangeListener(
                (e) ->{
                    sliderChanged();
                }
        );
        _gSlider.addChangeListener(
                (e) ->{
                    sliderChanged();
                }
        );

    }

    private void sliderChanged(){
        _mainFrame.setColor(ColorUtils.color(_rSlider.getValue(), _gSlider.getValue(), _bSlider.getValue()));

        _mainFrame.showExample();
    }
}
