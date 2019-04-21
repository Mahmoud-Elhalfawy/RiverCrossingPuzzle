package sample;

public class GetOnBoard implements Command {
    Move move ;
    public GetOnBoard (Move move){
        this.move=move;
    }
    @Override
    public void execute() {
        move.getOn();
    }
}
