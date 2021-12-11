package pl.edu.pwr.bd2_cinema_app.authentication;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private final long user_id;
    private final String username;

    public JwtResponse(String jwttoken, long user_id, String username) {
        this.jwttoken = jwttoken;
        this.user_id = user_id;
        this.username = username;
    }

    public String getToken() {
        return this.jwttoken;
    }
    public long getUserId(){return this.user_id; }

    public String getUsername() {
        return this.username;
    }
}