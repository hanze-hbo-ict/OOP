package gameoflife.logic;

import java.util.*;

import gameoflife.exception.*;

public class LifeLogic extends AbstractModel implements Runnable {

	private static final int MIN_SIZE=10;
	private static final int MAX_SIZE=50;
	private static final float MIN_DEGREE=0.0f;
	private static final float MAX_DEGREE=1.0f;
	
	private int size;
	private boolean sizeIsSet;
	private float degree;
	private boolean degreeIsSet;
	
	private boolean initRun;
	
	private int[][] fieldOriginal;
	private int[][] fieldUnderConstruction;
	private Random r;
	
	private int numOfSteps;
	private boolean run;
	
	public LifeLogic() {
		size=MIN_SIZE-1;
		degree=MIN_DEGREE-1;
		sizeIsSet=false;
		degreeIsSet=false;
		r=new Random();
		run=false;
	}
	
	private void calculateRound() {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				int count=0;
				for(int k=Math.max(0, i-1);k<=Math.min(size-1, i+1);k++) {
					for(int l=Math.max(0, j-1);l<=Math.min(size-1, j+1);l++) {
						count+=fieldOriginal[k][l];
					}
				}
				if (fieldOriginal[i][j]==1) count--;
				if (count==2 || count==3) fieldUnderConstruction[i][j]=1; else fieldUnderConstruction[i][j]=0;
			}
		}
		int[][] temp=fieldOriginal;
		fieldOriginal=fieldUnderConstruction;
		fieldUnderConstruction=temp;
	}
	
	public void doStep() throws LifeException {
		if (!sizeIsSet || !degreeIsSet)
			throw new LifeException("Size and/or degree is not set yet");
		if (!initRun)
			throw new LifeException("Run init first");
		calculateRound();
		notifyViews();
	}
	
	public void doSteps(int numOfSteps) throws LifeException {
		if (!sizeIsSet || !degreeIsSet)
			throw new LifeException("Size and/or degree is not set yet");
		if (!initRun)
			throw new LifeException("Run init first");
		this.numOfSteps=numOfSteps;
		run=true;
		new Thread(this).start();
	}
	
	public int[][] getState() {
		return fieldOriginal;
	}
	
	public void randomInit() throws LifeException {
		if (!sizeIsSet || !degreeIsSet)
			throw new LifeException("Size and/or degree is not set yet");
		for(int i=0;i<size;i++)
			for(int j=0;j<size;j++)
				if (r.nextFloat()<=degree) fieldOriginal[i][j]=1; else fieldOriginal[i][j]=0;
		initRun=true;
		notifyViews();
	}
	
	@Override
	public void run() {
		for(int i=0;i<numOfSteps && run;i++) {
			calculateRound();
			notifyViews();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		run=false;
	}
	
	public void setDegree(float degree) throws LifeException {
		if (degree<MIN_DEGREE) 
			throw new LifeException("Degree too small");
		if (degree>MAX_DEGREE)
			throw new LifeException("Degree too large");
		this.degree=degree;
		degreeIsSet=true;
		initRun=false;
	}
	
	public void setSize(int size) throws LifeException {
		if (size<MIN_SIZE) 
			throw new LifeException("Size too small");
		if (size>MAX_SIZE)
			throw new LifeException("Size too large");
		this.size=size;
		sizeIsSet=true;
		fieldOriginal=new int[size][size];
		fieldUnderConstruction=new int[size][size];
		initRun=false;
	}

	public void stopSteps() {
		run=false;
	}

}
