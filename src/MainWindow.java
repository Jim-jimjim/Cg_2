import javax.swing.*;

public class MainWindow extends JFrame {
    private JPanel panel1;
    private JPanel Draw;
    private JTextField x0;
    private JTextField y0;
    private JTextField grad;
    private JTextField mas;
    private JTextField rY;
    private JTextField rX;
    private JTextField pX;
    private JTextField pY;
    private JCheckBox target;
    private JCheckBox rotate;
    private JCheckBox mash;
    private JCheckBox rXCB;
    private JCheckBox pXCB;
    private JButton trans;
    private JButton resetButton;

    public MainWindow() {
//        JFrame frame = new JFrame("MainWindow");
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        trans.addActionListener(e -> {
            if (target.isSelected()) {
                ((DrawPanel)Draw).tt(Double.parseDouble(x0.getText()), Double.parseDouble(y0.getText()));
            }
            if (rotate.isSelected()) {
                ((DrawPanel)Draw).rotate(Double.parseDouble(grad.getText()));
            }
            if (mash.isSelected()) {
                ((DrawPanel)Draw).mas(Double.parseDouble(mas.getText()));
            }
            if (pXCB.isSelected()) {
                ((DrawPanel)Draw).perm(Double.parseDouble(pX.getText()), Double.parseDouble(pY.getText()));
            }
            if (rXCB.isSelected()) {
                ((DrawPanel)Draw).ras(Double.parseDouble(rX.getText()), Double.parseDouble(rY.getText()));
            }
            Draw.repaint();
        });
        resetButton.addActionListener(e -> {
            ((DrawPanel)Draw).triangle = new Triangle();
            Draw.repaint();
        });
    }

    private void createUIComponents() {
        Draw = new DrawPanel();
    }
}
