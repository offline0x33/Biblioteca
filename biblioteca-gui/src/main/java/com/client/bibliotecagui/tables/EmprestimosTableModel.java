/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.client.bibliotecagui.tables;

import com.bajo.biblioteca.model.Emprestimo;
import java.util.Date;
import com.client.bibliotecagui.business.EmprestimosController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author bajinho
 */
public class EmprestimosTableModel extends AbstractTableModel {

    private final EmprestimosController emprestimosController;

    private final List<Emprestimo> emprestimosList;

    private final String[] columnNames = new String[]{
        "ID", "LIVRO", "PESSOA", "DATA EMPRESTIMO", "DATA DEVOLUÇÃO"
    };
    private final Class[] columnClass = new Class[]{
        java.lang.Long.class,
        java.util.Date.class,
        java.util.Date.class,
        java.lang.Long.class,
        java.lang.Long.class
    };

    public EmprestimosTableModel(List<Emprestimo> emprestimosList) {
        this.emprestimosList = emprestimosList;
        this.emprestimosController = new EmprestimosController();
        System.out.print(emprestimosList.getFirst().getDatadevolucao());
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClass[columnIndex];
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return emprestimosList.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Emprestimo row = emprestimosList.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                row.getId();
            case 1 ->
                row.getDatadevolucao();
            case 2 ->
                row.getDataemprestimo();
            case 3 ->
                row.getPessoa_id();
            case 4 ->
                row.getLivro_id();
            default ->
                null;
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Emprestimo row = emprestimosList.get(rowIndex);
        switch (columnIndex) {
            case 0 ->
                row.setId((Long) aValue);
            case 1 ->
                row.setDatadevolucao((Date) aValue);
            case 2 ->
                row.setDataemprestimo((Date) aValue);
            case 3 ->
                row.setPessoa_id((Long) aValue);
            case 4 ->
                row.setLivro_id((Long) aValue);
            default -> {
            }
        }

        try {
            emprestimosController.atualizar(row);
        } catch (Exception ex) {
            Logger.getLogger(EmprestimosTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
