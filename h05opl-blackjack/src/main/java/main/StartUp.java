package main;

import cui.BlackjackApplicatie;
import domein.DomeinController;

public class StartUp {

	void main() {
		BlackjackApplicatie blackjackApp = new BlackjackApplicatie(new DomeinController());
		blackjackApp.startBlackjack();
	}
}
