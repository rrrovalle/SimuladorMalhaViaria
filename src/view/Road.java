package view;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import controller.Controller;
import controller.FrameController;
import controller.observer.Observer;

import java.awt.*;

public class Road extends JPanel implements Observer {


    class CellModel extends AbstractTableModel{

        @Override
        public int getRowCount() {
            return c.getMatrixManager().getRows();
        }

        @Override
        public int getColumnCount() {
            return c.getMatrixManager().getCols();
        }

        @Override
        public Object getValueAt(int row, int col) {
            return c.renderCell(row, col);
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

    private Controller c;

    private CellModel cellModel;
    private JTable cellTable;


    public Road() {
        super();

        c = FrameController.getInstance();
        c.attach(this);

        cellModel = new CellModel();

        initComponents();

    }

    private void initComponents() {

        cellTable = new JTable();
        cellTable.setBackground(Color.black);
        cellTable.setModel(this.cellModel);
        for (int x = 0 ; x < cellTable.getColumnModel().getColumnCount(); x++) {
            cellTable.getColumnModel().getColumn(x).setWidth(35);
            cellTable.getColumnModel().getColumn(x).setMaxWidth(45);
        }
        cellTable.setRowHeight(32);
        cellTable.setShowGrid(false);

        cellTable.setDefaultRenderer(Object.class, new CellRenderer());

        add(cellTable);
    }

    @Override
    public void updateCarPosition() {
        updateUI();
    }

    @Override
    public void changeStartButtonStatus(boolean status) {}

    @Override
    public void changeEndButtonStatus(boolean status) {}

    @Override
    public void changeCounter(int value) {}
}
