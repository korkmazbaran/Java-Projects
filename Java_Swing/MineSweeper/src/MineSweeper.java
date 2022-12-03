import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MineSweeper implements MouseListener{

	JFrame frame;
	Btn[][] board = new Btn[10][10];
	int openButton;

	public MineSweeper() {
		openButton= 0 ;
		frame = new JFrame("MineSweeper");
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(10, 10));

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				
				Btn b = new Btn(row,col);
				frame.add(b);
				b.addMouseListener(this);
				board[row][col] = b;

			}
		}
		generateMine();
		updateCount();
		//print();
		

		frame.setVisible(true);

	}
	
	public void generateMine() {
		int i = 0;
		while (i<10) {
			int randRow = (int) (Math.random() * board.length);
			int randCol = (int) (Math.random() * board[0].length);
			while (board[randRow][randCol].isMine()) {
				randRow = (int) (Math.random() * board.length);
				randCol = (int) (Math.random() * board[0].length);
			}
			board[randRow][randCol].setMine(true);
			i++;
		}		
		
	}
	public void print() {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				if (board[row][col].isMine()) {
					board[row][col].setIcon(new ImageIcon("src/bomb.png"));
				}
				else {
					board[row][col].setText(board[row][col].getCount()+"");
					board[row][col].setEnabled(false);
				}
				
				
			}
		}
		
	}
	public void updateCount() {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				if (board[row][col].isMine()){
					counting(row,col);
				}
				
				
			}
		}
		
	}
	public void counting(int row, int col) {
		for (int i = row-1; i <= row+1; i++) {
			for (int k = col-1; k <= col+1; k++) {
				try {
					int value =board[i][k].getCount();
					board[i][k].setCount(++value);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
	
	public void open(int r, int c) {
		if (r<0 || r >= board.length || c<0||c >=board[0].length ||board[r][c].getText().length() > 0 || board[r][c].isEnabled()==false ) {
			return;
		}if (board[r][c].getCount() !=0) {
			board[r][c].setText(board[r][c].getCount()+"");
			board[r][c].setEnabled(false);
			openButton++;
		} else {
			openButton++;
			board[r][c].setEnabled(false);
			open(r-1,c);
			open(r+1,c);
			open(r,c-1);
			open(r,c+1);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Btn b = (Btn)e.getComponent();
		if (e.getButton()==1) {
			if (b.isMine()) {
				JOptionPane.showMessageDialog(frame, "You stepped on a mine.Game Over");
				print();
			}
			else {
				open(b.getRow(),b.getCol());
				if (openButton == (board.length * board[0].length)-10) {
					JOptionPane.showMessageDialog(frame, "Congratulations, You won the game !");
					print();
				}

			}
		} else if(e.getButton()==3){
			if (!b.isFlag()) {
				b.setIcon(new ImageIcon("src/flag.png"));
				b.setFlag(true);
			}
			else {
				b.setIcon(null);
				b.setFlag(false);
			}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
