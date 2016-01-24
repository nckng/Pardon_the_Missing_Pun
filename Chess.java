import cs1.Keyboard;
public class Chess{//driver file for chess game
    public static Piece[][] board = new Piece[8][8];//instance variable for the board

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
    public static void swap(int x1, int y1, int x2, int y2){
	Piece stor = board[y1][x1];
	board[y1][x1] = board[y2][x2];
	board[y2][x2] = stor;
    }
	
    public static void move(){
	//select square
	System.out.println("input x");
	int x = Keyboard.readInt();
	System.out.println("input y");
	int y = Keyboard.readInt();
	System.out.println(x+","+y+" selected");
	if(board[y][x] == null){
	    System.out.println("There is no piece on that square. Choose another one.");
	    move();
	} else{
	    //check if square has correct turn piece
	    //is it correct player?
	    //check for check
	    //select new square
	    System.out.println("input new x");
	    int x1 = Keyboard.readInt();
	    System.out.println("input new y");
	    int y1 = Keyboard.readInt();
	    System.out.println(x1+","+y1+" selected");
	    //can piece move?
	    /*
	    if(board[y][x].canMove(x1,y1)){
		if(board[y1][x1] == null){
		    swap(x1,y1,x,y);
		} else{
		    swap(x1,y1,x,y);
		    Piece store = board[y][x];
		    board[y][x] = null;
		    capturedPieceList.add(store);
		}
	    }
	    */
	    swap(x,y,x1,y1);
	}
    }

    public static void makeBoard(){
	board[1][1] = new Pawn();
	board[2][1] = new Pawn(1);
	board[3][1] = new Knight();
	board[4][1] = new Knight();
	board[5][1] = new Bishop();
	board[6][1] = new Bishop(1);
	board[7][1] = new King();
	board[0][1] = new King(1);
	board[1][2] = new Queen();
	board[1][3] = new Queen(1);
    }
    public static void game(){
	
	int movecounter = 0;
	boolean turn = false; //false = white, true = black
	while(! isGameOver()){//if the game is not over
	    movecounter++;
	    move();

	}
    }


	
    public static void main(String[] args){
	makeBoard();
	game();
    }

}
