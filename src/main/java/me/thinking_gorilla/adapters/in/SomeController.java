package me.thinking_gorilla.adapters.in;

import me.thinking_gorilla.application.domain.SomeDomain;
import me.thinking_gorilla.application.port.in.SomeUseCase;
import me.thinking_gorilla.application.port.in.UserInterfacePort;
import me.thinking_gorilla.configuration.Assembler;
import me.thinking_gorilla.configuration.Inject;

@Inject
class SomeController implements UserInterfacePort {

    public void execute() {
        SomeUseCase useCase = Assembler.inject(SomeUseCase.class);
        useCase.meet(new SomeDomain());
    }
}
