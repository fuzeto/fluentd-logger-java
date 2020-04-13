package com.fuzeto.fluentdloggerjava;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fluentd.logger.FluentLogger;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
public class LogController {

    private static FluentLogger LOG = FluentLogger.getLogger("client_logger", "fluentd", 24224);

    @RequestMapping(method = RequestMethod.POST, value = "/log", consumes = {"application/json"})
    public String log(@RequestBody String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map map = mapper.readValue(json, Map.class);

        LOG.log("access", map);

        return ">>>>>>>>> LOG SENT | by java <<<<<<<<<<<";
    }
}