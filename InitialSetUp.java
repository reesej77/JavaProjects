import java.util.Scanner;

 public class InitialSetUp{
 public static void main(String[] args){
 // This in array is drawing up the board lines. In (xstart, ystart, xend, yend) format
  int[][]boardLine = {{0,200,600,200},
  {0,400,600,400},
  {200,0,200,600},
  {400,0,400,600}};

 // This sets up the array that will be used to set up the X/O grid. They are temporarily filled with hyphens until they are fiflled with x and o values.
  char [][]arr = new char[3][3];
for (int i=0;i<3;i++)
for (int j=0;j<3;j++)
  arr[i][j]='-';

 // Use This Sample Code to see if your pictures are displaying on the board.
  /*arr[1][1]='o';
arr[2][2]='x';
  arr[1][2]='o';
arr[0][0]='x';
  arr[0][1]='x';*/


 // This line imports the TicTacToeBoard file
  TicTacToeBoard board = new TicTacToeBoard(620,720);
 // This sets up the grid given the lines you provided above in the boardLine array
  board.defineBoard(boardLine);
 // This will set your pictures to display for the x and o values. Make sure your names match exactly what you type in the parameters.
  board.setFiles("ThisX.png","O.png"); //make sure file names match those in your folder
 // This sets up the spacing and place values for x and o
board.setBoard(arr);
 // This will refresh the board so that new elements will display.
  board.repaint();

 Scanner reader = new Scanner(System.in);
  boolean gameMode = false;
  int turn = 1;
boolean won = false;
  while (!gameMode)
  {
  System.out.println("Tic Tac Toe: Choose (1) for 1 players or (2) for 2 player: ");
  int mode = reader.nextInt();
  if (mode == 1) //1 player
  {
  gameMode = true;
  while ((turn <= 9) && !(won))
  {
  if (!(turn%2 == 0))
  {
  boolean correctInput = false;
  while (!correctInput)
  {
  System.out.print("Enter a row: ");
  int row = reader.nextInt();
  System.out.print("Enter a column: ");
  int col = reader.nextInt();
if (row < 4 && row > 0 && col < 4 && col > 0 && !(arr[row-1][col-1] == 'x') && !(arr[row-1][col-1] == 'o'))
  {
arr[row-1][col-1] = 'x';
  turn ++;
  correctInput = true;
  board.repaint();
won = gameWon(arr);
  }
  else
  System.out.println("Invalid entry, try again");


  }
  }
  else
  {
  board.delay(500);
  boolean correctInput = false;
  while (!correctInput)
  {
  int row = (int)(Math.random()*3)+1;
  int col = (int)(Math.random()*3)+1;
  if (!(arr[row-1][col-1] == 'x') && !(arr[row-1][col-1] == 'o'))
  {
  arr[row-1][col-1] = 'o';
  turn ++;
  correctInput = true;
  board.repaint();
  won = gameWon(arr);
  }

  }
  }

 }
  //while loop ends

if (turn == 10 && won == false)
{
	board.setWinner("It's a tie!", 200, 650, 35);
  System.out.println("It's a tie!\n\n");
}
else
{
  if (turn % 2 == 0)
  {
  board.setWinner("Player Wins!", 200, 650, 35);
  System.out.println("Player Wins!\n\n");
  }
  else
  {
  board.setWinner("Computer Wins!", 200, 650, 35);
  System.out.println("Computer Wins!\n\n");
  }
}
board.showText(true);

}
  if (mode == 2) //2 player mode
  {
  gameMode = true;
  while ((turn <= 9) && !(won))
  {
if (!(turn%2 == 0))
{
boolean correctInput = false;
while (!correctInput)
{
System.out.print("Enter a row: ");
int row = reader.nextInt();
System.out.print("Enter a column: ");
int col = reader.nextInt();
if (row < 4 && row > 0 && col < 4 && col > 0 && !(arr[row-1][col-1] == 'x') && !(arr[row-1][col-1] == 'o'))
{
arr[row-1][col-1] = 'x';
turn ++;
correctInput = true;
board.repaint();
won = gameWon(arr);
}
else
System.out.println("Invalid entry, try again");
}
}

else
{
boolean correctInput = false;
while (!correctInput)
{
System.out.print("Enter a row: ");
int row = reader.nextInt();
System.out.print("Enter a column: ");
int col = reader.nextInt();
if (row < 4 && row > 0 && col < 4 && col > 0 && !(arr[row-1][col-1] == 'x') && !(arr[row-1][col-1] == 'o'))
{
arr[row-1][col-1] = 'o';
turn ++;
correctInput = true;
board.repaint();
won = gameWon(arr);
}
else
{
System.out.println("Invalid entry, try again");
}

}
}

}
if (turn == 10 && won == false)
{
	board.setWinner("It's a tie!", 200, 650, 35);
  System.out.println("It's a tie!\n\n");
}
else
{
  if (turn % 2 == 0)
  {
  board.setWinner("X Wins!", 200, 650, 35);
  System.out.println("X Wins!\n\n");
  }
  else
  {
  board.setWinner("O Wins!", 200, 650, 35);
  System.out.println("O Wins!\n\n");
  }
}
board.showText(true);
}

 }
}


 public static boolean gameWon(char[][] arr)
 {
 if (arr[0][0] == 'x' && arr[0][1] == 'x' && arr[0][2] == 'x' || arr[0][0] == 'o' && arr[0][1] == 'o' && arr[0][2] == 'o')
 return true;
 if (arr[1][0] == 'x' && arr[1][1] == 'x' && arr[1][2] == 'x' || arr[1][0] == 'o' && arr[1][1] == 'o' && arr[1][2] == 'o')
 return true;
 if (arr[2][0] == 'x' && arr[2][1] == 'x' && arr[2][2] == 'x' || arr[2][0] == 'o' && arr[2][1] == 'o' && arr[2][2] == 'o')
 return true;
 if (arr[0][0] == 'x' && arr[1][0] == 'x' && arr[2][0] == 'x' || arr[0][0] == 'o' && arr[1][0] == 'o' && arr[2][0] == 'o')
 return true;
 if (arr[0][1] == 'x' && arr[1][1] == 'x' && arr[2][1] == 'x' || arr[0][1] == 'o' && arr[1][1] == 'o' && arr[2][1] == 'o')
 return true;
 if (arr[0][2] == 'x' && arr[1][2] == 'x' && arr[2][2] == 'x' || arr[0][2] == 'o' && arr[1][2] == 'o' && arr[2][2] == 'o')
 return true;
 if (arr[0][0] == 'x' && arr[1][1] == 'x' && arr[2][2] == 'x' || arr[0][0] == 'o' && arr[1][1] == 'o' && arr[2][2] == 'o')
 return true;
 if (arr[2][0] == 'x' && arr[1][1] == 'x' && arr[0][2] == 'x' || arr[2][0] == 'o' && arr[1][1] == 'o' && arr[0][2] == 'o')
 return true;
 return false;

 }


}


