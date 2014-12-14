package com.epam.jmp.spring.service;

import com.epam.jmp.spring.Param;
import com.epam.jmp.spring.repository.UserRepository;

/**
 * Date: 12/14/2014
 * Time: 2:01 PM
 *
 * @author Artur Memekh
 */
public class ProposalService {

    private Param param;
    private UserRepository userRepository;

    public ProposalService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setParam(Param param) {
        this.param = param;
    }
}
