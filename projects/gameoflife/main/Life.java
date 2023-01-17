package gameoflife.main;

import javax.swing.*;

import gameoflife.controller.*;
import gameoflife.logic.*;
import gameoflife.view.*;

public class Life {

	public static void main(String[] args) {
		LifeLogic lifelogic=new LifeLogic();
		AbstractController initController=new InitController(lifelogic);
		AbstractController runController=new RunController(lifelogic);
		AbstractView fieldView=new FieldView(lifelogic);
		AbstractView statView=new StatView(lifelogic);
		
		JFrame screen=new JFrame("The Conway game of Life");
		screen.setSize(540, 285);
		screen.setResizable(false);
		screen.setLayout(null);
		screen.getContentPane().add(fieldView);
		screen.getContentPane().add(statView);
		screen.getContentPane().add(runController);
		screen.getContentPane().add(initController);
		fieldView.setBounds(10, 10, 200, 200);
		statView.setBounds(230, 10, 200, 200);
		runController.setBounds(0, 210, 450, 50);
		initController.setBounds(440, 10, 90, 130);
		screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		screen.setVisible(true);
	}
}
