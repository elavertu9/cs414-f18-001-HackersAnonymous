package com.hackersanon.banqi.main.player;

import com.hackersanon.banqi.main.piece.TeamColor;

public class Player {
    private TeamColor team;

    public Player(TeamColor color){
        this.team = color;
    }

    public TeamColor getPlayerTeam(){
        return team;
    }
}
