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
	else if((((x1 - x2) == (y2 - y1))||((x1 - x2) == (y1 - y2)))  ||
		(((x2 != x1)&&(y2 == y1)) || ((x2 == x1)&&(y1 != y2)))){
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
	    if((x2 > x1)&&(y2 == y1)){
		for(int i = x1 + 1; i < x2; i++){
		    if (!(Chess.isEmpty(i, y2))){
			return false;
		    }
		}
		return true;
	    }
	    if((x2 < x1)&&(y2 == y1)){
		for(int i = x2 + 1; i < x1; i++){
		    if (!(Chess.isEmpty(i, y2))){
			return false;
		    }
		}
		return true;
	    }
	    if((x2 == x1)&&(y2 > y1)){
		for(int i = y1 + 1; i < y2; i++){
		    if(!(Chess.isEmpty(x2, i))){
			return false;
		    }
		}
		return true;
	    }
	    if((x2 == x2)&&(y2 < y1)){
		for(int i = y2 + 1; i < y1; i++){
		    if(!(Chess.isEmpty(x2, i))){
			return false;
		    }
		}
		return true;
	    }
	    
	}
	return false;
    }
}
