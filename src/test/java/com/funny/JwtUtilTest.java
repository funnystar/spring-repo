package com.funny;

import com.funny.common.utils.JwtUtil;
import com.funny.sys.entity.User;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JwtUtilTest {
    @Autowired
    private JwtUtil jwtUtil;

    @Test
    public void testCreatJwt(){
        User user = new User();
        user.setUsername("张三");
        user.setPhone("12399998887");
        String token = jwtUtil.createToken(user);
        System.out.println(token);
    }

    @Test
    public void testParseJwt(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI0YWFmYzA5Ny0xYTcxLTQ5NWQtODQ5Zi1iYjRkMTYzODMxODEiLCJzdWIiOiJ7XCJwaG9uZVwiOlwiMTIzOTk5OTg4ODdcIixcInVzZXJuYW1lXCI6XCLlvKDkuIlcIn0iLCJpc3MiOiJzeXN0ZW0iLCJpYXQiOjE2OTU2MjU4NDcsImV4cCI6MTY5NTYyNzY0N30.IjkVHJs6TCPTBFshXFzKy5LiPWFbP1Ak-FwcN4jBg3g";
        Claims claims = jwtUtil.parseToken(token);
        System.out.println(claims);
    }

    @Test
    public void testParseJwt2(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI0YWFmYzA5Ny0xYTcxLTQ5NWQtODQ5Zi1iYjRkMTYzODMxODEiLCJzdWIiOiJ7XCJwaG9uZVwiOlwiMTIzOTk5OTg4ODdcIixcInVzZXJuYW1lXCI6XCLlvKDkuIlcIn0iLCJpc3MiOiJzeXN0ZW0iLCJpYXQiOjE2OTU2MjU4NDcsImV4cCI6MTY5NTYyNzY0N30.IjkVHJs6TCPTBFshXFzKy5LiPWFbP1Ak-FwcN4jBg3g";
        User user = jwtUtil.parseToken(token, User.class);
        System.out.println(user);
    }
}
