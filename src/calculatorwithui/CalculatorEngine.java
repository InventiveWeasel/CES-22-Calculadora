package calculatorwithui;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Gabriel Brito
 */
public class CalculatorEngine implements ActionListener{
    private final int HEIGHT = 220;
    private final int WIDTH = 240;
    
    private double keep;
    private double value;
    private char toDo;
    private boolean result;
    private boolean hasComma;
    private int commaCounter;
    
    
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
        keep = 0;
        value = 0;
        result = false;
        hasComma = false;
        commaCounter = 0;
        
        frame = new JFrame("Calculadora do BIZU");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        
        fPane = new JPanel();
        fPane.setLayout(new BoxLayout(fPane, BoxLayout.PAGE_AXIS));
        frame.add(fPane);
        
        display = new JTextField(30);
        display.setText("0.0");
        Font font = new Font("Courier", Font.BOLD,30);
        //display.setSize(WIDTH, HEIGHT/5);
        display.setFont(font);
        display.setEditable(false);
        fPane.add(display);
        
        buttonRow1 = new JPanel();
        //buttonRow1.setLayout(new BoxLayout(buttonRow1, BoxLayout.LINE_AXIS));
        buttonRow1.setLayout(new GridLayout(1,0));
        clear = new JButton("clear");
        moreLess = new JButton("moreLess");
        perc = new JButton("perc");
        div = new JButton("div");
        clear.setText("C");
        moreLess.setText("\u00b1");
        perc.setText("\u0025");
        div.setText("\u00f7");
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
        seven.setText("7");
        eight.setText("8");
        nine.setText("9");
        mult.setText("\u00d7");
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
        four.setText("4");
        five.setText("5");
        six.setText("6");
        minus.setText("\u2212");
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
        one.setText("1");
        two.setText("2");
        three.setText("3");
        plus.setText("\u002b");
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
        c.fill = GridBagConstraints.BOTH;
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
        zero.setText("0");
        comma.setText(",");
        equal.setText("\u003d");
        fPane.add(buttonRow5);
        
        frame.setVisible(true);
    }
    
    public void initialize(){
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        zero.addActionListener(this);
        
        mult.addActionListener(this);
        minus.addActionListener(this);
        plus.addActionListener(this);
        div.addActionListener(this);
        equal.addActionListener(this);
        
        moreLess.addActionListener(this);
        comma.addActionListener(this);
        clear.addActionListener(this);
        perc.addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == one){
            if(result){
                value = 0;
                result = false;
                hasComma = false;
                commaCounter = 0;
            }
            if(hasComma){
                value = value + Math.pow(10, -commaCounter)*1;
                commaCounter++;
            }
            else
                value = 10*value + 1;
            display.setText(String.format("%g", value));
        }
        else if(event.getSource() == two){
            if(result){
                value = 0;
                result = false;
                hasComma = false;commaCounter = 0;
            }
            if(hasComma){
                value = value + Math.pow(10, -commaCounter)*2;
                commaCounter++;
            }
            else
                value = 10*value + 2;
            display.setText(String.format("%g", value));
        }
        else if(event.getSource() == three){
            if(result){
                value = 0;
                result = false;
                hasComma = false;
                commaCounter = 0;
            }
            if(hasComma){
                value = value + Math.pow(10, -commaCounter)*3;
                commaCounter++;
            }
            else
                value = 10*value + 3;
            display.setText(String.format("%g", value));
        }
        else if(event.getSource() == four){
            if(result){
                value = 0;
                result = false;
                hasComma = false;
                commaCounter = 0;
            }
            if(hasComma){
                value = value + Math.pow(10, -commaCounter)*4;
                commaCounter++;
            }
            else
                value = 10*value + 4;
            display.setText(String.format("%g", value));
        }
        else if(event.getSource() == five){
            if(result){
                value = 0;
                result = false;
                hasComma = false;
                commaCounter = 0;
            }
            if(hasComma){
                value = value + Math.pow(10, -commaCounter)*5;
                commaCounter++;
            }
            else
                value = 10*value + 5;
            display.setText(String.format("%g", value));
        }
        else if(event.getSource() == six){
            if(result){
                value = 0;
                result = false;
                hasComma = false;
                commaCounter = 0;
            }
            if(hasComma){
                value = value + Math.pow(10, -commaCounter)*6;
                commaCounter++;
            }
            else
                value = 10*value + 6;
            display.setText(String.format("%g", value));
        }
        else if(event.getSource() == seven){
            if(result){
                value = 0;
                result = false;
                hasComma = false;
                commaCounter = 0;
            }
            if(hasComma){
                value = value + Math.pow(10, -commaCounter)*7;
                commaCounter++;
            }
            else
                value = 10*value + 7;
            display.setText(String.format("%g", value));
        }
        else if(event.getSource() == eight){
            if(result){
                value = 0;
                result = false;
                hasComma = false;
                commaCounter = 0;
            }
            if(hasComma){
                value = value + Math.pow(10, -commaCounter)*8;
                commaCounter++;
            }
            else
                value = 10*value + 8;
            display.setText(String.format("%g", value));
        }
        else if(event.getSource() == nine){
            if(result){
                value = 0;
                result = false;
                hasComma = false;
                commaCounter = 0;
            }
            if(hasComma){
                value = value + Math.pow(10, -commaCounter)*9;
                commaCounter++;
            }
            else
                value = 10*value + 9;
            display.setText(String.format("%g", value));
        }
        else if(event.getSource() == zero){
            if(result){
                value = 0;
                result = false;
                hasComma = false;
                commaCounter = 0;
            }
            if(hasComma){
                value = value + Math.pow(10, -commaCounter)*0;
                commaCounter++;
            }
            else
                value = 10*value;
            display.setText(String.format("%g", value));
        }
        
        else if(event.getSource() == plus){
            keep = value;
            value = 0;
            commaCounter = 0;
            display.setText("0,0");
            toDo = '+';
        }
        else if(event.getSource() == minus){
            keep = value;
            value = 0;
            commaCounter = 0;
            display.setText("0,0");
            toDo = '-';
        }
        else if(event.getSource() == mult){
            keep = value;
            value = 0;
            commaCounter = 0;
            display.setText("0,0");
            toDo = '*';
        }
        else if(event.getSource() == div){
            keep = value;
            value = 0;
            commaCounter = 0;
            display.setText("0,0");
            toDo = '/';
        }
        
        else if(event.getSource() == equal){
            switch(toDo){
                case '+':
                    value = value+keep;
                    break;
                case '-':
                    value = keep-value;
                    break;
                case '*':
                    value = value*keep;
                    break;
                case '/':
                    value = keep/value;
                    break;
            }
            display.setText(String.format("%g", value));
            result = true;
        }
        
        else if(event.getSource() == moreLess){
            value = -value;
            display.setText(String.format("%g", value));
        }
        
        else if(event.getSource() == comma){
            hasComma = true;
            commaCounter = 1;
        }
        
        else if(event.getSource()==perc){
            value = value/100;
            display.setText(String.format("%g", value));
            System.out.println(value);
        }
        
        else if(event.getSource() == clear){
            value = 0;
            keep = 0;
            commaCounter = 0;
            display.setText("0,0");
        }
    }
    
}
