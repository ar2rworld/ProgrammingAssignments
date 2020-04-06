package application;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application{
	static int time=0;
	static int userNMines;
	static boolean timerStatus=true;
	static boolean gameOver = false;
	static boolean firstClick = true;
	static CustomPane rcp;
	static Label timeLBL= new Label(String.valueOf(time));//u can update lable to change time on form
	static Label minesLBL;
	static char[][] ar;
	static char[][] ar2;
	private Timeline animation;
	static faceButton tb;
	static int rows = 8, cols = 8, mines = 10;
	public static void main(String[] args) {
		launch(args);
	}
	public void start(Stage theStage) {
		
		userNMines = mines;
		minesLBL = new Label(String.valueOf(mines));
		GridPane gp = new GridPane();
		XOButton[][] buttons = new XOButton[rows][cols];
		HBox levelsButtons = new HBox();
		levelsButtons.setAlignment(Pos.CENTER);
		CButton beginner = new CButton("Beginner");
		beginner.setOnMouseClicked(e->{
			rows = 8;cols = 8;mines = 10;
			start(theStage);
		});
		CButton intermediate = new CButton("Intermediate");
		intermediate.setOnMouseClicked(e->{
			rows = 16;cols = 16;mines = 40;
			start(theStage);
		});
		CButton expert = new CButton("Expert");
		expert.setOnMouseClicked(e->{
			rows = 32;cols = 16;mines = 99;
			start(theStage);
		});
		levelsButtons.getChildren().addAll(beginner, intermediate, expert);
		//my things
		animation = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
			time+=1;
			timeLBL.setText(String.valueOf(time));
		}));
		animation.setCycleCount(Timeline.INDEFINITE);
		
		BorderPane pane = new BorderPane();//ShowBorderPane.java
		BorderPane paneTop = new BorderPane();//ShowBorderPane.java
		StackPane paneCenter = new StackPane();
		CustomPane lcp = new CustomPane("");
		lcp.getChildren().add(minesLBL);
		tb = new faceButton(paneCenter.getHeight());
		tb.setOnMouseClicked(e -> {
			time = 0;
			timeLBL.setText(String.valueOf(time));
			animation.stop();
			firstClick = true;
			start(theStage);
		});
		tb.setGraphic(tb.imSmile);
		paneCenter.getChildren().add(tb);
		paneTop.setCenter(paneCenter);
		paneTop.setLeft(lcp);
		paneTop.setTop(levelsButtons);
		rcp = new CustomPane("");
		rcp.getChildren().add(timeLBL);
		paneTop.setRight(rcp);
		pane.setTop(paneTop);
		pane.setBottom(gp);
		
		createTables(rows,cols,mines);
		
		for(int y = 0; y < rows; y++) {
			for(int x = 0; x < cols; x++) {
				buttons[y][x] = new XOButton(new Point(y, x));
				XOButton b = buttons[y][x];				
				b.setOnMouseClicked(e -> {
					animation.play();
					if(e.getButton().equals(MouseButton.SECONDARY)) {
						System.out.println("// " + b.state);
						if(b.state == 0 || b.state >= 100) {
							if(b.state < 100) {
								b.state = 101;
							}else if(b.state == 101) {
								b.state = 0;
							}else {
								b.state = 101;}
							if(b.state == 101) {
								b.setGraphic(b.imFlag);
								userNMines -= 1;
								ar[b.p.y][b.p.x] =  'f';
								minesLBL.setText(String.valueOf(userNMines));
							}
							else {
								b.setGraphic(b.imageCover);
								if(ar2[b.p.y][b.p.x] == 'm')
									ar[b.p.y][b.p.x] =  'm';
								else
									ar[b.p.y][b.p.x] = ' ';
								userNMines += 1;
								minesLBL.setText(String.valueOf(userNMines));
							}
						}
					}else {
						if(ar[b.p.y][b.p.x] != 'f' ) {
							while(getNofObjsAround(b.p.y, b.p.x, ar, 'm') != 0 && firstClick) {
								//System.out.println("New table");
								createTables(rows, cols, mines);
							}
							firstClick=false;
							recursion(buttons,ar, b.p.y, b.p.x);
							//recursion2(buttons,ar, b.p.y, b.p.x);
							b.state = getNofObjsAround(b.p.y, b.p.x,ar2, 'm')+10;
							if(checkMine(ar, b.p.y,b.p.x)) {
								animation.stop();
								stopGameUncoverMines(buttons,ar);
								b.state = 9;
							}else {
								if(ar[b.p.y][b.p.x]== 'c') {
									int mines = getNofObjsAround(b.p.y, b.p.x,ar2,'m');
									int flags = getNofObjsAround(b.p.y, b.p.x,ar,'f');
									if(mines == flags) {
										//System.out.println("mines == flags");
										boolean tempGG = uncoverNotMines(buttons,  ar,ar2  , b.p.y, b.p.x);
										if(tempGG) {
											animation.stop();
											tb.setGraphic(tb.imDead);
										}
									}
								}
								ar[b.p.y][b.p.x] = 'c';
							}
							//
						}
					}
					switch(b.state) {
					case 0:
						b.setGraphic(b.imageCover);
						break;
					case 100:
						b.setGraphic(b.imageCover);
						break;
					case 101:
						b.setGraphic(b.imFlag);
						break;
					case 1:
						b.setGraphic(b.imageX);
						break;
					case 2:
						b.setGraphic(b.imageO);
						break;
					case 3:
						b.setGraphic(b.mineGrey);
						break;
					case 9:
						b.setGraphic(b.mineRed);
						tb.setGraphic(tb.imDead);
						break;
					case 10:
						b.setGraphic(b.im0);
						break;
					case 11:
						b.setGraphic(b.im1);
						break;
					case 12:
						b.setGraphic(b.im2);
						break;
					case 13:
						b.setGraphic(b.im3);
						break;
					case 14:
						b.setGraphic(b.im4);
						break;
					case 15:
						b.setGraphic(b.im5);
						break;
					case 16:
						b.setGraphic(b.im6);
						break;
					case 17:
						b.setGraphic(b.im7);
						break;
					case 18:
						b.setGraphic(b.im8);
						break;
					}
					if(checkBoard()) {
						tb.setGraphic(tb.imWin);
						animation.stop();
						for(int i=0;i<ar.length;i++) {
							for(int j=0;j<ar[0].length;j++) {
									buttons[i][j].setDisable(true);
							}	
						}
					}
					for(int i=0;i<ar.length;i++) {
						for(int j=0;j<ar[0].length;j++) {
							System.out.print(ar[i][j]+ " ");
						}
						System.out.println();
					}
					/*for(int i=0;i<ar.length;i++) {
						for(int j=0;j<ar[0].length;j++) {
							System.out.print(buttons[i][j].state+ " ");
						}
						System.out.println();
					}*/
					System.out.println();
				});
				gp.add(b, x, y);
			}
		}
		
		theStage.setScene(new Scene(pane));
		theStage.show();
	}
public static void recursion(XOButton[][] buttons,char[][] ar, int y, int x) {
	if (x < 0 || x >= ar[0].length || y < 0 || y >= ar.length) return;
	
	if(getNofObjsAround(y,x, ar,'m') == 0  && ar[y][x] !='c' && ar[y][x] != 'm') {
		buttons[y][x].setGraphic(buttons[y][x].im0);
		ar[y][x] = 'c';
		recursion(buttons, ar, y+1, x+1);
		recursion(buttons, ar, y+1, x);
		recursion(buttons, ar, y+1, x-1);
		recursion(buttons, ar, y-1, x+1);
		recursion(buttons, ar, y-1, x);
		recursion(buttons, ar, y-1, x-1);
		recursion(buttons, ar, y, x+1);
		recursion(buttons, ar, y, x-1);
	}else if(getNofObjsAround(y,x, ar,'m') >=0 && ar[y][x] != 'm'){
		ar[y][x] = 'c';
		buttons[y][x].setImNumber(getNofObjsAround(y,x, ar,'m'));
	}
	return;
}

public static void recursion2(XOButton[][] buttons,char[][] ar, int y, int x) {
	if (x < 0 || x >= ar[0].length || y < 0 || y >= ar.length) return;
	
	if(getNofObjsAround(y,x, ar,'m') == 0  && ar[y][x] =='c' && ar[y][x] != 'm') {
		buttons[y][x].setGraphic(buttons[y][x].im0);
		ar[y][x] = 'c';
		ar[y+1][x+1] = 'c';
		ar[y+1][x] = 'c';
		ar[y+1][x-1] = 'c';
		ar[y-1][x+1] = 'c';
		ar[y-1][x] = 'c';
		ar[y-1][x-1] = 'c';
		ar[y][x+1] = 'c';
		ar[y][x-1] = 'c';
		buttons[y+1][x+1].setImNumber(getNofObjsAround(y,x, ar,'m'));
		buttons[y+1][x].setImNumber(getNofObjsAround(y,x, ar,'m'));
		buttons[y+1][x-1].setImNumber(getNofObjsAround(y,x, ar,'m'));
		buttons[y-1][x+1].setImNumber(getNofObjsAround(y,x, ar,'m'));
		buttons[y-1][x].setImNumber(getNofObjsAround(y,x, ar,'m'));
		buttons[y-1][x-1].setImNumber(getNofObjsAround(y,x, ar,'m'));
		buttons[y][x+1].setImNumber(getNofObjsAround(y,x, ar,'m'));
		buttons[y][x-1].setImNumber(getNofObjsAround(y,x, ar,'m'));
		recursion2(buttons, ar, y+1, x+1);
		recursion2(buttons, ar, y+1, x);
		recursion2(buttons, ar, y+1, x-1);
		recursion2(buttons, ar, y-1, x+1);
		recursion2(buttons, ar, y-1, x);
		recursion2(buttons, ar, y-1, x-1);
		recursion2(buttons, ar, y, x+1);
		recursion(buttons, ar, y, x-1);
	}
	return;
}
public static void createTables(int rows, int cols, int mines) {
	ar = createTableOfMines(rows,cols, mines);
	ar2 = new char[ar.length][ar[0].length];
	for(int i=0;i<ar.length;i++) {
		for(int j=0;j<ar[i].length;j++) {
			ar2[i][j] = ar[i][j];
		}	
	}
}
public static void stopGameUncoverMines(XOButton[][] buttons,char[][] ar) {
		for(int i=0;i<ar.length;i++) {
			for(int j=0;j<ar[0].length;j++) {
				if(ar[i][j] == 'm') {
					buttons[i][j].state = 3;
					buttons[i][j].setGraphic(buttons[i][j].mineGrey);
				}
					buttons[i][j].setDisable(true);
			}	
		}
		tb.setGraphic(tb.imDead);
	}
	public static boolean checkBoard() {
		boolean out = false;
		q: for(int i=0;i<ar.length;i++) {
			for(int j=0;j<ar[i].length;j++) {
				if(ar[i][j] != ' ') {
					if(i==ar.length-1 && j==ar[i].length-1) {
						out = true;
					}
				}else {
					break q;
				}
			}
		}
		return out;
	}
	public static boolean uncoverNotMines(XOButton[][] buttons,char[][] ar,char[][] ar2, int y, int x) {
		//in case of flags == mines uncover mines by changing chars 'c'
		//buttons[y+1][x].setGraphic(buttons[y+1][x].mineRed);
		boolean out = false;
		if(x >= 1 && x < ar[0].length-1) {
			if(y>=1 && y< ar.length-1) {
				for(int i = y-1; i<y+2;i++) {
					for(int j = x-1; j<x+2;j++) {
						if(ar[i][j] == ' ') {
							ar[i][j] = 'c';
							buttons[i][j].setImNumber(getNofObjsAround(i, j, ar2, 'm'));
							buttons[i][j].state = getNofObjsAround(i, j, ar2, 'm');
						}else if(ar[i][j] == 'm') {
							stopGameUncoverMines(buttons, ar);
							buttons[i][j].state = 9;
							buttons[i][j].setGraphic(buttons[i][j].mineRed);
							out = true;
						}
					}
				}
			}
		}
		if(y==0) {
			if(x>0 && x<ar[0].length-1) {
				for(int i = 0; i<y+2;i++) {
					for(int j = x-1; j<x+2;j++) {
						if(ar[i][j] == ' ') {
							ar[i][j] = 'c';
							buttons[i][j].setImNumber(getNofObjsAround(i, j, ar2, 'm'));
							buttons[i][j].state = getNofObjsAround(i, j, ar2, 'm');
						}else if(ar[i][j] == 'm') {
							stopGameUncoverMines(buttons, ar);
							buttons[i][j].state = 9;
							buttons[i][j].setGraphic(buttons[i][j].mineRed);
							out = true;
						}
					}
				}
			}
			if(x==0) {
				for(int i = 0; i<y+2;i++) {
					for(int j = 0; j<x+2;j++) {
						if(ar[i][j] == ' ') {
							ar[i][j] = 'c';
							buttons[i][j].setImNumber(getNofObjsAround(i, j, ar2, 'm'));
							buttons[i][j].state = getNofObjsAround(i, j, ar2, 'm');
						}else if(ar[i][j] == 'm') {
							stopGameUncoverMines(buttons, ar);
							buttons[i][j].state = 9;
							buttons[i][j].setGraphic(buttons[i][j].mineRed);
							out = true;
						}
					}
				}
			}else if(x == ar[0].length - 1) {
				for(int i = 0; i<2;i++) {
					for(int j = x-1; j<ar[0].length;j++) {
						if(ar[i][j] == ' ') {
							ar[i][j] = 'c';
							buttons[i][j].setImNumber(getNofObjsAround(i, j, ar2, 'm'));
							buttons[i][j].state = getNofObjsAround(i, j, ar2, 'm');
						}else if(ar[i][j] == 'm') {
							stopGameUncoverMines(buttons, ar);
							buttons[i][j].state = 9;
							buttons[i][j].setGraphic(buttons[i][j].mineRed);
							out = true;
						}
					}
				}
			}
		}else if(y == ar.length -1) {
			if(x>0 && x<ar[0].length-1) {
				for(int i = y-1; i<=y;i++) {
					for(int j = x-1; j<x+2;j++) {
						if(ar[i][j] == ' ') {
							ar[i][j] = 'c';
							buttons[i][j].setImNumber(getNofObjsAround(i, j, ar2, 'm'));
							buttons[i][j].state = getNofObjsAround(i, j, ar2, 'm');
						}else if(ar[i][j] == 'm') {
							stopGameUncoverMines(buttons, ar);
							buttons[i][j].state = 9;
							buttons[i][j].setGraphic(buttons[i][j].mineRed);
							out = true;
						}
					}
				}
			}
			if(x==0) {
				for(int i = y-1; i<=y;i++) {
					for(int j = 0; j<2;j++) {
						if(ar[i][j] == ' ') {
							ar[i][j] = 'c';
							buttons[i][j].setImNumber(getNofObjsAround(i, j, ar2, 'm'));
							buttons[i][j].state = getNofObjsAround(i, j, ar2, 'm');
						}else if(ar[i][j] == 'm') {
							stopGameUncoverMines(buttons, ar);
							buttons[i][j].state = 9;
							buttons[i][j].setGraphic(buttons[i][j].mineRed);
							out = true;
						}
					}
				}
			}else if(x == ar[0].length - 1) {
				for(int i = y-1; i<=y;i++) {
					for(int j = x-1; j<=x;j++) {
						if(ar[i][j] == ' ') {
							ar[i][j] = 'c';
							buttons[i][j].setImNumber(getNofObjsAround(i, j, ar2, 'm'));
							buttons[i][j].state = getNofObjsAround(i, j, ar2, 'm');
						}else if(ar[i][j] == 'm') {
							stopGameUncoverMines(buttons, ar);
							buttons[i][j].state = 9;
							buttons[i][j].setGraphic(buttons[i][j].mineRed);
							out = true;
						}
					}
				}
			}
		}
		if(x == 0) {
			if(y>0 && y<ar.length-1) {
				for(int i = y-1; i<y+2;i++) {
					for(int j = 0; j<2;j++) {
						if(ar[i][j] == ' ') {
							ar[i][j] = 'c';
							buttons[i][j].setImNumber(getNofObjsAround(i, j, ar2, 'm'));
							buttons[i][j].state = getNofObjsAround(i, j, ar2, 'm');
						}else if(ar[i][j] == 'm') {
							stopGameUncoverMines(buttons, ar);
							buttons[i][j].state = 9;
							buttons[i][j].setGraphic(buttons[i][j].mineRed);
							out = true;
						}
					}
				}
			}
		}else if(x == ar[0].length-1) {
			if(y>0 && y<ar.length-1) {
				for(int i = y-1; i<y+2;i++) {
					for(int j = x-1; j<=x;j++) {
						if(ar[i][j] == ' ') {
							ar[i][j] = 'c';
							buttons[i][j].setImNumber(getNofObjsAround(i, j, ar2, 'm'));
							buttons[i][j].state = getNofObjsAround(i, j, ar2, 'm');
						}else if(ar[i][j] == 'm') {
							stopGameUncoverMines(buttons, ar);
							buttons[i][j].state = 9;
							buttons[i][j].setGraphic(buttons[i][j].mineRed);
							out = true;
						}
					}
				}
			}
		}
		return out;
	}
	public static char[][] createTableOfMines(int y, int x, int nOfMines) {
		//still has duplicates
		char[][] ar = new char[y][x];
		int m = 0;
		for(int i=0;i<ar.length; i++) {
			for(int j=0;j<ar[i].length; j++) {
				if(ar[i][j] == 'm')
					m+=1;
				else
					ar[i][j] = ' ';
			}
		}
		int n = 0;
		while(n != nOfMines) {
			int ti = (int)(Math.random() * ar.length), tj = (int)(Math.random() * ar[0].length);
			if(ar[ti][tj] != 'm') {
				ar[ti][tj] = 'm';
				n+=1;
			}
		}
		for(int i=0;i<ar.length; i++) {
			for(int j=0;j<ar[i].length; j++) {
				if(ar[i][j] == 'm')
					m+=1;
				else
					ar[i][j] = ' ';
			}
		}
		return ar;
	}
	public static boolean checkMine(char[][] ar,int y, int x) {
		return ar[y][x] == 'm';
	}
	public static int getNofObjsAround(int y, int x,char[][] ar,char c) {//counts n of chars on the board 
		int sum=0;
		if(x >= 1 && x < ar[0].length-1) {
			if(y>=1 && y< ar.length-1) {
				for(int i = y-1; i<y+2;i++) {
					for(int j = x-1; j<x+2;j++) {
						if(ar[i][j]==c) 
							sum +=1;
					}
				}
				return sum;
			}
		}
		if(y==0) {
			if(x>0 && x<ar[0].length-1) {
				if(ar[y][x-1]==c)
					sum++;
				if(ar[y+1][x-1] == c)
					sum++;
				if(ar[y+1][x] == c)
					sum++;
				if(ar[y][x+1] == c)
					sum++;
				if(ar[y+1][x+1] == c)
					sum++;
				return sum;
			}
			if(x==0) {
				if(ar[0][1] == c)
					sum ++;
				if(ar[1][0] == c)
					sum ++;
				if(ar[1][1] == c)
					sum ++;
				return sum;
			}else if(x == ar[0].length - 1) {
				if(ar[0][ar[0].length-2] == c)
					sum++;
				if(ar[1][ar[0].length-2] == c)
					sum++;
				if(ar[1][ar[0].length-1] == c)
					sum++;
				return sum;
			}
		}else if(y == ar.length -1) {
			if(x>0 && x<ar[0].length-1) {
				if(ar[y][x-1]==c)
					sum++;
				if(ar[y-1][x-1] == c)
					sum++;
				if(ar[y-1][x] == c)
					sum++;
				if(ar[y][x+1] == c)
					sum++;
				if(ar[y-1][x+1] == c)
					sum++;
				return sum;
			}
			if(x==0) {///
				if(ar[ar.length-2][0] == c)
					sum ++;
				if(ar[ar.length-2][1] == c)
					sum ++;
				if(ar[ar.length-1][1] == c)
					sum ++;
				return sum;
			}else if(x == ar[0].length - 1) {
				if(ar[ar.length-2][ar[0].length-1] == c)
					sum++;
				if(ar[ar.length-2][ar[0].length-2] == c)
					sum++;
				if(ar[ar.length-1][ar[0].length-2] == c)
					sum++;
				return sum;
			}
		}
		if(x == 0) {
			if(y>0 && y<ar.length-1) {
				if(ar[y-1][x] == c)
					sum++;
				if(ar[y-1][x+1] == c)
					sum++;
				if(ar[y][x+1] == c)
					sum++;
				if(ar[y+1][x+1] == c)
					sum++;
				if(ar[y+1][x] == c)
					sum++;
				return sum;
			}
		}else if(x == ar[0].length-1) {
			if(y>0 && y<ar.length-1) {
				if(ar[y-1][x] == c)
					sum++;
				if(ar[y-1][x-1] == c)
					sum++;
				if(ar[y][x-1] == c)
					sum++;
				if(ar[y+1][x-1] == c)
					sum++;
				if(ar[y+1][x] == c)
					sum++;
				return sum;
			}
		}
		return sum;
	}
	public static boolean checkPoint(ArrayList<Point> al, Point p) {
		boolean out = false;
		for(int i=0; i<al.size(); i++) {
			if(p.x == al.get(i).x && p.y == al.get(i).y) {
				out = true;
				break;
			}
		}
		return out;
	}
}
class Point{
	public int x,y;
	public Point(int y, int x) {
		this.x = x;
		this.y = y;
	}
}
class CButton extends Button{
	public CButton(String s) {
		setPadding(new Insets(10,10,10,10));
		setText(s);
	}
}
class faceButton extends Button{
	int state = 0;//0-smile, 1-o, 2-dead, 3-win
	ImageView imSmile, imO, imDead, imWin,imCover ;
	public faceButton(double size) {
		imSmile = new ImageView(new Image("file:res/face-smile.png"));
		imO = new ImageView(new Image("file:res/face-O.png"));
		imDead= new ImageView(new Image("file:res/face-dead.png"));
		imWin = new ImageView(new Image("file:res/face-win.png"));
		imCover = new ImageView(new Image("file:res/cover.png"));
		imSmile.setFitWidth(size);
		imSmile.setFitHeight(size);
		setGraphic(imCover);
	}
	
}
class XOButton extends Button{
	int state; //0 means blank, 1 means X, 2 means O
	ImageView imageCover, imageX, imageO, mineRed, mineGrey,faceSmile;
	ImageView im0, im1, im2, im3, im4, im5, im6, im7, im8,imFlag;
	public Point p;
	public XOButton(Point p) {
		state = 0;
		this.p = p;
		double size = 30;
		setMinWidth(size);
		setMaxWidth(size);
		setMinHeight(size);
		setMaxHeight(size);
		faceSmile = new ImageView(new Image("file:res/face-smile.png"));
		mineRed= new ImageView(new Image("file:res/mine-red.png"));
		imageCover = new ImageView(new Image("file:res/cover.png"));
		imageX = new ImageView(new Image("file:res/X.png"));
		imageO = new ImageView(new Image("file:res/O.png"));
		im0 = new ImageView(new Image("file:res/0.png"));
		im1 = new ImageView(new Image("file:res/1.png"));
		im2 = new ImageView(new Image("file:res/2.png"));
		im3 = new ImageView(new Image("file:res/3.png"));
		im4 = new ImageView(new Image("file:res/4.png"));
		im5 = new ImageView(new Image("file:res/5.png"));
		im6 = new ImageView(new Image("file:res/6.png"));
		im7 = new ImageView(new Image("file:res/7.png"));
		im8 = new ImageView(new Image("file:res/8.png"));
		mineGrey = new ImageView(new Image("file:res/mine-grey.png"));
		imFlag = new ImageView(new Image("file:res/flag.png"));
		imageCover.setFitWidth(size);
		imageCover.setFitHeight(size);
		
		imageX.setFitWidth(size);
		imageX.setFitHeight(size);
		
		imageO.setFitWidth(size);
		imageO.setFitHeight(size);
		
		setGraphic(imageCover);
	}
	public void setImNumber(int i) {
		switch(i) {
		case 0:
			setGraphic(im0);
			break;
		case 1:
			setGraphic(im1);
			break;
		case 2:
			setGraphic(im2);
			break;
		case 3:
			setGraphic(im3);
			break;
		case 4:
			setGraphic(im4);
			break;
		case 5:
			setGraphic(im5);
			break;
		case 6:
			setGraphic(im6);
			break;
		case 7:
			setGraphic(im7);
			break;
		case 8:
			setGraphic(im8);
			break;
		}
	}
}
class CustomPane extends StackPane{
	public CustomPane(String title){
		getChildren().add(new Label(title));
		setStyle("-fx-border-color:red");
		setPadding(new Insets(12,12,12,12));
	}
	public void setLabel(String s) {
		getChildren().add(new Label(s));
	}
}