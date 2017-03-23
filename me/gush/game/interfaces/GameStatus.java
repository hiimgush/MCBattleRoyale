package me.gush.game.interfaces;

public enum GameStatus {
	Setup,
	Waiting,//Sitting in the lobby, hasnt reached the minimum number of player
	Starting,//Game has reached minimum number of players and the countdown has begun
	InGame,//Countdown as ended and start() was called
	Ending;//There is only one team left and we have a winner
	
}
