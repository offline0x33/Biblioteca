/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.client.bibliotecagui.tables;

import com.bajo.biblioteca.model.Pessoa;
import com.client.bibliotecagui.business.PessoasController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author bajinho
 */
public class PessoasTableModel extends AbstractTableModel {

    private PessoasController pessoasController;

    private final List<Pessoa> pessoasList;

    private final String[] columnNames = new String[]{
        "ID", "NAME"
    };
    private final Class[] columnClass = new Class[]{
        java.lang.Long.class, java.lang.String.class
    };

//    Class[] types = new Class[]{
//        java.lang.Long.class, java.lang.String.class
//    };
//
//    @Override
//    public Class getColumnClass(int columnIndex) {
//        return types[columnIndex];
//    }
    public PessoasTableModel(List<Pessoa> pessoasList) {
        this.pessoasList = pessoasList;
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
        return pessoasList.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pessoa row = pessoasList.get(rowIndex);
        System.out.println("ERROR!:" + row);
        if (0 == columnIndex) {
            return row.getId();
        } else if (1 == columnIndex) {
            return row.getNome();
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Pessoa row = pessoasList.get(rowIndex);
        if (0 == columnIndex) {
            row.setId((Long) aValue);
        } else if (1 == columnIndex) {
            row.setNome((String) aValue);
        }

        pessoasController = new PessoasController();
        try {
            pessoasController.atualizar(row);
        } catch (Exception ex) {
            Logger.getLogger(PessoasTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
