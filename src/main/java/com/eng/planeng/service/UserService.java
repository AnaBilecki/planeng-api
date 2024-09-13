package com.eng.planeng.service;

import com.eng.planeng.dto.user.UserRegisterRequestDTO;
import com.eng.planeng.entity.user.User;
import com.eng.planeng.exception.LoginAlreadyInUseException;
import com.eng.planeng.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public void register(UserRegisterRequestDTO userRegisterDTO) {
        if (repository.findByLogin(userRegisterDTO.getLogin()).isPresent()) {
            throw new LoginAlreadyInUseException("This email is already registered. Please use a different email or log in.");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(userRegisterDTO.getPassword());
        userRegisterDTO.setPassword(encryptedPassword);
        repository.save(convertToEntity(userRegisterDTO));
    }

    private User convertToEntity(UserRegisterRequestDTO dto) {
        return modelMapper.map(dto, User.class);
    }
}
