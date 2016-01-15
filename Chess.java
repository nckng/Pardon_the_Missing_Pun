public class Chess{//driver file for chess game
    public Matrix board;//instance variable for the board
    public Chess(){
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
	board.set(6,0,new Pawn(B));
	board.set(6,1,new Pawn(B));
	board.set(6,2,new Pawn(B));
       	board.set(6,3,new Pawn(B));
	board.set(6,4,new Pawn(B));
	board.set(6,5,new Pawn(B));
	board.set(6,6,new Pawn(B));
	board.set(6,7,new Pawn(B));

	board.set(6,0,new Pawn(B));
	board.set(6,1,new Pawn(B));
	board.set(6,2,new Pawn(B));
       	board.set(6,3,new Pawn(B));
	board.set(6,4,new Pawn(B));
	board.set(6,5,new Pawn(B));
	board.set(6,6,new Pawn(B));
	board.set(6,7,new Pawn(B));
	
	
	//set locations for pieces
    }
    public static void game(){
    }
    public static void main(String[] args){
	game();
    }
    
}
