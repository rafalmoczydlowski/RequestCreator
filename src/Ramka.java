import javax.swing.*;
import java.awt.*;

public class Ramka extends JFrame
{
    public Ramka()
    {
        super("REQUEST CREATOR");
        int szerokoscEkranu = Toolkit.getDefaultToolkit().getScreenSize().width;
        int wysokoscEkranu = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize(szerokoscEkranu/2, wysokoscEkranu/2);
        int szerokoscRamki = this.getSize().width;
        int wysokoscRamki = this.getSize().height;
        this.setLocation((szerokoscEkranu-szerokoscRamki)/2, (wysokoscEkranu-wysokoscRamki)/2);
        initComponents();
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setVisible(true);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.jpg"));
    }

    public void initComponents()
    {
        GroupLayout layout = new GroupLayout(getContentPane());
        this.getContentPane().setLayout(layout);

        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup().addContainerGap(10,Short.MAX_VALUE).addComponent(button_one)
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup().addContainerGap(10, Short.MAX_VALUE).addComponent(button_one)
        );

    }
    JButton button_one = new JButton("WYGENERUJ REQUEST");
}
