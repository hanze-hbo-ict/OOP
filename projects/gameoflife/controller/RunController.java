package gameoflife.controller;

import java.awt.event.*;
import javax.swing.*;

import gameoflife.exception.*;
import gameoflife.logic.*;

public class RunController extends AbstractController implements ActionListener {

	private JButton stepOne;
	private JTextField steps;
	private JButton startSteps;
	private JButton stopSteps;
	
	public RunController(LifeLogic life) {
		super(life);
		setSize(450, 50);
		stepOne=new JButton("One step");
		stepOne.addActionListener(this);
		steps=new JTextField();
		startSteps=new JButton("Start");
		startSteps.addActionListener(this);
		stopSteps=new JButton("Stop");
		stopSteps.addActionListener(this);
		
		this.setLayout(null);
		add(stepOne);
		add(steps);
		add(startSteps);
		add(stopSteps);
		stepOne.setBounds(50, 10, 70, 30);
		steps.setBounds(140, 10, 70, 30);
		startSteps.setBounds(229, 10, 70, 30);
		stopSteps.setBounds(319, 10, 70, 30);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==stepOne) {
			try {
				life.doStep();
			} catch (LifeException ex) {
				ex.printStackTrace();
			}
			return;
		}
		
		if (e.getSource()==startSteps) {
			try {
				int steps=parseSteps();				
				if (steps<1 || steps>1000) throw new LifeException("Illegal number of steps");
				life.doSteps(steps);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return;
		}
		
		if (e.getSource()==stopSteps) {
			life.stopSteps();
		}
		
	}
	
	private int parseSteps() throws NumberFormatException {
		return Integer.parseInt(steps.getText());
	}
}
