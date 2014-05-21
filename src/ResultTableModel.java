import javax.swing.table.AbstractTableModel;

/**
 * Created by Платон on 20.05.2014.
 */
public class ResultTableModel extends AbstractTableModel {


    public ResultTableModel() {

    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return KMTUser.getSearchDeph();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
}
