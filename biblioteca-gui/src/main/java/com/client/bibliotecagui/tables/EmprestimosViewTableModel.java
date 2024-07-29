/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.client.bibliotecagui.tables;

import com.bajo.biblioteca.model.view.EmprestimoView;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author bajinho
 */
public class EmprestimosViewTableModel extends AbstractTableModel {

    private final List<EmprestimoView> emprestimosList;

    private final String[] columnNames = new String[]{
        "ID", "PESSOA", "LIVRO",  "AUTOR", "DATA EMPRESTIMO", "DATA DEVOLUÇÃO", "PESSOA_ID", "LIVRO_ID"
    };
    private final Class[] columnClass = new Class[]{
        java.lang.Long.class,
        java.lang.String.class,
        java.lang.String.class,
        java.lang.String.class,
        java.util.Date.class,
        java.util.Date.class,
        java.lang.Long.class,
        java.lang.Long.class
    };

    public EmprestimosViewTableModel(List<EmprestimoView> emprestimosList) {
        this.emprestimosList = emprestimosList;
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
        EmprestimoView row = emprestimosList.get(rowIndex);
        System.out.print(row);
        return switch (columnIndex) {
            case 0 ->
                row.getId();
            case 1 ->
                row.getNome();
            case 2 ->
                row.getTitulo();
            case 3 ->
                row.getAutor();
            case 4 ->
                row.getDataemprestimo();
            case 5 ->
                row.getDatadevolucao();
            case 6 ->
                row.getPessoaId();
            case 7 ->
                row.getLivroId();
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
//        Emprestimo row = emprestimosList.get(rowIndex);
//        switch (columnIndex) {
//            case 0 ->
//                row.setId((Long) aValue);
//            case 1 ->
//                row.setDatadevolucao((Date) aValue);
//            case 2 ->
//                row.setDataemprestimo((Date) aValue);
//            case 3 ->
//                row.setPessoa_id((Long) aValue);
//            case 4 ->
//                row.setLivro_id((Long) aValue);
//            default -> {
//            }
//        }
//
//        try {
//            emprestimosController.atualizar(row);
//        } catch (Exception ex) {
//            Logger.getLogger(EmprestimosViewwTableModel.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

}
