package main;

import cui.BlackjackApp;
import domein.DomeinController;

public class StartUp {

	public static void main(String[] args) {
		BlackjackApp blackjackApp = new BlackjackApp(new DomeinController());
		blackjackApp.startBlackjack();
	}
}
