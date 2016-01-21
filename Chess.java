import cs1.Keyboard;
public class Chess{//driver file for chess game
    public static Piece[][] board = new Piece[8][8];//instance variable for the board
    public Chess(){
	/*
	Matrix board = new Matrix(8);
	//white pieces
	board.set(7,0,new Rook());
	board.set(7,1,new Knight());
	board.set(7,2,new Bishop());
       	board.set(7,3,new Queen());
	board.set(7,4,new King());
	board.set(7,5,new Bishop());
	board.set(7,6,new Knight());
	board.set(7,7,new Rook());
	//black pieces
	board.set(0,0,new Rook(B));
	board.set(0,1,new Knight(B));
	board.set(0,2,new Bishop(B));
       	board.set(0,3,new Queen(B));
	board.set(0,4,new King(B));
	board.set(0,5,new Bishop(B));
	board.set(0,6,new Knight(B));
	board.set(0,7,new Rook(B));
	//white pawns
	board.set(6,0,new Pawn());
	board.set(6,1,new Pawn());
	board.set(6,2,new Pawn());
       	board.set(6,3,new Pawn());
	board.set(6,4,new Pawn());
	board.set(6,5,new Pawn());
	board.set(6,6,new Pawn());
	board.set(6,7,new Pawn());
	//black pawns
	board.set(1,0,new Pawn(B));
	board.set(1,1,new Pawn(B));
	board.set(1,2,new Pawn(B));
       	board.set(1,3,new Pawn(B));
	board.set(1,4,new Pawn(B));
	board.set(1,5,new Pawn(B));
	board.set(1,6,new Pawn(B));
	board.set(1,7,new Pawn(B));
	*/
    }//set locations for pieces

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
    public static void move(){
	//select square
	System.out.println("input x");
	x = Keyboard.readInt();
	System.out.println("input y");
	y = Keyboard.readInt();
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
	}
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
	game();
    }

}
