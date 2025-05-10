import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GesdiNamber extends JFrame implements ActionListener{

    Font font = new Font("Comic Sans MS", Font.BOLD, 30);
    Font font1 = new Font("Comic Sans MS", Font.BOLD, 128);
    Random random = new Random();

    JTextArea textarea1;
    JLabel label1;
    JButton button1;
    JLabel label2;
    JButton button2;
    JButton button3;
    JLabel label3;
    JLabel label4;
    JLabel label5;

    int numbertoguess = random.nextInt(1,101);
    int wins = 0;
    boolean submitenabled = true;
    int guesstook = 0;


    GesdiNamber(){

        label1 = new JLabel("Enter your number here");
        label1.setForeground(Color.white);
        label1.setBounds(100,25,400,50);
        label1.setFont(font);

        textarea1 = new JTextArea();
        textarea1.setEditable(true);
        textarea1.setBounds(100,75,400,50);
        textarea1.setFont(font);

        button1 = new JButton("Submit");
        button1.setFont(font);
        button1.setBounds(100,150,400,50);
        button1.addActionListener(this);

        label2 = new JLabel("Take a guess!");
        label2.setFont(font);
        label2.setBounds(100,225,500,50);
        label2.setForeground(Color.white);

        button2 = new JButton("Reveal number");
        button2.setFont(font);
        button2.setBounds(100,575,400,50);
        button2.addActionListener(this);

        button3 = new JButton("Reset number");
        button3.setFont(font);
        button3.setBounds(100,650,400,50);
        button3.addActionListener(this);

        label3 = new JLabel("Previous guess:");
        label3.setFont(font);
        label3.setBounds(100,295,400,50);
        label3.setForeground(Color.ORANGE);

        label4 = new JLabel("");
        label4.setFont(font1);
        label4.setBounds(100,300,400,250);
        label4.setForeground(Color.MAGENTA);

        label5 = new JLabel("Guessed: "+wins);
        label5.setFont(font);
        label5.setForeground(Color.PINK);
        label5.setBounds(100,700,400,50);



        this.setSize(600,800);
        this.setTitle("ges di namber");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(20,20,20));
        this.setVisible(true);
        this.setResizable(false);

        this.add(label1);
        this.add(textarea1);
        this.add(button1);
        this.add(label2);
        this.add(button2);
        this.add(button3);
        this.add(label3);
        this.add(label4);
        this.add(label5);


    }

    @Override
    public void actionPerformed(ActionEvent e){


        if (e.getSource()==button1) {
            try{
            String userguess = textarea1.getText();

            int userguessint = Integer.parseInt(userguess);

            if (userguessint > 100 || userguessint < 1){

                label2.setText("1-100 only!");
                label2.setForeground(Color.CYAN);
                guesstook += 1;
                textarea1.setText("");

                }

            else if (userguessint > numbertoguess) {
                label2.setText("Lower!");
                label2.setForeground(Color.RED);
                label4.setText(String.valueOf(userguessint));
                guesstook += 1;
                textarea1.setText("");
            } else if (userguessint < numbertoguess) {
                label2.setText("Higher!");
                label2.setForeground(Color.GREEN);
                label4.setText(String.valueOf(userguessint));
                guesstook += 1;
                textarea1.setText("");
            } else {

                label2.setForeground(Color.YELLOW);
                label3.setText("The number is:");
                label4.setText(String.valueOf(userguessint));
                wins += 1;
                label5.setText("Guessed: "+wins);
                button1.setEnabled(false);
                submitenabled = false;
                guesstook += 1;
                label2.setText("It took you "+guesstook+" guesses!");
                textarea1.setText("You guessed it!");
                textarea1.setEditable(false);


            }

        }catch (Exception i){

                label2.setText("Please enter a valid number!");
                label2.setForeground(Color.BLUE);
            }
        }
        else if (e.getSource()==button2) {
            label2.setText("The number is: "+numbertoguess);
            label2.setForeground(Color.GREEN);
        }

        else if (e.getSource()==button3) {
            numbertoguess = random.nextInt(1,101);
            label2.setText("Take a guess!");
            label2.setForeground(Color.white);
            label3.setText("Previous guess:");
            label4.setText("");
            if (submitenabled == false){
                submitenabled = true;
                button1.setEnabled(true);
                button1.setText("Submit");
                textarea1.setEditable(true);
                textarea1.setText("");
                guesstook = 0;
            }
            else{
                label2.setText("Can't reset yet!");
            }
        }

    }

    public static void main(String[] args) {
        new GesdiNamber();
    }


}
