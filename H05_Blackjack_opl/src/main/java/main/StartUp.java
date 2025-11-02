package main;

import cui.BlackjackApplicatie;
import domein.DomeinController;

public class StartUp {

	public static void main(String[] args) {
		BlackjackApplicatie blackjackApp = new BlackjackApplicatie(new DomeinController());
		blackjackApp.startBlackjack();
	}
}
