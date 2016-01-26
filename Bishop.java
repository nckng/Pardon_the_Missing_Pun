public class Bishop extends Piece{
    public Bishop(){
	displayName = "\033[37mB";
	white = true;
    }
    public Bishop(int b){
	displayName = "\033[30B";
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
	else if (((x1 - x2) == (y2 - y1))||((x1 - x2) == (y1 - y2))){
	    if((x1 > x2)&&(y1 > y2)){
		for(int i = 1; i < (x1 - x2); i++){
		    if(!(Chess.isEmpty((x1 - i), (y1 - i)))){
			return false;
		    }
		}
		return true;
	    }
	    if((x1 > x2)&&(y1 < y2)){
		for(int i = 1; i < (x1 - x2); i++){
		    if(!(Chess.isEmpty((x1 - i), (y1 + i)))){
			return false;
		    }
		}
		return true;
	    }
	    if((x1 < x2)&&(y1 > y2)){
		for(int i = 1; i < (x2 - x1); i++){
		    if(!(Chess.isEmpty((x1 + i), (y1 - i)))){
			return false;
		    }
		}
		return true;
	    }
	    if((x1 < x2)&&(y1 < y2)){
		for(int i = 1; i < (x2 - x1); i++){
		    if(!(Chess.isEmpty((x1 + i), (y1 + i)))){
			return false;
		    }
		}
		return true;
	    }
	}
	return false;
    }
}

