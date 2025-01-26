import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;
import java.util.Random;

public class aitoe extends ticTacToe {


    public aitoe() {

    }
    @Override
    public void checkFirstTurn() {

        Timer timer = new Timer(2000, e -> {

            if (random.nextInt(1, 3) == 1) {
                playerone = true;

                textLabel.setText("X's Turn");
            } else if (random.nextInt(1, 3) == 2) {
                playerone = false;
                textLabel.setText("O's Turn");
                aimove();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        for (int i = 0; i < 9; i++) {

            if (playerone) {

                if (e.getSource() == buttons[i]) {
                    if (buttons[i].getText().equals("")) {

                        textLabel.setText("O's Turn");
                        buttons[i].setForeground(new Color(25, 200, 30));
                        buttons[i].setFont(new Font("Comic Sans", Font.ITALIC, 100));
                        buttons[i].setText("X");
                        playerone = false;
                        isXWinner();
                        isOWinner();
                        draw();

                        aimove();

                    }
                }
            }
        }
        if(e.getSource()==reset) {
           frame.dispose();
            aitoe game= new aitoe();
            JOptionPane.showMessageDialog(null,"You are O");

        }
    }
            private void aimove( ) {
                if (gameOver == false) {
                    Timer timer = new Timer(1000, e -> {
                        if (!playerone) {
                            Random random = new Random();
                            int r = random.nextInt(9);
                            boolean moved = false;

                            if (Objects.equals(buttons[r].getText(), "")) {
                                textLabel.setText("X's Turn");
                                buttons[r].setForeground(Color.RED);
                                buttons[r].setFont(new Font("Comic Sans", Font.ITALIC, 100));
                                buttons[r].setText("O");
                                playerone = true;
                                moved = true;
                                isXWinner();
                                isOWinner();
                                draw();
                            } else aimove();


                        }
                    });
                    timer.setRepeats(false);
                    timer.start();

                }
                    }
            }







