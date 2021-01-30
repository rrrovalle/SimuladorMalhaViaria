package view;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import controller.FrameController;
import controller.observer.Observer;

import java.awt.*;

public class Road extends JPanel implements Observer {


    class CellModel extends AbstractTableModel{

        @Override
        public int getRowCount() {
            return fc.getMatrixManager().getRows();
        }

        @Override
        public int getColumnCount() {
            return fc.getMatrixManager().getCols();
        }

        @Override
        public Object getValueAt(int row, int col) {
            return fc.renderCell(row, col);
        }

    }

    class CellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table,
                                                       Object value,
                                                       boolean isSelected,
                                                       boolean hasFocus,
                                                       int row,
                                                       int col) {
            setIcon((ImageIcon) value);

            return this;
        }
    }

    private FrameController fc;

    private CellModel cellModel;
    private JTable cellTable;


    public Road() {
        super();

        fc = FrameController.getInstance();
        fc.attach(this);

        cellModel = new CellModel();

        initComponents();

    }

    private void initComponents() {

        cellTable = new JTable();
        cellTable.setBackground(Color.black);
        cellTable.setModel(this.cellModel);
        for (int x = 0 ; x < cellTable.getColumnModel().getColumnCount(); x++) {
            cellTable.getColumnModel().getColumn(x).setWidth(35);
//            cellTable.getColumnModel().getColumn(x).setMinWidth(35);
            cellTable.getColumnModel().getColumn(x).setMaxWidth(45);
        }
        cellTable.setRowHeight(32);
        cellTable.setShowGrid(false);

        cellTable.setDefaultRenderer(Object.class, new CellRenderer());

        add(cellTable);


    }

    @Override
    public void updateCarPosition() {

    }

}
