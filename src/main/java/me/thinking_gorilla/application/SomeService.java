package me.thinking_gorilla.application;

import me.thinking_gorilla.application.domain.SomeDomain;
import me.thinking_gorilla.application.port.in.SomeUseCase;
import me.thinking_gorilla.application.port.out.SaveSomeDomainPort;
import me.thinking_gorilla.configuration.Assembler;
import me.thinking_gorilla.configuration.Inject;

@Inject
class SomeService implements SomeUseCase {

    @Override
    public void meet(SomeDomain domain) {
        System.out.println("When you first meet someone, say...");
        domain.sayHello();

        SaveSomeDomainPort adapter = Assembler.inject(SaveSomeDomainPort.class);
        adapter.save(domain);
    }
}
