package com.bijanghanei.GottaBuy;

import io.jsonwebtoken.Jwts;
import jakarta.xml.bind.DatatypeConverter;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;

public class JwtSecretGeneratorTest {
    @Test
    public void generateSecret() {
        SecretKey key = Jwts.SIG.HS512.key().build();
        String decoded = DatatypeConverter.printHexBinary(key.getEncoded());
        System.out.println("_____________________________\nKey : " + decoded + "\n_____________________________");
    }
}
