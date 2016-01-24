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
	if ((x2 == x1) && (y2 == y1)){
	    return false;
	}
	else if (((x1-x2)==(y2-y1))||((x1-x2)==(y1-y2))){
	    return true;
	}
	else{
	    return false;
	}
    }
}
