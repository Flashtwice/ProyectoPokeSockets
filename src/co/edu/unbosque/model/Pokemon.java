package co.edu.unbosque.model;

import java.io.Serializable;

public class Pokemon implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int level;
    private String nickname;
    private int[] stats;
    private String[] moves;

    public Pokemon(String name, int level, String nickname, int[] stats, String[] moves) {
        this.name = name;
        this.level = level;
        this.nickname = nickname;
        this.stats = stats;
        this.moves = moves;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public String getNickname() {
        return nickname;
    }

    public int[] getStats() {
        return stats;
    }

    public String[] getMoves() {
        return moves;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setStats(int[] stats) {
        this.stats = stats;
    }

    public void setMoves(String[] moves) {
        this.moves = moves;
    }
}