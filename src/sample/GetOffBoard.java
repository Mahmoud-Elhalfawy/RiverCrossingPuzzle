package sample;

public class GetOffBoard implements Command {
    Move move;
    public GetOffBoard (Move move){
        this.move=move;
    }
    @Override
    public void execute() {
        move.getOff();
    }

}
