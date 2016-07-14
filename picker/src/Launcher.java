import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by xirtam on 16/4/2.
 */
public class Launcher extends JFrame implements MouseListener {
    private final TextArea textArea, textAreaOut;
    private int h = 600, w = 800, bottom = 100;

    public Launcher() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(200, 80, w, h);
        this.setLayout(null);
        this.setTitle("中文字符拾取器by:xirtam.zhang@gmail.com");

        textArea = new TextArea();
        textArea.setBounds(10, 10, w - 20, (h - bottom) / 2 - 20);
        textAreaOut = new TextArea();
        textAreaOut.setBounds(10, (h - bottom) / 2 + 10, w - 20, (h - bottom) / 2 - 50);
        JButton button = new JButton("处理");
        button.setBounds(50, h - 110, 100, 50);
        button.addMouseListener(this);
        this.add(textArea);
        this.add(textAreaOut);
        this.add(button);
    }

    public static void main(String[] args) {
        new Launcher().setVisible(true);
    }

    public String pick(String str) {
        String rex = "[^\\一-\\龥]+";
        return str.replaceAll(rex, "");
    }

    public void convert() {
        textAreaOut.setText(delete(pick(textArea.getText())));
    }

    private String delete(String str) {
        char[] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        TreeSet<String> result = new TreeSet<String>();
        for (char c : chars) {
            result.add("" + c);
        }
        for (String string : result) {
            sb.append(string);
        }
        return sb.toString();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        convert();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
