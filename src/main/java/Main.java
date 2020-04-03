import javax.swing.*;
import java.awt.*;
import java.util.Collections;

public class Main extends JFrame {
    private static JFrame jFrame;
    private static JPanel jPanel;
    private static JLabel infectedTotal;
    private static JLabel infectedTotalNew;
    private static JLabel active;
    private static JLabel activeNew;
    private static JLabel deaths;
    private static JLabel deathsNew;
    private static JLabel cured;
    private static JLabel curedNew;
    private static JLabel updateDate;
    private static JLabel country;

    public static void main(String[] args) {

        jFrame = new JFrame("COVID-19 MONITOR");

        jPanel = new JPanel(new GridLayout(5, 2));
        jPanel.setBackground(Color.darkGray);
        jPanel.setSize(800,800);

        countryCreate();
        updateDateCreate();
        infectedTotalCreate();
        activeCreate();
        infectedTotalNewCreate();
        activeNewCreate();
        deathsCreate();
        curedCreate();
        deathsNewCreate();
        curedNewCreate();

        jPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));


        jFrame.setVisible(true);
        jFrame.setSize(800, 800);
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.add(jPanel);
        jFrame.pack();
    }

    private static void countryCreate() {
        country=new JLabel("Country: ");
        jPanel.add(country);
        country.setForeground(Color.white);
        setHeightOfFont_LOW(country);


    }

    private static void updateDateCreate() {

        updateDate=new JLabel("Updated: ");
        jPanel.add(updateDate);
        updateDate.setForeground(Color.white);
        setHeightOfFont_LOW(updateDate);

    }

    private static void infectedTotalCreate() {

        infectedTotal=new JLabel("Infected: ");
        jPanel.add(infectedTotal);
        infectedTotal.setForeground(Color.yellow);
        setHeightOfFont_HIGH(infectedTotal);


    }

    private static void activeCreate() {

        active=new JLabel("Active: ");
        jPanel.add(active);
        active.setForeground(Color.orange);
        setHeightOfFont_HIGH(active);

    }

    private static void infectedTotalNewCreate() {

        infectedTotalNew=new JLabel("new infected +");
        jPanel.add(infectedTotalNew);
        infectedTotalNew.setForeground(Color.yellow);
        setHeightOfFont_LOW(infectedTotalNew);


    }

    private static void activeNewCreate() {

        activeNew=new JLabel("active new +");
        jPanel.add(activeNew);
        activeNew.setForeground(Color.orange);
        setHeightOfFont_LOW(activeNew);


    }

    private static void deathsCreate() {

        deaths=new JLabel("Deaths: ");
        jPanel.add(deaths);
        deaths.setForeground(Color.red);
        setHeightOfFont_HIGH(deaths);


    }

    private static void curedCreate() {

        cured=new JLabel("Cured: ");
        jPanel.add(cured);
        cured.setForeground(Color.green);
        setHeightOfFont_HIGH(cured);

    }

    private static void deathsNewCreate() {

        deathsNew= new JLabel("deaths new +");
        jPanel.add(deathsNew);
        deathsNew.setForeground(Color.red);
        setHeightOfFont_LOW(deathsNew);


    }

    private static void curedNewCreate() {

        curedNew = new JLabel("cured new +");
        jPanel.add(curedNew);
        curedNew.setForeground(Color.green);
        setHeightOfFont_LOW(curedNew);


    }

    private static void setHeightOfFont_HIGH(JLabel jLabel) {
        jLabel.setFont(new Font("Helvetica", Font.BOLD, 50));
    }

    private static void setHeightOfFont_LOW(JLabel jLabel) {
        jLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
    }


}
