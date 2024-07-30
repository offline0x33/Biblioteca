/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.client.bibliotecagui.invoker;

import com.bajo.biblioteca.bean.impl.LivroRemote;
import com.client.bibliotecagui.Application;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author bajinho
 */
public class InvokerLivro {

    /**
     * Looks up a stateless bean and invokes on it
     *
     * @return
     */
    public static LivroRemote invokeLivroStatelessBean() {
        try {
            InitialContext context = Invoker.getContext();
            return (LivroRemote) context.lookup("ejb:/biblioteca-war-1.0.17/LivroBean!"
                    + LivroRemote.class.getName());
        } catch (NamingException e) {
            System.out.println("ERROR!: " + e);
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, e);
        }

        return null;
    }
}

