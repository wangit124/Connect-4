package application;
import javafx.application.*;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import java.util.*;
import java.io.*;

public class connect4 extends Application
{

    
    @Override
    public void start(Stage primaryStage)
    {
        this.gameboard = new connect4_functions();
        // Create the pane that will hold all of the visual objects
        pane = new GridPane();
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setStyle("-fx-background-color: rgb(0, 0, 0)");
        // Set the spacing between the Tiles
        pane.setHgap(15); 
        pane.setVgap(15);

        Label title = new Label("Connect4");
        title.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        title.setTextFill(Color.WHITE);
        pane.add(title,0,0);
        
        //create a stackpane and an overlay pane for game over function
        parent=new StackPane();
        root= new GridPane();
        root.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        // make overlay transparent initially(238,228,218,0.73)
        root.setStyle("-fx-background-color: rgb(238, 228, 218,0.73)");
        Text gameStart=new Text("Press N to start a new game (clear the board)\n\nHint: Use keyboard numbers to place pieces in column");
        root.getChildren().add(gameStart);
        root.setAlignment(Pos.CENTER);
        //add StackPane to scene, and add scene to state, set stage title
        Scene scene= new Scene(parent,850,750);
        parent.getChildren().addAll(pane,root);   
        primaryStage.setTitle("Connect4");
        primaryStage.setScene(scene);
        primaryStage.show(); 
        
        // set the initial state of the board
        update(); 
        
        // whenever a key is presed, access meKeyHandler class and implement EventHandler
        scene.setOnKeyPressed(new myKeyHandler());
    }
    
    // Class Header: myKeyHandler class uses the interface EventHandler to help the Gui react to 
    // key preses. It also contains the handle method for key preses
    private class myKeyHandler implements EventHandler<KeyEvent> {
        //Handle method calls move methods and update methods, checks game over if up down left or
        //right key is presed
        //Parameter: The key presed
        @Override
        public void handle(KeyEvent e) { 
	    if (gameboard.check_win_or_tie()&&e.getCode()!=KeyCode.N) {
		return;
            }
            // if key pressed is available column, move respectively
            if (e.getCode()==KeyCode.DIGIT1&&!gameboard.is_column_full(1)) {
            	root.setStyle("-fx-background-color: rgb(187, 173, 160,0)");
                root.getChildren().clear();
                gameboard.update_board(gameboard.board,1,turn);
                turn=3-turn;
                pane.getChildren().clear();
                // check game over then change transparency of overlay pane
                update();
                if (gameboard.check_win_or_tie()) {
                    Text gameOver=new Text("Game Over! Press N to start a new game");
                    root.getChildren().add(gameOver);
                    root.setAlignment(Pos.CENTER);
                    root.setStyle("-fx-background-color: rgb(238,228,218,0.73)");
                    return;
                }
            }
            else if (e.getCode()==KeyCode.DIGIT2&&!gameboard.is_column_full(2)) {
             	root.setStyle("-fx-background-color: rgb(187, 173, 160,0)");
                root.getChildren().clear();  	
                gameboard.update_board(gameboard.board,2,turn); 
	        turn=3-turn;
		pane.getChildren().clear(); 
                // check game over then change transparency of overlay pane
                update();
                if (gameboard.check_win_or_tie()) {
                    Text gameOver=new Text("Game Over! Press N to start a new game");
                    root.getChildren().add(gameOver);
                    root.setAlignment(Pos.CENTER);
                    root.setStyle("-fx-background-color: rgb(238,228,218,0.73)");
                    return;
                }
            }
            else if (e.getCode()==KeyCode.DIGIT3&&!gameboard.is_column_full(3)) {
            	root.setStyle("-fx-background-color: rgb(187, 173, 160,0)");
                root.getChildren().clear();
                gameboard.update_board(gameboard.board,3,turn); 
                turn=3-turn;
 		pane.getChildren().clear(); 
                // check game over then change transparency of overlay pane
                update();
                if (gameboard.check_win_or_tie()) {
                    Text gameOver=new Text("Game Over! Press N to start a new game");
                    root.getChildren().add(gameOver);
                    root.setAlignment(Pos.CENTER);
                    root.setStyle("-fx-background-color: rgb(238,228,218,0.73)");
                    return;
                }
            }
            else if (e.getCode()==KeyCode.DIGIT4&&!gameboard.is_column_full(4)) {
            	root.setStyle("-fx-background-color: rgb(187, 173, 160,0)");
                root.getChildren().clear();
                gameboard.update_board(gameboard.board,4,turn); 
                turn=3-turn;
		pane.getChildren().clear(); 
                // check game over then change transparency of overlay pane
                update();
                if (gameboard.check_win_or_tie()) {
                    Text gameOver=new Text("Game Over! Press N to start a new game");
                    root.getChildren().add(gameOver);
                    root.setAlignment(Pos.CENTER);
                    root.setStyle("-fx-background-color: rgb(238,228,218,0.73)");
                    return;
                }
            }
            else if (e.getCode()==KeyCode.DIGIT5&&!gameboard.is_column_full(5)) {
            	root.setStyle("-fx-background-color: rgb(187, 173, 160,0)");
                root.getChildren().clear();
                gameboard.update_board(gameboard.board,5,turn); 
                turn=3-turn; 
		pane.getChildren().clear(); 
                // check game over then change transparency of overlay pane
                update();
                if (gameboard.check_win_or_tie()) {
                    Text gameOver=new Text("Game Over! Press N to start a new game");
                    root.getChildren().add(gameOver);
                    root.setAlignment(Pos.CENTER);
                    root.setStyle("-fx-background-color: rgb(238,228,218,0.73)");
                    return;
                }
            }
            else if (e.getCode()==KeyCode.DIGIT6&&!gameboard.is_column_full(6)) {
            	root.setStyle("-fx-background-color: rgb(187, 173, 160,0)");
                root.getChildren().clear();
                gameboard.update_board(gameboard.board,6,turn); 
                turn=3-turn; 
		pane.getChildren().clear(); 
                // check game over then change transparency of overlay pane
                update();
                if (gameboard.check_win_or_tie()) {
                    Text gameOver=new Text("Game Over! Press N to start a new game");
                    root.getChildren().add(gameOver);
                    root.setAlignment(Pos.CENTER);
                    root.setStyle("-fx-background-color: rgb(238,228,218,0.73)");
                    return;
                }
            }
            else if (e.getCode()==KeyCode.DIGIT7&&!gameboard.is_column_full(7)) {
            	root.setStyle("-fx-background-color: rgb(187, 173, 160,0)");
                root.getChildren().clear();
                gameboard.update_board(gameboard.board,7,turn); 
                turn=3-turn; 
		pane.getChildren().clear(); 
                // check game over then change transparency of overlay pane
                update();
                if (gameboard.check_win_or_tie()) {
                    Text gameOver=new Text("Game Over! Press N to start a new game");
                    root.getChildren().add(gameOver);
                    root.setAlignment(Pos.CENTER);
                    root.setStyle("-fx-background-color: rgb(238,228,218,0.73)");
                    return;
                }
            }
            else if (e.getCode()==KeyCode.N) {
                root.getChildren().clear();
                root.setStyle("-fx-background-color: rgb(187,173,160,0)");
                clearTiles(); 
                return;
 	    }		
	    else {
		return;
 	    }
        }
    }         
    // Update Method: updates the tile values of the game grid after each move
    private void update() {
        // store the board array
    	boardGrid=gameboard.board;
        // update the Gui each time
        Label title = new Label("Connect4");
        title.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        title.setTextFill(Color.WHITE);
        pane.add(title,0,0);
        // loop through the board array and cahnge the rectangles to their respective 
        // features based on the number in the array
        for (int i=0; i<gameboard.height;i++) {
            for (int j=0; j<gameboard.width;j++) {
            	if (boardGrid[i][j]==0) {
                    Circle thisTile = new Circle ();
                    thisTile.setRadius(50);
                    thisTile.setFill(Color.WHITE);
                    pane.add(thisTile,j,i+1);
                }
                else if (boardGrid[i][j]==2) {
                    makeTile(i,j,Color.YELLOW);
                }
                else if (boardGrid[i][j]==1) {
                    makeTile(i,j,Color.RED);
                }
	    }
        }
    }
    // Helper method to update rectangles, makeTile method sets rectangle features
    // Parameters: sets position of circle, color of tile
    private void makeTile(int x, int y, Color tileColor) {
        // Create new circle
    	Circle thisTile = new Circle ();
        thisTile.setRadius(50);
        thisTile.setFill(tileColor);
        pane.add(thisTile,y,x+1);
    }
    
    // helper method to restart board
    private void clearTiles() {
        for (int i = 0; i < gameboard.height; i++) {
            for (int j = 0; j < gameboard.width; j++) {
                boardGrid[i][j] = 0;
                Circle thisTile = new Circle();
                thisTile.setRadius(50);
                thisTile.setFill(Color.WHITE);
                pane.add(thisTile, j, i + 1);
            }
        }
    }
}


