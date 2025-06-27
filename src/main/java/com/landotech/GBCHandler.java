package com.landotech;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GBCHandler {

    private int rowCounter;
    private int columnCounter;
    private int baseRow;
    private int baseColumn;
    private int maxRow;
    private int maxColumn;

    GBCHandler(int baseRow, int baseColumn, int maxRow, int maxColumn) {
        this.baseRow = baseRow;
        this.baseColumn = baseColumn;
        this.rowCounter = baseRow;
        this.columnCounter = baseColumn;
        this.maxRow = maxRow;
        this.maxColumn = maxColumn;
    }

    public void addPaddingToGBC(GridBagConstraints gbc) {
        gbc.ipadx = 4;
        gbc.ipady = 4;
        gbc.insets = new Insets(4, 4, 4, 4);
    }

    public void addPaddingToGBC(GridBagConstraints gbc, int padx, int pady, Insets insets) {
        gbc.ipadx = padx;
        gbc.ipady = pady;
        gbc.insets = insets;
    }

    public GridBagConstraints getCurrentConstraints() {
        GridBagConstraints gbc = new GridBagConstraints();
        addPaddingToGBC(gbc);
        gbc.gridy = this.rowCounter;
        gbc.gridx = this.columnCounter;
        return gbc;
    }

    public GridBagConstraints nextConstraintsRow() {
        GridBagConstraints gbc = new GridBagConstraints();
        addPaddingToGBC(gbc);
        gbc.gridy = ++rowCounter;
        gbc.gridx = columnCounter;
        if (rowCounter > maxRow) {
            throw new IllegalStateException("Rows have exceeded maxRows.");
        }
        return gbc;
    }

    public GridBagConstraints prevConstraintsRow() {
        GridBagConstraints gbc = new GridBagConstraints();
        addPaddingToGBC(gbc);
        gbc.gridy = rowCounter - 1;
        if (rowCounter < baseRow) {
            throw new IllegalStateException("Rows cannot be negative.");
        }
        return gbc;
    }

    public GridBagConstraints nextConstraintsColumn() {
        GridBagConstraints gbc = new GridBagConstraints();
        addPaddingToGBC(gbc);
        gbc.gridx = ++columnCounter;
        gbc.gridy = rowCounter;
        if (columnCounter > maxColumn) {
            throw new IllegalStateException("Columns have exceeded maxColumns.");
        }
        return gbc;
    }

    public GridBagConstraints prevConstraintsColumn() {
        GridBagConstraints gbc = new GridBagConstraints();
        addPaddingToGBC(gbc);
        gbc.gridx = columnCounter - 1;
        if (columnCounter < baseColumn) {
            throw new IllegalStateException("Columns cannot be negative.");
        }
        return gbc;
    }

    public void incrementRow() {
        ++rowCounter;
    }

    public void incrementColumn() {
        ++columnCounter;
    }

    public void resetRow() {
        this.rowCounter = baseRow;
    }

    public void resetColumn() {
        this.columnCounter = baseColumn;
    }
}
