package com.myapp.passwordmanager.model;

public record Credential(String service, String username, String password, String notes) {}



// package com.myapp.passwordmanager.model;

// public class Credential {
//     private String username;
//     private String password;
//     private String site;

//     public Credential() {}

//     public Credential(String username, String password, String site) {
//         this.username = username;
//         this.password = password;
//         this.site = site;
//     }

//     public String getUsername() {
//         return username;
//     }

//     public void setUsername(String username) {
//         this.username = username;
//     }

//     public String getPassword() {
//         return password;
//     }

//     public void setPassword(String password) {
//         this.password = password;
//     }

//     public String getSite() {
//         return site;
//     }

//     public void setSite(String site) {
//         this.site = site;
//     }
// }