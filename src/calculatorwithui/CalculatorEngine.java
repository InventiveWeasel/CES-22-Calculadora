package calculatorwithui;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author Gabriel Brito
 */
public class CalculatorEngine {
    private final int HEIGHT = 640;
    private final int WIDTH = 480;
    
    private JFrame frame;
    private JPanel fPane;
    private JTextField display;
    
    private JPanel buttonRow1;
    private JButton clear;
    private JButton moreLess;
    private JButton perc;
    private JButton div;
    
    private JPanel buttonRow2;
    private JButton seven;
    private JButton eight;
    private JButton nine;
    private JButton mult;
    
    private JPanel buttonRow3;
    private JButton four;
    private JButton five;
    private JButton six;
    private JButton minus;
    
    private JPanel buttonRow4;
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton plus;
    
    private JPanel buttonRow5;
    private JButton zero;
    private JButton comma;
    private JButton equal;
    private GridBagConstraints c;
    
    CalculatorEngine(){
        frame = new JFrame("Calculadora do BIZU");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        
        fPane = new JPanel();
        fPane.setLayout(new BoxLayout(fPane, BoxLayout.PAGE_AXIS));
        frame.add(fPane);
        
        display = new JTextField(30);
        display.setText("0.0");
        //display.setSize(WIDTH, HEIGHT/5);
        display.setEditable(false);
        fPane.add(display);
        
        buttonRow1 = new JPanel();
        //buttonRow1.setLayout(new BoxLayout(buttonRow1, BoxLayout.LINE_AXIS));
        buttonRow1.setLayout(new GridLayout(1,0));
        clear = new JButton("clear");
        moreLess = new JButton("moreLess");
        perc = new JButton("perc");
        div = new JButton("div");
        buttonRow1.add(clear);
        buttonRow1.add(moreLess);
        buttonRow1.add(perc);
        buttonRow1.add(div);
        fPane.add(buttonRow1);
        
        buttonRow2 = new JPanel();
        //buttonRow1.setLayout(new BoxLayout(buttonRow1, BoxLayout.LINE_AXIS));
        buttonRow2.setLayout(new GridLayout(1,0));
        seven = new JButton("seven");
        eight = new JButton("eight");
        nine = new JButton("nine");
        mult = new JButton("mult");
        buttonRow2.add(seven);
        buttonRow2.add(eight);
        buttonRow2.add(nine);
        buttonRow2.add(mult);
        fPane.add(buttonRow2);
        
        buttonRow3 = new JPanel();
        //buttonRow1.setLayout(new BoxLayout(buttonRow1, BoxLayout.LINE_AXIS));
        buttonRow3.setLayout(new GridLayout(1,0));
        four = new JButton("four");
        five = new JButton("five");
        six = new JButton("six");
        minus = new JButton("minus");
        buttonRow3.add(four);
        buttonRow3.add(five);
        buttonRow3.add(six);
        buttonRow3.add(minus);
        fPane.add(buttonRow3);
        
        buttonRow4 = new JPanel();
        //buttonRow1.setLayout(new BoxLayout(buttonRow1, BoxLayout.LINE_AXIS));
        buttonRow4.setLayout(new GridLayout(1,0));
        one = new JButton("one");
        two = new JButton("two");
        three = new JButton("three");
        plus = new JButton("plus");
        buttonRow4.add(one);
        buttonRow4.add(two);
        buttonRow4.add(three);
        buttonRow4.add(plus);
        fPane.add(buttonRow4);
        
        buttonRow5 = new JPanel();
        //buttonRow1.setLayout(new BoxLayout(buttonRow1, BoxLayout.LINE_AXIS));
        buttonRow5.setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        zero = new JButton("zero");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        buttonRow5.add(zero, c);
        comma = new JButton("comma");
        c.gridx = 1;
        buttonRow5.add(comma, c);
        equal = new JButton("equal");
        c.gridwidth = 2;
        c.gridx = 2;
        buttonRow5.add(equal, c);
        fPane.add(buttonRow5);
        
        frame.setVisible(true);
    }
}
