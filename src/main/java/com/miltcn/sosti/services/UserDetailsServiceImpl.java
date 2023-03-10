package com.miltcn.sosti.services;

import com.miltcn.sosti.domain.Person;
import com.miltcn.sosti.repositories.PersonRepository;
import com.miltcn.sosti.security.UserSpringSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Person> person = personRepository.findByEmail(email);
        if(person.isPresent()) {
            return new UserSpringSecurity(person.get().getId(), person.get().getEmail(), person.get().getPassword(), person.get().getProfiles());
        }
        throw new UsernameNotFoundException(email);
    }
}
