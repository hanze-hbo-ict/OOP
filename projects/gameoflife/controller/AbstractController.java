package gameoflife.controller;

import javax.swing.*;

import gameoflife.logic.*;

public abstract class AbstractController extends JPanel {

	protected LifeLogic life;
	
	public AbstractController(LifeLogic life) {
		this.life=life;
	}
}
