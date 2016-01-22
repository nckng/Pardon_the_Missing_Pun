public class Pawn extends Piece{//class for pawn
    public boolean hasMoved = false;
    public Pawn(){
	displayName = "P";
    }
    public boolean canMove(){
	return true;
    }	
}
