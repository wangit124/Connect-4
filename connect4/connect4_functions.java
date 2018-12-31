import java.util.*;
import java.io.*;

public class connect4_functions {
 	
	public Random random;
	public int[][] board;
	public final int width = 7;
	public final int height = 6;
	public int playernum=1;
	public int computernum=2;
	public int last_move;

	public connect4_functions () {
		this.random=new Random();
		this.board= new int[this.height][this.width];
                
	} 
	public void setplayerturn (int turn) {
            this.playernum=turn;
	    this.computernum=3-this.playernum;
        }
 	
		
                    /*     int print_welcome(void)
                         {
                            char decision='y';
                            printf("*** Welcome to the Connect-Four game!!! ***\n");
                            printf("Would you like to make the first move [y/n]: ");
                            scanf("%c",&decision);
                            printf("\n");
                            while (getchar()!='\n');
                            if (decision=='n'||decision=='N') {
                                return 2;
                            } 
                            else {

                                return 1;
                            }
                         }*/

                       /*  void display_board(int board[][BOARD_SIZE_VERT])
                         {
                             int colNum=0;
                             printf("\n");
                             for (int i=0;i<BOARD_SIZE_VERT;i++) {
                                 for (int j=0;j<BOARD_SIZE_HORIZ;j++) {
                                    printf("+---");
                                 }
                                 printf("+\n");
                                 for (int k=0;k<BOARD_SIZE_HORIZ;k++) {
                                    printf("| ");
                                    if (board[k][i]==0) {
                                        printf("  ");
                                    }
                                    else if (board[k][i]==1) {
                                        printf("X ");
                                    }
                                    else {
                                        printf("O ");
                                    }
                                 }
                                 printf("|\n");
                             }
                             for (int m=0;m<BOARD_SIZE_HORIZ;m++) {
                                 printf("+---");
                             }
                             printf("+\n");
                             for (int n=0;n<BOARD_SIZE_HORIZ;n++) {
                                 colNum++;
                                 printf("  %d ",colNum);
                             }
                             printf("\n\n");
                         }*/
  
                         public int random_move()
                         {
                             int m= this.random.nextInt(this.width)+1;
                             do 
                             {
                             	m = this.random.nextInt(this.width)+1;
                             }  while (this.is_column_full(m)); 
			     this.last_move=m;
                             return m;
                         }
  
                         public int player_move(int playernum)
                         {
		             this.setplayerturn(playernum);
                             int m=0;
			     Scanner input = new Scanner(System.in);
                             while (m==0) {
                             	System.out.println("Please enter your move: ");
                            	m= input.nextInt();
                                while (m<1||m>this.width) {
                                    System.out.println("Not a valid move. Enter a column number!");
                                    System.out.println("Please enter your move: ");
                                    m=input.nextInt();
                          
                                } 
                                if (this.is_column_full(m)) {
                                    System.out.println("This column is full. Try again!.");
                                    m=0;
                                }
                                else {
                                    this.update_board(this.board,m,this.playernum);
                                    this.last_move=m;
                                    return m;
                                }
                             }
                             return m;
                         }
  
                         public boolean check_win_or_tie()
                         {   
                             int winner=this.check_winner(this.board,this.last_move);
                             if (winner==1) {
                                 System.out.print("*****************************\n* Player X won!!! Game over *\n");
                                 System.out.print("*****************************\n");
                                 return true;
                             }
                             else if (winner==2) {
                                 System.out.print("*****************************\n* Player O won!!! Game over *\n");
                                 System.out.print("*****************************\n");
                                 return true;
                             }
                             else {
                                 for (int i=1;i<this.width+1;i++) {
                                     if (!this.is_column_full(i)) {
                                         return false;
                                     }
                                 }
                                 System.out.print("*****************************\n* Game is a tie!! No winner *\n");
                                 System.out.print("*****************************\n");
                                 return true;
                             }
                         }
  
                         public boolean is_column_full(int m)
                         {
                             for (int i=0;i<this.height;i++) {
                                 if (board[i][m-1]==0) {
                                     return false;
                                 }
                             }
                             return true;
                         }
  
                         public void update_board(int [][] board, int m, int turn)
                         {
			     this.last_move=m;
                             for (int i=this.height-1;i>=0;i--) {
                                if (board[i][m-1]==0) {
                                    board[i][m-1]=turn;
                                    return;
                                }
                             }
                         }
  
                         public int check_winner(int [][] board, int move)
                         {
                             if (this.check_horizontal(this.board)!=0) {
                                 return this.check_horizontal(this.board);
                             }
                             if (this.check_vertical(this.board)!=0) {
                                 return this.check_vertical(this.board);
                             }
                             if (this.check_upslope_diagonal(this.board)!=0) {
                                 return this.check_upslope_diagonal(this.board);
                             }
                             if (this.check_downslope_diagonal(this.board)!=0) {
                                 return this.check_downslope_diagonal(this.board);
                             }
                             return 0;
                         }

//                       int best_move(int board[][BOARD_SIZE_VERT], int computer_num)
//                       {
//
//                       }
//
//
//
//
//
//
//                       /*=============================================================================
//                         Function definitions of other functions
//                         =============================================================================*/
//
//                         // If you would like to use functions other than those declared in
//                         // connect4_functions.h and implemented above, put the definitions
//                         // of these functions here.
//
                         public int check_horizontal(int [][] board) {
                             int temp=0;
                             for (int i=0; i<this.height;i++) {
                                 for (int j=0;j<4;j++) {
                                     temp=board[i][j];
                                     if (temp!=0) {
                                    	if (temp==board[i][j+1]&&temp==board[i][j+2]&&temp==board[i][j+3]) {
                                            return temp;
                                        }
                                     }
                                 }
                             }
                             return 0;
                         }
  
                         public int check_vertical(int [][] board) { 
  			     int temp=0;
                             for (int i=0; i<this.width;i++) {
                                 for (int j=0;j<3;j++) {
                                     temp=board[j][i];
                                     if (temp!=0) {
                                     	if (temp==board[j+1][i]&&temp==board[j+2][i]&&temp==board[j+3][i]) {
                                            return temp;
                                        }
                                     }
                                 }
                             }
                             return 0;
                         }
  
                         	    public int check_upslope_diagonal(int [][] board) {
  			                 for (int i=0;i<4;i++) {
  			                     for (int j=0;j<3;j++) {
  			                         int temp=board[j][i];
  			                            if (temp!=0) {
  			                               if (temp==board[j+1][i+1]&&temp==board[j+2][i+2]&&temp==board[j+3][i+3]) {
  			                                   return temp;
  			                               }
  			                            }
 			                     }
			                 }
			                 return 0;
			            }
                        	    public int check_downslope_diagonal(int [][] board) {
			                 for (int i=3;i<this.width;i++) {
  			                     for (int j=0;j<3;j++) {
  			                         int temp=board[j][i];
			                             if (temp!=0) {
			                                 if (temp==board[j+1][i-1]&&temp==board[j+2][i-2]&&temp==board[j+3][i-3]) {
			                                    return temp;
			                                 }
			                             }
			                      }
  			                  }
  			                     return 0;
  			             }  
//
//
//                         /******************************************************************************
//                                                         End of file
//                                                         ******************************************************************************/
//
//
}
