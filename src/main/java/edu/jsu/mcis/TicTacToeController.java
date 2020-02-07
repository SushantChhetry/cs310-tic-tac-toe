package edu.jsu.mcis;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class TicTacToeController implements ActionListener {

    private final TicTacToeModel model;
    private final TicTacToeView view;

    public TicTacToeController(int width) {
        
    	model = new TicTacToeModel(width);
        view = new TicTacToeView(this, width);
        
    }
    
    public String getMarkAsString(int row, int col) {
        
        return (model.getMark(row, col).toString());
        
    }
    
    public TicTacToeView getView() {
        
        return view;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        
        String name = ((JButton) event.getSource()).getName();
        
        int row = Integer.parseInt(name.substring(6,7));
        int col = Integer.parseInt(name.substring(7));
        
        
        model.makeMark(row, col);
        
        view.updateSquares();
        
        TicTacToeModel.Result result = model.getResult();
        
        if (result != TicTacToeModel.Result.NONE) {

            view.disableSquares();
            view.showResult(result.toString());
            
        }
        
        else {
            
            view.clearResult();
            
        }

    }
    
}