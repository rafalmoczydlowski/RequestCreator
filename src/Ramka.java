import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

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

        ActionListener stoper = new Zegar();

        Timer zegar = new Timer(1000, stoper);

        zegar.start();

        layout.setHorizontalGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(request).addComponent(etykieta).addComponent(templateID).addComponent(repo).addComponent(name).addComponent(ver).addComponent(env))
        .addComponent(czas)
        .addComponent(button_one)
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
        .addComponent(request)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(etykieta).addComponent(czas))
        .addComponent(templateID)
        .addComponent(repo)
        .addComponent(name)
        .addComponent(ver)
        .addComponent(env)
        .addComponent(button_one)
        );

        button_one.addActionListener(new WygenerujRequest());
    }

    private class WygenerujRequest implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("WYGENEROWANO REQUEST");
        }
    }

    JButton button_one = new JButton("WYGENERUJ REQUEST");
    JLabel request = new JLabel("Request z Kibany: ");
    JLabel etykieta = new JLabel("Godzina: ");
    JLabel repo = new JLabel("Repozytorium: ");
    JLabel templateID = new JLabel("TemplateID: ");
    JLabel name = new JLabel("Nazwa PDF: ");
    JLabel ver = new JLabel("Wersja: ");
    JLabel env = new JLabel("Środowisko: ");
    JLabel czas = new JLabel(pobierzCzas());

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
        return hour + " : " + minute + " : " + sec;
    }
}
