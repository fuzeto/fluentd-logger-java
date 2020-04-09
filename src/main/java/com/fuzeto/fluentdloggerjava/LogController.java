package com.fuzeto.fluentdloggerjava;

import org.fluentd.logger.FluentLogger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/log")
public class LogController {

    private static FluentLogger LOG = FluentLogger.getLogger("wspot", "fluentd", 24224);

    @GetMapping
    public String log() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("from", "userA");
        map.put("to", "userB");

        LOG.log("guests", map);

        return "LOG ENVIADO!!!!!";
    }
}