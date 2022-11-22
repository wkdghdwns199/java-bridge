package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    MoveCheck moveCheck;
    MoveStatus moveStatus = new MoveStatus();
    private boolean availableToMove;
    public List<List<String>> statusMap = null;

    public BridgeGame (List<String> bridge){
        this.bridge = bridge;
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<List<String>> move(int moveValue, String moves){
        moveCheck = new MoveCheck(bridge);
        availableToMove = moveCheck.checkIfAvailableToMove(moveValue,moves);
        statusMap = moveStatus.printMoves(moves,availableToMove);
        return statusMap;
    }
    public boolean getAvailableToMove(){
        return availableToMove;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String readCommand){
        if (readCommand.equals("R")) {
            return true;
        }
        return false;
    }
}
