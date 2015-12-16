package server;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by emon on 12/4/2015.
 */
public class Data {
        private final SimpleStringProperty name;
        private final SimpleStringProperty post;

        Data(String name, String post) {
            this.name = new SimpleStringProperty(name);
            this.post = new SimpleStringProperty(post);
        }

        public String getName() {
            return name.get();
        }
        public void setName(String fName) {
            name.set(fName);
        }

        public String getPost() {
            return post.get();
        }
        public void setPost(String fName) {
            post.set(fName);
        }

        public String toString() {
            return name + ", " + post ;
        }
}
