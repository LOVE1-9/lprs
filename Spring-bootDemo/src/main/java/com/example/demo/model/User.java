package com.example.demo.model;
import io.swagger.annotations.ApiModel;

@ApiModel(value="user2", description = "用户")
public class User {
        int id;
        String username;
        String password;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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
}
