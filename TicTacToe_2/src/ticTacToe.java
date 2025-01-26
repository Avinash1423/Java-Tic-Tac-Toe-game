import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ticTacToe implements ActionListener {

    JFrame frame = new JFrame();
    JPanel textPanel = new JPanel();
    JPanel board = new JPanel();
    JLabel textLabel = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean playerone;
    Random random = new Random();
    boolean gameOver=false;
    ImageIcon x= new ImageIcon("ticimage.JPG");
    JButton reset=new JButton();

    public ticTacToe() {

        // create main frame
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        frame.setSize(600, 650);
        frame.setResizable(false);
        frame.setTitle("Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(x.getImage());


        //create a textLabel,add it to textPanel and add that to frame

        textPanel.setLayout(new BorderLayout());
        frame.add(textPanel, BorderLayout.NORTH);


        textLabel.setText("Tic-Tac-Toe");
        textLabel.setFont(new Font("Cosmic Sans", Font.ITALIC, 30));
        textLabel.setOpaque(true);
        textLabel.setBackground(new Color(15, 30, 45));
        textLabel.setForeground(Color.RED);
        textLabel.setHorizontalAlignment(JLabel.CENTER);

        textPanel.add(textLabel,BorderLayout.CENTER);
        reset.setSize(10,10);
        reset.setFocusable(false);
        reset.addActionListener(this);
        reset.setText("R");
        reset.setBackground(Color.RED);
        reset.setForeground(Color.WHITE);
        reset.setFont(new Font("Cosmic Sans",Font.BOLD,20));
        textPanel.add(reset,BorderLayout.EAST);


        //create a Board and  it to the frame
        frame.add(board);
        board.setBackground(Color.green);
        board.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++) {

            buttons[i] = new JButton();
            board.add(buttons[i]);
            buttons[i].setFocusable(false);
            buttons[i].setBackground(new Color(20, 45, 85));
            buttons[i].addActionListener(this);

            Border border = BorderFactory.createLineBorder(Color.black, 1);
            buttons[i].setBorder(border);

            checkFirstTurn();

        }


    }


    public void checkFirstTurn() {

        Timer timer = new Timer(2000, e -> {

            if (random.nextInt(1, 3) == 1) {
                playerone = true;

                textLabel.setText("X's Turn");
            } else if (random.nextInt(1, 3) == 2) {
                playerone = false;
                textLabel.setText("O's Turn");
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {

            if (e.getSource() == buttons[i]) {

                if (playerone) {
                    if (buttons[i].getText().equals("")) {

                        textLabel.setText("O's Turn");
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setFont(new Font("Comic Sans", Font.ITALIC, 100));
                        buttons[i].setText("X");
                        playerone = false;
                        isXWinner();
                        isOWinner();
                        draw();
                    }
                }

                if (!playerone) {
                    if (buttons[i].getText().equals("")) {
                        textLabel.setText("X's Turn");
                        buttons[i].setForeground(new Color(25, 200, 30));
                        buttons[i].setFont(new Font("Comic Sans", Font.ITALIC, 100));
                        buttons[i].setText("O");
                        playerone = true;
                        isXWinner();
                        isOWinner();
                        draw();
                    }


                }

            }
        }

        if(e.getSource()==reset){
            frame.dispose();
            ticTacToe game =new ticTacToe();
        }

    }

    public boolean isXWinner() {

        if      (buttons[0].getText() == "X" && buttons[1].getText() == "X" && buttons[2].getText() == "X"||
                buttons[3].getText() == "X" && buttons[4].getText() == "X" && buttons[5].getText() == "X" ||
                buttons[6].getText() == "X" && buttons[7].getText() == "X" && buttons[8].getText() == "X" ||
                buttons[0].getText() == "X" && buttons[3].getText() == "X" && buttons[6].getText() == "X" ||
                buttons[1].getText() == "X" && buttons[4].getText() == "X" && buttons[7].getText() == "X" ||
                buttons[2].getText() == "X" && buttons[5].getText() == "X" && buttons[8].getText() == "X" ||
                buttons[0].getText() == "X" && buttons[4].getText() == "X" && buttons[8].getText() == "X" ||
                buttons[2].getText() == "X" && buttons[4].getText() == "X" && buttons[6].getText() == "X") {

            textLabel.setText("X wins");
            for(int i=0;i<9;i++)
                buttons[i].setEnabled(false);
                gameOver=true;

            return true;
        } else return false;
    }

    public boolean isOWinner() {
        if (buttons[0].getText() == "O" && buttons[1].getText() == "O" && buttons[2].getText() == "O" ||
                buttons[3].getText() == "O" && buttons[4].getText() == "O" && buttons[5].getText() == "O" ||
                buttons[6].getText() == "O" && buttons[7].getText() == "O" && buttons[8].getText() == "O" ||
                buttons[0].getText() == "O" && buttons[3].getText() == "O" && buttons[6].getText() == "O" ||
                buttons[1].getText() == "O" && buttons[4].getText() == "O" && buttons[7].getText() == "O" ||
                buttons[2].getText() == "O" && buttons[5].getText() == "O" && buttons[8].getText() == "O" ||
                buttons[0].getText() == "O" && buttons[4].getText() == "O" && buttons[8].getText() == "O" ||
                buttons[2].getText() == "O" && buttons[4].getText() == "O" && buttons[6].getText() == "O") {

            textLabel.setText("O wins");
            for(int i=0;i<9;i++)
                buttons[i].setEnabled(false);
               gameOver=true;

            return true;
        } else return false;

    }

    public void draw() {

        boolean allFilled=true;

        for (int i = 0; i < 9; i++)
            if (buttons[i].getText().isEmpty()){
                allFilled=false;
                break;}

        if (allFilled &&
                !isXWinner() &&
                !isOWinner()) {
            textLabel.setText("Draw");
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
                gameOver = true;

        }



    }
}




