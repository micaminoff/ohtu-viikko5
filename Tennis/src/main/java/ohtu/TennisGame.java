package ohtu;

import java.util.HashMap;
import java.util.Map;

public class TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    private Map scores;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        if (m_score1>=4 || m_score2>=4) {
            return calcAdvantageOrWin(m_score1, m_score2);
        }
        score += getScoreName(m_score1) + "-";
        if (m_score1==m_score2) {
            return score += "All";
        } else {
            return score += getScoreName(m_score2);
        }
    }
    
    private String calcAdvantageOrWin(int m_score1, int m_score2) {
        int minusResult = m_score1-m_score2;
        if (minusResult==0) return "Deuce";
        else if (minusResult==1) return "Advantage player1";
        else if (minusResult ==-1) return "Advantage player2";
        else if (minusResult>=2) return "Win for player1";
        else return "Win for player2";
    }
    
    private String getScoreName(int score) {
        switch(score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }
    }
}