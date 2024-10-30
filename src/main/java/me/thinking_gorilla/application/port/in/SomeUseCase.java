package me.thinking_gorilla.application.port.in;

import me.thinking_gorilla.application.domain.SomeDomain;

public interface SomeUseCase {
    void meet(SomeDomain domain);
}
