package com.spring.highlevel.proxy.pureproxy.concreateproxy;

import com.spring.highlevel.proxy.pureproxy.concreateproxy.code.ConcreteClient;
import com.spring.highlevel.proxy.pureproxy.concreateproxy.code.ConcreteLogic;
import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {

    @Test
    void noProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient client = new ConcreteClient(concreteLogic);
        client.execute();

    }
}
