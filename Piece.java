public abstract class Piece{//super class for all pieces
    public String displayName;
    public abstract void move();
    public OrderedPair location = new OrderedPair();
}
