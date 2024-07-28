package com.rashmita.movieReview.emailValidation;
import com.rashmita.movieReview.authentication.ImplementSecurity.dtos.RegisterUserDto;
import com.rashmita.movieReview.user.model.UserDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.util.HashMap;
import java.util.Map;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.regex.Pattern.matches;

@Service
@RequiredArgsConstructor
public class EmailValidationService {
    private final JavaMailSender javaMailSender;
    private final Configuration freemarkerConfig;

    @Value("${spring.mail.username}")
    private String sender;
    private String savedOtp;
    public String sendEmailWithVerificationLink(String email) {
        try {
            // Validate recipient email
            if (!isValidEmailAddress(email)) {
                return "Error in Sending Mail: Invalid recipient email address";
            }

            // Generate OTP
            savedOtp = generateOtp();

            String subject = "Email Validation";
            System.out.println("Recipient Email Address: " + email);

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(sender);
            helper.setTo(email);
            helper.setSubject(subject);

            Map<String, Object> model = new HashMap<>();
            model.put("name",email);
            model.put("input",savedOtp);



            Template template = freemarkerConfig.getTemplate("email-template.ftl");
            String htmlContent = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

            helper.setText(htmlContent, true);

            javaMailSender.send(mimeMessage);
            return "Mail Sent!";
        } catch (MailException | MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
            return "Error in Sending Mail:" + e.getMessage();
        }
    }

    private boolean isValidEmailAddress(String email) {
        //  email validation logic
        return email != null && email.contains("@");
    }


        public String generateOtp() {
            int otp = ThreadLocalRandom.current().nextInt(100000, 999999);
            return String.valueOf(otp);
        }

    public boolean verifyOtp(String enteredOtp) {
        return savedOtp.equals(enteredOtp);
    }



}
