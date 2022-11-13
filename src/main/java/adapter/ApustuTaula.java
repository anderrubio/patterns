package adapter;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import businesslogic.BLFacade;
import domain.ApustuAnitza;
import domain.Apustua;
import domain.Registered;
import domain.User;
import gui.MainGUI;

public class ApustuTaula extends AbstractTableModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] columnNames = {"Event","Question","Event Date", "Bet(€)"};
    private Vector<ApustuAnitza> myBets;
    public ApustuTaula(Registered r){
        myBets = r.getApustuAnitzak();
    }
    public int getColumnCount() {
        return columnNames.length;
    }
    public int getRowCount() {
        int size;
        if (myBets == null) {
            size = 0;
        }
        else {
            size = myBets.size();
        }
        return size;
    }
    public Object getValueAt(int row, int col) {
        Object temp = null;   
        for(int row2=0; row2<myBets.get(row).getApustuak().size(); row2++) {
        	if (col == 0) {
                temp = myBets.get(row).getApustuak().get(row2).getKuota().getQuestion().getEvent();
            }
            else if (col == 1) {
                temp = myBets.get(row).getApustuak().get(row2).getKuota().getQuestion();
            }
            else if (col == 2) {
                temp = myBets.get(row).getData();
            }
            else if (col == 3) {
                temp = myBets.get(row).getBalioa();
            }
        }
        return temp;
     
    }
    public String getColumnName(int col) {
        return columnNames[col];
    }
}
