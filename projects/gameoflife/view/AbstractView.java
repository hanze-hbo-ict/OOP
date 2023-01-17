package gameoflife.view;

import javax.swing.*;

import gameoflife.logic.*;

public abstract class AbstractView extends JPanel {

	protected LifeLogic life;

	public AbstractView(LifeLogic life) {
		this.life=life;
		life.addView(this);
	}
	
	public LifeLogic getModel() {
		return life;
	}
	
	public void updateView() {
		repaint();
	}
}
