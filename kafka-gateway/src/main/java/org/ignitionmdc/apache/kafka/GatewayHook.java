package org.ignitionmdc.apache.kafka;

import com.inductiveautomation.ignition.common.licensing.LicenseState;
import com.inductiveautomation.ignition.common.script.ScriptManager;
import com.inductiveautomation.ignition.gateway.clientcomm.ClientReqSession;
import com.inductiveautomation.ignition.gateway.model.AbstractGatewayModuleHook;
import com.inductiveautomation.ignition.gateway.model.GatewayContext;
import org.apache.kafka.clients.consumer.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.HashMap;
import java.util.Map;

public class GatewayHook extends AbstractGatewayModuleHook {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private GatewayContext context;
    public static Map<String, Consumer> ConsumerHashMap = new HashMap<>();
    @Override
    public void setup(GatewayContext gatewayContext) {
        this.context = gatewayContext;
    }

    @Override
    public void startup(LicenseState licenseState) {

    }

    @Override
    public void shutdown() {

    }

    @Override
    public void initializeScriptManager(ScriptManager manager) {
        Kafka kInst = new Kafka(context);
        manager.addScriptModule("system.kafka", kInst);
    }
    public Object getRPCHandler(ClientReqSession session, Long projectId){
        return new Kafka(context);
    }

}
