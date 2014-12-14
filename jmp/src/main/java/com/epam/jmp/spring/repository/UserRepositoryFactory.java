package com.epam.jmp.spring.repository;

/**
 * Date: 12/14/2014
 * Time: 1:06 PM
 *
 * @author Artur Memekh
 */
public class UserRepositoryFactory {

    private static final UserRepository userRepository = new UserRepository();

    private UserRepository createUserRepository() {
        return userRepository;
    }
}
