public class King extends Piece{
    public King(){
	displayName = "\033[37mK";
	white = true;
    }
    public King(int b){
	displayName = "\033[30K";
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
	else if((((x2-x1)==1)||
		((x2-x1)== -1)||
		((x2-x1)== 0))
		&&
		(((y2-y1)== -1)||
		((y2-y1)==0)||
		 ((y2-y1)==1))){
	    return true;
	}
	else{
	    return false;
	}
    }
}
