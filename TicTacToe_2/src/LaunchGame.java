import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class LaunchGame implements ActionListener {

        JFrame frame=new JFrame();
        JLabel label=new  JLabel();
        JButton ai=new JButton();
        JButton human=new JButton();


        public LaunchGame(){

                frame.setVisible(true);
                frame.setSize(400,200);
                frame.setResizable(false);
                frame.setLayout(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                label.setText("Welcome to Tic-Tac-Toe");
                label.setFont(new Font("Cosmic Sans",Font.ITALIC,20));
                label.setForeground( new Color(10,79,128));
                label.setBounds(70,10,250,50);
                frame.add(label);

                ai.setText("Play with AI");
                ai.setBounds(50,100,125,20);
                ai.addActionListener(this);
                ai.setFocusable(false);
                frame.add(ai);

                human.setText("Play with Human");
                human.setBounds(200,100,130,20);
                human.addActionListener(this);
                human.setFocusable(false);
                frame.add(human);

        }
        @Override
        public void actionPerformed(ActionEvent e) {

                if(e.getSource()==ai){
                        aitoe game= new aitoe();
                        frame.dispose();
                        JOptionPane.showMessageDialog(null,"You are O");
                }

                if(e.getSource()==human){
                        ticTacToe game =new ticTacToe();
                        frame.dispose();

                }

        }

}

