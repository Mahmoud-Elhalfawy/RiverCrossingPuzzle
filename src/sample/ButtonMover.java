package sample;

public class ButtonMover {
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void pressButton(){
        command.execute();
    }


}
