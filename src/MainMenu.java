import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

    private JButton requestCreator = new JButton("REQUEST CREATOR");
    private JPanel menuPanel = new JPanel();

    public MainMenu()
    {
        super("MENU");
        int szerokoscEkranu = Toolkit.getDefaultToolkit().getScreenSize().width;
        int wysokoscEkranu = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize(szerokoscEkranu / 8, wysokoscEkranu / 2);
        int szerokoscRamki = this.getSize().width;
        int wysokoscRamki = this.getSize().height;
        this.setLocation((szerokoscEkranu - szerokoscRamki) / 2, (wysokoscEkranu - wysokoscRamki) / 2);
        initComponents();
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void initComponents()
    {
        Container cont = getContentPane();
        cont.setLayout(new GridBagLayout());
        add(menuPanel);

        GroupLayout layout = new GroupLayout(menuPanel);
        menuPanel.setLayout(layout);

        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
        .addComponent(requestCreator, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
        .addComponent(requestCreator, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        requestCreator.addActionListener(new Program());

    }

    private class Program implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            new Ramka();
        }
    }
}