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
 * Descrição da Classe AdicionarUsuarioWildFly
 * 
 * **Pacote**: com.bajo.biblioteca.resources.auth.jwt.util
 * 
 * **Descrição:**
 * 
 * A classe AdicionarUsuarioWildFly fornece uma funcionalidade específica para 
 * adicionar usuários no WildFly em memória. Ela não implementa a interface 
 * UserDetailsService usada pelo Spring Security para carregar usuários de um 
 * banco de dados ou diretório.
 * 
 * **Atributos:**
 * 
 * em: Injetado EntityManager para interagir com o banco de dados (não utilizado
 * no método createUserInMemory). host: Endereço IP do host WildFly (inicialmente
 * nulo, depois definido como "localhost").port: Porta de acesso ao WildFly 
 * (fixada em 9990).
 * 
 * **Método:**
 * 
 *  createUserInMemory(User user):
 * 
 *         Tenta criar uma conexão com o WildFly através do ModelControllerClient.
 *       Define o endereço do host como "localhost".
 *       Constrói um modelo ModelNode para a operação de adição de usuário.
 *       Define os parâmetros da operação:
 *           operation: "add-user" (adicionar usuário).
 *           address: Caminho para o recurso de gerenciamento de usuários.
 *           user: Nome de usuário a ser adicionado (obtido do objeto User).
 *           groups: Grupo(s) ao qual o usuário pertence (atualmente definido como "user").
 *           password: Senha do usuário (obtida do objeto User).
 *           realm: Nome do reino de segurança ("ApplicationRealm").
 *       Executa a operação no WildFly e imprime o resultado na saída.
 *       Em caso de exceção, imprime o erro no console.
 * 
 * **Observações:**
 * 
 * A classe AdicionarUsuarioWildFly depende da biblioteca 
 * org.jboss.as.controller.client.ModelControllerClient para interagir com 
 * o WildFly.
 * O método createUserInMemory modifica diretamente o WildFly em memória, o que 
 * pode não ser adequado para ambientes de produção.\
 * A classe não está configurada para recuperar informações do usuário de um 
 * banco de dados.
 * O método loadUserByUsername está comentado e não implementado.
 * 
 * **Uso:**
 * 
 * Esta classe pode ser utilizada para provisionar usuários temporariamente no 
 * WildFly durante o desenvolvimento ou testes. No entanto, para cenários de 
 * produção, é recomendado utilizar mecanismos de gerenciamento de usuários mais
 * robustos, como integração com um banco de dados ou LDAP. 
 *
 *
 * @author bajinho
 * @created 2024-07-04
 * @updated 
 * 17-06-2024 - changed for package com.bajo.biblioteca.resources.auth.jwt.util;
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
