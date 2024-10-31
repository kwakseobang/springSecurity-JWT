package com.kwakmunsu.JWT.service;


import com.kwakmunsu.JWT.dto.JoinDTO;
import com.kwakmunsu.JWT.entity.User;
import com.kwakmunsu.JWT.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class JoinService {

        private  final UserRepository userRepository;
        private  final BCryptPasswordEncoder bCryptPasswordEncoder;


        public void join(JoinDTO joinDTO) throws Exception{
            String username = joinDTO.getUsername();
            String password = joinDTO.getPassword();

            boolean isExist = userRepository.existsByUsername(username);

            if (isExist) {
                return;
            }

            User user = new User();

            user.setUsername(username);
            user.setPassword(bCryptPasswordEncoder.encode(password));
            user.setRole("ROLE_ADMIN");

            userRepository.save(user);
        }

}
