package com.QA.utilités;

import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;


public class XMLUtilities {

    public static void main(String[] args)  {
        XMLUtilities utilities = new XMLUtilities();

    }

    /**
     * Given a userName as input, this method returns an Object containing the
     * User details (userName/Password)
     *
     * @param username
     * @return User
     * @throws Exception
     */
    public User findUser(String username) throws Exception {

        XMLUtilities utilities = new XMLUtilities();
        SAXParserFactory parserFactor = SAXParserFactory.newInstance();
        SAXParser parser = parserFactor.newSAXParser();
        UserHolder handler = utilities.new UserHolder();
        parser.parse(ClassLoader.getSystemResourceAsStream("jeudedonnées/users.xml"), handler);

        for (User user : handler.users) {
            if (username.equalsIgnoreCase(user.getUsername())) {
                return user;
            }
        }

        return null;
    }

    /**
     * @author habdelhedi
     * <p>
     * An extension of the Sax DefaultHandler to read User objects from
     * an XML file
     */
    class UserHolder extends DefaultHandler {

        List<User> users = new ArrayList<>();
        User user = null;
        String content = null;

        @Override
        // Triggered when the start of tag is found.
        public void startElement(String uri, String localName, String qName, Attributes attributes) {

            switch (qName) {
                // Create a new Employee object when the start tag is found
                case "user":
                    user = new User();
                    user.setPassword(attributes.getValue("username"));
                    user.setUsername(attributes.getValue("password"));
                    break;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            switch (qName) {
                // Add the employee to list once end tag is found
                case "user":
                    users.add(user);
                    break;
                // For all other end tags the employee has to be updated.
                case "username":
                    user.username = content;
                    break;
                case "password":
                    user.password = content;
                    break;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            content = String.copyValueOf(ch, start, length).trim();
        }

    }

    /**
     * A model class for User object. So far containing only userName and
     * password.
     *
     * @author habdelhedi
     */

    public class User {
        private String username;
        private String password;

        public User() {
            super();
        }

        public User(String username, String password) {
            super();
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "User[username = " + username + "; password = " + password + "]";
        }

    }

}

