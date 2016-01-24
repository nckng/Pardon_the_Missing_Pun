import cs1.Keyboard;
import java.util.*;
public class Chess{//driver file for chess game
    public static Piece[][] board = new Piece[8][8];//instance variable for the board
    public static ArrayList<Piece> cap = new ArrayList();
    public static int movecounter;

    public static boolean isStalemate()//is there a stalemate?
    {return false;}
    
    public static boolean isCheckmate()
    {return false;}
    
    public static boolean isGameOver(){//if there is checkmate or stalemate the game is over
       
	if (isCheckmate())
	    {return true;}
	else if (isStalemate())
	    {return true;}
	else
	    {return false;}
	    
    }

    public static String printSquare(int x, int y){
	if (board[x][y] == null){
	    return "X";
	} else{
	    return board[x][y].getDisplayName();
	}
    }

    public static void print() {
	for(int i = 0; i < 8; i++){
	    String line = "";
	    for(int j = 0; j < 7; j++){
		line += printSquare(i, j) + "  ";
	    }
	    line += printSquare(i, 7);
	    System.out.println(line);
	}
    }


    public static void swap(int x1, int y1, int x2, int y2){
	Piece stor = board[y1][x1];
	board[y1][x1] = board[y2][x2];
	board[y2][x2] = stor;
    }
	
    public static void move(){
	//check for turn
	boolean whiteturn = ((movecounter % 2)==0);
	//Ask for square
	if (whiteturn){
	    System.out.println("White's turn");
	}
	else{
	    System.out.println("Black's turn");
	}
	System.out.println("input x");
	int x = Keyboard.readInt();
	System.out.println("input y");
	int y = Keyboard.readInt();
	System.out.println(x+","+y+" selected");
	//is square empty?
	if(board[y][x] == null){
	    System.out.println("There is no piece on that square. Choose another one.");
	    move();
	}
	//check if square has correct turn piece
	else if(((board[y][x]).getWhite())!=(whiteturn)){
	    System.out.println("That is not your piece. Choose another.");
	    move();
	}
	//check for check
	//select new square
	else{
	    System.out.println("You have chosen a "+(board[y][x]).getDisplayName());
	    System.out.println("input new x");
	    int x1 = Keyboard.readInt();
	    System.out.println("input new y");
	    int y1 = Keyboard.readInt();
	    System.out.println(x1+","+y1+" selected");
	    //can piece move?
	    if(board[y][x].canMove(x,y,x1,y1)){//if square is empty, just move
		if(board[y1][x1] == null){
		    swap(x1,y1,x,y);
		} else{//if the square has a piece
		    //check if this piece is a friendly
		    if(((board[y][x]).getWhite())==((board[y1][x1]).getWhite())){
			System.out.println("That is your own piece! Choose another.");
			move();
		    }
		    else{
			swap(x1,y1,x,y);
			cap.add(board[y][x]);
			board[y][x] = null;
		    }
		}
	    }
	    else{
		System.out.println("Your piece cannot move there. Please select a different move.");
		move();
	    }
	}
    }

    public static void makeBoard(){
	//add black pieces
	board[0][0] = new Rook(1);
	board[0][1] = new Knight(1);
	board[0][2] = new Bishop(1);
	board[0][3] = new Queen(1);
	board[0][4] = new King(1);
	board[0][5] = new Bishop(1);
	board[0][6] = new Knight(1);
	board[0][7] = new Rook(1);
	//add black pawns
	board[1][0] = new Pawn(1);
	board[1][1] = new Pawn(1);
	board[1][2] = new Pawn(1);
	board[1][3] = new Pawn(1);
	board[1][4] = new Pawn(1);
	board[1][5] = new Pawn(1);
	board[1][6] = new Pawn(1);
	board[1][7] = new Pawn(1);
	//add white pawns
	board[6][0] = new Pawn();
	board[6][1] = new Pawn();
	board[6][2] = new Pawn();
	board[6][3] = new Pawn();
	board[6][4] = new Pawn();
	board[6][5] = new Pawn();
	board[6][6] = new Pawn();
	board[6][7] = new Pawn();
	//add white pieces
	board[7][0] = new Rook();
	board[7][1] = new Knight();
	board[7][2] = new Bishop();
	board[7][3] = new Queen();
	board[7][4] = new King();
	board[7][5] = new Bishop();
	board[7][6] = new Knight();
	board[7][7] = new Rook();	
    }
    
    public static void game(){
	boolean turn = false; //false = white, true = black
	while(! isGameOver()){//if the game is not over
	    move();
	    System.out.println(movecounter);
	    movecounter++;
	}
    }


	
    public static void main(String[] args){
	makeBoard();
	print();
	//game();
    }

}
