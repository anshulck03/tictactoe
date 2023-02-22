/**
 * Edited by Anshul Karanam
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class TicTacToe {
   public static JFrame window;
   public static JPanel display;
   public static JPanel controls;

   public static JLabel message = new JLabel("Default Message");

   public static int board[] = new int[9];

   public static boolean xTurn = true;

   public static final int WINDOW_UPPER_OFFSET = 30;
   public static final int WINDOW_LOWER_OFFSET = 8;
   public static final int WINDOW_LEFT_OFFSET = 8;
   public static final int WINDOW_RIGHT_OFFSET = 8;

   public static final String GAME_CARD = "GameCard";
   public static final String WIN_CARD = "WinCard";

   public static class ButtonListener implements ActionListener {
   
      @Override
      public void actionPerformed(ActionEvent event) {
         if (event.getActionCommand().equals("replay")) {
            Arrays.fill(board, -1);
            xTurn = true;
            changeCard(GAME_CARD);
         }
      }
   }

   public static class TicTacToeComponent extends Component {
      int cellWidth;
      int cellHeight;
   
      public class MakeMove implements MouseListener {
         public void mouseClicked(MouseEvent e) {
            Point p = e.getPoint();
         
            p.x -= WINDOW_LEFT_OFFSET;
            p.y -= WINDOW_UPPER_OFFSET;
         
            int row = p.y / cellHeight;
            int column = p.x / cellWidth;
         
            int boardPosition = column + row * 3;
         
            if (board[boardPosition] == -1) {
               if (xTurn) {
                  board[boardPosition] = 1;
               } else {
                  board[boardPosition] = 0;
               }
               window.repaint();
            
               xTurn = !xTurn;
            
               int gameState = checkGameState();
               if (gameState != -2) {
                  if (gameState == 1) {
                     message.setText("X wins");
                  } else if (gameState == 0) {
                     message.setText("O wins");
                  } else {
                     message.setText("Tie");
                  }
                  changeCard(WIN_CARD);
               }
            }
         }
      
         public void mouseEntered(MouseEvent e) {
         }
      
         public void mouseExited(MouseEvent e) {
         }
      
         public void mousePressed(MouseEvent e) {
         }
      
         public void mouseReleased(MouseEvent e) {
         }
      }
   
      public TicTacToeComponent() {
         window.addMouseListener(this.new MakeMove());
         cellWidth = (window.getWidth() - WINDOW_LEFT_OFFSET - WINDOW_RIGHT_OFFSET) / 3;
         cellHeight = (window.getHeight() - WINDOW_UPPER_OFFSET - WINDOW_LOWER_OFFSET) / 3;
      }
   
      public void paint(Graphics graphics) {
      	/* Vertical lines */
         int x = cellWidth;
         for (int i = 1; i < 3; ++i) {
            graphics.drawLine(x, 0, x, getHeight());
            x += cellWidth;
         }
      
         int y = cellHeight;
      
         for (int i = 0; i < 2; ++i) {
            graphics.drawLine(0, y, getWidth(), y);
            y += cellHeight;
         }
      
         for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 3; ++col) {
               switch (board[col + row * 3]) {
                  case 0:
                     graphics.setColor(Color.BLACK);
                     graphics.drawOval(col * cellWidth + 10, row * cellHeight + 10, cellWidth - 20, cellHeight - 20);
                     break;
               
                  case 1:
                     graphics.setColor(Color.BLACK);
                     graphics.drawLine(col * cellHeight + 10, row * cellHeight + 10, col * cellHeight + cellHeight - 10, row * cellHeight + cellHeight - 10);
                     graphics.drawLine(col * cellHeight + 10, row * cellHeight + cellHeight - 10, col * cellHeight + cellHeight - 10, row * cellHeight + 10);
                     break;
               }
            }
         }
      }
   
      @Override
      public Dimension getPreferredSize() {
         return new Dimension(display.getWidth(), display.getHeight());
      }
   }

   public static void changeCard(String card) {
      CardLayout cl = (CardLayout) window.getContentPane().getLayout();
      cl.show(window.getContentPane(), card);
   }

   public static int checkGameState() {
      if (board[0] == board[1] && board[0] == board[2]) {
         if (board[0] == 0) {
            return 0;
         } else if (board[0] == 1) {
            return 1;
         }
      }
      if (board[0] == board[3] && board[0] == board[6]) {
         if (board[0] == 0) {
            return 0;
         } else if (board[0] == 1) {
            return 1;
         }
      }
   
      if (board[0] == board[4] && board[0] == board[8]) {
         if (board[0] == 0) {
            return 0;
         } else if (board[0] == 1) {
            return 1;
         }
      }
      if (board[1] == board[4] && board[1] == board[7]) {
         if (board[1] == 0) {
            return 0;
         } else if (board[1] == 1) {
            return 1;
         }
      }
      if (board[2] == board[5] && board[2] == board[8]) {
         if (board[2] == 0) {
            return 0;
         } else if (board[2] == 1) {
            return 1;
         }
      }
      if (board[2] == board[4] && board[2] == board[6]) {
         if (board[2] == 0) {
            return 0;
         } else if (board[2] == 1) {
            return 1;
         }
      }
      if (board[6] == board[7] && board[7] == board[8]) {
         if (board[6] == 0) {
            return 0;
         } else if (board[6] == 1) {
            return 1;
         }
      }
      if (board[3] == board[4] && board[4] == board[5]) {
         if (board[3] == 0) {
            return 0;
         } else if (board[3] == 1) {
            return 1;
         }
      }
      if (board[2] == board[4] && board[2] == board[6]) {
         if (board[2] == 0) {
            return 0;
         } else if (board[2] == 1) {
            return 1;
         }
      
      } 
      if (board[0] != -1 && board[1] != -1 && board[2] != -1 && board[3] != -1 && board[4] != -1 && board[5] != -1 && board[6] != -1 && board[7] != -1 && board[8] != -1) {
         return -1;
      } else ;
      return -2;
   
   
   }













   public static void createWindow(String name, int resX, int resY, boolean resizeable)
   {
      window = new JFrame(name);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setSize(resX,resY);
      window.setMinimumSize(new Dimension(resX,resY));
      window.setResizable(resizeable);
   
      window.getContentPane().setLayout(new CardLayout());
      window.setVisible(true);
   }

   public static void addControls()
   {
      JButton replay = new JButton("Play Again?");
      replay.setActionCommand("replay");
      replay.addActionListener(new ButtonListener());
      controls = new JPanel(new BorderLayout());
      message.setHorizontalAlignment(SwingConstants.CENTER);
      message.setFont(new Font("Serif", Font.PLAIN, 180));
      controls.add("Center",message);
      controls.add(replay,BorderLayout.PAGE_END);
      window.getContentPane().add(controls,WIN_CARD);
   }

   public static void addDisplay()
   {
      display = new JPanel();
      display.add(new TicTacToeComponent());
      window.getContentPane().add(display,GAME_CARD);
   }

   public static void main(String[] args)
   {
      createWindow("Tic-Tac-Toe",616,638,true);
      Arrays.fill(board,-1);
      addControls();
      addDisplay();
      changeCard(GAME_CARD);
      window.repaint();
   }
}
