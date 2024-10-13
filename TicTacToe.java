import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class TicTacToe {
   private JFrame frame = new JFrame("Tic Tac Toe by SSMCosmic");
   private int count = 0;
   private JButton button1 = new JButton("");
   private JButton button2 = new JButton("");
   private JButton button3 = new JButton("");
   private JButton button4 = new JButton("");
   private JButton button5 = new JButton("");
   private JButton button6 = new JButton("");
   private JButton button7 = new JButton("");
   private JButton button8 = new JButton("");
   private JButton button9 = new JButton("");
   private JTextArea output = new JTextArea();

   public TicTacToe() {
      this.frame.setDefaultCloseOperation(3);
      this.frame.setSize(400, 550);
      this.frame.setResizable(false);
      this.frame.setLayout((LayoutManager)null);
      Color CustomGray = new Color(232, 232, 232);
      Color customBlue = new Color(133, 220, 186);
      this.frame.getContentPane().setBackground(customBlue);
      this.output.setSize(400, 50);
      this.output.setLocation(0, 10);
      this.output.setBackground(CustomGray);
      this.playerTurnMessage(this.count);
      this.createButtons();
      this.createActionListeners();
      this.displayObjects();
      this.frame.setVisible(true);
   }

   private void playerTurnMessage(int count) {
      if (count % 2 == 0) {
         this.output.setText("Player X's turn");
      } else {
         this.output.setText("Player O's turn");
      }

   }

   private String whoWins() {
      String winner = "-1";
      if (this.button1.getText().equals(this.button2.getText()) && this.button2.getText().equals(this.button3.getText()) && (this.button1.getText().equals("x") || this.button1.getText().equals("o"))) {
         winner = this.button1.getText();
      }

      if (this.button4.getText().equals(this.button5.getText()) && this.button5.getText().equals(this.button6.getText()) && (this.button4.getText().equals("x") || this.button4.getText().equals("o"))) {
         winner = this.button4.getText();
      }

      if (this.button7.getText().equals(this.button8.getText()) && this.button8.getText().equals(this.button9.getText()) && (this.button7.getText().equals("x") || this.button7.getText().equals("o"))) {
         winner = this.button6.getText();
      }

      if (this.button1.getText().equals(this.button4.getText()) && this.button4.getText().equals(this.button7.getText()) && (this.button1.getText().equals("x") || this.button1.getText().equals("o"))) {
         winner = this.button1.getText();
      }

      if (this.button2.getText().equals(this.button5.getText()) && this.button5.getText().equals(this.button8.getText()) && (this.button2.getText().equals("x") || this.button2.getText().equals("o"))) {
         winner = this.button2.getText();
      }

      if (this.button3.getText().equals(this.button6.getText()) && this.button6.getText().equals(this.button9.getText()) && (this.button3.getText().equals("x") || this.button3.getText().equals("o"))) {
         winner = this.button3.getText();
      }

      if (this.button1.getText().equals(this.button5.getText()) && this.button5.getText().equals(this.button9.getText()) && (this.button1.getText().equals("x") || this.button1.getText().equals("o"))) {
         winner = this.button1.getText();
      }

      if (this.button3.getText().equals(this.button5.getText()) && this.button5.getText().equals(this.button7.getText()) && (this.button3.getText().equals("x") || this.button3.getText().equals("o"))) {
         winner = this.button3.getText();
      }

      return winner;
   }

   private void setWinMessage() {
      String winner = this.whoWins();
      String message = "Player " + winner + " wins!";
      if (winner.equals("-1") && this.count == 9) {
         message = "It's a tie!";
         this.output.setText(message);
      } else if (winner.equals("x") || winner.equals("o")) {
         this.output.setText(message);
         this.disableButtons();
      }

      System.out.println(winner);
   }

   private void displayObjects() {
      this.frame.add(this.button1);
      this.frame.add(this.button2);
      this.frame.add(this.button3);
      this.frame.add(this.button4);
      this.frame.add(this.button5);
      this.frame.add(this.button6);
      this.frame.add(this.button7);
      this.frame.add(this.button8);
      this.frame.add(this.button9);
      this.frame.add(this.output);
   }

   private void createButtons() {
      this.button1.setSize(133, 100);
      this.button1.setLocation(0, 200);
      this.button2.setSize(133, 100);
      this.button2.setLocation(133, 200);
      this.button3.setSize(133, 100);
      this.button3.setLocation(266, 200);
      this.button4.setSize(133, 100);
      this.button4.setLocation(0, 300);
      this.button5.setSize(133, 100);
      this.button5.setLocation(133, 300);
      this.button6.setSize(133, 100);
      this.button6.setLocation(266, 300);
      this.button7.setSize(133, 100);
      this.button7.setLocation(0, 400);
      this.button8.setSize(133, 100);
      this.button8.setLocation(133, 400);
      this.button9.setSize(133, 100);
      this.button9.setLocation(266, 400);
   }

   private void disableButtons() {
      this.button1.setEnabled(false);
      this.button2.setEnabled(false);
      this.button3.setEnabled(false);
      this.button4.setEnabled(false);
      this.button5.setEnabled(false);
      this.button6.setEnabled(false);
      this.button7.setEnabled(false);
      this.button8.setEnabled(false);
      this.button9.setEnabled(false);
   }

   private void createActionListeners() {
      this.button9.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (TicTacToe.this.count % 2 == 0) {
               TicTacToe.this.button9.setText("x");
            } else {
               TicTacToe.this.button9.setText("o");
            }

            TicTacToe var10000 = TicTacToe.this;
            var10000.count = var10000.count + 1;
            TicTacToe.this.playerTurnMessage(TicTacToe.this.count);
            TicTacToe.this.button9.setEnabled(false);
            TicTacToe.this.setWinMessage();
         }
      });
      this.button8.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (TicTacToe.this.count % 2 == 0) {
               TicTacToe.this.button8.setText("x");
            } else {
               TicTacToe.this.button8.setText("o");
            }

            TicTacToe var10000 = TicTacToe.this;
            var10000.count = var10000.count + 1;
            TicTacToe.this.playerTurnMessage(TicTacToe.this.count);
            TicTacToe.this.button8.setEnabled(false);
            TicTacToe.this.setWinMessage();
         }
      });
      this.button7.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (TicTacToe.this.count % 2 == 0) {
               TicTacToe.this.button7.setText("x");
            } else {
               TicTacToe.this.button7.setText("o");
            }

            TicTacToe var10000 = TicTacToe.this;
            var10000.count = var10000.count + 1;
            TicTacToe.this.playerTurnMessage(TicTacToe.this.count);
            TicTacToe.this.button7.setEnabled(false);
            TicTacToe.this.setWinMessage();
         }
      });
      this.button6.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (TicTacToe.this.count % 2 == 0) {
               TicTacToe.this.button6.setText("x");
            } else {
               TicTacToe.this.button6.setText("o");
            }

            TicTacToe var10000 = TicTacToe.this;
            var10000.count = var10000.count + 1;
            TicTacToe.this.playerTurnMessage(TicTacToe.this.count);
            TicTacToe.this.button6.setEnabled(false);
            TicTacToe.this.setWinMessage();
         }
      });
      this.button5.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (TicTacToe.this.count % 2 == 0) {
               TicTacToe.this.button5.setText("x");
            } else {
               TicTacToe.this.button5.setText("o");
            }

            TicTacToe var10000 = TicTacToe.this;
            var10000.count = var10000.count + 1;
            TicTacToe.this.playerTurnMessage(TicTacToe.this.count);
            TicTacToe.this.button5.setEnabled(false);
            TicTacToe.this.setWinMessage();
         }
      });
      this.button4.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (TicTacToe.this.count % 2 == 0) {
               TicTacToe.this.button4.setText("x");
            } else {
               TicTacToe.this.button4.setText("o");
            }

            TicTacToe var10000 = TicTacToe.this;
            var10000.count = var10000.count + 1;
            TicTacToe.this.playerTurnMessage(TicTacToe.this.count);
            TicTacToe.this.button4.setEnabled(false);
            TicTacToe.this.setWinMessage();
         }
      });
      this.button3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (TicTacToe.this.count % 2 == 0) {
               TicTacToe.this.button3.setText("x");
            } else {
               TicTacToe.this.button3.setText("o");
            }

            TicTacToe var10000 = TicTacToe.this;
            var10000.count = var10000.count + 1;
            TicTacToe.this.playerTurnMessage(TicTacToe.this.count);
            TicTacToe.this.button3.setEnabled(false);
            TicTacToe.this.setWinMessage();
         }
      });
      this.button2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (TicTacToe.this.count % 2 == 0) {
               TicTacToe.this.button2.setText("x");
            } else {
               TicTacToe.this.button2.setText("o");
            }

            TicTacToe var10000 = TicTacToe.this;
            var10000.count = var10000.count + 1;
            TicTacToe.this.playerTurnMessage(TicTacToe.this.count);
            TicTacToe.this.button2.setEnabled(false);
            TicTacToe.this.setWinMessage();
         }
      });
      this.button1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (TicTacToe.this.count % 2 == 0) {
               TicTacToe.this.button1.setText("x");
            } else {
               TicTacToe.this.button1.setText("o");
            }

            TicTacToe var10000 = TicTacToe.this;
            var10000.count = var10000.count + 1;
            TicTacToe.this.playerTurnMessage(TicTacToe.this.count);
            TicTacToe.this.button1.setEnabled(false);
            TicTacToe.this.setWinMessage();
         }
      });
   }

   public static void main(String[] args) {
      new TicTacToe();
   }
}