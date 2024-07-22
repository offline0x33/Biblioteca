/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.resources.auth.jwt.util;

import com.bajo.biblioteca.dao.UserDAO;
import com.bajo.biblioteca.model.User;
import jakarta.ejb.Local;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import org.jboss.as.controller.client.ModelControllerClient;
import org.jboss.dmr.ModelNode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @created
 * 
 * @updated 
 * 17-06-2024 - changed for package com.bajo.biblioteca.resources.auth.jwt.util;
 *
 *
 * @author bajinho
 */
//implements UserDetailsService 
@Local
public class AdicionarUsuarioWildFly {

    @PersistenceContext
    private EntityManager em;

//    GrantedAuthority adminAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
//    GrantedAuthority managerAuthority = new SimpleGrantedAuthority("ROLE_MANAGER");
//    GrantedAuthority userAuthority = new SimpleGrantedAuthority("ROLE_USER");

    private InetAddress host;
    private final int port = 9990;
//    private final String username = "admin";
//    private final String password = "Admin#70365";

    public AdicionarUsuarioWildFly() {

    }

    public void createUserInMemory(User user) {

        try (ModelControllerClient client = ModelControllerClient.Factory.create(host, port)) {
            host = InetAddress.getByName("localhost");
            ModelNode op = new ModelNode();
            op.get("operation").set("add-user");
            op.get("address").add("core-service", "management");
            op.get("address").add("access", "authorization");
            op.get("address").add("user", user.getUsername());
            op.get("groups").add("user");
//            op.get("groups").add(user.getUsername());
            op.get("password").set(user.getPassword());
            op.get("realm").set("ApplicationRealm");

            ModelNode result = client.execute(op);
            System.out.println("Usuário adicionado com sucesso: " + result.get("outcome").asString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        
//        // Retrieve user information from database or directory
//        UserDAO dao = new UserDAO(em);
//        User user = dao.consultarPorEmail(username);
//
//        GrantedAuthority userAuthority = new SimpleGrantedAuthority(user.getAuthorities());
//        // Assign roles based on user information
//        List<GrantedAuthority> authorities = new ArrayList<>();
//
//        authorities.add(userAuthority);
//
//        // Return UserDetails object
//        return (UserDetails) new Login(user.getEmail(), user.getPassword(), authorities);
//    }
}
