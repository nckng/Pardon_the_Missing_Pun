public class Queen extends Piece{
    public Queen(){
	displayName = "Q";
	white = true;
    }
    public Queen(int b){
	displayName = "Q";
	white = false;
    }
    public boolean getWhite(){
	return white;
    }
    public boolean canMove(int x1, int y1, int x2, int y2){
	if ((x2 == x1) && (y2 == y1)){
	    return false;
	}
	else if((((x1-x2)==(y2-y1))||((x1-x2)==(y1-y2)))  ||  (((x2!=x1)&&(y2==y1)) || ((x2==x1)&&(y1 !=y2)))){
	    return true;
	}
	else{
	    return false;
	}
    }
}
