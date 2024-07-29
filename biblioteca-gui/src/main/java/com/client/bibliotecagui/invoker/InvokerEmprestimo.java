/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.client.bibliotecagui.invoker;

import com.bajo.biblioteca.bean.impl.EmprestimoRemote;
import com.client.bibliotecagui.Application;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author bajinho
 */
public class InvokerEmprestimo {

    /**
     * Looks up a stateless bean and invokes on it
     *
     * @return
     */
    public static EmprestimoRemote invokeEmprestimoStatelessBean() {
        try {
            InitialContext context = Invoker.getContext();
            return (EmprestimoRemote) context.lookup("ejb:/biblioteca-1.0-SNAPSHOT/EmprestimoBean!"
                    + EmprestimoRemote.class.getName());
        } catch (NamingException e) {
            System.out.println("ERROR!: " + e);
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, e);
        }

        return null;
    }
}

