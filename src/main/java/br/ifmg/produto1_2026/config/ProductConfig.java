package br.ifmg.produto1_2026.config;

import br.ifmg.produto1_2026.repositories.ProductRepository;
import br.ifmg.produto1_2026.service.ActivationClientService;
import br.ifmg.produto1_2026.util.NotificationEmail;
import br.ifmg.produto1_2026.util.NotificationSms;
import br.ifmg.produto1_2026.util.Notificator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProductConfig {
    @Bean
    public NotificationEmail notificationEmail() {
        NotificationEmail notificationEmail = new NotificationEmail("www.google.com");
        notificationEmail.setUpperCase(true);

        return notificationEmail;
    }
/*
    @Bean
    public ActivationClientService activationClientService(Notificator notificator) {
        ActivationClientService activationClientService = new ActivationClientService(notificator);
        return activationClientService;
    }
    */
    @Primary
    @Bean
    public Notificator notificatorSms() {
        NotificationSms notificationSms = new NotificationSms();
        notificationSms.setUpperCase(true);
        return notificationSms;
    }
}
