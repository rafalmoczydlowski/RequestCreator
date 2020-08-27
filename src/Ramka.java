import javax.swing.*;
import java.awt.*;

public class Ramka extends JFrame
{
    int szerokoscRamki;
    int wysokoscRamki;
    JButton button_one;
    public Ramka(int szerokosc, int wysokosc)
    {
        super("REQUEST CREATOR");
        szerokoscRamki = szerokosc;
        wysokoscRamki = wysokosc;
        initComponents();
        int szerokoscEkranu = Toolkit.getDefaultToolkit().getScreenSize().width;
        int wysokoscEkranu = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize(szerokosc, wysokosc);
        szerokoscRamki = this.getSize().width;
        wysokoscRamki = this.getSize().height;
        this.setLocation((int)(szerokoscEkranu - szerokoscRamki)/2, (int)(wysokoscEkranu - wysokoscRamki)/2);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setVisible(true);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.jpg"));
    }

    public void initComponents()
    {
        button_one = new JButton("Wygeneruj request");
        button_one.setSize(button_one.getPreferredSize());
        Container kontener = this.getContentPane();
        kontener.setLayout(null);
        kontener.add(button_one);

        int szerokosc = getSzerokoscRamki();
        int polowaPrzycisku = (int)button_one.getSize().getWidth() / 2;
        System.out.println("Szerokość ramki: " + szerokosc);
        System.out.println("Długość przycisku: " + (int)button_one.getSize().getWidth() + ". Połowa długości przycisku: " + polowaPrzycisku);
        button_one.setLocation(((szerokosc/2) - polowaPrzycisku), getWysokoscRamki() - 100);
        System.out.println("Początek przycisku na osi X: " + button_one.getX());
    }

    public int getSzerokoscRamki()
    {

        return this.szerokoscRamki;
    }

    public int getWysokoscRamki()
    {
        return this.wysokoscRamki;
    }

}
