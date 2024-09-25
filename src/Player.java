public abstract class Player {
    char mark;
    public Player(char mark) {
        this.mark = mark;
    }
    public abstract int returnMove(Board board);
}
