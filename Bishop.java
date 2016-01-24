public class Bishop extends Piece{
    public Bishop(){
	displayName = "B";
	white = true;
    }
    public Bishop(int b){
	displayName = "B";
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
