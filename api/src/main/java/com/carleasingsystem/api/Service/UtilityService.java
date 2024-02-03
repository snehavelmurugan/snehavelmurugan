package com.carleasingsystem.api.Service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.carleasingsystem.api.Config.ConfigConstants;

@Service
public class UtilityService implements UtilityInterface
{
    @Autowired
    private Random random;

    @Autowired
    private StringBuffer password;


    @Override
    public boolean isId(String value)
    {
        value = value.strip();
        return value.matches("[0-9]+");
    }

    @Override
    public String generateRandomPassword()
    {
        password.delete(0, password.length());

        for(int i = 0; i < 10; i++)
        {
            password.append(ConfigConstants.POSSIBLE_CHARS.charAt(random.nextInt(65)));
        }

        return password.toString();
    }
}