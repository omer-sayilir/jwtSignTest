package tr.sayilir.jwtsigntest;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JwtSignTestApplication {


    public static void main(String[] args) {
        SpringApplication.run(JwtSignTestApplication.class, args);
        Date now = new Date();
        Integer jwtExpirationInMs=10000;
        String jwtSecret="secret";
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        String result=Jwts.builder()
                .setHeaderParam("producer","PEYK")
                .setSubject("encryptedSubject")
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();

        System.out.println(" result:"+result);
    }

}
