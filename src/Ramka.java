import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ramka extends JFrame
{
    private final Ramka THIS_WINDOW = this;
    private JComboBox screenAppearance = new JComboBox();
    private JTextArea requestText = new JTextArea();
    private JScrollPane suwak = new JScrollPane(requestText);
    private JButton button_one = new JButton("WYGENERUJ REQUEST");
    private JLabel request = new JLabel("Request z Kibany: ");
    private JLabel etykieta = new JLabel("Godzina: ");
    private JLabel repo = new JLabel("Repozytorium: ");
    private JLabel templateID = new JLabel("TemplateID: ");
    private JLabel name = new JLabel("Nazwa PDF: ");
    private JLabel ver = new JLabel("Wersja: ");
    private JLabel env = new JLabel("Środowisko: ");
    private JLabel choice = new JLabel("Wygląd okna: ");
    private JLabel czas = new JLabel(pobierzCzas());

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
        this.setDefaultCloseOperation(0);
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

        this.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowOpened(WindowEvent e)
            {
                JOptionPane.showMessageDialog(rootPane,"Witaj w programie do tworzenia requestów xml");
            }

            @Override
            public void windowClosing(WindowEvent e)
            {
                int option = JOptionPane.showConfirmDialog(rootPane, "Czy na pewno chcesz zakończyć działanie programu?", "Potrzebne potwierdzenie", JOptionPane.YES_NO_OPTION);
                if (option == 0)
                    THIS_WINDOW.dispose();
            }
        });

        ActionListener stoper = new Zegar();

        screenAppearance.setModel(new DefaultComboBoxModel(new String [] {"Metal", "Windows", "Motif"}));
        screenAppearance.addActionListener(e -> choiceHandler(e));

        Timer zegar = new Timer(1000, stoper);

        zegar.start();

        layout.setHorizontalGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(choice).addComponent(request).addComponent(etykieta).addComponent(templateID).addComponent(repo).addComponent(name).addComponent(ver).addComponent(env))
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(screenAppearance).addComponent(suwak).addComponent(czas))
        .addComponent(button_one)
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(choice).addComponent(screenAppearance))
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(request).addComponent(suwak))
        .addComponent(templateID)
        .addComponent(repo)
        .addComponent(name)
        .addComponent(ver)
        .addComponent(env)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(etykieta).addComponent(czas))
        .addComponent(button_one)
        );

        button_one.addActionListener(new WygenerujRequest());
    }

    private void choiceHandler(ActionEvent evt)
    {
        String interfaceName = "";

        if (((JComboBox)evt.getSource()).getSelectedItem().equals("Metal"))
            interfaceName = "javax.swing.plaf.metal.MetalLookAndFeel";
        else if (((JComboBox)evt.getSource()).getSelectedItem().equals("Motif"))
            interfaceName = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
        else if (((JComboBox)evt.getSource()).getSelectedItem().equals("Windows"))
            interfaceName = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

        try
        {
            UIManager.setLookAndFeel(interfaceName);
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException e)
        {
            e.printStackTrace();
        }
    }

    private class WygenerujRequest implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            int opcja = JOptionPane.showConfirmDialog(rootPane, "Czy chcesz wygenerować request?", "Potrzebne potwierdzenie", JOptionPane.YES_NO_OPTION);
            if (opcja == 0)
                System.out.println("WYGENEROWANO REQUEST");
        }
    }

    private class Zegar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            czas.setText(pobierzCzas());
        }
    }

    public String pobierzCzas()
    {
        GregorianCalendar calendar = new GregorianCalendar();

        String hour = "" + calendar.get(Calendar.HOUR_OF_DAY);
        String minute = "" + calendar.get(Calendar.MINUTE);
        String sec = "" + calendar.get(Calendar.SECOND);

        if (Integer.parseInt(hour) < 10)
        {
            hour = "0" + hour;
        }
        if (Integer.parseInt(minute) < 10)
        {
            minute = "0" + minute;
        }
        if (Integer.parseInt(sec) < 10)
        {
            sec = "0" + sec;
        }
        return hour + ":" + minute + ":" + sec;
    }
}
