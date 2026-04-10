package br.ifmg.produto1_2026.service;

import br.ifmg.produto1_2026.anotations.NotifierType;
import br.ifmg.produto1_2026.constants.NotificationTypes;
import br.ifmg.produto1_2026.entities.User;
import br.ifmg.produto1_2026.util.Notificator;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivationClientService {
    //@NotifierType(value = NotificationTypes.EMAIL)
    @Autowired
    private Notificator notificator;

    //private List<Notificator> notificators;

    //@Autowired
    public ActivationClientService(List <Notificator> notificators) {
        System.out.println("Iniciando AtivacaoClienteService");
     //   this.notificator = notificator;
    }

    public ActivationClientService() {
        System.out.println("Iniciando AtivacaoClienteService");
    }

    public void activate(User user, String message) {
        notificator.notify(user, message);
        if(notificator != null) {
            notificator.notify(user, message);
        }
        //for (Notificator notificator : notificators) {
        //    notificator.notify(user, message);
        //}
    }
    @PostConstruct
    public void init() {
        System.out.println("Metodo ativado apos o constructor");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("Metodo executado ao destruir o objeto");
    }
}