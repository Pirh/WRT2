package com.optimism.wrt.game.wormhole.components;

import com.artemis.Component;


public class Team extends Component {

	public static final Team TEAM0 = new Team(0);	// The enemy team
	public static final Team TEAM1 = new Team(1);	// The player / first player
	public static final Team TEAM2 = new Team(2);	// A second player?
	
	
	public int teamNumber;
	
	public Team(int teamNumber) {
		this.teamNumber = teamNumber;
	}
	
}
