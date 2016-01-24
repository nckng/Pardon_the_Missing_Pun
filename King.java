public class King extends Piece{
    public King(){
	displayName = "K";
	white = true;
    }
    public King(int b){
	displayName = "K";
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
