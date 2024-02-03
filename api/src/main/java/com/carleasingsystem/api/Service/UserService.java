package com.carleasingsystem.api.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carleasingsystem.api.Entities.User;
import com.carleasingsystem.api.Repositories.UserRepository;

@Service
public class UserService implements UserInterface
{
    @Autowired
	private UserRepository userRepository;

    @Autowired
    private UtilityService utilityService;

    @Override
    public User saveUser(User user)
    {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id)
    {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent())
        {
            return user.get();
        }

        return null;
    }

    @Override
    public User getUserByUsername(String username)
    {
        Optional<User> user = userRepository.findByUsername(username);

        if(user.isPresent())
        {
            return user.get();
        }

        return null;
    }

    @Override 
    public User getUserByEmail(String email)
    {
        Optional<User> user = userRepository.findByemail(email);

        if(user.isPresent())
        {
            return user.get();
        }

        return null;
    }

    @Override
    public String updateUserById(Long id, User newUserData)
    {
        Optional<User> oldUserData = userRepository.findById(id);

        if(oldUserData.isPresent())
        {
            oldUserData.get().copy(newUserData);
            userRepository.save(oldUserData.get());
            return oldUserData.get().getId() + " record Updated";
        }

        return "no data found";
    }

    @Override
    public String updateUserByUsername(String username, User newUserData)
    {
        Optional<User> oldUserData = userRepository.findByUsername(username);

        if(oldUserData.isPresent())
        {
            oldUserData.get().copy(newUserData);
            userRepository.save(oldUserData.get());
            return oldUserData.get().getUsername() + " record Updated";
        }

        return "no data found";
    }

    @Override
    public String deleteUserById(Long id)
    {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent())
        {
            userRepository.deleteById(id);
            return id + " record deleted";
        }

        return "no data found";
    }

    @Override
    public String deleteUserByUsername(String username)
    {
        Optional<User> user = userRepository.findByUsername(username);

        if(user.isPresent())
        {
            userRepository.deleteById(user.get().getId());
            return username + " record deleted";
        }

        return "no data found";
    }

    public String usersave(User user)
    {
        String message;
        int duplicate_status = isDuplicateEntry(user);

        if(duplicate_status == 0)
        {
            saveUser(user);
            message = "new record added";
        } 
        else if(duplicate_status == 1)
        {
            message = "duplicate record found - username";
        }
        else if(duplicate_status == 2)
        {
            message = "duplicate record found - email";
        }
        else
        {
            message = "collatral damage";
        }

        return message;
    }

    public String userupdate(String value, User user)
    {
        String message;
        int duplicate_status = isDuplicateEntry(user);

        if(duplicate_status == 0)
        {
            if(utilityService.isId(value))
            {
                message = updateUserById(Long.parseLong(value), user);
            }
            else
            {
                message = updateUserByUsername(value, user);
            }
        }
        else if(duplicate_status == 1)
        {
            message = "duplicate record found - username";
        }
        else if(duplicate_status == 2)
        {
            message = "duplicate record found - email";
        }
        else
        {
            message = "collatral damage";
        }

        return message;
    }

    @Override
    public int isDuplicateEntry(User user)
    {
        // 0 - no duplicate
        // 1 - username is duplicate
        // 2 - email is duplicate
        
        Optional<User> u = userRepository.findByUsername(user.getUsername());

        if(u.isPresent())
        {
            return 1;
        }

        u = userRepository.findByemail(user.getEmail());

        if(u.isPresent())
        {
            return 2;
        }

        return 0;
    }

    public User userGetId(String value)
    {
        User user;

        if(utilityService.isId(value))
        {
            user = getUserById(Long.parseLong(value));
        }
        else
        {
            user = getUserByUsername(value);
        }

        return user;
    }

    public String userDeleteId(String value)
    {
        String message;

        if(utilityService.isId(value))
        {
            message = deleteUserById(Long.parseLong(value));
        }
        else
        {
            message = deleteUserByUsername(value);
        }

		return message;
    }
}