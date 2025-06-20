package com.task.signup.service;

import com.task.signup.dto.UserDTO;
import com.task.signup.entity.User;
import com.task.signup.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public String registerUser(UserDTO user) {
        String id = user.getId();

        // 이메일 형식 및 길이 체크
        if (!Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", id) || id.length() > 32) {
            return "아이디는 이메일 형식이어야 하며 32자 이하입니다.";
        }

        // 아이디 중복 체크
        if (userRepository.existsById(id)) {
            return "아이디가 중복되었습니다.";
        }

        // 비밀번호 유효성 검사
        String pw = user.getPassword();
        if (!Pattern.matches("(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{4,}", pw)) {
            return "비밀번호는 대문자, 소문자, 특수문자, 숫자를 각각 하나 이상 포함해야 합니다.";
        }

        // 비밀번호 확인
        if (!pw.equals(user.getConfirmPassword())) {
            return "비밀번호가 일치하지 않습니다.";
        }

        // 비밀번호 암호화
        String encryptedPw = encryptSHA256(pw);

        // 저장
        userRepository.save(User.builder()
                .id(id)
                .password(encryptedPw)
                .build());

        log.info("신규가입 아이디: {}", id);
        return "가입되셨습니다";
    }

    private String encryptSHA256(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashed = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashed) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("암호화 실패", e);
        }
    }

    // 더미 유저 등록
    @PostConstruct
    public void initDummyUser() {
        String id = "email@email.com";
        if (!userRepository.existsById(id)) {
            User dummy = User.builder()
                    .id(id)
                    .password(encryptSHA256("Qwer!234"))
                    .build();
            userRepository.save(dummy);
            log.info("더미 유저 등록 완료: {}", id);
        } else {
            log.info("더미 유저 이미 존재함: {}", id);
        }
    }
}
