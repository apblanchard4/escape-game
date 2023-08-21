package escape;

import escape.required.GameStatus;
import escape.required.Rule;
import escape.required.Rule.RuleID;

import java.util.Map;

public class RuleManager {
    private Map<RuleID, Rule> ruleDescriptorMap;

    public RuleManager() {
        this.ruleDescriptorMap = null;
    }
    public RuleManager(Map<RuleID, Rule> ruleDescriptorMap) {
        this.ruleDescriptorMap = ruleDescriptorMap;
    }
    /**
     * checks the given rule
     *
     * @return value, -1 if no turn limit
     */
    public int checkRule(RuleID ruleID) {
        if (ruleDescriptorMap != null) {
            Rule limit = this.ruleDescriptorMap.get(ruleID);
            if (limit != null) return limit.getIntValue();
        }
        return -1;
    }

    public boolean checkGameEnd(EscapeGameManagerImpl gameManager) {

        int limit = checkRule(RuleID.TURN_LIMIT);
        int score = checkRule(RuleID.SCORE);
        if (checkPlayer(gameManager.getPlayers(), gameManager.turn)) return true;
        if (limit == -1 && score == -1)
            return false;

        if (limit == -1) {
           return checkScore(gameManager, score);
        }

        if (score == -1) {
            if (limit <= ((gameManager.turn) / 2)) {  //divide by 2 since 1 turn means each player moved
                return true;
            }
        }
        else if (checkScore(gameManager, score) || limit <= ((gameManager.turn) / 2)) {
            return true;
        }
        return false;
    }

    public GameStatus.MoveResult getMoveResult(PlayerInfo[] playerInfo, int playerTurn) {
        GameStatus.MoveResult moveResult = GameStatus.MoveResult.NONE;
        if (playerInfo[playerTurn].getScore() > playerInfo[(playerTurn + 1) % 2].getScore()) {
            moveResult = GameStatus.MoveResult.WIN;
        } else if (playerInfo[playerTurn].getScore() < playerInfo[(playerTurn + 1) % 2].getScore())
            moveResult = GameStatus.MoveResult.LOSE;
        else
            moveResult = GameStatus.MoveResult.DRAW;

        return moveResult;
    }

    public boolean checkScore(EscapeGameManagerImpl gameManager, int score) {
        if (gameManager.getPlayers()[(gameManager.turn+1) % 2].getScore() >= score) {
            return true;
        }
        return false;
    }

    /**
     * Check if player has cleared all pieces
     * @param playerInfos
     * @param turn
     * @return
     */
    public boolean checkPlayer(PlayerInfo[] playerInfos, int turn) {
        if (playerInfos[(turn+1)%2].getPieces() ==0) {
            return true;
        }

        return false;
    }
}
