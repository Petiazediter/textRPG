package game;

public class GameEngine{
    public static void main(String[] args) {
        boolean isStart = GameMenu.callMenu();
        if (isStart){
            System.out.println("Game Started!");
            
        }
    }
}