public class Pawn extends Piece{//class for pawn
    public boolean hasMoved = false;
    public Pawn(){
	displayName = "P";
	white = true;
    }
    public Pawn(int a){
	displayName = "P";
	white = false;
    }
    public boolean getWhite(){
	return white;
    }
    public String getDisplayName(){
	return displayName;
    }
    public boolean canMove(int x1, int y1, int x2, int y2){
	return true;
    }	
}
