package br.ifmg.produto1_2026.util;

import br.ifmg.produto1_2026.entities.User;
import org.springframework.stereotype.Component;

@Component
public class NotificationEmail implements Notificator {
    private boolean upperCase;
    private String serverSmpt;

    public NotificationEmail(String serverSmpt) {
        System.out.println("NotificaçãoEmail criado");
        this.serverSmpt = serverSmpt;
    }
    public void notify(User user, String message) {
        if (upperCase) {
            message = message.toUpperCase();
        }
        System.out.printf("Notificação %s através do email %s no servidor %s\n", user.getName(),user.getEmail(), serverSmpt,message);
    }
}
