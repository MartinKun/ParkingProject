package xmlsrc;

import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;

import model.privileges.Privileges;

public class XMLUserElementsGenerator extends DOMGenerator {
    
    //Declaring usernames:
    private static final String ADMIN = "Admin";
    private static final String USER = "user";
    //Declaring passwords:
    private static final String ADMIN_PASS = "firns";
    private static final String USER_PASS = "678";
    //Declaring privileges:
    private static final String ADMIN_PRIVILEGE = Privileges.ADMINISTRATOR.toString().toLowerCase();
    private static final String USER_PRIVILEGE = Privileges.USER.toString().toLowerCase();
    

    public XMLUserElementsGenerator() throws ParserConfigurationException {
        super();
    }

    @Override
    protected void generateDocument() {
        Element users = document.createElement("users");
        document.appendChild(users);
        
        Element user1 = document.createElement("user");
        Element user1_username = document.createElement("username");
        Element user1_password = document.createElement("password");
        user1.appendChild(user1_username);
        user1.appendChild(user1_password);
        user1.setAttribute("privilege", ADMIN_PRIVILEGE);
        user1_username.appendChild(document.createTextNode(ADMIN));
        user1_password.appendChild(document.createTextNode(ADMIN_PASS));
        users.appendChild(user1);
        
        Element user2 = document.createElement("user");
        Element user2_username = document.createElement("username");
        Element user2_password = document.createElement("password");
        user2.appendChild(user2_username);
        user2.appendChild(user2_password);
        user2.setAttribute("privilege", USER_PRIVILEGE);
        user2_username.appendChild(document.createTextNode(USER));
        user2_password.appendChild(document.createTextNode(USER_PASS));
        users.appendChild(user2);
    }

}
