package com.example.logbackdemo.com.spring.evevt.notify;

import de.codecentric.boot.admin.server.domain.entities.Instance;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.domain.events.InstanceEvent;
import de.codecentric.boot.admin.server.domain.events.InstanceStatusChangedEvent;
import de.codecentric.boot.admin.server.notify.AbstractEventNotifier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @program: source-demo
 * @description: 定制化通知
 * @ClassName：NotifyDemo
 * @author: Mr.Wang
 * @create: 2022-02-21 14:34
 **/
@Slf4j
@Component
@SuppressWarnings("all")
public class NotifyDemo extends AbstractEventNotifier {

    protected NotifyDemo(InstanceRepository repository) {
        super(repository);
    }

    @Override
    protected Mono<Void> doNotify(InstanceEvent event, Instance instance) {
        return Mono.fromRunnable(new Runnable() {
            @Override
            public void run() {
                if (event instanceof InstanceStatusChangedEvent){
                    log.info("Instance Status Change: [{}], [{}],[{}],",
                            instance.getRegistration().getName(),event.getInstance(),
                            ((InstanceStatusChangedEvent)event).getStatusInfo().getStatus());
                }else {
                    log.info("Instance Info: [{}], [{}],[{}],", instance.getRegistration().getName(),event.getInstance(),
                            event.getType());
                }
            }
        });
    }
}
